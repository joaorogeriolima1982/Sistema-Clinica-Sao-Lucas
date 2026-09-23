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
public class ServiceTelaNovoPaciente {
    
    public boolean adicionarPaciente(DaoTelaPaciente daotelapaciente, String nome, String cpf, String telefone, String email, TabelaPaciente tabelapaciente){
       return  daotelapaciente.adicionarPaciente(nome, cpf, telefone, email, tabelapaciente);
    }
}
