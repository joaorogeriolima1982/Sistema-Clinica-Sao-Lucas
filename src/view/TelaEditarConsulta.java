/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import dao.DaoTelaConsulta;
import model.Consulta;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JFrame;
import tabelas.TabelaConsulta;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import service.ServiceTelaEditarConsulta;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaEditarConsulta extends JFrame{
    private static final long serialVersionUID = 1L;
    private Consulta editarConsulta;
    ServiceTelaEditarConsulta servicetelaeditarconsulta = new ServiceTelaEditarConsulta();
    
    public TelaEditarConsulta(Consulta editar, TabelaConsulta tabelaconsulta){
        editarConsulta = editar;
	setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setBounds(500, 100, 528, 440);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Editar Consulta");
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
        
        JTextField txtPaciente = new JTextField();
	txtPaciente.setEditable(false);  
	txtPaciente.setText(editarConsulta.getPaciente());
	txtPaciente.setForeground(new Color(0, 0, 0));
	txtPaciente.setBackground(new Color(220, 220, 220));
	txtPaciente.setColumns(10);
	txtPaciente.setBounds(110, 81, 258, 31);
	contentPane.add(txtPaciente);
        
        JLabel lblBuscarPaciente = new JLabel("Buscar");
        lblBuscarPaciente.setEnabled(false);
        lblBuscarPaciente.setHorizontalAlignment(SwingConstants.CENTER);
	lblBuscarPaciente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	lblBuscarPaciente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	lblBuscarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblBuscarPaciente.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/pesquisar01.png")));
	lblBuscarPaciente.setBounds(386, 81, 79, 31);
	contentPane.add(lblBuscarPaciente);
        
        JLabel lblProfissional = new JLabel("Profissional");
        lblProfissional.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblProfissional.setBounds(27, 144, 65, 14);
        contentPane.add(lblProfissional);
        
        JTextField txtProfissional = new JTextField();
	txtProfissional.setEditable(false);
        txtProfissional.setText(editarConsulta.getMedico());
	txtProfissional.setBackground(new Color(220, 220, 220));
	txtProfissional.setColumns(10);
	txtProfissional.setBounds(110, 135, 258, 31);
	contentPane.add(txtProfissional);
        
        JLabel lblBuscarProfissional = new JLabel("Buscar");
        lblBuscarProfissional.setEnabled(false);
        lblBuscarProfissional.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarProfissional.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblBuscarProfissional.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBuscarProfissional.setIcon(new ImageIcon(TelaNovaConsulta.class.getResource("/imagens/pesquisar01.png")));
        lblBuscarProfissional.setBounds(386, 135, 79, 31);
        contentPane.add(lblBuscarProfissional);
        
        JLabel lblExame = new JLabel("Exame");
	lblExame.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblExame.setBounds(53, 198, 79, 14);
	contentPane.add(lblExame);
        
        JComboBox cbExame = new JComboBox();
        cbExame.setEnabled(false);
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
        
        cbExame.setSelectedItem(editarConsulta.getExame());
        ((JTextField) calendario.getDateEditor().getUiComponent()).setText(editarConsulta.getData());
        cbHorario.setSelectedItem(editarConsulta.getHorario());
        
        
        salvar(tabelaconsulta, btnSalvar, calendario, cbHorario);
        
        cancelar(btnCancelar);
    }
    
    private void salvar(TabelaConsulta tabelaconsulta, JButton btnSalvar, JDateChooser calendario, JComboBox cbHorario){
        btnSalvar.addActionListener(e -> {
                String data = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();
                String horario =  cbHorario.getSelectedItem().toString();
                int idConsulta = editarConsulta.getId();
                String nomeMedico = editarConsulta.getMedico();
                String nomePaciente = editarConsulta.getPaciente();
                    
                if (servicetelaeditarconsulta.validarData(data)) {
                JOptionPane.showMessageDialog(null, "Verifique o campo Data.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return;
                }
		
                DaoTelaConsulta daotelaconsulta = new DaoTelaConsulta();
                if(servicetelaeditarconsulta.atualizarConsulta(daotelaconsulta, idConsulta, data, horario, nomeMedico, nomePaciente, tabelaconsulta)){
                dispose();
                JOptionPane.showMessageDialog(null, "Consulta remarcada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                }else{
                JOptionPane.showMessageDialog(null, "SELECIONE OUTRA DATA E HORÁRIO. Já existe uma consulta marcada para o dia "
						+ data + " às " + horario + " HS.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                }
        });
    }  
    
    private void cancelar(JButton btnCancelar){
        btnCancelar.addActionListener(e -> {
                dispose();
        }); 
        
    }     
}
