/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoTelaLogin;                                    

                                                             
/**
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaLogin {           
    
    public boolean verificarCredenciais(DaoTelaLogin daotelalogin, String login, String senha){
       
        return daotelalogin.verificarCredenciais(login, senha);
    }
                 
}

