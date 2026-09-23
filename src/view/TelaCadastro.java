/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import service.ServiceTelaCadastro;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaCadastro extends JFrame{
    private static final long serialVersionUID = 1L;
    ServiceTelaCadastro servicetelacadastro = new ServiceTelaCadastro();
    private String valorsenhaautorizacao;
    
    public TelaCadastro(){
        setTitle("Clínica São Lucas");
        setBounds(640, 150, 350, 500);
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setLayout(null);
        
        JPanel cadastrar = new JPanel();
        cadastrar.setBounds(0, 0, 350, 500);
        cadastrar.setBackground(new Color(0, 102, 255));
        cadastrar.setLayout(null);
        add(cadastrar);
        
        JLabel lblTitulo = new JLabel("Cadastrar Novo Usuário");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblTitulo.setBounds(17, 30, 300, 31);
        cadastrar.add(lblTitulo);
        
        JLabel lblLoginNovo = new JLabel("Login");
        lblLoginNovo.setFont(new Font("Dialog", Font.BOLD, 16));
	lblLoginNovo.setBounds(43, 100, 100, 30);
	cadastrar.add(lblLoginNovo);
        
        JTextField txtLoginNovo = new JTextField();
        txtLoginNovo.setFont(new Font("Dialog", Font.PLAIN, 16));                                
        txtLoginNovo.setBounds(43, 135, 250, 25);
        txtLoginNovo.setColumns(10);
        txtLoginNovo.setToolTipText("Digite o login para cadastrar");                                   
        txtLoginNovo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        cadastrar.add(txtLoginNovo);
        
        JLabel lblSenhaNova = new JLabel("Senha");
        lblSenhaNova.setFont(new Font("Dialog", Font.BOLD, 16));                      
	lblSenhaNova.setBounds(43, 195, 100, 30);
	cadastrar.add(lblSenhaNova);
        
        JTextField txtSenhaNova = new JTextField();
        txtSenhaNova.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtSenhaNova.setBounds(43, 230, 250, 25);
        txtSenhaNova.setToolTipText("Digite a senha para cadastrar");
        txtSenhaNova.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        cadastrar.add(txtSenhaNova);
        
        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 14));
        btnCadastrar.setBounds(43, 310, 250, 30);
        btnCadastrar.setBackground(new Color(0, 204, 0));
        cadastrar.add(btnCadastrar);
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
        btnCancelar.setBounds(43, 390, 250, 30);
        btnCancelar.setBackground(new Color(255, 51, 51));
        cadastrar.add(btnCancelar);
        
        cadastrarNovoUsuario(btnCadastrar, txtLoginNovo, txtSenhaNova);
        
        cancelar(btnCancelar);
        
        limpar(txtLoginNovo, txtSenhaNova);
    }
    
    private void cadastrarNovoUsuario(JButton btnCadastrar, JTextField txtLoginNovo, JTextField txtSenhaNova) {
        btnCadastrar.addActionListener(e -> {
            String login = txtLoginNovo.getText();
            String senha = txtSenhaNova.getText();      
            if(login.isBlank() || senha.isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return;
            }
            if( ! login.isBlank() && ! senha.isBlank()){           
            JPasswordField senhaautorizacao = new JPasswordField();
            JOptionPane.showConfirmDialog(null, senhaautorizacao, "Digite a senha de autorização:", JOptionPane.OK_CANCEL_OPTION);
            valorsenhaautorizacao = String.valueOf(senhaautorizacao.getPassword());
            } 
            if(servicetelacadastro.cadastrarCredenciais(login, senha, valorsenhaautorizacao)){
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Acesso negado!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                 limpar(txtLoginNovo, txtSenhaNova);
            }
                               
                        
        });

   }
    
     private void cancelar(JButton btnCancelar){
          btnCancelar.addActionListener(e -> {
              dispose();
          });  
     } 
     
      private void limpar(JTextField txtLoginNovo, JTextField txtSenhaNova){
         txtLoginNovo.setText("");
         txtSenhaNova.setText("");
         txtLoginNovo.requestFocus();
     }
}
