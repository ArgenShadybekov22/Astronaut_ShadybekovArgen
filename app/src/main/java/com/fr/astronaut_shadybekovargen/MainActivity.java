package com.fr.astronaut_shadybekovargen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextYearOfBirth;
    EditText editTextPlaceOfBirth;
    Button buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextYearOfBirth = findViewById(R.id.editTextYearOfBirth);
        editTextPlaceOfBirth = findViewById(R.id.editTextPlaceOfBirth);
        buttonShare = findViewById(R.id.buttonShare);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String yearOfBirth = editTextYearOfBirth.getText().toString().trim();
                String placeOfBirth = editTextPlaceOfBirth.getText().toString().trim();

                if (!name.isEmpty() && !yearOfBirth.isEmpty() && !placeOfBirth.isEmpty()) {
                    // Создаем текст сообщения для отправки
                    String message = "Имя: " + name + "\nГод рождения: " + yearOfBirth + "\nМесто рождения: " + placeOfBirth;

                    // Создаем новый интент для отправки сообщения
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, message);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Данные астронома"); // Тема сообщения

                    // Проверяем, есть ли приложения для обработки данного интента
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(Intent.createChooser(intent, "Выберите приложение для отправки данных"));
                    } else {
                        Toast.makeText(MainActivity.this, "Нет приложений для отправки данных", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

