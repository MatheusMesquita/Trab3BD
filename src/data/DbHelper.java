package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atleta;
import models.Esporte;
import models.Modalidade;

/**
 *
 * @author EMAX
 */
public class DbHelper {
    static Statement stmt;
    static ResultSet rs;
    static Connection connection;
    PreparedStatement pstmt;
    
    public DbHelper() {
        try {
            /*CONEXÃO*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl",
                    "8531438",
                    "a");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addModalidade(String nome, String esporte, int n_equipe, String categoria, String unidade_ponto) {
        try {
            stmt = connection.createStatement();
            stmt.executeQuery("INSERT INTO MODALIDADE VALUES " + nome + ", " + esporte + ", " + n_equipe + ", " + categoria + ", " + unidade_ponto);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addEsporte(String nome) {
        try {
            stmt = connection.createStatement();
            stmt.executeQuery("INSERT INTO ESPORTE(NOME) VALUES ('" + nome + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Modalidade> getAllModalidades() {
        List<Modalidade> modalidades = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM MODALIDADE");
            while (rs.next()) {
                Modalidade modalidade = new Modalidade();
                
                modalidade.setId(rs.getInt("ID_MODALIDADE"));
                modalidade.setNome(rs.getString("NOME"));
                modalidade.setEsporte(rs.getString("ESPORTE"));
                modalidade.setN_equipe(rs.getInt("N_EQUIPE"));
                modalidade.setCategoria(rs.getString("CATEGORIA"));
                modalidade.setUnidade_ponto(rs.getString("UNIDADE_PONTO"));
                
                modalidades.add(modalidade);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modalidades;
    }
    
    public List<Esporte> getAllEsportes() {
        List<Esporte> esportes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ESPORTE");
            while (rs.next()) {
                Esporte esporte = new Esporte();
                
                esporte.setNome(rs.getString("NOME"));
                
                esportes.add(esporte);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return esportes;
    }
    
    public List<Atleta> getAllAtletas() {
        List<Atleta> atletas = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT ID_PESSOA, NOME, PASSAPORTE, SEXO, DATA_NASC, IDADE, ALTURA, PESO, count(*) as NumJogos " +
                                    "FROM (PESSOA P JOIN ATLETA A ON P.ID_PESSOA = A.PESSOA) " +
                                    "JOIN PARTICIPA_EQUIPE E ON E.ATLETA = A.PESSOA " +
                                    "JOIN EQUIPE_JOGOU J ON J.EQUIPE_ID = E.EQUIPE_ID " +
                                    "GROUP BY P.ID_PESSOA, ID_PESSOA, NOME, P.NOME, PASSAPORTE, " +
                                    "SEXO, P.PASSAPORTE, DATA_NASC, IDADE, P.SEXO, " +
                                    "P.DATA_NASC, P.IDADE, ALTURA, PESO HAVING count(*) > 3");
            while (rs.next()) {
                Atleta atleta = new Atleta();
                
                atleta.setId(rs.getInt("ID_PESSOA"));
                atleta.setNome(rs.getString("NOME"));
                atleta.setPassaporte(rs.getString("PASSAPORTE"));
                atleta.setSexo(rs.getString("SEXO"));
                atleta.setData_nasc(rs.getString("DATA_NASC"));
                atleta.setIdade(rs.getInt("IDADE"));
                atleta.setAltura(rs.getInt("ALTURA"));
                atleta.setPeso(rs.getInt("PESO"));
                atleta.setNumJogos(rs.getInt("NumJogos"));
                
                atletas.add(atleta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return atletas;
    }
    
    public void endConnection() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
