/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.DaoTelaPaciente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import tabelas.TabelaPaciente;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaListarPacientes extends JFrame{
    private static final long serialVersionUID = 1L;
    TabelaPaciente tabelapaciente = new TabelaPaciente();              
    private TelaNovaConsulta telanovaconsulta;
    
    public TelaListarPacientes(TelaNovaConsulta telanovaconsulta){
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setSize(1121, 648);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(18, 25, 1070, 495);
	contentPane.add(scrollPane);

        JTable jtablePaciente = new JTable();
	scrollPane.setViewportView(jtablePaciente);
        jtablePaciente.setModel(tabelapaciente);
        
        jtablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jtablePaciente.getColumnModel().getColumn(0).setPreferredWidth(76);  
        jtablePaciente.getColumnModel().getColumn(1).setPreferredWidth(410);  
        jtablePaciente.getColumnModel().getColumn(2).setPreferredWidth(108);  
        jtablePaciente.getColumnModel().getColumn(3).setPreferredWidth(108); 
        jtablePaciente.getColumnModel().getColumn(4).setPreferredWidth(365);  
        
        jtablePaciente.getTableHeader().setResizingAllowed(false);
        
        this.telanovaconsulta = telanovaconsulta;
        
        DaoTelaPaciente telapaciente = new DaoTelaPaciente();
        telapaciente.exibirAllPacientes(tabelapaciente);
       
        JButton btnContinuar = new JButton("Continuar");
	btnContinuar.setIconTextGap(6);
	btnContinuar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/imagens/checked.png")));
	btnContinuar.setForeground(Color.WHITE);
	btnContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnContinuar.setDoubleBuffered(true);
	btnContinuar.setBorder(null);
	btnContinuar.setBackground(new Color(0, 102, 52));
	btnContinuar.setBounds(370, 545, 146, 40);
	contentPane.add(btnContinuar);
        
        JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setIconTextGap(6);
	btnCancelar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/imagens/error.png")));
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnCancelar.setDoubleBuffered(true);
	btnCancelar.setBorder(null);
	btnCancelar.setBackground(new Color(255, 0, 0));
	btnCancelar.setBounds(570, 545, 146, 40);
	contentPane.add(btnCancelar);
        
        continuar(btnContinuar, jtablePaciente);
        
	cancelar(btnCancelar);
        
    }
    
    private void continuar(JButton btnContinuar, JTable jtablePaciente) {

		btnContinuar.addActionListener(e -> {

			if (jtablePaciente.getSelectedRow() != -1) {
			    int linha = jtablePaciente.getSelectedRow();

			    String id = jtablePaciente.getValueAt(linha, 0).toString();
			    String nome = jtablePaciente.getValueAt(linha, 1).toString();
					
		            telanovaconsulta.setarPaciente(nome, id);
			    telanovaconsulta.setLocationRelativeTo(null);
			    telanovaconsulta.setVisible(true);

			    dispose();

			} else {
			  JOptionPane.showMessageDialog(null, "Selecione um paciente.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

			}

			
		});
    }
    
    private void cancelar(JButton btnCancelar) {

	btnCancelar.addActionListener(e -> {
		dispose();
			
	});
    }
    
}
