package ru.ponomarevss.lesson3.seminar.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

    private String title;
    private boolean isDone;

    public ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
        isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

//    region Externalizable Implementation

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(title);
        objectOutput.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        title = (String) objectInput.readObject();
        isDone = objectInput.readBoolean();
    }
//    endregion

}
