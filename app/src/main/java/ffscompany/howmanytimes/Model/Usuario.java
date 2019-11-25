package ffscompany.howmanytimes.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Usuario implements Parcelable {
    private ArrayList<Task> taskList;
    private String id;
    private String name;
    private String email;
    private String birthDate;
    private String birthTime;
    private String createdAt;
    private String updatedAt;

    public Usuario(ArrayList<Task> taskList, String id, String name, String email, String birthDate, String birthTime, String createdAt, String updatedAt) {
        this.taskList = taskList;
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Usuario() {
    }

    protected Usuario(Parcel in) {
        taskList = in.createTypedArrayList(Task.CREATOR);
        id = in.readString();
        name = in.readString();
        email = in.readString();
        birthDate = in.readString();
        birthTime = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
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

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(taskList);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(birthDate);
        dest.writeString(birthTime);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
    }
}
