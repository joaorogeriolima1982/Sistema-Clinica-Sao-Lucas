/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoTelaConsulta;
import tabelas.TabelaConsulta;

/**
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaNovaConsulta {
    
    public boolean validarPaciente(String paciente){
        if(paciente.isBlank()){
            return true;
        }
        return false;
    }
    
    public boolean validarMedico(String medico){
        if(medico.isBlank()){
            return true;
        }
        return false;
    }
     
    public boolean validarData(String data){
        if(data.isBlank()){
            return true;
        }
        return false;
    }
    
    public boolean marcarConsulta(DaoTelaConsulta daotelaconsulta, int idMedico, int idPaciente, String data, String horario, String exame, String nomePaciente, String nomeMedico, TabelaConsulta tabelaconsulta){
        return daotelaconsulta.marcarConsulta(idMedico, idPaciente, data, horario, exame, nomePaciente, nomeMedico, tabelaconsulta);  
    } 
     
    public boolean conferirPaciente(DaoTelaConsulta daotelaconsulta, String data, String nomePaciente, String horario) {
        return daotelaconsulta.conferirPaciente(data, nomePaciente, horario);
    }
    
    public boolean conferirMedico(DaoTelaConsulta daotelaconsulta, String data, String horario, String nomeMedico){
        return daotelaconsulta.conferirMedico(data, horario, nomeMedico);
    }
}
