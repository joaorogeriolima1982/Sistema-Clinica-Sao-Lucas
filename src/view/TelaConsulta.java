


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import dao.DaoTelaConsulta;
import dao.HikariCP;
import model.Consulta;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import mouse.MouseFunction;
import service.ServiceTelaConsulta;
import tabelas.TabelaConsulta;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaConsulta extends JPanel{
    private static final long serialVersionUID = 1L;
    TabelaConsulta tabelaconsulta = new TabelaConsulta();
    ServiceTelaConsulta servicetelaconsulta = new ServiceTelaConsulta();
    
     public TelaConsulta(JPanel jpanel){
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
        btnConsulta.setBackground(new Color(204, 204, 255));
        btnConsulta.setBounds(0, 200, 300, 70);
        btnConsulta.setLayout(null);
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
        btnMedico.setBackground(Color.WHITE);
        btnMedico.setBounds(0, 340, 300, 70);
        btnMedico.setLayout(null);
        btnMedico.addActionListener(e -> {
            CardLayout layout = (CardLayout) jpanel.getLayout();
            layout.show(jpanel, "telamedico");
        });
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
        
        JLabel lblPrincipal2 = new JLabel("> Consultas");
        lblPrincipal2.setForeground(new Color(0, 0, 0));
        lblPrincipal2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrincipal2.setBounds(69, 7, 100, 30);
        menuPrincipal.add(lblPrincipal2);
        
        JLabel imgfundoPrincipal = new JLabel();
        imgfundoPrincipal.setIcon(new ImageIcon(TelaConsulta.class.getResource("")));
        imgfundoPrincipal.setBounds(302, 38, 1238, 800);
        add(imgfundoPrincipal);
        
        JScrollPane scrollPane = new JScrollPane();                    
        scrollPane.setBounds(340, 140, 1150, 552);
        add(scrollPane);
        
        JTable jtableConsulta = new JTable();
        
        scrollPane.setViewportView(jtableConsulta);
        
        jtableConsulta.setModel(tabelaconsulta);
        
        jtableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jtableConsulta.getColumnModel().getColumn(0).setPreferredWidth(76);  
        jtableConsulta.getColumnModel().getColumn(1).setPreferredWidth(108);  
        jtableConsulta.getColumnModel().getColumn(2).setPreferredWidth(320);  
        jtableConsulta.getColumnModel().getColumn(3).setPreferredWidth(320); 
        jtableConsulta.getColumnModel().getColumn(4).setPreferredWidth(215);  
        jtableConsulta.getColumnModel().getColumn(5).setPreferredWidth(108);
        
        jtableConsulta.getTableHeader().setResizingAllowed(false);
        
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
	txtPesquisar.setBounds(775, 70, 511, 35);
	txtPesquisar.setColumns(10);
        add(txtPesquisar);
        
        JButton btnPesquisar = new JButton();
        btnPesquisar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/search.png")));
	btnPesquisar.setForeground(Color.WHITE);
	btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnPesquisar.setDoubleBuffered(true);
	btnPesquisar.setBorder(null);
	btnPesquisar.setBackground(new Color(0, 102, 52));
	btnPesquisar.setBounds(1305, 70, 55, 35);
	add(btnPesquisar);
        
        JButton btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/trash.png")));
	btnLimpar.setForeground(Color.WHITE);
	btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	btnLimpar.setDoubleBuffered(true);                                                                                                                                         
	btnLimpar.setBorder(null);
	btnLimpar.setBackground(Color.RED);
	btnLimpar.setBounds(1305, 70, 55, 35);
        btnLimpar.setVisible(false);
        add(btnLimpar);
        
        JButton btnHistorico = new JButton("Histórico");
        btnHistorico.setIcon(new ImageIcon(TelaConsulta.class.getResource("/imagens/listaconsultas.png")));
        btnHistorico.setForeground(Color.WHITE);
        btnHistorico.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnHistorico.setDoubleBuffered(true);
        btnHistorico.setBorder(null);
        btnHistorico.setBackground(new Color(0, 102, 52));
        btnHistorico.setBounds(340, 725, 120, 35);
        add(btnHistorico);
        
        JDateChooser calendario = new JDateChooser(null, "dd/MM/yyyy");
	calendario.setBounds(1386, 78, 102, 20);
        calendario.setMinSelectableDate(new Date());
        add(calendario);
        
        btnConsulta.addMouseListener(new MouseFunction(btnConsulta, this));
        btnPaciente.addMouseListener(new MouseFunction(btnPaciente, this));
	btnMedico.addMouseListener(new MouseFunction(btnMedico, this));
	btnSair.addMouseListener(new MouseFunction(btnSair, this));
        
        DaoTelaConsulta daotelaconsulta = new DaoTelaConsulta();
        servicetelaconsulta.exibirConsultas(daotelaconsulta, tabelaconsulta); 
        
        home(jpanel, imgPrincipal);
        
        adicionarConsulta(btnNovo);
        
        editarConsulta(btnEditar, jtableConsulta);
        
        excluirConsulta(btnExcluir, jtableConsulta, daotelaconsulta);
        
        limpar(btnLimpar, txtPesquisar, calendario, daotelaconsulta, btnPesquisar);
       
        pesquisarConsultaPor3Digitos(txtPesquisar, btnPesquisar, btnLimpar, daotelaconsulta);
        
        pesquisarConsultaPor1DigitoEData(btnPesquisar, calendario, txtPesquisar, daotelaconsulta, btnLimpar);
        
        pesquisarHistorico(btnHistorico);

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
     
     private void adicionarConsulta(JButton btnNovo){
		btnNovo.addActionListener(e -> {
			TelaNovaConsulta telanovaconsulta = new TelaNovaConsulta(tabelaconsulta);
                        telanovaconsulta.setLocationRelativeTo(null);
                        telanovaconsulta.setVisible(true);
		});

    }
     
     private void editarConsulta(JButton btnEditar, JTable jtableConsulta) {
            btnEditar.addActionListener(e -> {
                
		        if (jtableConsulta.getSelectedRow() != -1) {
                     
			int linha =  jtableConsulta.getSelectedRow();

			String id =  jtableConsulta.getValueAt(linha, 0).toString();
			String horario =  jtableConsulta.getValueAt(linha, 1).toString();
			String paciente =  jtableConsulta.getValueAt(linha, 2).toString();
			String profissional =  jtableConsulta.getValueAt(linha, 3).toString();
			String procedimento = jtableConsulta.getValueAt(linha, 4).toString();
			String data =  jtableConsulta.getValueAt(linha, 5).toString();

			int id2 = Integer.parseInt(id);

			Consulta editar = new Consulta(id2, horario, paciente, profissional, procedimento, data);

			TelaEditarConsulta telaeditarconsulta = new TelaEditarConsulta(editar, tabelaconsulta);
			telaeditarconsulta.setLocationRelativeTo(null);
			telaeditarconsulta.setVisible(true);
		        } else {
			JOptionPane.showMessageDialog(null, "Selecione uma consulta.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
		        }
           });
            
     }
     
     private void excluirConsulta(JButton btnExcluir, JTable jtableConsulta, DaoTelaConsulta daotelaconsulta) {
		btnExcluir.addActionListener(e -> {

			if (jtableConsulta.getSelectedRow() != -1) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja excluir a consulta selecionada?", "ATENÇÃO", JOptionPane.OK_CANCEL_OPTION);

			    if (i == JOptionPane.YES_OPTION) {

			    String id = jtableConsulta.getValueAt(jtableConsulta.getSelectedRow(), 0).toString();
                            
                               if(servicetelaconsulta.deletarConsulta(id, daotelaconsulta)){
                                tabelaconsulta.removerLinha(jtableConsulta.getSelectedRow()); 
                                JOptionPane.showMessageDialog(null, "Consulta excluída com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                               }
                            
			    }
                            
			}else {
			JOptionPane.showMessageDialog(null, "Selecione uma consulta.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

		        }
                            
		});

     }
     
     private void limpar(JButton btnLimpar, JTextField txtPesquisar, JDateChooser calendario, DaoTelaConsulta daotelaconsulta, JButton btnPesquisar) {
		btnLimpar.addActionListener(e -> {
			txtPesquisar.setText("");
                        ((JTextField) calendario.getDateEditor().getUiComponent()).setText("");
                        tabelaconsulta.limparTabela(tabelaconsulta.getRowCount()); 
                        servicetelaconsulta.exibirConsultas(daotelaconsulta, tabelaconsulta);
        	        btnLimpar.setVisible(false);                              
		        btnPesquisar.setVisible(true);
		                
			
		});
    }
     
     private void pesquisarConsultaPor3Digitos(JTextField txtPesquisar, JButton btnPesquisar, JButton btnLimpar, DaoTelaConsulta daotelaconsulta){
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtPesquisar.getText().trim().length() <= 1) {   
       				btnPesquisar.setVisible(true);
				btnLimpar.setVisible(false);
				}else {
				String nome = txtPesquisar.getText();
				if(servicetelaconsulta.pesquisarConsulta(nome, tabelaconsulta, daotelaconsulta)){
				btnPesquisar.setVisible(false);
				btnLimpar.setVisible(true);
                                }else{
                                JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                txtPesquisar.setText("");
                                servicetelaconsulta.exibirConsultas(daotelaconsulta, tabelaconsulta);
                                }
				}
			}

		});

    }
     
     private void pesquisarConsultaPor1DigitoEData(JButton btnPesquisar, JDateChooser calendario, JTextField txtPesquisar, DaoTelaConsulta daotelaconsulta, JButton btnLimpar){                           
          btnPesquisar.addActionListener(e -> {

				String data = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();

				if(txtPesquisar.getText().isBlank() && data.isBlank()) {
                                JOptionPane.showMessageDialog(null, "Digite um nome ou uma data para realizar a pesquisa.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                return;
                                }
				if(!data.isBlank()){
				    if(servicetelaconsulta.pesquisarConsultaDatas(data, tabelaconsulta, daotelaconsulta)){   
                                    btnPesquisar.setVisible(false);
			            btnLimpar.setVisible(true);  
                                    }else{
                                    JOptionPane.showMessageDialog(null, "Não existe consulta agendada para o dia " + data + ".", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                    ((JTextField) calendario.getDateEditor().getUiComponent()).setText(""); 
                                    servicetelaconsulta.exibirConsultas(daotelaconsulta, tabelaconsulta);
                                    }
				}
                                if(!txtPesquisar.getText().isBlank()){
                                    String nome = txtPesquisar.getText();
				    if(servicetelaconsulta.pesquisarConsulta(nome, tabelaconsulta, daotelaconsulta)){
				    btnPesquisar.setVisible(false);
				    btnLimpar.setVisible(true);
                                    }else{
                                    JOptionPane.showMessageDialog(null, "Sem resultado(s) para o(s) dígito(s) informado(s).", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                                    txtPesquisar.setText("");
                                    servicetelaconsulta.exibirConsultas(daotelaconsulta, tabelaconsulta);
                                    }
                                }
		});
      }
     
     private void pesquisarHistorico(JButton btnHistorico){
         btnHistorico.addActionListener(e -> {
                 
                  TelaHistoricoConsultas tela = new  TelaHistoricoConsultas();
                  tela.setLocationRelativeTo(null);
                  tela.setVisible(true); 
         });
     }

     
     
     
     
}
