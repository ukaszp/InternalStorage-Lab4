package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText imieEditText = findViewById(R.id.imie);
                String imie = imieEditText.getText().toString();

                EditText nazwiskoEditText = findViewById(R.id.nazwisko);
                String nazwisko = nazwiskoEditText.getText().toString();

                EditText miejscowoscEditText = findViewById(R.id.miejscowosc);
                String miejscowosc = miejscowoscEditText.getText().toString();

                EditText ulicaEditText = findViewById(R.id.ulica);
                String ulica = ulicaEditText.getText().toString();

                EditText nrDomuEditText = findViewById(R.id.nrd);
                String nrDomu = nrDomuEditText.getText().toString();

                EditText nrMieszkaniaEditText = findViewById(R.id.nrm);
                String nrMieszkania = nrMieszkaniaEditText.getText().toString();

                EditText kodPocztowyEditText = findViewById(R.id.kodc);
                String kodPocztowy = kodPocztowyEditText.getText().toString();

                RadioGroup radioGroup = findViewById(R.id.radio_group);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String plec = radioButton.getText().toString();

                // pobieranie
                CheckBox plywanieCheckBox = findViewById(R.id.plywanie);
                boolean plywanie = plywanieCheckBox.isChecked();

                CheckBox koszykowkaCheckBox = findViewById(R.id.koszykowka);
                boolean koszykowka = koszykowkaCheckBox.isChecked();

                CheckBox jazdaKonnaCheckBox = findViewById(R.id.kon);
                boolean jazdaKonna = jazdaKonnaCheckBox.isChecked();

                CheckBox siatkowkaCheckBox = findViewById(R.id.siatkowka);
                boolean siatkowka = siatkowkaCheckBox.isChecked();

                CheckBox joggingCheckBox = findViewById(R.id.jogging);
                boolean jogging = joggingCheckBox.isChecked();

                CheckBox pilkaNoznaCheckBox = findViewById(R.id.noga);
                boolean pilkaNozna = pilkaNoznaCheckBox.isChecked();

                // druga
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("IMIE", imie);
                intent.putExtra("NAZWISKO", nazwisko);
                intent.putExtra("MIEJSCOWOSC", miejscowosc);
                intent.putExtra("ULICA", ulica);
                intent.putExtra("NR_DOMU", nrDomu);
                intent.putExtra("NR_MIESZKANIA", nrMieszkania);
                intent.putExtra("KOD_POCZTOWY", kodPocztowy);
                intent.putExtra("PLEC", plec);
                intent.putExtra("PLYWANIE", plywanie);
                intent.putExtra("KOSZYKOWKA", koszykowka);
                intent.putExtra("JAZDA_KONNA", jazdaKonna);
                intent.putExtra("SIATKOWKA", siatkowka);
                intent.putExtra("JOGGING", jogging);
                intent.putExtra("PILKA_NOZNA", pilkaNozna);

                startActivity(intent);
            }
        });
    }
}
