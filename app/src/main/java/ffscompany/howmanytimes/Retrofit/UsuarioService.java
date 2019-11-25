package ffscompany.howmanytimes.Retrofit;


import ffscompany.howmanytimes.Model.Usuario;
import ffscompany.howmanytimes.Retrofit.model.LoginDetails;
import ffscompany.howmanytimes.Retrofit.model.RegistrationDetails;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UsuarioService {
    @FormUrlEncoded
    @POST("register")
    Call<Usuario> register(@Field("email") String email,
                           @Field("nome") String nome,
                           @Field("senha") String senha,
                           @Field("celular") String celular);
    @FormUrlEncoded
    @POST("login")
    Call<Usuario> login(@Field("email") String email,
                        @Field("senha") String senha);

    @FormUrlEncoded
    @PUT("edit")
    Call<Usuario> edit(@Field("email") String email,
                       @Field("nome") String nome,
                       @Field("senha") String senha,
                       @Field("celular") String celular);
}
