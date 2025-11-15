package com.vacral.calculate;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        FrameLayout heart = findViewById(R.id.heart_container);
        ImageView heartBg = findViewById(R.id.heart_bg);
        TextView tv = findViewById(R.id.text_view_second);

        // Клик по сердцу – меняем состояние
        heart.setOnClickListener(v -> {
            heartBg.setSelected(!heartBg.isSelected());
        });

        // Отступы
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Показываем результат
        String result = getIntent().getStringExtra("result");
        tv.setText(result);
    }
}

