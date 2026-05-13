package com.example.ksiazka;

public class Book {
    private String tytul;
    private String autor;
    private String gatunek;
    private boolean czNowa;
    private double cena;
    private int promocja;
    private String dostepnosc;
    private String kategoriaWiekowa;
    private float ocena;

    public Book(String tytul, String autor, String gatunek, boolean czNowa,
                double cena, int promocja, String dostepnosc, String kategoriaWiekowa, float ocena) {
        this.tytul = tytul;
        this.autor = autor;
        this.gatunek = gatunek;
        this.czNowa = czNowa;
        this.cena = cena;
        this.promocja = promocja;
        this.dostepnosc = dostepnosc;
        this.kategoriaWiekowa = kategoriaWiekowa;
        this.ocena = ocena;
    }

    public String getTytul() { return tytul; }
    public String getAutor() { return autor; }
    public String getGatunek() { return gatunek; }
    public boolean isCzNowa() { return czNowa; }
    public double getCena() { return cena; }
    public int getPromocja() { return promocja; }
    public String getDostepnosc() { return dostepnosc; }
    public String getKategoriaWiekowa() { return kategoriaWiekowa; }
    public float getOcena() { return ocena; }
}