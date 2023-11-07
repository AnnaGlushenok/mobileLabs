package lab.lab1.presenters;

import java.util.stream.Collectors;

import lab.lab1.Contract;
import lab.lab1.Model;
import lab.lab1.Student;
import lab.lab1.activities.EditStudentActivity;

public class EditPresenter implements Contract.Presenter.EditPresenter {
    private EditStudentActivity activity;
    private Contract.Model model;

    public EditPresenter(EditStudentActivity activity) {
        this.activity = activity;
        this.model = Model.getModel(activity.getFilesDir());
    }

    @Override
    public void onEditStudent(Student oldStudent, Student newStudent) {
        model.edit(oldStudent, newStudent);
        activity.onClose();
    }

    @Override
    public void getDepartments() {
        activity.departments = model.get()
                .stream()
                .map(Student::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void getGroups() {
        activity.groups = model.get()
                .stream()
                .map(Student::getGroup)
                .distinct()
                .collect(Collectors.toList());
    }
}
