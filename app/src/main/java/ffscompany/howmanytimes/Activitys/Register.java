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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText email;
    EditText senha;
    EditText numero;
    EditText nome;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        getWindow().setStatusBarColor(0XD3272750);
        getSupportActionBar().hide();

        email = (EditText) findViewById(R.id.ETRegisterEmail);
        nome = (EditText) findViewById(R.id.ETRegisterNome);
        senha = (EditText) findViewById(R.id.ETRegisterSenha);
        numero= (EditText) findViewById(R.id.ETRegisterCelular);
        btnRegister = (Button) findViewById(R.id.BTNRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") || nome.getText().toString().equals("") || senha.getText().toString().equals("") || numero.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_LONG)
                            .show();
                }else{
                    Call<Usuario> call = new RetrofitConfig().getUsuarioService().register(email.getText().toString(),nome.getText().toString(),senha.getText().toString(),numero.getText().toString());
                    call.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            Log.w("Sucesso Register", "xd");
                            Intent z = new Intent(getApplicationContext(), Login.class);
                            startActivity(z);
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Log.w("Falha Registro", "xd");
                            Toast.makeText(getApplicationContext(), "Algo de errado, com nossos servidores :(", Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            }
        });

    }
}
