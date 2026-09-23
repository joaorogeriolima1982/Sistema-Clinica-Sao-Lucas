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
public class ServiceTelaEditarConsulta {
    
    public boolean validarData(String data){
        if(data.isBlank()){
            return true;
        }
        return false;
    }
    
    public boolean atualizarConsulta(DaoTelaConsulta daotelaconsulta, int idConsulta, String data, String horario, String nomeProfissional, String nomePaciente, TabelaConsulta tabelaconsulta){
        return daotelaconsulta.atualizarConsulta(idConsulta, data, horario, nomeProfissional, nomePaciente, tabelaconsulta);
    }
}
