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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText minRango = findViewById(R.id.minRango);
        EditText maxRango = findViewById(R.id.maxRango);
        TextView resultTextView = findViewById(R.id.resultado);

        // Configurar el botón para generar un número aleatorio
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            // Obtener los valores de los rangos ingresados por el usuario
            int min = Integer.parseInt(minRango.getText().toString());
            int max = Integer.parseInt(maxRango.getText().toString());

            // Generar un número aleatorio dentro del rango especificado
            int randomNum = new Random().nextInt((max - min) + 1) + min;

            // Mostrar el número aleatorio en el TextView
            resultTextView.setText(String.valueOf(randomNum));
        });

        //Aqui se utiliza el cambiar de ventana, pasando a la actividad IMCActivity con el método startActivity de la actividad principal.
        Button buttonIMC = findViewById(R.id.venIMC);

        buttonIMC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IMCActivity.class);
            startActivity(intent);
        });
    }
}






