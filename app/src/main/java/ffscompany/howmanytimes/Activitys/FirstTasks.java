package ffscompany.howmanytimes.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import ffscompany.howmanytimes.Adapter.FirstChooseAdapter;
import ffscompany.howmanytimes.Adapter.TaskAdapter;
import ffscompany.howmanytimes.Model.Task;
import ffscompany.howmanytimes.Model.Usuario;
import ffscompany.howmanytimes.R;
import ffscompany.howmanytimes.Retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstTasks extends AppCompatActivity {
    RecyclerView rvFirtsTaskFT;
    Task task;
    Button buttonProseseguir;
    ArrayList<Task> tasksFirstTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_tasks);
        task = new Task();
        tasksFirstTask = new ArrayList<>();
        tasksFirstTask = (ArrayList<Task>) task.initializeData();

        buttonProseseguir = (Button) findViewById(R.id.BTNFIRSTTASKPROSSEGUIR);
        rvFirtsTaskFT = (RecyclerView) findViewById(R.id.rvFirstTask);

        LinearLayoutManager llmFirtTask = new LinearLayoutManager(getApplicationContext());

        rvFirtsTaskFT.setLayoutManager(llmFirtTask);
        FirstChooseAdapter adapterZada = new FirstChooseAdapter(tasksFirstTask, getApplicationContext());
        rvFirtsTaskFT.setAdapter(adapterZada);

        Intent getintent = getIntent();
        final Usuario user = getintent.getParcelableExtra("Usuario");

        buttonProseseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Usuario> call = new RetrofitConfig().getUsuarioService().edit(user.getEmail(),"Qualquer",user.getSenha(),user.getCelular());
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Log.w("Sucesso", "xd");
                        Intent z = new Intent(getApplicationContext(), Main.class);
                        startActivity(z);
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.w("Falha", "xd");
                        Toast.makeText(getApplicationContext(), "Algo de errado, com nossos servidores :(", Toast.LENGTH_LONG)
                                .show();
                    }
                });


            }
        });





    }

}
