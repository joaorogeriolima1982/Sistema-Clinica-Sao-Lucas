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
public class ServiceTelaEditarMedico {
    
    public void atualizarMedico(DaoTelaMedico daotelamedico, int idd, String nome, String crm, String especialidade, String telefone, String email, TabelaMedico tabelamedico){
        daotelamedico.atualizarMedico(idd, nome, crm, especialidade, telefone, email, tabelamedico);
    }
}
