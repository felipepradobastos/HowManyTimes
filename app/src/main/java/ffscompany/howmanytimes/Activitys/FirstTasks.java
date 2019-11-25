//package ffscompany.howmanytimes.Activitys;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.Button;
//
//import java.util.ArrayList;
//
//import ffscompany.howmanytimes.Adapter.TaskAdapter;
//import ffscompany.howmanytimes.Model.Task;
//import ffscompany.howmanytimes.R;
//
//public class FirstTasks extends AppCompatActivity {
//    RecyclerView rvFirtsTask;
//    Task tasks;
//    Button buttonProseseguir;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        tasks = new Task();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_first_tasks);
//        buttonProseseguir = (Button) findViewById(R.id.BTNFIRSTTASKPROSSEGUIR);
//        rvFirtsTask = (RecyclerView) findViewById(R.id.rvFirstTask);
//        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
//        rvFirtsTask.setLayoutManager(llm);
//        rvFirtsTask.setHasFixedSize(true);
//        TaskAdapter adapter = new TaskAdapter(tasks.initializeData());
//        rvFirtsTask.setAdapter(adapter);
//
//        buttonProseseguir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent z = new Intent(getApplicationContext(), Main.class);
//                startActivity(z);
//
//            }
//        });
//
//
//
//
//
//    }
//
//}
