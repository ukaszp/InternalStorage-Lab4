package com.example.lab1;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.widget.TextView;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import java.io.Console;
import java.io.FileOutputStream;


public class SecondActivity extends AppCompatActivity {

    public static String nameOfFile="summary.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        saveToFile(nameOfFile,displaySummary());

    }

    private String getSportSummary(boolean plywanie, boolean koszykowka, boolean jazdaKonna, boolean siatkowka, boolean jogging, boolean pilkaNozna) {
        StringBuilder summary = new StringBuilder();
        if (plywanie) {
            summary.append("Pływanie, ");
        }
        if (koszykowka) {
            summary.append("Koszykówka, ");
        }
        if (jazdaKonna) {
            summary.append("Jazda konna, ");
        }
        if (siatkowka) {
            summary.append("Siatkówka, ");
        }
        if (jogging) {
            summary.append("Jogging, ");
        }
        if (pilkaNozna) {
            summary.append("Piłka nożna, ");
        }

        if (summary.length() > 0) {
            summary.deleteCharAt(summary.length() - 2);
        }

        return summary.toString();
    }

    private String displaySummary()
    {
        Intent intent = getIntent();
        String imie = intent.getStringExtra("IMIE");
        String nazwisko = intent.getStringExtra("NAZWISKO");
        String miejscowosc = intent.getStringExtra("MIEJSCOWOSC");
        String ulica = intent.getStringExtra("ULICA");
        String nrDomu = intent.getStringExtra("NR_DOMU");
        String nrMieszkania = intent.getStringExtra("NR_MIESZKANIA");
        String kodPocztowy = intent.getStringExtra("KOD_POCZTOWY");
        String plec = intent.getStringExtra("PLEC");
        boolean plywanie = intent.getBooleanExtra("PLYWANIE", false);
        boolean koszykowka = intent.getBooleanExtra("KOSZYKOWKA", false);
        boolean jazdaKonna = intent.getBooleanExtra("JAZDA_KONNA", false);
        boolean siatkowka = intent.getBooleanExtra("SIATKOWKA", false);
        boolean jogging = intent.getBooleanExtra("JOGGING", false);
        boolean pilkaNozna = intent.getBooleanExtra("PILKA_NOZNA", false);

        TextView summaryTextView = findViewById(R.id.summary);
        String summaryText = "Imię: " + imie + "\n" +
                "Nazwisko: " + nazwisko + "\n" +
                "Miejscowość: " + miejscowosc + "\n" +
                "Ulica: " + ulica + "\n" +
                "Nr domu: " + nrDomu + "\n" +
                "Nr mieszkania: " + nrMieszkania + "\n" +
                "Kod pocztowy: " + kodPocztowy + "\n" +
                "Płeć: " + plec + "\n" +
                "Ulubione sporty: " + getSportSummary(plywanie, koszykowka, jazdaKonna, siatkowka, jogging, pilkaNozna);
        summaryTextView.setText(summaryText);

        return summaryText;
    }

    private void saveToFile(String fileName, String dataToSave)
    {
        TextView summaryTextView = findViewById(R.id.summary);
        try {
            FileOutputStream fos= openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(dataToSave.getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("SaveToFile", "Exception: " + e.getMessage());
            summaryTextView.setText("CANNOT SAVE DATA" + e.getMessage());
        }

    }
}