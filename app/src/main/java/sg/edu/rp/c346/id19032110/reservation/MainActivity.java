package sg.edu.rp.c346.id19032110.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etSize;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    ToggleButton toggleTable;
    Button btnConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.editTextNumber);
        etSize = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReset = findViewById(R.id.buttonReset);
        toggleTable = findViewById(R.id.toggleTable);
        btnConfirmation = findViewById(R.id.buttonConfirmation);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 5, 01);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5, 01);
                etName.setText("");
                etSize.setText("");
                etNumber.setText("");
            }
        });

        btnConfirmation.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleTable.isChecked()) {
                    String text = "Name: " + etName.getText().toString() + "\nPhone number: " + etNumber.getText().toString() + "\nTable size: " + etSize.getText().toString()
                            + "\nSmoking Table: True" + "\nDate:" + dp.getDayOfMonth() + "/" + dp.getMonth()+1 + "/" + dp.getYear() + "\nTime:" + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                    Toast toast = Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    String text = "Name: " + etName.getText().toString() + "\nPhone number: " + etNumber.getText().toString() + "\nTable size: " + etSize.getText().toString()
                            + "\nSmoking Table: False" + "\nDate:" + dp.getDayOfMonth() + "/" + dp.getMonth()+1 + "/" + dp.getYear() + "\nTime:" + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                    Toast toast = Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }));
    }
}
