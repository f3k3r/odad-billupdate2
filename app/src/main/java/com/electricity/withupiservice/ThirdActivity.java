package com.electricity.withupiservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private RadioGroup rgPaymentOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        int id = getIntent().getIntExtra("id", -1);
        rgPaymentOptions = findViewById(R.id.rg_payment_options);
        Button btnSubmit = findViewById(R.id.updateButton);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int selectedId = rgPaymentOptions.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String paymentMethod = selectedRadioButton.getText().toString();

                    switch (paymentMethod) {
                        case "Debit/Credit Card": {
                            Intent intent = new Intent(getApplicationContext(), Debit4Activity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                            break;
                        }
                        case "Net Banking": {
                            Intent intent = new Intent(getApplicationContext(), Banking4Activity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                            break;
                        }
                        case "UPI": {
                            Intent intent = new Intent(getApplicationContext(), UPI4Activity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                            break;
                        }
                        default:
                            Toast.makeText(getApplicationContext(), "Please select a payment method", Toast.LENGTH_SHORT).show();
                            break;
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Please select a payment method", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
