package lab.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecondActivity extends AppCompatActivity {
    List<Student> students = new ArrayList<Student>() {
        {
            add(new Student("Мария", 7));
            add(new Student("Вотер", 9));
            add(new Student("Лиза", 6));
            add(new Student("Никита", 7));
            add(new Student("Антон", 4));
            add(new Student("Кирилл", 8));
            add(new Student("Никита", 3));
        }
    };
    ActivityResultLauncher<List<Student>> starter = registerForActivityResult(new StudentContract(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.list_view);
        StudentAdapter adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> list =
                new ArrayAdapter<>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        getResources().getStringArray(R.array.spinner_array)
                );
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(list);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int mark = Integer.parseInt((String) adapterView.getItemAtPosition(i));
                students = students.stream()
                        .filter(s -> s.getMark() >= mark)
                        .collect(Collectors.toList());
                listView.setAdapter(
                        new StudentAdapter(adapterView.getContext(), students));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        starter.launch(students);
    }
}