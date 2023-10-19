package lab.lab1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

public class Student implements Serializable {
    private String surname, name, department, group, birth;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getGroup() {
        return group;
    }

    public String getBirth() {
        return birth;
    }

    public Student(String surname, String name, String department, String group, String birth) {
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.group = group;
        this.birth = birth;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", surname, name, department, group, birth);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Student)) return false;
        Student o = (Student) obj;
        return o.surname.equals(this.surname) &&
                o.name.equals(this.name) &&
                o.department.equals(this.department) &&
                o.group.equals(this.group) &&
                o.birth.equals(this.birth);
    }
}