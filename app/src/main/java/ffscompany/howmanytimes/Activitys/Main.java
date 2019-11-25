package ffscompany.howmanytimes.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import ffscompany.howmanytimes.Adapter.TaskAdapter;
import ffscompany.howmanytimes.DAOS.TaskDAO;
import ffscompany.howmanytimes.DB.DBConnection;
import ffscompany.howmanytimes.Model.Task;
import ffscompany.howmanytimes.R;

public class Main extends AppCompatActivity {
    ImageView imgAdd;
    RecyclerView rvMain;
    ArrayList<Task> Listtasks;
    ArrayList<Task> teste;
    Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(0XD3272750);
        getSupportActionBar().hide();
        task = new Task();
        Listtasks = new ArrayList<>();


        imgAdd = (ImageView) findViewById(R.id.ImgViewMainActivity);
        rvMain = (RecyclerView) findViewById(R.id.rvMain);

        TaskDAO crud = new TaskDAO(getApplicationContext());
        Cursor dao =crud.getTasks();
        if(dao.getColumnCount()==0){

        }else{
            while (dao.moveToNext()) {
                int id = dao.getInt(dao.getColumnIndex("ID"));
                String nome = dao.getString(dao.getColumnIndex("NAME"));
                int doTimes = dao.getInt(dao.getColumnIndex("DOTIMES"));
                String creationdate = dao.getString(dao.getColumnIndex("CREATION_DATE"));
                int PHOTOID = dao.getInt(dao.getColumnIndex("PHOTOID"));
                if(PHOTOID>0){
                    Task taskZada = new Task(id, nome,doTimes,creationdate,PHOTOID);
                    Listtasks.add(taskZada);
                }
            }
        }

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(llm);
        TaskAdapter adapter = new TaskAdapter(Listtasks, getApplicationContext());
        rvMain.setAdapter(adapter);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddTask.class);
                startActivity(i);
            }
        });
    }


}
