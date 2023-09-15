package lab.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    List<Student> students = new ArrayList<Student>() {
        {
            add(new Student("Анна", 8));
            add(new Student("Денис", 5));
            add(new Student("Рома", 9));
            add(new Student("Настя", 7));
            add(new Student("Влад", 5));
            add(new Student("Миша", 7));
            add(new Student("Максим", 9));
        }
    };
    ActivityResultLauncher<List<Student>> starter = registerForActivityResult(new StudentContract(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {

        }
    });

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        GridView gridView = findViewById(R.id.grid_view);
        StudentAdapter adapter = new StudentAdapter(this, students);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                starter.launch(new ArrayList<>(Collections.singleton(students.get(i))));
            }
        });
    }
}
