/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import dao.DaoTelaConsulta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import service.ServiceTelaNovaConsulta;
import tabelas.TabelaConsulta;


/**
 *
 * @author João Rogério de Lima
 */
public class TelaNovaConsulta extends JFrame{
    private static final long serialVersionUID = 1L;
    private int idPaciente;
    private int idMedico;
    private String nomePaciente;
    private String nomeMedico;
    private JTextField txtPaciente;
    private JTextField txtId;
    private JLabel lblId;
    private JTextField txtMedico;
    private JTextField txtId2;
    private JLabel lblId2;
    DaoTelaConsulta daotelaconsulta = new DaoTelaConsulta();
    ServiceTelaNovaConsulta servicetelanovaconsulta = new ServiceTelaNovaConsulta();
    private TabelaConsulta tabelaconsulta;
    
    public TelaNovaConsulta(TabelaConsulta tabelaconsulta){
        this.tabelaconsulta = tabelaconsulta;
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(500, 100, 528, 440);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Agendar Consulta");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblTitulo.setBounds(10, 10, 495, 31);
        contentPane.add(lblTitulo);
        
        JLabel lblPaciente = new JLabel("Paciente");
	lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblPaciente.setBounds(43, 89, 52, 14);
	contentPane.add(lblPaciente);
        
        txtPaciente = new JTextField();
	txtPaciente.setEditable(false);  
	txtPaciente.setText("\r\n");
	txtPaciente.setForeground(new Color(0, 0, 0));
	txtPaciente.setBackground(new Color(220, 220, 220));
	txtPaciente.setColumns(10);
	txtPaciente.setBounds(110, 81, 258, 31);
	contentPane.add(txtPaciente);
        
        JLabel lblBuscarPaciente = new JLabel("Buscar");
        lblBuscarPaciente.setHorizontalAlignment(SwingConstants.CENTER);
	lblBuscarPaciente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	lblBuscarPaciente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	lblBuscarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblBuscarPaciente.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/pesquisar01.png")));
	lblBuscarPaciente.setBounds(386, 81, 79, 31);
	contentPane.add(lblBuscarPaciente);
        
        JLabel lblMedico = new JLabel("Médico");
        lblMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMedico.setBounds(51, 144, 65, 14);
        contentPane.add(lblMedico);
        
        txtMedico = new JTextField();
	txtMedico.setEditable(false);
	txtMedico.setBackground(new Color(220, 220, 220));
	txtMedico.setColumns(10);
	txtMedico.setBounds(110, 135, 258, 31);
	contentPane.add(txtMedico);
        
        JLabel lblBuscarMedico = new JLabel("Buscar");
        lblBuscarMedico.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarMedico.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblBuscarMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBuscarMedico.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/pesquisar01.png")));
        lblBuscarMedico.setBounds(386, 135, 79, 31);
        contentPane.add(lblBuscarMedico);
                
        JLabel lblExame = new JLabel("Exame");
	lblExame.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblExame.setBounds(53, 198, 79, 14);
	contentPane.add(lblExame);
        
        JComboBox cbExame = new JComboBox();
        cbExame.setModel(new DefaultComboBoxModel(new String[] {"Eletrocardiograma", "Ecocardiograma", "Teste Ergométrico", "Holter", "MAPA", "Angiotomografia", "Cintilografia", "Ressonância cardíaca"}));
	cbExame.setBounds(110, 190, 258, 31);
	contentPane.add(cbExame);
        
        JLabel lblData = new JLabel("Data");
	lblData.setBounds(65, 254, 52, 15);
	lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblData);
        
        JDateChooser calendario = new JDateChooser(null, "dd/MM/yyyy");
	calendario.setBounds(110, 251, 95, 22);
        calendario.setMinSelectableDate(new Date());
	contentPane.add(calendario);
        
        JLabel lblHorario = new JLabel("Horário");
	lblHorario.setBounds(230, 255, 52, 15);
	lblHorario.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblHorario);
        
        JComboBox cbHorario = new JComboBox();
	cbHorario.setModel(new DefaultComboBoxModel(new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"}));
	cbHorario.setBounds(288, 251, 79, 22);
	contentPane.add(cbHorario);
        
        JButton btnSalvar = new JButton("Salvar");
	btnSalvar.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/checked.png")));
	btnSalvar.setForeground(Color.WHITE);
	btnSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnSalvar.setDoubleBuffered(true);
	btnSalvar.setBorder(null);
	btnSalvar.setBackground(new Color(0, 102, 52));
	btnSalvar.setBounds(105, 325, 102, 35);
	contentPane.add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/error.png")));
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnCancelar.setDoubleBuffered(true);
	btnCancelar.setBorder(null);
	btnCancelar.setBackground(new Color(255, 0, 0));
	btnCancelar.setBounds(266, 325, 102, 35);
	contentPane.add(btnCancelar);
        
        lblId = new JLabel("ID");
	lblId.setVisible(false);
	lblId.setHorizontalAlignment(SwingConstants.CENTER);
	lblId.setHorizontalTextPosition(SwingConstants.CENTER);
	lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblId.setBounds(481, 69, 15, 14);
	contentPane.add(lblId);
        
        txtId = new JTextField();
	txtId.setBackground(new Color(255, 255, 255));
	txtId.setEditable(false);
	txtId.setVisible(false);
	txtId.setBounds(476, 86, 24, 22);
	txtId.setColumns(10);
        contentPane.add(txtId);
        
        lblId2 = new JLabel("ID");
	lblId2.setVisible(false);
        lblId2.setHorizontalAlignment(SwingConstants.CENTER);
	lblId2.setHorizontalTextPosition(SwingConstants.CENTER);
	lblId2.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblId2.setBounds(481, 123, 15, 14);
	contentPane.add(lblId2);
        
        txtId2 = new JTextField();
	txtId2.setVisible(false);
	txtId2.setBackground(new Color(255, 255, 255));
	txtId2.setEditable(false);
	txtId2.setBounds(476, 140, 24, 22);
	txtId2.setColumns(10);
        contentPane.add(txtId2);
       
        salvar(btnSalvar, cbExame, cbHorario, calendario, txtPaciente, txtMedico);
        
        cancelar(btnCancelar);
        
        abrirPacientes(this, lblBuscarPaciente);
        
        abrirMedicos(this, lblBuscarMedico); 
        
    }
    
    private void salvar(JButton btnSalvar, JComboBox cbExame, JComboBox cbHorario, JDateChooser calendario, JTextField txtPaciente, JTextField txtMedico){
        
        btnSalvar.addActionListener(e -> {
                String exame = cbExame.getSelectedItem().toString();
		String horario = cbHorario.getSelectedItem().toString();
                String data = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();
                String paciente = txtPaciente.getText();
                String medico = txtMedico.getText();
                
                if (servicetelanovaconsulta.validarPaciente(paciente)) {
                JOptionPane.showMessageDialog(null, "Selecione um paciente.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return;
                }
                
		if(servicetelanovaconsulta.validarMedico(medico)){
		JOptionPane.showMessageDialog(null, "Selecione um médico.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return;
                }
                
                if (servicetelanovaconsulta.validarData(data)) {
		JOptionPane.showMessageDialog(null, "Selecione uma data.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return;
		} 
                
		if(servicetelanovaconsulta.marcarConsulta(daotelaconsulta, idMedico, idPaciente, data, horario, exame, nomePaciente, nomeMedico, tabelaconsulta)){
                dispose();
                JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                
                }else if( ! servicetelanovaconsulta.conferirPaciente(daotelaconsulta, data, nomePaciente, horario)){
                 JOptionPane.showMessageDialog(null, "O paciente selecionado já possui uma consulta marcada para o dia "
						+ data + " às " + horario + " HS.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                 
                }else if( ! servicetelanovaconsulta.conferirMedico(daotelaconsulta, data, horario, nomeMedico)){
                 JOptionPane.showMessageDialog(null, "O médico selecionado já possui uma consulta marcada para o dia "
						+ data + " às " + horario + " HS.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                }
                
        });
    }
    
    private void cancelar(JButton btnCancelar){
        
	btnCancelar.addActionListener(e -> {
		dispose();
	});
    }

   private void abrirPacientes(TelaNovaConsulta telanovaconsulta, JLabel lblBuscarPaciente) {
       
       lblBuscarPaciente.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
                TelaListarPacientes tela = new  TelaListarPacientes(telanovaconsulta);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
                
                dispose();
           }

           @Override
           public void mousePressed(MouseEvent e) {
               
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               lblBuscarPaciente.setBackground(Color.BLACK);
           }

           @Override
           public void mouseExited(MouseEvent e) {
               lblBuscarPaciente.setBackground(null);
           }

			
       });

    }
   
   private void abrirMedicos(TelaNovaConsulta telanovaconsulta, JLabel lblBuscarMedico){
       
       lblBuscarMedico.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
               TelaListarMedicos tlmedicos = new TelaListarMedicos(telanovaconsulta);
               tlmedicos.setLocationRelativeTo(null);
	       tlmedicos.setVisible(true);
               
               dispose();
           }

           @Override
           public void mousePressed(MouseEvent e) {
               
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               lblBuscarMedico.setBackground(Color.BLACK);
           }

           @Override
           public void mouseExited(MouseEvent e) {
               lblBuscarMedico.setBackground(null);
           }
           
       });
       
   }
   
    public void setarPaciente(String nome, String id) {
		this.idPaciente = Integer.parseInt(id);
		this.nomePaciente = nome;

		txtPaciente.setText(nome);
		txtPaciente.setBackground(new Color(255, 255, 255));

		txtId.setText(id);
		txtId.setVisible(true);
		lblId.setVisible(true);
    }

    public void setarMedico(String nome, String id) {

		this.idMedico = Integer.parseInt(id);
		this.nomeMedico = nome;

		txtMedico.setText(nome);
		txtMedico.setBackground(new Color(255, 255, 255));

		txtId2.setText(id);
		txtId2.setVisible(true);
		lblId2.setVisible(true);

    }

      
}
