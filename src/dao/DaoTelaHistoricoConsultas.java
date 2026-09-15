/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import model.HistoricoConsultas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tabelas.TabelaHistoricoConsultas;

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaHistoricoConsultas {
        
        public boolean pesquisarHistoricoConsultas(String nome, TabelaHistoricoConsultas tabelahistoricoconsultas) {
            
                        String sql = "SELECT * FROM historicoconsultas WHERE paciente LIKE ?";

		try{
                    
			String nomeCaps = nome.toUpperCase();
                        
			try (Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, "%" + nomeCaps + "%");
			
                           try (ResultSet rs = stmt.executeQuery()) {
                        
                           tabelahistoricoconsultas.limparTabela(tabelahistoricoconsultas.getRowCount());

                           int i = 0;
                        
			      while (rs.next()) {
                              i++;
				String nomePaciente = rs.getString("paciente");
				String horario = rs.getString("horario");
				String exame = rs.getString("exame");
				String data = rs.getString("data");
				String nomeMedico = rs.getString("medico");
				int id = rs.getInt("id");

				HistoricoConsultas historicoconsultas = new HistoricoConsultas(id, horario, nomePaciente, nomeMedico, exame, data);
                               
				tabelahistoricoconsultas.adicionarLinha(historicoconsultas);
                               
                               }
                                
                                 if (i > 0) {
				
                                 return true;
                                 }
                                 if(i <= 0){
                                 return false;
                                 }
                             
                           }
                           
                        }

		    }catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO EXIBIR O HISTÓRICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                  return false;
	}
        
        public boolean pesquisarHistoricoConsultaDatas(String data, TabelaHistoricoConsultas tabelahistoricoconsultas){
            
                      String sql = "SELECT * FROM historicoconsultas WHERE data = ?";
             
             try {
                 
                     try (Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, data);
		
                        try (ResultSet rs = stmt.executeQuery()) {
                        
                        tabelahistoricoconsultas.limparTabela(tabelahistoricoconsultas.getRowCount());
                   
			int i = 0;
                        
                           while (rs.next()) {
				i++;
                                
				String paciente = rs.getString("paciente");
				String horario = rs.getString("horario");
				String exame = rs.getString("exame");
				String dataa = rs.getString("data");
				String medico = rs.getString("medico");
				int id = rs.getInt("id");

				HistoricoConsultas historicoconsultas = new HistoricoConsultas(id, horario, paciente, medico, exame, dataa);
                                
				tabelahistoricoconsultas.adicionarLinha(historicoconsultas);
			   }
                        
                             if (i > 0) {
                              return true;
                             }
                        
                             if (i <= 0) {
                              return false;
                             }
                             
                        }
                        
                     }

		 }catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO EXIBIR O HISTÓRICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                  return false;
	}
        
        public boolean deletarHistoricoConsultas(String nome, TabelaHistoricoConsultas tabelahistoricoconsultas){     
            
                        String sql1 = "DELETE FROM historicoconsultas WHERE paciente = ?";
                                
                        String sql2 = "SELECT paciente FROM historicoconsultas WHERE paciente = ?";
                                
             try {
                 
                        try (Connection con = HikariCP.getConnection();
                        PreparedStatement stmt1 = con.prepareStatement(sql1)){
                            
                            stmt1.setString(1, nome);
                            stmt1.executeUpdate();
                    
                        }
                        
                            try(Connection con = HikariCP.getConnection();
                            PreparedStatement stmt2 = con.prepareStatement(sql2)){
                                
			    stmt2.setString(1, nome);
                            
                               try (ResultSet rs = stmt2.executeQuery()) {
			
                                  if( ! rs.next()){
                                  return true;
                                  }
                        
                               }
                               
                            }
		} catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO DELETAR O HISTÓRICO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                 return false;
        }
}
