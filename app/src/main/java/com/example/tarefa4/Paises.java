package com.example.tarefa4;

public class Paises {
    public String nome;
    public String latitude;
    public String longitude;

    Paises(String nome, String latitude, String longitude)
    {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude(){
        return longitude;
    }

    @Override public String toString() {
        return this.nome ;
    }
}
