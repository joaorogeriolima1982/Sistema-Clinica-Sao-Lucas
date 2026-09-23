/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tabelas.TabelaConsulta;

/**
 *
 * @author João Rogério de Lima
 */
public class DaoTelaConsulta {
     
    public boolean marcarConsulta(int idMedico, int idPaciente, String data, String horario, String exame, String nomePaciente, String nomeMedico, TabelaConsulta tabelaconsulta){
        
                 String sqlConsulta = "INSERT INTO consulta (id_Medico, id_Paciente, data, horario, exame)  VALUES(?, ?, ?, ?, ?)";
                    
                 String sqlHistorico = "INSERT INTO historicoconsultas (id, horario, paciente, medico, exame, data)  VALUES(?, ?, ?, ?, ?, ?)";
                 
                 Connection con = null;
                 
             try{
                 
                 boolean medico = verificarMedico(data, horario, nomeMedico);
                 boolean paciente = verificarPaciente(data, nomePaciente, horario);
                 
                 if (!medico || !paciente) { 
                     return false; 
                 }
                     
                      con = HikariCP.getConnection();
                      con.setAutoCommit(false);

                       int idconsultaGerado;
                       
                       try (PreparedStatement stmt1 = con.prepareStatement(sqlConsulta, PreparedStatement.RETURN_GENERATED_KEYS)) {
                           
		       stmt1.setInt(1, idMedico);
		       stmt1.setInt(2, idPaciente);
		       stmt1.setString(3, data);
		       stmt1.setString(4, horario);
		       stmt1.setString(5, exame);
		       stmt1.executeUpdate();
                       
                        try (ResultSet rs = stmt1.getGeneratedKeys()) {
                           if (rs.next()) {
                           idconsultaGerado = rs.getInt("idconsulta");
                           } else {
                           con.rollback();
                           return false;
                           }
                        }
                        
                       }
                        
                         try (PreparedStatement stmt2 = con.prepareStatement(sqlHistorico)) {
                             
                         stmt2.setInt(1, idconsultaGerado);                    
		         stmt2.setString(2, horario);
		         stmt2.setString(3, nomePaciente);
		         stmt2.setString(4, nomeMedico);
		         stmt2.setString(5, exame);
                         stmt2.setString(6, data);
		         stmt2.executeUpdate();
                                
                        }
                         
                         con.commit();
                         
                        tabelaconsulta.limparTabela(tabelaconsulta.getRowCount());
                        exibirConsultas(tabelaconsulta);
                 
                         return true;
                } catch (SQLException e) {
                        e.printStackTrace();
                        
                        if (con != null) {
                          try {
                           con.rollback();
                        } catch (SQLException rollbackException) {
                          rollbackException.printStackTrace();
                        }
                        }

                         JOptionPane.showMessageDialog(null, "ERRO AO MARCAR A CONSULTA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

                         return false;

                        } finally {

                          if (con != null) {
                              try {
                                   con.close();
                             } catch (SQLException e) {
                                e.printStackTrace();
                             }
                         }
                       }
               
    }
              
    
    public boolean verificarMedico(String data, String horario, String nomeMedico) {
        
                    String sql = "SELECT medico.nome FROM medico, consulta\r\n"
					+ "WHERE idmedico = id_medico AND data = ? AND horario = ?\r\n"
					+ "AND medico.nome = ?";
                    
            try{
                      
		try(Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)) {
               
			stmt.setString(1, data);
			stmt.setString(2, horario);
			stmt.setString(3, nomeMedico);
			
			try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                return false;
                            }else { 
                                return true; 
                            }
                        }
                        
                }
                        
            }catch (SQLException e) {
			e.printStackTrace();
                       return false; 
		}
           
    }
     
    public boolean verificarPaciente(String data, String nomePaciente, String horario) {
        
                   String sql = "SELECT paciente.nome FROM paciente, consulta\r\n"
                        + "WHERE idpaciente = id_paciente\r\n"
                           + "AND data = ? AND paciente.nome = ? AND horario = ?";
                   
            try{
                   
		try(Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)){
                    
			stmt.setString(1, data);
			stmt.setString(2, nomePaciente);
			stmt.setString(3, horario);

			try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                return false;
                            }else { 
                                return true; 
                            }
                        }
                        
                }

	    }catch (SQLException e) {
			e.printStackTrace();
                        return false;
		}
    }
      
   
    
    public void exibirConsultas(TabelaConsulta tabelaconsulta){
        
                  String sql = "SELECT consulta.horario, paciente.nome, medico.nome, consulta.exame, consulta.data, consulta.idconsulta FROM paciente, medico, consulta\r\n"
					+ "WHERE idpaciente = id_paciente AND idmedico = id_medico"; 
                  
            try{

		try(Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)){
                 
                        try (ResultSet rs = stmt.executeQuery()) {
                    
                        tabelaconsulta.limparTabela(tabelaconsulta.getRowCount());

			while (rs.next()) {
				String paciente = rs.getString(2);
				String horario = rs.getString(1);
				String medico = rs.getString(3);
				String exame = rs.getString(4);
				String data = rs.getString(5);
				int id = rs.getInt(6);
                                
				Consulta consulta = new Consulta(id, horario, paciente, medico, exame, data);
                                
				tabelaconsulta.adicionarLinha(consulta);

			}
                        
                       }
                        
                }

	    }catch (SQLException e) {
			e.printStackTrace();
            }

    }
    
    public boolean pesquisarConsulta(String nome, TabelaConsulta tabelaconsulta) {
        
                       String sql = "SELECT * FROM paciente, consulta, medico\r\n"
					+ "WHERE idpaciente = id_paciente AND idmedico = id_medico AND horario IS not null AND data IS not null\r\n"
					+ "AND paciente.nome LIKE ?";
                       
          try{

		try(Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)){
                    
			String nomeCaps = nome.toUpperCase();
                        
			stmt.setString(1, "%" + nomeCaps + "%");
			
                        try (ResultSet rs = stmt.executeQuery()) {
		
                        
                        tabelaconsulta.limparTabela(tabelaconsulta.getRowCount());
                        
                        int i = 0;
                        
			while (rs.next()) {
                            i++;
				String nomee = rs.getString(2);
				String horario = rs.getString("horario");
				String exame = rs.getString("exame");
				String data = rs.getString("data");
				String medico = rs.getString(13);
				int id = rs.getInt("idconsulta"); 

				Consulta consulta = new Consulta(id, horario, nomee, medico, exame, data);
                                
				tabelaconsulta.adicionarLinha(consulta);
                                
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
                JOptionPane.showMessageDialog(null, "ERRO AO REALIZAR A PESQUISA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
               return false;
    }
    
    public boolean atualizarConsulta(int idConsulta, String data, String horario, String nomeMedico, String nomePaciente, TabelaConsulta tabelaconsulta){
        
                   String sqlConsulta = "UPDATE consulta SET data = ?, horario = ? WHERE idconsulta = ?";
                           
                   String sqlHistorico = "UPDATE historicoconsultas SET data = ?, horario = ? WHERE id = ?";
                           
                   Connection con = null;
	            
             try{
                 
                 boolean medico = conferirMedico(data, horario, nomeMedico);
                 boolean paciente = conferirPaciente(data, nomePaciente, horario);
                 
                 if (!medico || !paciente){
                     return false;
                 }
                 
                 con = HikariCP.getConnection();
                 con.setAutoCommit(false);

                 try (PreparedStatement stmt1 = con.prepareStatement(sqlConsulta)){
                 
		     stmt1.setString(1, data);
		     stmt1.setString(2, horario);
		     stmt1.setInt(3, idConsulta);
		     stmt1.executeUpdate();
                 }      
                     
                   try(PreparedStatement stmt2 = con.prepareStatement(sqlHistorico)){
                 
		     stmt2.setString(1, data);
		     stmt2.setString(2, horario);
		     stmt2.setInt(3, idConsulta);
                     stmt2.executeUpdate();
                     
                   }
                     
                     con.commit();
		    
                     tabelaconsulta.limparTabela(tabelaconsulta.getRowCount());
                     
		     exibirConsultas(tabelaconsulta);
                     
                     return true;
                 
             }catch (SQLException e) {
		e.printStackTrace();
                
                if (con != null) {
                  try {
                  con.rollback();
                  } catch (SQLException rollbackException) {
                   rollbackException.printStackTrace();
                  }
                }
                
                JOptionPane.showMessageDialog(null, "ERRO AO REMARCAR A CONSULTA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                
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
    
    public boolean conferirMedico(String data, String horario, String nomeMedico){
        
                    String sql = "SELECT medico.nome FROM medico, consulta\r\n"
					+ "WHERE idmedico = id_medico AND data = ? AND horario = ?\r\n"
					+ "AND medico.nome = ?";
            try{

		try(Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)){
                   
		    stmt.setString(1, data);
		    stmt.setString(2, horario);
		    stmt.setString(3, nomeMedico);
		    
		    try (ResultSet rs = stmt.executeQuery()) {
                    
                       if (rs.next()) {
			return false;
		       }else{
                        return true;
                       }
                    
                    }
                    
                }
                    
               }catch (SQLException e) {
			e.printStackTrace();
                        return false; 
                }
    }
    
    public boolean conferirPaciente(String data, String nomePaciente, String horario){
        
                    String sql = "SELECT paciente.nome FROM paciente, consulta\r\n"
					+ "WHERE idpaciente = id_paciente\r\n"
					+ "AND data = ? AND paciente.nome = ? AND horario = ?";
         try{
             
              try (Connection con = HikariCP.getConnection();
                     PreparedStatement stmt = con.prepareStatement(sql)){
                 
		    stmt.setString(1, data);
		    stmt.setString(2, nomePaciente);
		    stmt.setString(3, horario);
		    
                    try (ResultSet rs = stmt.executeQuery()) {

			if (rs.next()) {
			return false;
			}else {
			return true;
			}
                    }
                    
              }

            } catch (SQLException e) {
			e.printStackTrace();
                        return false;
		}
    }
    
    public boolean deletarConsulta(String id){
        
                      String sql1 = "DELETE FROM consulta WHERE idconsulta = ?";
                      
                      String sql2 = "SELECT idconsulta FROM consulta WHERE idconsulta = ?";
             
             try {

			int idd = Integer.parseInt(id);

			try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt1 = con.prepareStatement(sql1)){
                        
			stmt1.setInt(1, idd);
		        stmt1.executeUpdate();
                          
                        }
                        
                            try(Connection con = HikariCP.getConnection();
                            PreparedStatement stmt2 = con.prepareStatement(sql2)){
                        
			    stmt2.setInt(1, idd);
			
                               try (ResultSet rs = stmt2.executeQuery()) {
                            
                                  if( ! rs.next()){
                                  return true;
                                  }
                            
                               }
                        
                           }
                             
		} catch (SQLException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERRO AO DELETAR A CONSULTA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		}
                  return false;
    }
    
    public boolean pesquisarConsultaDatas(String data, TabelaConsulta tabelaconsulta){
        
                  String sql = "SELECT * FROM paciente, consulta, medico\r\n"
					+ "WHERE idpaciente = id_paciente AND idmedico = id_medico AND horario IS not null AND data IS not null\r\n"
					+ "AND data = ?";
             
               try {
                 
                        try(Connection con = HikariCP.getConnection();
                        PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, data);
		         
                           try (ResultSet rs = stmt.executeQuery()) {
                        
                           tabelaconsulta.limparTabela(tabelaconsulta.getRowCount());
                        
			   int i = 0;
                        
                           while (rs.next()) {
				i++;
				String paciente = rs.getString(2);
				String horario = rs.getString("horario");
				String exame = rs.getString("exame");
				String dataa = rs.getString("data");
				String medico = rs.getString(13);
				int id = rs.getInt("idconsulta");

				Consulta consulta = new Consulta(id, horario, paciente, medico, exame, dataa);
                                
				tabelaconsulta.adicionarLinha(consulta);
                               
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
                        JOptionPane.showMessageDialog(null, "ERRO AO REALIZAR A PESQUISA, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		    }
                     return false;
    }
    
    
    
}
