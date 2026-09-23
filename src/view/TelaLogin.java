/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.DaoTelaLogin;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import service.ServiceTelaLogin;



/**
 *
 * @author João Rogério de Lima
 */
public class TelaLogin extends JPanel{
    private static final long serialVersionUID = 1L; 
    ServiceTelaLogin servicetelalogin = new ServiceTelaLogin();
          
    public TelaLogin(JPanel jpanel){
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null); 
        
        JPanel credenciais = new JPanel();
        credenciais.setBounds(750, 210, 340, 390);
        credenciais.setOpaque(false);
        credenciais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        credenciais.setLayout(null);
        add(credenciais);
        
        JLabel imgTelaInicio = new JLabel();
	imgTelaInicio.setBounds(0, 0, 1538, 800);
	imgTelaInicio.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/img_clinica002.png")));
        add(imgTelaInicio);
        
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Dialog", Font.BOLD, 16));
	lblLogin.setBounds(45, 28, 100, 30);
	credenciais.add(lblLogin);
        
        JTextField txtLogin = new JTextField();
        txtLogin.setFont(new Font("Dialog", Font.PLAIN, 16));                                
        txtLogin.setBounds(45, 63, 250, 25);
        txtLogin.setColumns(10);
        txtLogin.setToolTipText("Digite seu login");
        txtLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        credenciais.add(txtLogin);
        
        JLabel lblSenha = new JLabel("Senha");                                                         
        lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));                      
	lblSenha.setBounds(45, 123, 100, 30);
	credenciais.add(lblSenha);
        
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(45, 158, 250, 25);
        txtSenha.setToolTipText("Digite sua senha");
        txtSenha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        credenciais.add(txtSenha);
        
        JButton btnEntrar = new JButton("ACESSAR");
        btnEntrar.setFont(new Font("Dialog", Font.BOLD, 14));
        btnEntrar.setBounds(45, 238, 250, 30);
        btnEntrar.setBackground(new Color(0, 204, 0));
        credenciais.add(btnEntrar);
        
        JButton btnCadastrar = new JButton("CADASTRAR NOVO USUÁRIO");
        btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 14));
        btnCadastrar.setBounds(45, 318, 250, 30);
        btnCadastrar.setBackground(new Color(204, 204, 204));
        credenciais.add(btnCadastrar); 
        
        acessar(jpanel, btnEntrar, txtLogin, txtSenha);
        
        cadastrarNovoUsuario(btnCadastrar);
        
        limpar(txtLogin, txtSenha);
    }
    
    private void acessar(JPanel jpanel, JButton btnEntrar, JTextField txtLogin, JPasswordField txtSenha){
         btnEntrar.addActionListener(e -> {
             DaoTelaLogin daotelalogin = new DaoTelaLogin();
             String login = txtLogin.getText();
             String senha = String.valueOf(txtSenha.getPassword());
             
             if(login.isBlank() || senha.isBlank()){
             JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
             return; 
             }
             if(servicetelalogin.verificarCredenciais(daotelalogin, login, senha)){
             CardLayout layout = (CardLayout) jpanel.getLayout();
                layout.show(jpanel, "telamenuinicial"); 
                JOptionPane.showMessageDialog(null, "Escolha uma opção do menu no lado esquerdo da tela.", "BEM VINDO(A)!", JOptionPane.INFORMATION_MESSAGE);
             }else{
                JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                limpar(txtLogin, txtSenha);
             }      
             
         });
    }
    
    private void cadastrarNovoUsuario(JButton btnCadastrar){
         btnCadastrar.addActionListener(e -> {
             new TelaCadastro().setVisible(true);
         });
    }
    
    private void limpar(JTextField txtLogin, JPasswordField txtSenha){
         txtLogin.setText("");
         txtSenha.setText("");
         txtLogin.requestFocus();
     }
    
}
