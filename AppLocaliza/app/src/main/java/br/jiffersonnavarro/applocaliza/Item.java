package br.jiffersonnavarro.applocaliza;

public class Item {
    //Usei os mesmos nomes da tela
    private String tvCidadeUF,tvLocal,tvLat,tvLong;

    public Item(String tvCidadeUF, String tvLocal, String tvLat, String tvLong) {
        this.tvCidadeUF = tvCidadeUF;
        this.tvLocal = tvLocal;
        this.tvLat = tvLat;
        this.tvLong = tvLong;
    }

    public String getTvCidadeUF() {
        return tvCidadeUF;
    }

    public void setTvCidadeUF(String tvCidadeUF) {
        this.tvCidadeUF = tvCidadeUF;
    }

    public String getTvLocal() {
        return tvLocal;
    }

    public void setTvLocal(String tvLocal) {
        this.tvLocal = tvLocal;
    }

    public String getTvLat() {
        return tvLat;
    }

    public void setTvLat(String tvLat) {
        this.tvLat = tvLat;
    }

    public String getTvLong() {
        return tvLong;
    }

    public void setTvLong(String tvLong) {
        this.tvLong = tvLong;
    }
}