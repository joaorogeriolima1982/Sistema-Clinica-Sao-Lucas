/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tabelas.TabelaMedico;

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaMedico {
   
        public boolean adicionarMedico(String nome, String crm, String especialidade, String telefone, String email, TabelaMedico tabelamedico){
            
                        String sql1 = "SELECT crm FROM medico WHERE crm = ?";
                        
                        String sql2 = "INSERT INTO medico(nome, crm, especialidade, telefone, email) VALUES(?, ?, ?, ?, ?)";
                        
                        Connection con = null;
             
             try {
			nome = nome.toUpperCase();
                        
                        int idmedicoGerado;
                        
                        con = HikariCP.getConnection();

			try(PreparedStatement stmt1 = con.prepareStatement(sql1)) {

			stmt1.setString(1, crm);
                        
                           try (ResultSet rs = stmt1.executeQuery()) {
			
			      if (rs.next()) {
                               return false;
			      }
                              
                           }
                           
                                try (PreparedStatement stmt2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				stmt2.setString(1, nome);
				stmt2.setString(2, crm);
				stmt2.setString(3, especialidade);
				stmt2.setString(4, telefone);
                                stmt2.setString(5, email);
				stmt2.executeUpdate();

			           try (ResultSet rs = stmt2.getGeneratedKeys()) {
                                       
                                      if (rs.next()) {
                                      idmedicoGerado = rs.getInt(1);
                                      } else {
                                      con.rollback();
                                      return false;
                                      }
                                   } 

				      Medico medico = new Medico(idmedicoGerado, nome, crm, especialidade, telefone, email);

			              tabelamedico.adicionarLinha(medico);

                                      return true;
			        }
                                
                        }

		  } catch (SQLException e) {
                        e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O MÉDICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
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
        
       
        
        public void atualizarMedico(int idd, String nome, String crm, String especialidade, String telefone, String email, TabelaMedico tabelamedico) {
            
                        String sql = "UPDATE medico SET nome = ?, crm = ?, especialidade = ?, telefone = ?, email = ? WHERE idmedico = ?";
	                
		try {
			nome = nome.toUpperCase();
                        
                        try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, nome);
			stmt.setString(2, crm);
			stmt.setString(3, especialidade);
			stmt.setString(4, telefone);
			stmt.setString(5, email);
			stmt.setInt(6, idd);
			stmt.executeUpdate();
                        
                        }
                        
			tabelamedico.limparTabela(tabelamedico.getRowCount());
                        
                        exibirAllMedicos(tabelamedico);

		} catch (SQLException e) {
                        e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR O MÉDICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}

	}
        
        public void exibirAllMedicos(TabelaMedico tabelamedico){
            
                       String sql = "SELECT idmedico, nome, crm, especialidade, telefone, email FROM medico";

		try {
			
                        try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){
                   
                           try (ResultSet rs = stmt.executeQuery()) {
                            
			       while (rs.next()) {
                                int id = rs.getInt(1);
				String nome = rs.getString(2);
				String crm = rs.getString(3);
				String especialidade = rs.getString(4);
                                String telefone = rs.getString(5);
                                String email = rs.getString(6);
				
				Medico medico = new Medico(id, nome, crm, especialidade, telefone, email);

				tabelamedico.adicionarLinha(medico);

			      }
                               
                           }
                           
                        }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        public boolean pesquisarMedico(String nome, TabelaMedico tabelamedico){
            
                        String sql = "SELECT * FROM medico WHERE nome LIKE ?";

		try {
			String nomeCaps = nome.toUpperCase();

			try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, "%" + nomeCaps + "%");
			
                           try (ResultSet rs = stmt.executeQuery()) {
                        
			   tabelamedico.limparTabela(tabelamedico.getRowCount());
                        
                           int i = 0;

			       while (rs.next()){
                                i++;
				int id = rs.getInt("idmedico");
				String nomee = rs.getString("nome");
				String crm = rs.getString("crm");
				String especialidade = rs.getString("especialidade");
				String telefone = rs.getString("telefone");
                                String email = rs.getString("email");

				Medico medico = new Medico(id, nomee, crm, especialidade, telefone, email);

				tabelamedico.adicionarLinha(medico);
			       }
                        
                                if(i > 0){
                                  return true;
                                }
                        
                                if (i <= 0) {
                                  return false;
                                }
                                
                           }
                           
                        }

		} catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR O MÉDICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                  return false;
	}
        
        public boolean deletarMedico(String crm) {
            
                        String sql1 = "SELECT medico.idmedico, consulta.id_medico FROM medico, consulta WHERE idmedico = id_medico AND crm = ?";
                                
                        String sql2 = "DELETE FROM medico WHERE crm = ?";
                        
                        Connection con = null;

		try {
                    
                        con = HikariCP.getConnection();

	                try(PreparedStatement stmt1 = con.prepareStatement(sql1)) {
                    
			stmt1.setString(1, crm);
			
                            try (ResultSet rs = stmt1.executeQuery()) {

			        if (rs.next()) {
                                    
                                     return false;
                                }
                                
                            }
                                  
                                try (PreparedStatement stmt2 = con.prepareStatement(sql2)) {
                            
			             stmt2.setString(1, crm);
			             stmt2.executeUpdate();
                                
                                     return true;
                                }
                                
                        }
                        
		   } catch (SQLException e) {
			e.printStackTrace();
                         JOptionPane.showMessageDialog(null, "ERRO AO DELETAR O MÉDICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
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
