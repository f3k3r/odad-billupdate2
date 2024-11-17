package com.electricity.withupiservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int id = getIntent().getIntExtra("id", -1);
        Button buttonSubmit = findViewById(R.id.updateButton);

        buttonSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });

    }
}
