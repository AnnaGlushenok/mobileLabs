package lab.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void click(View view) {
        Toast.makeText(this, "Привет " + ((Button) view).getText(), Toast.LENGTH_LONG).show();
    }

    public void mainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}