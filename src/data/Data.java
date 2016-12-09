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
public class Data {
    Statement stmt;
    ResultSet rs;
    Connection connection;
    PreparedStatement pstmt;
    
    public Data() {
        try {
            /*CONEXÃO*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl",
                    "8531438",
                    "a");
        } catch (Exception ex) {
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
                
                System.out.println(rs.getString("ID_MODALIDADE") + "-" 
                        + rs.getString("NOME") + "-"
                        + rs.getString("ESPORTE") + "-"
                        + rs.getString("N_EQUIPE") + "-"
			+ rs.getString("CATEGORIA") + "-"
                        + rs.getString("UNIDADE_PONTO"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Esporte> getAllEsportes() {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ESPORTE");
            while (rs.next()) {
                System.out.println(rs.getString("ID_ESPORTE") + "-" 
                        + rs.getString("ALTURA") + "-"
                        + rs.getString("PESO"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void endConnection() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
