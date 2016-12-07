/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author EMAX
 */
public class Modalidade {
    public enum UnidadePonto {
        SIMPLES, TEMPO
    }
    
    private int id;
    private String nome;
    private String esporte;
    private int n_equipe;
    private String categoria;    
    private UnidadePonto unidade_ponto;

    public Modalidade() {
        
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

    public UnidadePonto getUnidade_ponto() {
        return unidade_ponto;
    }

    public void setUnidade_ponto(UnidadePonto unidade_ponto) {
        this.unidade_ponto = unidade_ponto;
    }
}
