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
public class Esporte {    
    private String nome;
    private List<String> atributos;

    public Esporte() {
        atributos = new ArrayList<>();
        atributos.add("NOME");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<String> getAtributos() {
        return atributos;
    }
    
    public String getAtributo(int index) {
        return atributos.get(index);
    }
}
