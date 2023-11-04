package lab.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView res = (TextView) findViewById(R.id.result);
        EditText enterSum = (EditText) findViewById(R.id.enter_sum);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        RadioButton buyRadioBtn = (RadioButton) findViewById(R.id.buy_radio_button);
        final double[] currency = {0};
        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sum = 0;
                try {
                    sum = Double.parseDouble(enterSum.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Ерунду ввёл", Toast.LENGTH_SHORT).show();
                }
                double result = 0;
                if (buyRadioBtn.isChecked())
                    result = sum * currency[0];
                else
                    result = sum / currency[0];
                res.setText(String.valueOf(result));
            }
        });
        ArrayAdapter<String> list = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.spinner_array)
        );
        spinner.setAdapter(list);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                currency[0] = Currency.getVal(adapterView.getItemAtPosition(i).toString());
                ((TextView) findViewById(R.id.currency_rate)).setText(String.valueOf(currency[0]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}