/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.DaoTelaMedico;
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
import service.ServiceTelaEditarMedico;
import service.ServiceValidarCpfEmailTelefone;
import tabelas.TabelaMedico;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaEditarMedico extends JFrame{
    private static final long serialVersionUID = 1L;
    private String nome;
    private String crm;
    private String email;
    private String telefone;
    private String especialidade;  
    private String id;
    ServiceTelaEditarMedico servicetelaeditarmedico = new ServiceTelaEditarMedico();
    ServiceValidarCpfEmailTelefone validar = new ServiceValidarCpfEmailTelefone();

    public TelaEditarMedico(String id, String nome, String crm, String especialidade, String telefone, String email, TabelaMedico tabelamedico){
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setBounds(500, 100, 546, 422);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Editar Médicos");
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
        
        JLabel lblCrm = new JLabel("CRM");
        lblCrm.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCrm.setBounds(70, 143, 60, 27);
        contentPane.add(lblCrm);
        
        JTextField txtCrm = new JTextField();
	txtCrm.setBounds(70, 170, 100, 27);
	contentPane.add(txtCrm);
        
        JLabel lblEspecialidade = new JLabel("Especialidade");
        lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEspecialidade.setBounds(200, 143, 130, 27);
        contentPane.add(lblEspecialidade);
        
        JTextField txtEspecialidade = new JTextField();
	txtEspecialidade.setBounds(200, 170, 258, 27);
	contentPane.add(txtEspecialidade);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTelefone.setBounds(70, 223, 60, 27); 
        contentPane.add(lblTelefone);
        
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(70, 250, 100, 27);
        contentPane.add(txtTelefone);  
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setBounds(200, 223, 60, 27);
        contentPane.add(lblEmail);
        
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(200, 250, 258, 27);
        contentPane.add(txtEmail);
        
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
        
        dadosMedico(txtNome, txtCrm, txtEspecialidade, txtTelefone, txtEmail);
        
        salvarMedicoEditado(tabelamedico, btnSalvar, txtTelefone, txtEmail, txtNome, txtCrm, txtEspecialidade); 
        
        cancelar(btnCancelar);
    }
    
    private void dadosMedico(JTextField txtNome, JTextField txtCrm, JTextField txtEspecialidade, JTextField txtTelefone, JTextField txtEmail){
        txtNome.setText(nome);
        txtCrm.setText(crm);
        txtEspecialidade.setText(especialidade);
        txtTelefone.setText(telefone);
        txtEmail.setText(email);
    }
    
    private void salvarMedicoEditado(TabelaMedico tabelamedico, JButton btnSalvar, JTextField txtTelefone, JTextField txtEmail, JTextField txtNome, JTextField txtCrm, JTextField txtEspecialidade){
        btnSalvar.addActionListener(e -> {
            String telefonee = txtTelefone.getText();
            boolean validar1 = validar.validarTelefone(telefonee);
                            
            String emaill = txtEmail.getText();
            boolean validar2 = validar.validarEmail(emaill);
                            
            if (txtNome.getText().isBlank()) {
	    JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

	    }else if(txtCrm.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo CRM", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
                            
            }else if(txtEspecialidade.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo Especialidade", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);   
                            
            }else if(txtTelefone.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                            
            }else if(! validar1){
            JOptionPane.showMessageDialog(null, "Telefone inválido!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
            txtTelefone.setBorder(new LineBorder(Color.RED));
                            
            }else if(txtEmail.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo E-mail", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                            
            }else if(! validar2){
            JOptionPane.showMessageDialog(null, "E-mail inválido!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE); 
            txtEmail.setBorder(new LineBorder(Color.RED));
                            
            }else {
            int idd = Integer.parseInt(id);
            String nome = txtNome.getText();
            String crm = txtCrm.getText();
            String especialidade = txtEspecialidade.getText();
            String telefone = txtTelefone.getText(); 
            String email = txtEmail.getText();
                                                                                                      
            DaoTelaMedico daotelamedico = new DaoTelaMedico();
            servicetelaeditarmedico.atualizarMedico(daotelamedico, idd, nome, crm, especialidade, telefone, email, tabelamedico);
            dispose();
            JOptionPane.showMessageDialog(null, "Médico atualizado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);               	
            }
                        
        });
        
    }
    
    private void cancelar(JButton btnCancelar){
	btnCancelar.addActionListener(e -> {
		dispose();
			
	});

    }
      
}
