package lab.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        presenter.onStart();
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
        else if (id == R.id.edit)
            presenter.onEditStudentClick();
//        else if (id == R.id.delete)
//            startActivity(new Intent(this, .class));
//        else if (id == R.id.find_by_birth)
//            startActivity(new Intent(this, .class));
//        else if (id == R.id.find_by_department)
//            startActivity(new Intent(this, .class));
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
}