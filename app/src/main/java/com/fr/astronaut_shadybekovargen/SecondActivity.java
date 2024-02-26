package com.fr.astronaut_shadybekovargen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Добавляем анимацию для текстового сообщения
        findViewById(R.id.textViewGreeting).setAlpha(0f);
        findViewById(R.id.textViewGreeting).animate().alpha(1f).setDuration(2000);

        Button buttonGreetings = findViewById(R.id.buttonGreetings);
        buttonGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }
}

