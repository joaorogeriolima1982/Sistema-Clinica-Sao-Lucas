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
public class ServiceTelaEditarPaciente {
    
    public void atualizarPaciente(DaoTelaPaciente daotelapaciente, int idd, String nome, String cpf, String telefone, String email, TabelaPaciente tabelapaciente){
        daotelapaciente.atualizarPaciente(idd, nome, cpf, telefone, email, tabelapaciente);
    }
}
