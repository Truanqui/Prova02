package com.Prova2.dao;

import com.Prova2.factory.ConnectionFactory;
import com.Prova2.model.Filme;
import com.Prova2.model.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {
    private Connection connection;

    public SessaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableSessao();
    }
    public  void createTableSessao(){
        String sql = "CREATE TABLE IF NOT EXIST Sessao(" +
                "idSessao PRIMARY KEY AUTO_INCREMENT," +
                "HorarioDoFilme TIME NOT NULL," +
                "DataDoFilme DATE NOT NULL," +
                "AssentosDisponivel int," +
                "idFilme int NOT NULL," +
                "CONSTRAINT fk_idFilme FOREIGN KEY (idFilme)" +
                "REFERENCES filme(idFilme)" +
                ");";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Sessao criada com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void insertSessao(Sessao sessao){
        String sql = "INSERT INTO sessao" +
                "(HorarioDoFilme, DataDoFilme, AssentoDisponivel,idFilme)" +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, sessao.getHorarioDoFilme());
            stmt.setString(2, sessao.getDataDoFilme());
            stmt.setInt(3, sessao.getAssentoDisponivel());
            stmt.setInt(4,sessao.getFilme().getIdFilme());


            stmt.execute();
            stmt.close();

            System.out.println("Informações inseridas!!");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Sessao> listSessao(){
        String sql = "SELECT * FROM sessao";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<Sessao> sessoes = new ArrayList<>();

            ResultSet resultSet = stmt.executeQuery();
            Sessao sessao;
            FilmeDAO filmeDAO = new FilmeDAO();
            while (resultSet.next()) {
                sessao = new Sessao();
                sessao.setIdSessao(resultSet.getInt("idSessao"));
                sessao.setHorarioDoFilme(resultSet.getString("HorarioDoFilme"));
                sessao.setDataDoFilme(resultSet.getString("DataDoFilme"));
                sessao.setAssentoDisponivel(resultSet.getInt("AssentoDisponivel"));
                sessao.setFilme(filmeDAO.findById(resultSet.getInt("idFilme")));

                sessoes.add(sessao);
            }
            return sessoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
