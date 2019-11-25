package ffscompany.howmanytimes.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ffscompany.howmanytimes.Model.Task;

public class PreferenceUtils {
    public PreferenceUtils(){

    }



    public static boolean saveNome(String nome, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_NOME, nome);
        prefsEditor.apply();
        return true;
    }

    public static String getNome(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(PreferenceKeys.KEY_NOME, null);
    }

    public static boolean saveId(String id, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_ID, id);
        prefsEditor.apply();
        return true;
    }

    public static String getId(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(PreferenceKeys.KEY_ID, null);
    }

    public static boolean savebirthTime(String birthTime, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_NOME, birthTime);
        prefsEditor.apply();
        return true;
    }

    public static String getbirthTime(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(PreferenceKeys.KEY_NOME, null);
    }

    public static boolean saveEmail(String email, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_EMAIL, email);
        prefsEditor.apply();
        return true;
    }

    public static String getEmail(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(PreferenceKeys.KEY_EMAIL, null);
    }


    public static boolean saveSenha(String senha, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_SENHA, senha);
        prefsEditor.apply();
        return true;
    }

    public static String getSenha(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return  prefs.getString(PreferenceKeys.KEY_SENHA, null);
    }


    public static boolean saveImage(String imagem, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(PreferenceKeys.KEY_IMAGEM, imagem);
        prefsEditor.apply();
        return true;
    }

    public static String getImage(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(PreferenceKeys.KEY_IMAGEM, null);
    }

}
