package com.example.ksiazka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book ksiazka = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_book, parent, false);
        }

        TextView tvTytul = convertView.findViewById(R.id.tvTytul);
        TextView tvAutor = convertView.findViewById(R.id.tvAutor);
        TextView tvGatunek = convertView.findViewById(R.id.tvGatunek);
        TextView tvCena = convertView.findViewById(R.id.tvCena);
        TextView tvDostepnosc = convertView.findViewById(R.id.tvDostepnosc);
        TextView tvKategoria = convertView.findViewById(R.id.tvKategoria);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);

        tvTytul.setText(ksiazka.getTytul());
        tvAutor.setText("Autor: " + ksiazka.getAutor());
        tvGatunek.setText("Gatunek: " + ksiazka.getGatunek());

        if (ksiazka.getPromocja() > 0) {
            double cenaPo = ksiazka.getCena() * (1 - ksiazka.getPromocja() / 100.0);
            tvCena.setText(String.format("%.2f zł  (-%d%%  ->  %.2f zł)",
                    ksiazka.getCena(), ksiazka.getPromocja(), cenaPo));
        } else {
            tvCena.setText(String.format("%.2f zł", ksiazka.getCena()));
        }

        tvDostepnosc.setText("Dostępna: " + ksiazka.getDostepnosc());
        tvKategoria.setText("Wiek: " + ksiazka.getKategoriaWiekowa());
        tvStatus.setText(ksiazka.isCzNowa() ? "NOWOŚĆ" : "");

        return convertView;
    }
}