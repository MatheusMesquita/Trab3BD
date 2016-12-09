/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMAX
 */
public class Modalidade {
    
    private int id;
    private String nome;
    private String esporte;
    private int n_equipe;
    private String categoria;    
    private String unidade_ponto;
    private List<String> atributos;

    public Modalidade() {
        atributos = new ArrayList<>();
        atributos.add("ID");
        atributos.add("NOME");
        atributos.add("ESPORTE");
        atributos.add("N_EQUIPE");
        atributos.add("CATEGORIA");
        atributos.add("UNIDADE_PONTO");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public int getN_equipe() {
        return n_equipe;
    }

    public void setN_equipe(int n_equipe) {
        this.n_equipe = n_equipe;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade_ponto() {
        return unidade_ponto;
    }

    public void setUnidade_ponto(String unidade_ponto) {
        this.unidade_ponto = unidade_ponto;
    }
    
    public List<String> getAtributos() {
        return atributos;
    }
    
    public String getAtributo(int index) {
        return atributos.get(index);
    }
}
