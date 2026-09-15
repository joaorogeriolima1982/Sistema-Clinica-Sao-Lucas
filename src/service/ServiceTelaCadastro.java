/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
                                                           
import dao.DaoTelaCadastro;                                
import security.CriptografiaAES;

                                                           
                                                           
/**                                                        
 *
 * @author João Rogério de Lima
 */
public class ServiceTelaCadastro {
    
     public boolean cadastrarCredenciais(String login, String senha, String valorsenhaautorizacao){
           if (login == null || login.isBlank()) {
            return false;
           }
           
           if (senha == null || senha.isBlank()) {
            return false;
           }
           
           String senhadescriptografada = null;
           String senhasecreta = CriptografiaAES.retornarSenha(senhadescriptografada);
           
           if(valorsenhaautorizacao.equals(senhasecreta)){  
           DaoTelaCadastro daotelacadastro = new DaoTelaCadastro();
           daotelacadastro.cadastrarCredenciais(login, senha);
           return true;
           
           }else {
               return false;
           }     
     }
}
