package ffscompany.howmanytimes.Retrofit;


import ffscompany.howmanytimes.Model.Usuario;
import ffscompany.howmanytimes.Retrofit.model.LoginDetails;
import ffscompany.howmanytimes.Retrofit.model.RegistrationDetails;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("register")
    Call<Usuario> register(@Body RegistrationDetails details);

    @POST("login")
    Call<Usuario> login(@Body LoginDetails details);
}
