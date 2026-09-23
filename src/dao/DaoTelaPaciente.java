/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tabelas.TabelaPaciente;

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaPaciente {
        
        public boolean adicionarPaciente(String nome, String cpf, String telefone, String email, TabelaPaciente tabelapaciente){
            
                        String sql1 = "SELECT cpf FROM paciente WHERE cpf = ?";
                                
                        String sql2 = "INSERT INTO paciente(nome, cpf, telefone, email) VALUES(?, ?, ?, ?)";
                        
                        Connection con = null;
             
             try {
			nome = nome.toUpperCase();
                        
                        int idpacienteGerado;
                        
                        con = HikariCP.getConnection();

	                try(PreparedStatement stmt1 = con.prepareStatement(sql1)) {

			 stmt1.setString(1, cpf);
                        
                           try (ResultSet rs = stmt1.executeQuery()) {
	
			      if (rs.next()) {
                               return false;
				
			      }
                                
                           }
                              
                                try (PreparedStatement stmt2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS)) {
                           
				stmt2.setString(1, nome);
				stmt2.setString(2, cpf);
				stmt2.setString(3, telefone);
				stmt2.setString(4, email);
			        stmt2.executeUpdate();
                                  
                                   try (ResultSet rs = stmt2.getGeneratedKeys()) {
                                      if (rs.next()) {
                                      idpacienteGerado = rs.getInt(1);
                                      } else {
                                      con.rollback();
                                      return false;
                                      }
                                   } 
                                
			            Paciente paciente = new Paciente(idpacienteGerado, nome, cpf, telefone, email);

			            tabelapaciente.adicionarLinha(paciente);

                                    return true;
			        }
                                
                        }
                              
		  } catch (SQLException e) {
                        e.printStackTrace();
                        
			JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O PACIENTE, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                        return false;
                        
		        }finally {

                          if (con != null) {
                              try {
                                   con.close();
                              } catch (SQLException e) {
                                e.printStackTrace();
                              }
                          }
                        }
        }
        
        public void atualizarPaciente(int idd, String nome, String cpf, String telefone, String email, TabelaPaciente tabelapaciente){
            
                     String sql = "UPDATE paciente SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE idpaciente = ?";
	                
             try {
                 
                        nome = nome.toUpperCase();
                 
                        try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, nome);                 
			stmt.setString(2, cpf);
                        stmt.setString(3, telefone);
                        stmt.setString(4, email);
			stmt.setInt(5, idd);
			stmt.executeUpdate();
                     
                        }

			tabelapaciente.limparTabela(tabelapaciente.getRowCount());
                        
                        exibirAllPacientes(tabelapaciente);
			
		} catch (SQLException e) {
			e.printStackTrace();
                       JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR O PACIENTE, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
		}
	}
        
        public void exibirAllPacientes(TabelaPaciente tabelapaciente){
            
                        String sql = "SELECT nome, cpf, telefone, email, idpaciente FROM paciente";

		try {
			
                        try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){
                            
			   try (ResultSet rs = stmt.executeQuery()) {

			       while (rs.next()) {
				String nome = rs.getString(1);
				String cpf = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				int id = rs.getInt(5);

				Paciente paciente = new Paciente(id, nome, cpf, telefone, email);
				tabelapaciente.adicionarLinha(paciente);

			        }
                               
                           }
                           
                        }

		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
        
        public boolean pesquisarPaciente(String nome, TabelaPaciente tabelapaciente){
            
                        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

		try {
			String nomeCaps = nome.toUpperCase();

			try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, "%" + nomeCaps + "%");
			
                           try (ResultSet rs = stmt.executeQuery()) {

			   tabelapaciente.limparTabela(tabelapaciente.getRowCount());
                        
                           int i = 0;

			      while (rs.next()) {
                               i++;
				int id = rs.getInt("idpaciente");
				String nomee = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");

				Paciente paciente = new Paciente(id, nomee, cpf, telefone, email);

				tabelapaciente.adicionarLinha(paciente);
			      }
                        
                                if (i > 0) {
                                return true;
                                }
                        
                                if (i <= 0) {
                                return false;
                                }
                                
                           }
                           
                        }
                        
		    } catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR O PACIENTE, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                  return false;
	}
        
        public boolean deletarPaciente(String cpf){
            
                        String sql1 = "SELECT paciente.idpaciente, consulta.id_paciente FROM paciente, consulta WHERE idpaciente = id_paciente AND cpf = ?";
                        
                        String sql2 = "DELETE FROM paciente WHERE cpf = ?";
                        
                        Connection con = null;

		try {
			
                        con = HikariCP.getConnection();

	                try(PreparedStatement stmt1 = con.prepareStatement(sql1)) {
                    
			stmt1.setString(1, cpf);
			
                            try (ResultSet rs = stmt1.executeQuery()) {
                           
                                if (rs.next()) {
                                    
                                     return false;
                                }
                              
                            }
                            
                                try (PreparedStatement stmt2 = con.prepareStatement(sql2)) {
                            
			             stmt2.setString(1, cpf);
			             stmt2.executeUpdate();
                                
                                     return true;
                                }
                                
                        }
                        
		    } catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO DELETAR O PACIENTE, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                        return false;
                        
		    }finally {

                      if (con != null) {
                          try {
                           con.close();
                          } catch (SQLException e) {
                           e.printStackTrace();
                          }
                      }
                    }
	}
         
}
