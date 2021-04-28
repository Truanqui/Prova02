package com.Prova2.model;

public class Filme {
    private int idFilme;
    private String NomeFilme;
    private String DuracaoFilme;
    private String Classificacao;
    private String Sinopse;
    private String Genero;

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return NomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        NomeFilme = nomeFilme;
    }

    public String getDuracaoFilme() {
        return DuracaoFilme;
    }

    public void setDuracaoFilme(String duracaoFilme) {
        DuracaoFilme = duracaoFilme;
    }

    public String getClassificacao() {
        return Classificacao;
    }

    public void setClassificacao(String classificacao) {
        Classificacao = classificacao;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public void setSinopse(String sinopse) {
        Sinopse = sinopse;
    }

    public String getGenero() { return Genero; }

    public void setGenero(String genero) { Genero = genero; }
}
