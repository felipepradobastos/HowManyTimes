package ffscompany.howmanytimes.DAOS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ffscompany.howmanytimes.DB.DBConnection;
import ffscompany.howmanytimes.Model.Task;

public class TaskDAO {
    private SQLiteDatabase db;
    private DBConnection connection;

    public TaskDAO(Context context){
        connection = new DBConnection(context);
    }

    public String insertTask(Task task){
        ContentValues values;
        long result;

        db = connection.getWritableDatabase();
        values = new ContentValues();
        values.put(connection.NAME, task.getName());
        values.put(connection.DOTIMES, task.getDoTimes());
        values.put("PHOTOID", task.getPhotoId());

        result = db.insert(DBConnection.TASK, null, values);
        db.close();

        if (result ==-1)
            return "Erro ao inserir registro";
        else
            Log.w("Insercao:", "Sucesso, "+task.getName());
            return "";
    }

    public Cursor getTasks(){
        Cursor cursor;
        String[] campos =  {connection.ID,connection.NAME,connection.DOTIMES,connection.CREATIONDATE,"PHOTOID"};
        db = connection.getReadableDatabase();
        cursor = db.query(connection.TASK, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor getTasksById(int id){
        Cursor cursor;
        String[] campos =  {connection.ID,connection.NAME,connection.DOTIMES,connection.CREATIONDATE};
        String where = connection.ID + "=" + id;
        db = connection.getReadableDatabase();
        cursor = db.query(connection.TASK,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void updateTask(Task task){
        ContentValues valores;
        String where;

        db = connection.getWritableDatabase();

        where = connection.ID + "=" + task.getId();

        valores = new ContentValues();
        valores.put(connection.DOTIMES, task.getDoTimes());
        valores.put(connection.NAME, task.getDoTimes());

        db.update(connection.TASK,valores,where,null);
        db.close();
    }

    public void IncreaseDoTimes(Task task){
        ContentValues valores;
        String where;

        db = connection.getWritableDatabase();

        where = "ID=" + task.getId();
        Log.w("ID=", String.valueOf(task.getId()));
        valores = new ContentValues();
        valores.put("DOTIMES", task.getDoTimes());
        db.update("TASK",valores,where,null);
        db.close();
    }


    public void deletaRegistro(Task task){
        String where = "NAME" + "=" + task.getName();
        db = connection.getReadableDatabase();
        db.delete("TASK",where,null);
        db.close();
    }
}
