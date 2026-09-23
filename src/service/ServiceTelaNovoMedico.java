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
public class ServiceTelaNovoMedico {
    
    public boolean adicionarMedico(DaoTelaMedico daotelamedico, String nome, String crm, String especialidade, String telefone, String email, TabelaMedico tabelamedico){
        return daotelamedico.adicionarMedico(nome, crm, especialidade, telefone, email, tabelamedico);
    }
}
