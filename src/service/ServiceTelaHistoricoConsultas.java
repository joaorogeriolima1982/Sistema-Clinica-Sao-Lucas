/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoTelaHistoricoConsultas;
import tabelas.TabelaHistoricoConsultas;

/**
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaHistoricoConsultas {
    

    public boolean pesquisarHistoricoConsultas(String nome, DaoTelaHistoricoConsultas daotelahistoricoconsultas, TabelaHistoricoConsultas tabelahistoricoconsultas){
        return daotelahistoricoconsultas.pesquisarHistoricoConsultas(nome, tabelahistoricoconsultas);
    }
    
    public boolean pesquisarHistoricoConsultaDatas(String data, TabelaHistoricoConsultas tabelahistoricoconsultas, DaoTelaHistoricoConsultas daotelahistoricoconsultas){
        return daotelahistoricoconsultas.pesquisarHistoricoConsultaDatas(data, tabelahistoricoconsultas);
    }
    
    public boolean deletarHistoricoConsultas(TabelaHistoricoConsultas tabelahistoricoconsultas, String nome, DaoTelaHistoricoConsultas daotelahistoricoconsultas){
        return daotelahistoricoconsultas.deletarHistoricoConsultas(nome, tabelahistoricoconsultas);
    }
    
    
    
}
