/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import dao.DaoTelaHistoricoConsultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import service.ServiceTelaHistoricoConsultas;
import tabelas.TabelaHistoricoConsultas;
import javax.swing.JOptionPane;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaHistoricoConsultas extends JFrame{
    private static final long serialVersionUID = 1L;
    ServiceTelaHistoricoConsultas servicetelahistoricoconsultas = new ServiceTelaHistoricoConsultas();
    TabelaHistoricoConsultas tabelahistoricoconsultas = new TabelaHistoricoConsultas();
    DaoTelaHistoricoConsultas daotelahistoricoconsultas = new DaoTelaHistoricoConsultas();
    
    
    public TelaHistoricoConsultas() {
        setTitle("Histórico de Consultas");
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(140, 10, 1239, 800);
        JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();                    
        scrollPane.setBounds(36, 80, 1150, 610);
        contentPane.add(scrollPane);
        
        JTable jtableHistoricoConsultas = new JTable();
        
        scrollPane.setViewportView(jtableHistoricoConsultas);
        
        jtableHistoricoConsultas.setModel(tabelahistoricoconsultas);
        
        jtableHistoricoConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jtableHistoricoConsultas.getColumnModel().getColumn(0).setPreferredWidth(76);  
        jtableHistoricoConsultas.getColumnModel().getColumn(1).setPreferredWidth(108);  
        jtableHistoricoConsultas.getColumnModel().getColumn(2).setPreferredWidth(320);  
        jtableHistoricoConsultas.getColumnModel().getColumn(3).setPreferredWidth(320); 
        jtableHistoricoConsultas.getColumnModel().getColumn(4).setPreferredWidth(215);  
        jtableHistoricoConsultas.getColumnModel().getColumn(5).setPreferredWidth(108);
        
        jtableHistoricoConsultas.getTableHeader().setResizingAllowed(false);
        
        JLabel lblPesquisar = new JLabel("Pesquisar:");
	lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPesquisar.setForeground(new java.awt.Color(255, 255, 255));
	lblPesquisar.setBounds(39, 23, 67, 35);
	contentPane.add(lblPesquisar);
        
        JTextField txtPesquisar = new JTextField();
	txtPesquisar.setBounds(114, 23, 511, 35);
	txtPesquisar.setColumns(10);
        contentPane.add(txtPesquisar);
        
        JButton btnPesquisar = new JButton();
        btnPesquisar.setIcon(new ImageIcon(TelaHistoricoConsultas.class.getResource("/imagens/search.png")));
	btnPesquisar.setForeground(Color.WHITE);
	btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnPesquisar.setDoubleBuffered(true);
	btnPesquisar.setBorder(null);
	btnPesquisar.setBackground(new Color(0, 102, 52));
	btnPesquisar.setBounds(643, 23, 90, 35);
	contentPane.add(btnPesquisar);
        
        JButton btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(TelaHistoricoConsultas.class.getResource("/imagens/trash.png")));
	btnLimpar.setForeground(Color.WHITE);
	btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnLimpar.setDoubleBuffered(true);                                                                                                                                         
	btnLimpar.setBorder(null);
	btnLimpar.setBackground(Color.RED);
	btnLimpar.setBounds(643, 23, 90, 35);
        btnLimpar.setVisible(false);
        contentPane.add(btnLimpar);
        
        JDateChooser calendario = new JDateChooser(null, "dd/MM/yyyy");
	calendario.setBounds(753, 33, 102, 20);
        contentPane.add(calendario);
        
        JButton btnExcluir = new JButton("Excluir");
	btnExcluir.setIcon(new ImageIcon(TelaHistoricoConsultas.class.getResource("/imagens/trash.png")));
        btnExcluir.setBackground(Color.RED);
	btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 16)); 
	btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
	btnExcluir.setBorder(null);
        btnExcluir.setBounds(1096, 23, 90, 35);
	btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	btnExcluir.setDoubleBuffered(true);
        contentPane.add(btnExcluir);
        
        JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setIconTextGap(6);
	btnCancelar.setIcon(new ImageIcon(TelaHistoricoConsultas.class.getResource("/imagens/error.png")));
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnCancelar.setDoubleBuffered(true);
	btnCancelar.setBorder(null);
	btnCancelar.setBackground(new Color(255, 0, 0));
	btnCancelar.setBounds(545, 706, 146, 40);
	contentPane.add(btnCancelar);
        
        pesquisarHistoricoPor3Digitos(txtPesquisar, btnPesquisar, btnLimpar);
        
        limpar(btnLimpar, txtPesquisar, calendario, btnPesquisar);
        
        pesquisarHistoricoPor1DigitoEData(btnPesquisar, calendario, txtPesquisar, btnLimpar);
        
        cancelar(btnCancelar);
        
        excluirHistorico(btnExcluir, jtableHistoricoConsultas, btnPesquisar, btnLimpar, calendario, txtPesquisar);
    }
    
     private void pesquisarHistoricoPor3Digitos(JTextField txtPesquisar, JButton btnPesquisar, JButton btnLimpar){
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtPesquisar.getText().trim().length() <= 1) {
       				    btnPesquisar.setVisible(true);
				    btnLimpar.setVisible(false);
				}
                                if(!txtPesquisar.getText().isBlank()){
					String nome = txtPesquisar.getText();
                                        
				    if(servicetelahistoricoconsultas.pesquisarHistoricoConsultas(nome, daotelahistoricoconsultas, tabelahistoricoconsultas)){
                                     btnPesquisar.setVisible(false);
			             btnLimpar.setVisible(true); 
                                    }else{
                                     JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                     txtPesquisar.setText("");
                                    }
					
				}
			}

		});

    }
     
     private void limpar(JButton btnLimpar, JTextField txtPesquisar, JDateChooser calendario, JButton btnPesquisar) {
		btnLimpar.addActionListener(e -> {
			txtPesquisar.setText("");
                        ((JTextField) calendario.getDateEditor().getUiComponent()).setText("");
                        tabelahistoricoconsultas.limparTabela(tabelahistoricoconsultas.getRowCount()); 
        	        btnLimpar.setVisible(false);                              
		        btnPesquisar.setVisible(true);
		                
		});
    }
     
    private void pesquisarHistoricoPor1DigitoEData(JButton btnPesquisar, JDateChooser calendario, JTextField txtPesquisar, JButton btnLimpar){                           
          btnPesquisar.addActionListener(e -> {

			String data = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();

			if(txtPesquisar.getText().isBlank() && data.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Digite um nome ou uma data para pesquisar.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                        return;
			}
                        if(!data.isBlank()){
			    if(servicetelahistoricoconsultas.pesquisarHistoricoConsultaDatas(data, tabelahistoricoconsultas, daotelahistoricoconsultas)){
                             btnPesquisar.setVisible(false);
		             btnLimpar.setVisible(true);   
                            }else{
                             JOptionPane.showMessageDialog(null, "Sem resultado(s) para o dia " + data + ".", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
			     ((JTextField) calendario.getDateEditor().getUiComponent()).setText("");
                            }
			}
                        if(!txtPesquisar.getText().isBlank()){
                            String nome = txtPesquisar.getText();
			    if(servicetelahistoricoconsultas.pesquisarHistoricoConsultas(nome, daotelahistoricoconsultas, tabelahistoricoconsultas)){
                             btnPesquisar.setVisible(false);
			     btnLimpar.setVisible(true);   
                            }else{
                             JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                             txtPesquisar.setText("");   
                            }
                        }

			
	});
    }
      
      private void cancelar(JButton btnCancelar) {

		btnCancelar.addActionListener(e -> {
			dispose();
			
		});
      }
      
      private void excluirHistorico(JButton btnExcluir, JTable jtableHistoricoConsultas, JButton btnPesquisar, JButton btnLimpar, JDateChooser calendario, JTextField txtPesquisar) {
		btnExcluir.addActionListener(e -> {
                            
                        if (jtableHistoricoConsultas.getSelectedRow() != -1) {
                        
			    int i = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR TODO O HISTÓRICO DO PACIENTE?", "ATENÇÃO", JOptionPane.OK_CANCEL_OPTION);

			    if (i == JOptionPane.YES_OPTION) {   
			    String nome = jtableHistoricoConsultas.getValueAt(jtableHistoricoConsultas.getSelectedRow(), 2).toString();
                                 if(servicetelahistoricoconsultas.deletarHistoricoConsultas(tabelahistoricoconsultas, nome, daotelahistoricoconsultas)){
                                 tabelahistoricoconsultas.removerLinha(jtableHistoricoConsultas.getSelectedRow());
                                 JOptionPane.showMessageDialog(null, "O histórico de consultas do paciente foi removido do sistema!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                 btnPesquisar.setVisible(true);
			         btnLimpar.setVisible(false); 
                                 ((JTextField) calendario.getDateEditor().getUiComponent()).setText("");
                                 txtPesquisar.setText("");
                                 }
                            
                            }
                            
                        }else {
                                JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA PARA QUE TODO O HISTÓRICO DO PACIENTE SEJA EXCLUÍDO.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                            
                              }  
                            
                       
		});

     }
    
    
}
