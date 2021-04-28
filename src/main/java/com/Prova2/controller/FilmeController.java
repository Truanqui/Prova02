package com.Prova2.controller;

import com.Prova2.dao.FilmeDAO;
import com.Prova2.model.Filme;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
public class FilmeController {
    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaFilmes() {
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.createTableFilme();
        return Response.ok(new Gson().toJson("Tabela Filme criada com sucesso!")).build();
    }
    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSFilme(){
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filme> filmes = filmeDAO.listFilme();
        return Response.ok(new Gson().toJson(filmes)).build();
    }
}
