package ffscompany.howmanytimes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ffscompany.howmanytimes.DAOS.TaskDAO;
import ffscompany.howmanytimes.Model.Task;
import ffscompany.howmanytimes.R;

public class FirstChooseAdapter extends RecyclerView.Adapter<FirstChooseAdapter.TaskViewHolder>{

    private ArrayList<Task> tasksx;
    private Context mContextx;


    public FirstChooseAdapter(ArrayList<Task> tasks, Context mContext) {
        this.tasksx = tasks;
        this.mContextx = mContext;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CardView cvx;
        TextView taskNamex;
        TextView taskDoTimesx;
        ImageView taskPhotox;
        CheckBox checkBoxTestex;

        TaskViewHolder(View itemView2) {
            super(itemView2);
            cvx = (CardView) itemView2.findViewById(R.id.CardViewFirstTaskFT);
            taskNamex = (TextView) itemView2.findViewById(R.id.TextViewCardViewFirstTaskFT);
            taskPhotox = (ImageView) itemView2.findViewById(R.id.ImgViewCardViewFirstTaskFT);
            checkBoxTestex = (CheckBox)itemView2.findViewById(R.id.CardViewAddFT);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContextx).inflate(R.layout.cardview_firstlogin, viewGroup, false);
        TaskViewHolder pvhx = new TaskViewHolder(v);
        return pvhx;

    }

    @Override
    public void onBindViewHolder(final TaskViewHolder TaskViewHolder, int i) {
        Log.w("Teste", tasksx.get(i).getName());
        String name = tasksx.get(i).getName();
        TaskViewHolder.taskNamex.setText(name);
        TaskViewHolder.taskPhotox.setImageResource(tasksx.get(i).getPhotoId());
        final int z=i;
        TaskViewHolder.checkBoxTestex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDAO taskDao = new TaskDAO(mContextx);
                if(TaskViewHolder.checkBoxTestex.isChecked()){
                    taskDao.insertTask(tasksx.get(z));
//                    Intent i = new Intent(mContext, Main.class);
//                    mContext.startActivity(i);
                }else {
                    taskDao.deletaRegistro(tasksx.get(z));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasksx.size();
    }




}
