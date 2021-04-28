package com.Prova2.controller;

import com.Prova2.dao.FilmeDAO;
import com.Prova2.dao.SessaoDAO;
import com.Prova2.model.Sessao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sessao")
public class SessaoController {
    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaSessoes() {
        SessaoDAO sessaoDAO = new SessaoDAO();
        sessaoDAO.createTableSessao();
        return Response.ok(new Gson().toJson("Tabela Sessao criada com sucesso!")).build();
    }
    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSessao(){
        SessaoDAO sessaoDAO = new SessaoDAO();
        List<Sessao> sessoes = sessaoDAO.listSessao();
        return Response.ok(new Gson().toJson(sessoes)).build();
    }

}
