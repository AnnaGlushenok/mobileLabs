package lab.lab1.presenters;

import android.content.Intent;

import java.io.Serializable;
import java.util.stream.Collectors;

import lab.lab1.Contract;
import lab.lab1.Model;
import lab.lab1.Student;
import lab.lab1.activities.AddStudentActivity;
import lab.lab1.activities.EditStudentActivity;
import lab.lab1.activities.MainActivity;

public class MainPresenter implements Contract.Presenter.MainPresenter {
    private MainActivity activity;
    private Contract.Model model;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
        model = Model.getModel();
    }

    @Override
    public void showAll() {
        activity.showAllStudents(model.get());
    }

    @Override
    public void onAddStudentClick() {
        activity.startActivity(new Intent(activity, AddStudentActivity.class));
    }

    @Override
    public void onEditStudentClick(Student student) {
        activity.startActivity(new Intent(activity, EditStudentActivity.class).putExtra("student", (Serializable) student));
    }

    @Override
    public void onDeleteStudentClick(Student student) {
        model.delete(student);
        showAll();
    }

    @Override
    public void onStudentsByDepartmentClick(String department) {
        activity.showStudentsByDepartment(model
                .get()
                .stream()
                .filter(d -> d.getDepartment().equals(department))
                .collect(Collectors.toList()));
    }

    @Override
    public void onStudentsByBirthClick(String birth) {
        activity.showStudentsByDepartment(model
                .get()
                .stream()
                .filter(d -> d.getBirth().matches(".*" + birth))
                .collect(Collectors.toList()));
    }
}
