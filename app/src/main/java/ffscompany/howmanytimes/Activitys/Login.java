package ffscompany.howmanytimes.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ffscompany.howmanytimes.Model.Usuario;
import ffscompany.howmanytimes.R;
import ffscompany.howmanytimes.Retrofit.RetrofitConfig;
import ffscompany.howmanytimes.Retrofit.model.LoginDetails;
import ffscompany.howmanytimes.SharedPreference.PreferenceUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button btnLogar;
    EditText ETpassword;
    EditText ETlogin;
    Button btnNovo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(0XD3272750);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        btnLogar =(Button) findViewById(R.id.BTNlogarls);
        btnNovo = (Button) findViewById(R.id.BTNregisterrls);
        ETlogin = (EditText) findViewById(R.id.ETloginls);
        ETpassword = (EditText) findViewById(R.id.ETpasswordls);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoginInfo();
            }
        });
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Register.class);
                startActivity(it);
            }
        });
    }

    private void submitLoginInfo() {
        String email = ETlogin.getText().toString().trim();
        String password = ETpassword.getText().toString().trim();
        Call<Usuario> call = new RetrofitConfig().getUsuarioService().login(email, password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.body() == null || response.body().getEmail() == null) {
                    Toast.makeText(getApplicationContext(), "Credenciais inválidas", Toast.LENGTH_LONG)
                            .show();
                }else{
                    Log.w("getEmail",response.body().getEmail());
                    Log.w("getPassword(",response.body().getSenha());
                    Log.w("getCelular",response.body().getCelular());
                    Log.w("getPrimeiro_login", response.body().getPrimeiro_login());
                    Usuario userLoggedIn = new Usuario(response.body().getEmail(),response.body().getSenha(),response.body().getCelular(),response.body().getPrimeiro_login());
                    Intent i = null;
                    if(userLoggedIn.getPrimeiro_login().equals("true")){
                        i = new Intent(getApplicationContext(), FirstTasks.class);
                    }else if(userLoggedIn.getPrimeiro_login().equals("false")){
                        i = new Intent(getApplicationContext(), Main.class);
                    }
                    if(i!=null){
                        i.putExtra("Usuario", userLoggedIn);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "Algo errado aconteceu :), Tente novamente.", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Houve um erro no login, por favor tente novamente.", Toast.LENGTH_LONG)
                        .show();
//                myTv.setVisibility(View.VISIBLE);
//                Log.d("Message", t.getMessage());
            }
        });
    }
}
