/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import tabelas.TabelaPaciente;
import dao.DaoTelaPaciente;
import service.ServiceTelaNovoPaciente;
import service.ServiceValidarCpfEmailTelefone;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaNovoPaciente extends JFrame{
    private static final long serialVersionUID = 1L;
    ServiceTelaNovoPaciente servicetelanovopaciente = new ServiceTelaNovoPaciente();
    DaoTelaPaciente daotelapaciente = new DaoTelaPaciente();
    ServiceValidarCpfEmailTelefone validar = new ServiceValidarCpfEmailTelefone();

    public TelaNovoPaciente(TabelaPaciente tabelapaciente){
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setBounds(500, 100, 546, 422);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Cadastro de Pacientes");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblTitulo.setBounds(10, 11, 511, 31);
        contentPane.add(lblTitulo);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNome.setHorizontalAlignment(SwingConstants.LEFT);
        lblNome.setBounds(70, 63, 60, 27);
        contentPane.add(lblNome);
        
        JTextField txtNome = new JTextField();
        txtNome.setBounds(70, 90, 390, 27);
        contentPane.add(txtNome);
        
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCpf.setBounds(70, 143, 60, 27);
        contentPane.add(lblCpf);
        
        JTextField txtCpf = new JTextField();
	txtCpf.setBounds(70, 170, 75, 27);
	contentPane.add(txtCpf);
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setBounds(200, 143, 60, 27);
        contentPane.add(lblEmail);
        
        JTextField txtEmail = new JTextField();
	txtEmail.setBounds(200, 170, 258, 27);
	contentPane.add(txtEmail);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTelefone.setBounds(70, 223, 60, 27); 
        contentPane.add(lblTelefone);
        
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(70, 250, 100, 27);
        contentPane.add(txtTelefone);  
        
        JButton btnSalvar = new JButton("Salvar");
	btnSalvar.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/checked.png")));
	btnSalvar.setForeground(Color.WHITE);
	btnSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnSalvar.setDoubleBuffered(true);
	btnSalvar.setBorder(null);
	btnSalvar.setBackground(new Color(0, 102, 52));
	btnSalvar.setBounds(135, 325, 102, 35);
	contentPane.add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/error.png")));
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnCancelar.setDoubleBuffered(true);
	btnCancelar.setBorder(null);
	btnCancelar.setBackground(new Color(255, 0, 0));
	btnCancelar.setBounds(296, 325, 102, 35);
	contentPane.add(btnCancelar);
        
        salvarPaciente(tabelapaciente, btnSalvar, txtCpf, txtTelefone, txtEmail, txtNome);
        
        cancelar(btnCancelar);
    }
    
    private void salvarPaciente(TabelaPaciente tabelapaciente, JButton btnSalvar, JTextField txtCpf, JTextField txtTelefone, JTextField txtEmail, JTextField txtNome){
        btnSalvar.addActionListener(e -> {
            String cpff = txtCpf.getText();
	    boolean validar1 = validar.validarCpf(cpff);
                            
            String telefonee = txtTelefone.getText();
            boolean validar2 = validar.validarTelefone(telefonee);
                            
            String emaill = txtEmail.getText();
            boolean validar3 = validar.validarEmail(emaill);
                            
            if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

	    }else if(txtCpf.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo CPF.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);  
                            
            }else if(! validar1){
            JOptionPane.showMessageDialog(null, "CPF inválido!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
            txtCpf.setBorder(new LineBorder(Color.RED));
                            
            }else if(txtEmail.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo E-mail.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
                            
            }else if(! validar3){
            JOptionPane.showMessageDialog(null, "E-mail inválido!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
            txtEmail.setBorder(new LineBorder(Color.RED));
                            
            }else if(txtTelefone.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                            
            }else if(! validar2){
            JOptionPane.showMessageDialog(null, "Telefone inválido!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
            txtTelefone.setBorder(new LineBorder(Color.RED));
                            
            }else {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();
                                                                                                                          
            if(servicetelanovopaciente.adicionarPaciente(daotelapaciente, nome, cpf, telefone, email, tabelapaciente)){
                dispose(); 
                JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "O CPF informado já está cadastrado.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
                               			
            }
                        
        });
        
    }
    
    private void cancelar(JButton btnCancelar) {
	btnCancelar.addActionListener(e -> {
		dispose();
			
	});

    }
    
    
}
