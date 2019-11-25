package ffscompany.howmanytimes.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Usuario implements Parcelable {
    private String email;
    private String nome;
    private String senha;
    private String celular;
    private String primeiro_login;

    public Usuario() {
    }

    public Usuario(String email, String senha, String celular, String primeiro_login) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.celular = celular;
        this.primeiro_login = primeiro_login;
    }

    protected Usuario(Parcel in) {
        email = in.readString();
        nome = in.readString();
        senha = in.readString();
        celular = in.readString();
        primeiro_login = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPrimeiro_login() {
        return primeiro_login;
    }

    public void setPrimeiro_login(String primeiro_login) {
        this.primeiro_login = primeiro_login;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(nome);
        dest.writeString(senha);
        dest.writeString(celular);
        dest.writeString(primeiro_login);
    }
}
