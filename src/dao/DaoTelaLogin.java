/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaLogin {
       
        public boolean verificarCredenciais(String login, String senha) {     
            
                String sql = "SELECT 1 FROM administrador WHERE login = ? AND senha = ?";
            
		try (Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)) {
                   
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
                        
                    try (ResultSet rs = stmt.executeQuery()) {
                            return rs.next();
                    }
                        
		}catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO AO VERIFICAR CREDENCIAIS, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
	            return false;     
		}
            
	}
}
