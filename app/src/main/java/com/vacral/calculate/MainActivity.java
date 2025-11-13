package com.vacral.calculate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private double x, y;
    private String operation;
    boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           // Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //return insets;
        //});
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    v.getPaddingLeft(),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    systemBarsInsets.bottom // добавляем нижний отступ
            );
            return insets;
        });
        textView = findViewById(R.id.text_view);

        initLisnteners();
    }

    private void initLisnteners() {
        findViewById(R.id.btn_plus_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExtraOperation(v);
            }
        });
        findViewById(R.id.procent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExtraOperation(v);
            }
        });
        findViewById(R.id.btn_tochka).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_fwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_thee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });   findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });findViewById(R.id.btn_ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onOperation(v);
            }
        });
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onOperation(v);
            }
        });
        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onOperation(v);
            }
        });
        findViewById(R.id.btn_umnojit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onOperation(v);
            }
        });
        findViewById(R.id.btn_razdelit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onOperation(v);
            }
        });

    }
    private void onNumberClick(View view){
        String text = ((MaterialButton)view).getText().toString();
        if(text.equals("AC")){
            textView.setText("0");
            x = 0;
            y = 0;
            operation = null;
        }else if(textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }
    private  void  onOperation(View view){
if(view.getId() == R.id.btn_plus){
    x = Double.parseDouble(textView.getText().toString());
    operation = "+";
        }else if(view.getId() == R.id.btn_minus){
    x = Double.parseDouble(textView.getText().toString());
    operation = "-";
        }else if(view.getId() == R.id.btn_umnojit){
    x = Double.parseDouble(textView.getText().toString());
    operation = "*";
        }else if(view.getId() == R.id.btn_razdelit){
    x = Double.parseDouble(textView.getText().toString());
    operation = "/";
        } else if (view.getId() == R.id.btn_equal) {
    y = Double.parseDouble(textView.getText().toString());
    double result = 0;

    if(operation.equals("+")){
        result = x + y;
    }else if(operation.equals("-")){
        result = x - y;
    }else if(operation.equals("*")){
        result = x * y;
    }else if (operation.equals("/")){
        if(y == 0 ){
            textView.setText("Ошибка");
            return;
        }else {
            result = x / y;
        }
    }
    if (result == (int)result){
    textView.setText(String.valueOf((int) result));
    }else {
        textView.setText(String.valueOf(result));
    }
}
        isOperationClick = true;
    }
    private void onExtraOperation(View view){
        double number = Double.parseDouble(textView.getText().toString());
        if (view.getId() == R.id.procent){
            number = number / 100;
        } else if(view.getId() == R.id.btn_plus_minus) {
number = number * -1;
        }
        if (number == (int)number){
            textView.setText(String.valueOf((int)number));
        }else {
            textView.setText(String.valueOf(number));
        }
    }

}