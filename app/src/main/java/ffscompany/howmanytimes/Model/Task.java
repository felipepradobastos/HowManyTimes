package ffscompany.howmanytimes.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;

import ffscompany.howmanytimes.R;

public class Task implements Parcelable {

    // Variable Declaration
    private int id;
    private int doTimes;
    private String name;
    private String creationTime;
    private int photoId;
    private int  toFirstTask;

    // Constructors

    public Task(int doTimes, String name) {
        this.doTimes = doTimes;
        this.name = name;
    }

    public Task(int Id, String name,int doTimes, String creationTime,int photoId) {
        this.doTimes = doTimes;
        this.name = name;
        this.creationTime = creationTime;
        this.photoId = photoId;
        this.id=Id;
    }
    public Task(String name,int doTimes, int photoId,String creationTime) {
        this.doTimes = doTimes;
        this.name = name;
        this.creationTime = creationTime;
        this.photoId = photoId;
        this.toFirstTask =1;
    }
    public Task(int Id, String name,int doTimes, String creationTime) {
        this.doTimes = doTimes;
        this.name = name;
        this.creationTime = creationTime;
        this.id=id;

    }


    public Task() {

    }
    // Getters and Setters


    public int getToFirstTask() {
        return toFirstTask;
    }

    public void setToFirstTask(int toFirstTask) {
        this.toFirstTask = toFirstTask;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getDoTimes() {
        return doTimes;
    }

    public void setDoTimes(int doTimes) {
        this.doTimes = doTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public static Creator<Task> getCREATOR() {
        return CREATOR;
    }

    // Parcelable Methods

    protected Task(Parcel in) {
        doTimes = in.readInt();
        name = in.readString();
        id = in.readInt();
        creationTime = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(doTimes);
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(creationTime);
    }

    public ArrayList<Task> initializeData(){
        ArrayList<Task> task =  new ArrayList<>();
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date(2019,11,29));
        task.add(new Task("Tênis \nde \nMesa",0, R.drawable.tenisdemesa, currentDateTimeString));
        task.add(new Task("Cinema", 0, R.drawable.cinema, currentDateTimeString));
        task.add(new Task("Progamar", 0, R.drawable.progamar, currentDateTimeString));
        return task;
    }
}
