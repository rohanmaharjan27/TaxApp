package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_salary;
    private Button btn_tax;
    private TextView tv_tax;
    float salary, tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_salary=findViewById(R.id.et_salary);
        btn_tax=findViewById(R.id.btn_tax);
        tv_tax=findViewById(R.id.tv_tax);

        btn_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salary=Float.parseFloat(et_salary.getText().toString());
                tv_tax.setText("Total Tax is "+calculateTax(salary));
            }
        });
    }

    private float calculateTax(float salary){
        if (salary>=1 && salary <=200000){
            tax=salary/100;
        }
        else if (salary>200000 && salary<=350000){
            tax=(200000f/100)+(salary-200000)*(15f/100);
        }
        else {
            tax=(200000f/100)+(150000*15f/100)+(salary-350000)*(25f/100);
        }
        return tax;
    }
}
