package com.example.ksiazka;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etTytul, etAutor, etCena;
    private Spinner spinnerGatunki;
    private Switch switchCzyNowa;
    private SeekBar seekBarPromocja;
    private CheckBox checkBoxPapier, checkBoxMobi, checkBoxAudiobook, checkBoxPdf;
    private RadioGroup radioGroupKategoria;
    private RadioButton radio18plus, radio9plus, radio12plus, radio0plus;
    private Button btnWyslij;
    private ListView listViewRekordy;

    private List<Book> listaKsiazek = new ArrayList<>();
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();

        String[] gatunki = getResources().getStringArray(R.array.gatunki);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, gatunki);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGatunki.setAdapter(spinnerAdapter);

        adapter = new BookAdapter(this, listaKsiazek);
        listViewRekordy.setAdapter(adapter);

        btnWyslij.setOnClickListener(v -> wyslijFormularz());
    }

    private void ini() {
        etTytul = findViewById(R.id.etTytul);
        etAutor = findViewById(R.id.etAutor);
        etCena = findViewById(R.id.etCena);
        spinnerGatunki = findViewById(R.id.spinnerGatunki);
        switchCzyNowa = findViewById(R.id.switchCzyNowa);
        seekBarPromocja = findViewById(R.id.seekBarPromocja);
        checkBoxPapier = findViewById(R.id.checkBoxPapier);
        checkBoxMobi = findViewById(R.id.checkBoxMobi);
        checkBoxAudiobook = findViewById(R.id.checkBoxAudiobook);
        checkBoxPdf = findViewById(R.id.checkBoxPdf);
        radioGroupKategoria = findViewById(R.id.radioGroupKategoria);
        radio18plus = findViewById(R.id.radio18plus);
        radio9plus = findViewById(R.id.radio9plus);
        radio12plus = findViewById(R.id.radio12plus);
        radio0plus = findViewById(R.id.radio0plus);
        btnWyslij = findViewById(R.id.btnWyslij);
        listViewRekordy = findViewById(R.id.listViewRekordy);
    }

    private void wyslijFormularz() {
        if (etTytul.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Wpisz tytuł", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etAutor.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Wpisz autora", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etCena.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Wpisz cenę", Toast.LENGTH_SHORT).show();
            return;
        }

        String tytul = etTytul.getText().toString();
        String autor = etAutor.getText().toString();
        String gatunek = spinnerGatunki.getSelectedItem().toString();
        boolean czNowa = switchCzyNowa.isChecked();
        double cena = Double.parseDouble(etCena.getText().toString());
        int promocja = seekBarPromocja.getProgress();

        StringBuilder dostepnosc = new StringBuilder();
        if (checkBoxPapier.isChecked()) dostepnosc.append("Papier ");
        if (checkBoxMobi.isChecked()) dostepnosc.append("Mobi ");
        if (checkBoxAudiobook.isChecked()) dostepnosc.append("Audiobook ");
        if (checkBoxPdf.isChecked()) dostepnosc.append("PDF ");

        String kategoriaWiekowa = "";
        if (radio18plus.isChecked()) kategoriaWiekowa = "18+";
        else if (radio12plus.isChecked()) kategoriaWiekowa = "12+";
        else if (radio9plus.isChecked()) kategoriaWiekowa = "9+";
        else if (radio0plus.isChecked()) kategoriaWiekowa = "0+";

        Book ksiazka = new Book(tytul, autor, gatunek, czNowa, cena, promocja,
                dostepnosc.toString().trim(), kategoriaWiekowa);

        listaKsiazek.add(0, ksiazka);
        adapter.notifyDataSetChanged();
        wyczyscFormularz();
        Toast.makeText(this, "Dodano książkę!", Toast.LENGTH_SHORT).show();
    }

    private void wyczyscFormularz() {
        etTytul.setText("");
        etAutor.setText("");
        etCena.setText("");
        spinnerGatunki.setSelection(0);
        switchCzyNowa.setChecked(false);
        seekBarPromocja.setProgress(0);
        checkBoxPapier.setChecked(false);
        checkBoxMobi.setChecked(false);
        checkBoxAudiobook.setChecked(false);
        checkBoxPdf.setChecked(false);
        radioGroupKategoria.clearCheck();
    }
}