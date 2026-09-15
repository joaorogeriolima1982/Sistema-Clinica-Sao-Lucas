/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoTelaPaciente;
import tabelas.TabelaPaciente;

/**
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaPaciente {
    
    public boolean deletarPaciente(DaoTelaPaciente daotelapaciente, String cpf){
        return daotelapaciente.deletarPaciente(cpf);
    }
    
    public void exibirAllPacientes(DaoTelaPaciente telapaciente, TabelaPaciente tabelapaciente){
        telapaciente.exibirAllPacientes(tabelapaciente);
    }
    
    public boolean pesquisarPaciente(DaoTelaPaciente daotelapaciente, String nome, TabelaPaciente tabelapaciente){
        return daotelapaciente.pesquisarPaciente(nome, tabelapaciente);
    }
    
    
}
