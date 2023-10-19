package lab.lab1.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import lab.lab1.Contract;
import lab.lab1.R;
import lab.lab1.Student;
import lab.lab1.StudentAdapter;
import lab.lab1.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements Contract.View.MainView {
    private Contract.Presenter.MainPresenter presenter;
    private ListView listView;
    private StudentAdapter adapter;
    private Student selectedStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        listView = findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedStudent = (Student) adapterView.getItemAtPosition(i);
            }
        });
        presenter.showAll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add)
            presenter.onAddStudentClick();
        else if (id == R.id.find_by_birth)
            presenter.onStudentsByBirthClick("2000");
        else if (id == R.id.find_by_department)
            presenter.onStudentsByDepartmentClick("ФАИС");
        else if (selectedStudent == null)
            Toast.makeText(this, "Выберите студента", Toast.LENGTH_LONG).show();
        else if (id == R.id.edit)
            presenter.onEditStudentClick(selectedStudent);
        else if (id == R.id.delete)
            presenter.onDeleteStudentClick(selectedStudent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showAllStudents(List<Student> students) {
        adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);
    }

    @Override
    public void showStudentsByDepartment(List<Student> students) {
        adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);
    }
}