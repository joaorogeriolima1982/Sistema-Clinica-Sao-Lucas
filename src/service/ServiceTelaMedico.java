/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoTelaMedico;
import tabelas.TabelaMedico;

/**
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaMedico {
    
    public boolean deletarMedico(DaoTelaMedico daotelamedico, String crm){
        return daotelamedico.deletarMedico(crm);
    }
    
    public void exibirAllMedicos(DaoTelaMedico daotelamedico, TabelaMedico tabelamedico){
        daotelamedico.exibirAllMedicos(tabelamedico);
    }
    
    public boolean pesquisarMedico(DaoTelaMedico daotelamedico, String nome, TabelaMedico tabelamedico){
        return daotelamedico.pesquisarMedico(nome, tabelamedico);
    }
}
