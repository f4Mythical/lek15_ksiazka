package com.example.ksiazka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();
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
}