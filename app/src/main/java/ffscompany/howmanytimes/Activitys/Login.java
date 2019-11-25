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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        btnLogar =(Button) findViewById(R.id.BTNlogarls);
        ETlogin = (EditText) findViewById(R.id.ETloginls);
        ETpassword = (EditText) findViewById(R.id.ETpasswordls);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoginInfo();
            }
        });
    }

    private void submitLoginInfo() {
        String email = ETlogin.getText().toString().trim();
        String password = ETpassword.getText().toString().trim();
        Log.w("Email", email);
        Log.w("Senha", password);
        Call<Usuario> call = new RetrofitConfig().getUsuarioService().login(new LoginDetails(email,password));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario userDetails = response.body();
                if (userDetails == null || userDetails.getId() == null) {
                    Toast.makeText(getApplicationContext(), "Credenciais inválidas", Toast.LENGTH_LONG)
                            .show();
                }else{
                    PreferenceUtils.saveNome(userDetails.getName(),getApplicationContext());
                    PreferenceUtils.saveId(userDetails.getId(), getApplicationContext());
                    PreferenceUtils.saveEmail(userDetails.getEmail(), getApplicationContext());
                    //PreferenceUtils.saveNasc(userDetails.getBirthDate(), getApplicationContext());
//                  PreferenceUtils.savebirthTime(userDetails.getBirthTime(), getContext());
                    //Intent i = new Intent(getApplicationContext(), Main.class);
                    Intent i = new Intent(getApplicationContext(), Main.class);
                    startActivity(i);
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
