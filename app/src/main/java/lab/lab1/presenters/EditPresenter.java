package lab.lab1.presenters;

import lab.lab1.Contract;
import lab.lab1.Model;
import lab.lab1.Student;
import lab.lab1.activities.EditStudentActivity;

public class EditPresenter implements Contract.Presenter.EditPresenter {
    private EditStudentActivity activity;
    private Contract.Model model;

    public EditPresenter(EditStudentActivity activity) {
        this.activity = activity;
        this.model = Model.getModel();
    }

    @Override
    public void onEditStudent(Student oldStudent, Student newStudent) {
        model.edit(oldStudent, newStudent);
        activity.onClose();
    }
}
