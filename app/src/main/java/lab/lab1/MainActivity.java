package lab.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Student> students = (List<Student>) getIntent().getSerializableExtra("students");

        StringBuilder str = new StringBuilder();
        if (students != null)
            students.forEach(str::append);

        ((TextView) findViewById(R.id.text_result)).setText(str);
    }

    public void find(View view) {
        findViewById(R.id.radio_group).setVisibility(View.VISIBLE);
    }

    public void firstActivity(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }

    public void secondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}