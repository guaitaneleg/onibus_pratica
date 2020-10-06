package com.example.onibusatividade;

public class Busao {

    private String marca;
    private String modelo;
    private String origem_destino;
    private String tipo;
    private int assentos;
    private int assentos_ocupados;

    Busao(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOrigem_destino() {
        return origem_destino;
    }

    public void setOrigem_destino(String origem_destino) {
        this.origem_destino = origem_destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public int getAssentos_ocupados() {
        return assentos_ocupados;
    }

    public void setAssentos_ocupados(int assentos_ocupados) {
        this.assentos_ocupados = assentos_ocupados;
    }
}
