package com.Prova2.dao;

import com.Prova2.factory.ConnectionFactory;
import com.Prova2.model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection connection;

    public FilmeDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableFilme();
    }
    public  void createTableFilme(){
        String sql = "CREATE TABLE IF NOT EXIST filme(" +
                "idFilme PRIMARY KEY AUTO_INCREMENT," +
                "DuracaoFilme TIME NOT NULL," +
                "Classificacao VARCHAR(20) NOT NULL," +
                "Sinopse TEXT NOT NULL," +
                "Genero VARCHAR(20) NOT NULL" +
                ");";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Filme criada com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void insertFilme(Filme filme){
        String sql = "INSERT INTO filme" +
                "(DuracaoFilme, Classificacao, Sinopse, Genero)" +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, filme.getDuracaoFilme());
            stmt.setString(2, filme.getClassificacao());
            stmt.setString(3, filme.getSinopse());
            stmt.setString(4, filme.getGenero());

            stmt.execute();
            stmt.close();

            System.out.println("Informações inseridas!!");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Filme> listFilme(){
        String sql = "SELECT * FROM filme";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<Filme> filmes = new ArrayList<>();

            ResultSet resultSet = stmt.executeQuery();
            Filme filme;
            while (resultSet.next()) {
                filme = new Filme();
                filme.setDuracaoFilme(resultSet.getString("DuracaoFilme"));
                filme.setClassificacao(resultSet.getString("Classificacao"));
                filme.setSinopse(resultSet.getString("Sinopse"));
                filme.setGenero(resultSet.getString("Genero"));

                filmes.add(filme);
            }
            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Filme findById(int id){
        String sql = "SELECT * FROM filme WHERE idFIlme = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            Filme filme = new Filme();
            while (resultSet.next()){
                filme.setDuracaoFilme(resultSet.getString("DuracaoFilme"));
                filme.setClassificacao(resultSet.getString("Classificacao"));
                filme.setSinopse(resultSet.getString("Sinopse"));
                filme.setGenero(resultSet.getString("Genero"));
            }return filme;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}