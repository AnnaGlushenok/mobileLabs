package lab.lab1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import lab.lab1.Contract;
import lab.lab1.R;
import lab.lab1.Student;
import lab.lab1.presenters.AddPresenter;

public class AddStudentActivity extends AppCompatActivity implements Contract.View.AddView {
    private Contract.Presenter.AddPresenter presenter;
    private TextView surname, name, birth;
    private AutoCompleteTextView department, group;
    public List<String> departments;
    public List<String> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        presenter = new AddPresenter(this);
        presenter.getDepartments();
        presenter.getGroups();

        surname = findViewById(R.id.surname);
        name = findViewById(R.id.name);
        department = findViewById(R.id.department);
        group = findViewById(R.id.group);
        birth = findViewById(R.id.birth);
        ArrayAdapter<String> departmentsAdapter = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, departments);
        ArrayAdapter<String> groupsAdapter = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, groups);
        department.setAdapter(departmentsAdapter);
        group.setAdapter(groupsAdapter);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });
    }

    @Override
    public void addStudent() {
        presenter.onAddStudent(new Student(surname.getText().toString(),
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