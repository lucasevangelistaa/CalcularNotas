package com.example.calcularnotas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4;
    private RadioButton aprovadoRadioButton, recuperacaoRadioButton;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        aprovadoRadioButton = findViewById(R.id.aprovadoRadioButton);
        recuperacaoRadioButton = findViewById(R.id.recuperacaoRadioButton);
        calcularButton = findViewById(R.id.calcularButton);

        // Ação do botão calcular
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });
    }

    private void calcularMedia() {
        try {
            // Pegando os valores das notas e convertendo para float
            float n1 = Float.parseFloat(nota1.getText().toString());
            float n2 = Float.parseFloat(nota2.getText().toString());
            float n3 = Float.parseFloat(nota3.getText().toString());
            float n4 = Float.parseFloat(nota4.getText().toString());

            // Calculando a média
            float media = (n1 + n2 + n3 + n4) / 4;

            // Verificando a média e ajustando os RadioButtons
            if (media >= 7) {
                aprovadoRadioButton.setChecked(true);
                recuperacaoRadioButton.setChecked(false);
                Toast.makeText(MainActivity.this, "Média: " + media + ". Aprovado!", Toast.LENGTH_SHORT).show();
            } else {
                aprovadoRadioButton.setChecked(false);
                recuperacaoRadioButton.setChecked(true);
                Toast.makeText(MainActivity.this, "Média: " + media + ". Recuperação!", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Por favor, insira todas as notas corretamente.", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
