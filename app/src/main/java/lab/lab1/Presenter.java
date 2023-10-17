package lab.lab1;

import android.widget.ListView;

import java.util.List;

public class Presenter implements Contract.Presenter {// а это связь шота типа BLL
    private MainActivity activity;
    private Model model;

    public Presenter(MainActivity activity) {
        this.activity = activity;
        model = new Model();
    }


    @Override
    public void onStart() {
        model.showAllStudents(model.get());
    }

    @Override
    public void onAddStudentClick() {

    }

    @Override
    public void onEditStudentClick() {

    }

    @Override
    public void onStudentsByDepartmentClick() {

    }

    @Override
    public void onStudentsByBirthClick() {

    }
}
