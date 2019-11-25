package ffscompany.howmanytimes.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ffscompany.howmanytimes.DAOS.TaskDAO;
import ffscompany.howmanytimes.Model.Task;
import ffscompany.howmanytimes.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{

    private ArrayList<Task> tasks;
    private Context mContext;


    public TaskAdapter(ArrayList<Task> tasks, Context mContext) {
        this.tasks = tasks;
        this.mContext = mContext;
    }



    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView taskName;
        TextView taskDoTimes;
        ImageView taskPhoto;
        CheckBox checkTask;
        Button btnTeste;

        TaskViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.CardViewFirsttask);
            taskName = (TextView)itemView.findViewById(R.id.TextViewCardViewFirstTask);
            taskPhoto = (ImageView)itemView.findViewById(R.id.ImgViewCardViewFirstTask);
            btnTeste = (Button)itemView.findViewById(R.id.CardViewAdd);
            taskDoTimes =(TextView) itemView.findViewById(R.id.DoTimesTV);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cardview_firsttasks, viewGroup, false);
        TaskViewHolder pvh = new TaskViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(final TaskViewHolder taskViewHolder, int i) {
        taskViewHolder.taskName.setText(tasks.get(i).getName());
        String dotimes = String.valueOf(tasks.get(i).getDoTimes());
        taskViewHolder.taskDoTimes.setText(dotimes);
        taskViewHolder.taskPhoto.setImageResource(tasks.get(i).getPhotoId());
        final int z=i;
        taskViewHolder.btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDAO taskDao = new TaskDAO(mContext);
                int Onclick = Integer.parseInt(taskViewHolder.taskDoTimes.getText().toString());
                Onclick++;
                String dotimes = String.valueOf(Onclick);
                tasks.get(z).setDoTimes(Onclick);
                taskViewHolder.taskDoTimes.setText(dotimes);
                Log.w("Name:" , tasks.get(z).getName());
                taskDao.IncreaseDoTimes(tasks.get(z));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void insereSelecionados(){
        for (int i=0;i<getItemCount();i++){

        }
    }




}
