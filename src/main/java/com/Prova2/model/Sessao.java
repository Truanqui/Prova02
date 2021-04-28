package com.Prova2.model;

public class Sessao {
    private int idSessao;
    private String HorarioDoFilme;
    private String DataDoFilme;
    private int AssentoDisponivel;
    private Filme filme;

    public int getIdSessao() {

        return idSessao;
    }

    public void setIdSessao(int idSessao) {

        this.idSessao = idSessao;
    }

    public String getHorarioDoFilme() {

        return HorarioDoFilme;
    }

    public void setHorarioDoFilme(String horarioDoFilme) {

        HorarioDoFilme = horarioDoFilme;
    }

    public String getDataDoFilme() {

        return DataDoFilme;
    }

    public void setDataDoFilme(String dataDoFilme) {

        DataDoFilme = dataDoFilme;
    }

    public int getAssentoDisponivel() {

        return AssentoDisponivel;
    }

    public void setAssentoDisponivel(int assentoDisponivel) {

        AssentoDisponivel = assentoDisponivel;
    }
    public Filme getFilme(){

        return filme;
    }
    public void setFilme(Filme filme){

        this.filme = filme;
    }
}
