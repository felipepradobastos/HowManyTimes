package ffscompany.howmanytimes.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ffscompany.howmanytimes.DAOS.TaskDAO;
import ffscompany.howmanytimes.Model.Task;
import ffscompany.howmanytimes.R;

public class AddTask extends AppCompatActivity {

    EditText doTimes;
    EditText name;
    Button btnCadastroTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(0XD3272750);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_task);
        doTimes = (EditText) findViewById(R.id.ETAddTaskDoTimes);
        name = (EditText) findViewById(R.id.ETAddTaskName);
        btnCadastroTask = (Button) findViewById(R.id.BTNAddTask);

        btnCadastroTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateInstance().format(new Date(2019,11,29));
                Task task = new Task();

                if(name.getText().toString().equals("") || doTimes.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_LONG)
                            .show();
                }else{
                    task.setPhotoId( R.drawable.imagenotavailable);
                    task.setName(name.getText().toString());
                    task.setDoTimes(Integer.parseInt(doTimes.getText().toString()));
                    task.setCreationTime(currentDateTimeString);
                    TaskDAO taskDao = new TaskDAO(getApplicationContext());
                    taskDao.insertTask(task);
                    Intent i = new Intent(getApplicationContext(),Main.class);
                    startActivity(i);
                }
            }
        });
    }
}
