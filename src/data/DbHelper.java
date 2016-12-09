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
    
    public void endConnection() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
