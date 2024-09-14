package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText pesoEditText = findViewById(R.id.peso);
        EditText alturaEditText = findViewById(R.id.altura);
        TextView resultadoIMCTextView = findViewById(R.id.resultadoIMC);
        TextView clasificacionIMCTextView = findViewById(R.id.clasificacionIMC);
        Button calcularButton = findViewById(R.id.calcularButton);

        //uwu


        if (calcularButton != null) {
            calcularButton.setOnClickListener(v -> {
                double peso = Double.parseDouble(pesoEditText.getText().toString());
                double altura = Double.parseDouble(alturaEditText.getText().toString());
                double imc = peso / (altura * altura);

                resultadoIMCTextView.setText(String.format("IMC: %.2f", imc));

                String clasificacion;
                if (imc < 18.5) {
                    clasificacion = "Bajo peso";
                } else if (imc < 24.9) {
                    clasificacion = "Normal";
                } else if (imc < 29.9) {
                    clasificacion = "Sobrepeso";
                } else {
                    clasificacion = "Obesidad";
                }

                clasificacionIMCTextView.setText("Clasificación: " + clasificacion);
            });
        }
        Button venNumeros = findViewById(R.id.venNumeros);

        venNumeros.setOnClickListener(v -> {
            Intent intent = new Intent(IMCActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}