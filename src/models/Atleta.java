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
public class Atleta {
    private int id;
    private String nome;
    private String passaporte;
    private String sexo;
    private String data_nasc;
    private int idade;
    private float altura;
    private float peso;
    private List<String> atributos;

    public Atleta() {
        atributos = new ArrayList<>();
        atributos.add("ID_PESSOA");
        atributos.add("NOME");
        atributos.add("PASSAPORTE");
        atributos.add("SEXO");
        atributos.add("DATA_NASC");
        atributos.add("IDADE");
        atributos.add("ALTURA");
        atributos.add("PESO");
    }
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public List<String> getAtributos() {
        return atributos;
    }
    
    public String getAtributo(int index) {
        return atributos.get(index);
    }
}
