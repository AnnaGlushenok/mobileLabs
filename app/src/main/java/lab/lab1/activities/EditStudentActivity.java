package lab.lab1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import lab.lab1.Contract;
import lab.lab1.R;
import lab.lab1.Student;
import lab.lab1.presenters.EditPresenter;

public class EditStudentActivity extends AppCompatActivity implements Contract.View.EditView {
    private Contract.Presenter.EditPresenter presenter;
    private TextView surname, name, department, group, birth;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        presenter = new EditPresenter(this);
        student = (Student) getIntent().getSerializableExtra("student");
        surname = findViewById(R.id.surname);
        name = findViewById(R.id.name);
        department = findViewById(R.id.department);
        group = findViewById(R.id.group);
        birth = findViewById(R.id.birth);

        surname.setText(student.getSurname());
        name.setText(student.getName());
        department.setText(student.getDepartment());
        group.setText(student.getGroup());
        birth.setText(student.getBirth());
        findViewById(R.id.edit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent();
            }
        });
    }

    @Override
    public void editStudent() {
        presenter.onEditStudent(student,
                new Student(surname.getText().toString(),
                        name.getText().toString(),
                        department.getText().toString(),
                        group.getText().toString(),
                        birth.getText().toString()));
    }

    @Override
    public void onClose() {
        startActivity(new Intent(this, MainActivity.class));
    }
}