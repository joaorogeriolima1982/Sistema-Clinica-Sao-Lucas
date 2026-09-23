/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.DaoTelaMedico;
import dao.HikariCP;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import mouse.MouseFunction;
import service.ServiceTelaMedico;
import tabelas.TabelaMedico;




/**
 *
 * @author João Rogério de Lima
 */
public class TelaMedico  extends JPanel{
    private static final long serialVersionUID = 1L;
    TabelaMedico tabelamedico = new TabelaMedico();
    ServiceTelaMedico servicetelamedico = new ServiceTelaMedico();
    DaoTelaMedico daotelamedico = new DaoTelaMedico();
    
    public TelaMedico(JPanel jpanel){
	setBackground(new Color(0, 0, 0));
	setBorder(new EmptyBorder(5, 5, 5, 5));
	setLayout(null);
        
        JPanel painel = new JPanel();
	painel.setBackground(new Color(51, 153, 255));
	painel.setBounds(0, 0, 299, 800);
        painel.setLayout(null);
        add(painel);
        
        JLabel lblLogoTipo = new JLabel();
        lblLogoTipo.setBounds(0, 0, 299, 199);
        lblLogoTipo.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/imagens/img_logotipo.png")));
        lblLogoTipo.setLayout(null);
        painel.add(lblLogoTipo);
        
        JButton btnConsulta = new JButton();
	btnConsulta.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btnConsulta.setBackground(Color.WHITE);
        btnConsulta.setBounds(0, 200, 300, 70);
        btnConsulta.setLayout(null);
        btnConsulta.addActionListener(e -> {
            CardLayout layout = (CardLayout) jpanel.getLayout();
            layout.show(jpanel, "telaconsulta");
        });
        painel.add(btnConsulta);
        
        JLabel lblConsulta = new JLabel("CONSULTAS");
        lblConsulta.setFont(new Font("Dialog", Font.BOLD, 18));
        lblConsulta.setBounds(91, 25, 145, 22);                           
        btnConsulta.add(lblConsulta);
        
        JButton btnPaciente = new JButton();
        btnPaciente.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btnPaciente.setBackground(Color.WHITE);
        btnPaciente.setBounds(0, 270, 300, 70);
        btnPaciente.setLayout(null);
        btnPaciente.addActionListener(e -> {
            CardLayout layout = (CardLayout) jpanel.getLayout();
            layout.show(jpanel, "telapaciente");
        });
        painel.add(btnPaciente);
        
        JLabel lblPaciente = new JLabel("PACIENTES");
        lblPaciente.setFont(new Font("Dialog", Font.BOLD, 18));  
        lblPaciente.setBounds(91, 25, 115, 22);
        btnPaciente.add(lblPaciente);
        
        JButton btnMedico = new JButton();
        btnMedico.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btnMedico.setBackground(new Color(204, 204, 255));
        btnMedico.setBounds(0, 340, 300, 70);
        btnMedico.setLayout(null);
        painel.add(btnMedico);  
        
        JLabel lblMedico = new JLabel("MÉDICOS");
        lblMedico.setFont(new Font("Dialog", Font.BOLD, 18));
        lblMedico.setBounds(91, 25, 200, 22);
        btnMedico.add(lblMedico);
        
        JButton btnSair = new JButton();
        btnSair.setBorder(new MatteBorder(2, 1, 3, 1, (Color) new Color(0, 0, 0)));
        btnSair.setBackground(Color.WHITE);
        btnSair.setBounds(0, 410, 300, 70);
        btnSair.setLayout(null);
        btnSair.addActionListener(e -> {
            int i = JOptionPane.showConfirmDialog(null, "DESEJA SAIR DA APLICAÇÃO?", "ATENÇÃO", JOptionPane.OK_CANCEL_OPTION);
			if (i == JOptionPane.YES_OPTION) {
                            HikariCP.fecharPool();
			    System.exit(0);
                        }
        });
        painel.add(btnSair);   
        
        JLabel lblSair = new JLabel("SAIR");
        lblSair.setFont(new Font("Dialog", Font.BOLD, 18));
        lblSair.setBounds(91, 25, 200, 22);
        btnSair.add(lblSair);
        
        JPanel menuPrincipal = new JPanel();
        menuPrincipal.setBackground(new Color(248, 248, 255));
        menuPrincipal.setBounds(302, 0, 1238, 35);
        menuPrincipal.setLayout(null);
        add(menuPrincipal);  
        
        JLabel imgPrincipal = new JLabel();
        imgPrincipal.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/imagens/pagina-inicial (1).png")));
        imgPrincipal.setBounds(5, 5, 30, 30);
        menuPrincipal.add(imgPrincipal);
        
        JLabel lblPrincipal = new JLabel("Home");
        lblPrincipal.setForeground(UIManager.getColor("Button.foreground"));
        lblPrincipal.setBackground(new Color(0, 0, 255));
        lblPrincipal.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrincipal.setBounds(35, 7, 46, 30);
        menuPrincipal.add(lblPrincipal);
        
        JLabel lblPrincipal2 = new JLabel("> Médicos");
        lblPrincipal2.setForeground(new Color(0, 0, 0));
        lblPrincipal2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrincipal2.setBounds(69, 7, 101, 30);
        menuPrincipal.add(lblPrincipal2);
        
        JLabel imgfundoPrincipal = new JLabel();
        imgfundoPrincipal.setIcon(new ImageIcon(TelaConsulta.class.getResource("")));
        imgfundoPrincipal.setBounds(302, 38, 1238, 800);
        add(imgfundoPrincipal);
        
        JScrollPane scrollPane = new JScrollPane();                    
        scrollPane.setBounds(340, 140, 1150, 610);
        add(scrollPane);
        
        JTable jtableMedico = new JTable();
        
        scrollPane.setViewportView(jtableMedico);
        
        jtableMedico.setModel(tabelamedico);
        
        jtableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jtableMedico.getColumnModel().getColumn(0).setPreferredWidth(76);  
        jtableMedico.getColumnModel().getColumn(1).setPreferredWidth(350);  
        jtableMedico.getColumnModel().getColumn(2).setPreferredWidth(108);  
        jtableMedico.getColumnModel().getColumn(3).setPreferredWidth(220); 
        jtableMedico.getColumnModel().getColumn(4).setPreferredWidth(108); 
        jtableMedico.getColumnModel().getColumn(5).setPreferredWidth(285); 
        
        jtableMedico.getTableHeader().setResizingAllowed(false);
        
        JButton btnNovo = new JButton("Novo");
        btnNovo.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/plus-black-symbol.png")));
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnNovo.setDoubleBuffered(true);
        btnNovo.setBorder(null);
        btnNovo.setBackground(new Color(0, 102, 52));
        btnNovo.setBounds(340, 70, 90, 35);
        add(btnNovo);
        
        JButton btnEditar = new JButton("Editar");
	btnEditar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/edit.png")));
	btnEditar.setForeground(Color.WHITE);
	btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnEditar.setDoubleBuffered(true);
	btnEditar.setBorder(null);
	btnEditar.setBackground(Color.BLUE);
	btnEditar.setBounds(460, 70, 90, 35);
	add(btnEditar);
        
        JButton btnExcluir = new JButton("Excluir");
	btnExcluir.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/trash.png")));
        btnExcluir.setBackground(Color.RED);
	btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 16)); 
	btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
	btnExcluir.setBorder(null);
        btnExcluir.setBounds(580, 70, 90, 35);
	btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	btnExcluir.setDoubleBuffered(true);
        add(btnExcluir);
        
        JLabel lblPesquisar = new JLabel("Pesquisar:");
	lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPesquisar.setForeground(new java.awt.Color(255, 255, 255));
	lblPesquisar.setBounds(700, 70, 67, 35);
	add(lblPesquisar);
        
        JTextField txtPesquisar = new JTextField();
	txtPesquisar.setBounds(775, 70, 606, 35);
	txtPesquisar.setColumns(10);
        add(txtPesquisar);
        
        JButton btnPesquisar = new JButton();
        btnPesquisar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/search.png")));
	btnPesquisar.setForeground(Color.WHITE);
	btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnPesquisar.setDoubleBuffered(true);
	btnPesquisar.setBorder(null);
	btnPesquisar.setBackground(new Color(0, 102, 52));
	btnPesquisar.setBounds(1400, 70, 90, 35);
	add(btnPesquisar);
        
        JButton btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/trash.png")));
	btnLimpar.setForeground(Color.WHITE);
	btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnLimpar.setDoubleBuffered(true);                                                                                                                                         
	btnLimpar.setBorder(null);
	btnLimpar.setBackground(Color.RED);
	btnLimpar.setBounds(1400, 70, 90, 35);
        btnLimpar.setVisible(false);
        add(btnLimpar);
        
        btnConsulta.addMouseListener(new MouseFunction(btnConsulta, this));
        btnPaciente.addMouseListener(new MouseFunction(btnPaciente, this));
	btnMedico.addMouseListener(new MouseFunction(btnMedico, this));
	btnSair.addMouseListener(new MouseFunction(btnSair, this));
        
        servicetelamedico.exibirAllMedicos(daotelamedico, tabelamedico);
        
         home(jpanel, imgPrincipal);
         
         adicionarMedico(btnNovo);
         
         editarMedico(btnEditar, jtableMedico);
         
         excluirMedico(btnExcluir, jtableMedico);
         
         limpar(btnLimpar, txtPesquisar, btnPesquisar);
         
         pesquisarMedicoPor3Digitos(txtPesquisar, btnPesquisar, btnLimpar);
         
         pesquisarMedicoPor1Digito(btnPesquisar, txtPesquisar, btnLimpar);
    }
    
    private void home(JPanel jpanel, JLabel imgPrincipal){
		imgPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 CardLayout layout = (CardLayout) jpanel.getLayout();
                                 layout.show(jpanel, "telamenuinicial");

			}
		});

     }
    
     private void adicionarMedico(JButton btnNovo){
         btnNovo.addActionListener(e -> {
                 TelaNovoMedico tela = new TelaNovoMedico(tabelamedico);
                 tela.setLocationRelativeTo(null);
                 tela.setVisible(true);
             
             
         });
     }
    
    private void editarMedico(JButton btnEditar, JTable jtableMedico){
          btnEditar.addActionListener(e -> {
		if (jtableMedico.getSelectedRow() != -1) {
		    int linha = jtableMedico.getSelectedRow();

		    String id = jtableMedico.getValueAt(linha, 0).toString();
		    String nome = jtableMedico.getValueAt(linha, 1).toString();
		    String crm = jtableMedico.getValueAt(linha, 2).toString();
		    String especialidade = jtableMedico.getValueAt(linha, 3).toString();                 
		    String telefone = jtableMedico.getValueAt(linha, 4).toString();
                    String email = jtableMedico.getValueAt(linha, 5).toString();

		    TelaEditarMedico editarmedico = new TelaEditarMedico(id, nome, crm, especialidade, telefone, email, tabelamedico);
		    editarmedico.setLocationRelativeTo(null);
		    editarmedico.setVisible(true);

		}else {
		   JOptionPane.showMessageDialog(null, "Selecione um médico.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

		}
               
	  });
          
     }
    
     private void excluirMedico(JButton btnExcluir, JTable jtableMedico){
	btnExcluir.addActionListener(e -> {

	    if (jtableMedico.getSelectedRow() != -1) {

	    int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o médico selecionado?", "ATENÇÃO", JOptionPane.OK_CANCEL_OPTION);

		if (i == JOptionPane.YES_OPTION){
                                            
		String crm = jtableMedico.getValueAt(jtableMedico.getSelectedRow(), 2).toString();
						
		    if(servicetelamedico.deletarMedico(daotelamedico, crm)){
                     tabelamedico.removerLinha(jtableMedico.getSelectedRow());
                     JOptionPane.showMessageDialog(null, "Médico excluído com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                     JOptionPane.showMessageDialog(null, "O médico selecionado tem uma consulta marcada, não é possível excluir.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                    }
                                                     
		}
                                        
            }else {

             JOptionPane.showMessageDialog(null, "Selecione um médico.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
                               
        });

     }
     
      private void limpar(JButton btnLimpar, JTextField txtPesquisar, JButton btnPesquisar) {
		btnLimpar.addActionListener(e -> {
		    txtPesquisar.setText("");
                    tabelamedico.limparTabela(tabelamedico.getRowCount());  
                    servicetelamedico.exibirAllMedicos(daotelamedico, tabelamedico);
        	    btnLimpar.setVisible(false);                              
		    btnPesquisar.setVisible(true);
		                
			
		});
    }
      
      private void pesquisarMedicoPor3Digitos(JTextField txtPesquisar, JButton btnPesquisar, JButton btnLimpar){
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			    if (txtPesquisar.getText().trim().length() <= 1) {
       			     btnPesquisar.setVisible(true);
		             btnLimpar.setVisible(false);
			    }else {
			     String nome = txtPesquisar.getText();
                                if(servicetelamedico.pesquisarMedico(daotelamedico, nome, tabelamedico)){
                                 btnPesquisar.setVisible(false);
			         btnLimpar.setVisible(true);  
                                }else{
                                 JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                 txtPesquisar.setText("");
                                 servicetelamedico.exibirAllMedicos(daotelamedico, tabelamedico);
                                }
					
		            }
			}

		});

      }
      
    private void pesquisarMedicoPor1Digito(JButton btnPesquisar, JTextField txtPesquisar, JButton btnLimpar){
          btnPesquisar.addActionListener(e -> {

		if(txtPesquisar.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Digite um nome para realizar a pesquisa.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return;
                }
		if(!txtPesquisar.getText().isBlank()){
		String nome = txtPesquisar.getText();
		   if(servicetelamedico.pesquisarMedico(daotelamedico, nome, tabelamedico)){
                   btnPesquisar.setVisible(false);
	           btnLimpar.setVisible(true);
                   }else{
                   JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                   txtPesquisar.setText("");
                   servicetelamedico.exibirAllMedicos(daotelamedico, tabelamedico);
                   }
	        }

			
          });
    }
    
    
}
