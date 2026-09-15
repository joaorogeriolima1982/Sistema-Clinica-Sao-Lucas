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
public class ServiceTelaConsulta {
    
    public boolean deletarConsulta(String id,  DaoTelaConsulta daotelaconsulta){
         return daotelaconsulta.deletarConsulta(id);
    }
    
    public void exibirConsultas(DaoTelaConsulta daotelaconsulta, TabelaConsulta tabelaconsulta){
        daotelaconsulta.exibirConsultas(tabelaconsulta); 
    }
    
    public boolean pesquisarConsulta(String nome, TabelaConsulta tabelaconsulta, DaoTelaConsulta daotelaconsulta){
        return daotelaconsulta.pesquisarConsulta(nome, tabelaconsulta);
    }
    
    public boolean pesquisarConsultaDatas(String data, TabelaConsulta tabelaconsulta, DaoTelaConsulta daotelaconsulta){
        return daotelaconsulta.pesquisarConsultaDatas(data, tabelaconsulta);
    }
    
   
    
}
