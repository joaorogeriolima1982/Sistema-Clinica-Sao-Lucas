/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.DaoTelaMedico;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import tabelas.TabelaMedico;
import tabelas.TabelaPaciente;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaListarMedicos extends JFrame{
    private static final long serialVersionUID = 1L;
    TabelaMedico tabelamedico = new TabelaMedico();               
    private TelaNovaConsulta telanovaconsulta;
    
    public TelaListarMedicos(TelaNovaConsulta telanovaconsulta){
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
        
        JTable jtableMedico = new JTable();
	scrollPane.setViewportView(jtableMedico);
        jtableMedico.setModel(tabelamedico);
        
        jtableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jtableMedico.getColumnModel().getColumn(0).setPreferredWidth(76);  
        jtableMedico.getColumnModel().getColumn(1).setPreferredWidth(350);  
        jtableMedico.getColumnModel().getColumn(2).setPreferredWidth(88);  
        jtableMedico.getColumnModel().getColumn(3).setPreferredWidth(180); 
        jtableMedico.getColumnModel().getColumn(4).setPreferredWidth(108); 
        jtableMedico.getColumnModel().getColumn(5).setPreferredWidth(265); 
        
        jtableMedico.getTableHeader().setResizingAllowed(false);
        
        this.telanovaconsulta = telanovaconsulta;
        
        DaoTelaMedico telamedico = new DaoTelaMedico();
        telamedico.exibirAllMedicos(tabelamedico);
        
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
        
        continuar(btnContinuar, jtableMedico);
        
	cancelar(btnCancelar);
    }
    
     private void continuar(JButton btnContinuar, JTable jtableMedico) {

		btnContinuar.addActionListener(e -> {

			if (jtableMedico.getSelectedRow() != -1) {
			    int linha = jtableMedico.getSelectedRow();

			    String id = jtableMedico.getValueAt(linha, 0).toString();
			    String nome = jtableMedico.getValueAt(linha, 1).toString();
					
			    telanovaconsulta.setarMedico(nome, id);
			    telanovaconsulta.setLocationRelativeTo(null);
		            telanovaconsulta.setVisible(true);

			    dispose();

			} else {
			  JOptionPane.showMessageDialog(null, "Selecione um médico.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

			}

			
		});
    }
     
    private void cancelar(JButton btnCancelar) {

	btnCancelar.addActionListener(e -> {
		dispose();
			
	});
   }
    
}
