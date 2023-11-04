package lab.lab1.presenters;

import lab.lab1.Contract;
import lab.lab1.Model;
import lab.lab1.Student;
import lab.lab1.activities.AddStudentActivity;

public class AddPresenter implements Contract.Presenter.AddPresenter {
    private AddStudentActivity activity;
    private Contract.Model model;

    public AddPresenter(AddStudentActivity activity) {
        this.activity = activity;
        this.model = Model.getModel(activity.getFilesDir());
    }

    @Override
    public void onAddStudent(Student student) {
        model.add(student);
        activity.onClose();
    }
}
