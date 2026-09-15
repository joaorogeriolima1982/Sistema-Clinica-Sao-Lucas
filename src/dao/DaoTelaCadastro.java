/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;                                  

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaCadastro {
                  
        public void cadastrarCredenciais(String login, String senha){
            
                 String sql = "INSERT INTO administrador(login, senha) VALUES(?, ?)";
	         
                try(Connection con = HikariCP.getConnection();
                    PreparedStatement stmt = con.prepareStatement(sql)){
                
			stmt.setString(1, login);
			stmt.setString(2, senha);
			stmt.executeUpdate();
                        
               }catch (SQLException e) {
		e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR LOGIN E SENHA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                
              }
        }
    
}
