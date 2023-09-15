package lab.lab1;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int mark;

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": " + mark + "\n";
    }
}
