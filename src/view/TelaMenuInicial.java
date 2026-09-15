/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.HikariCP;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import mouse.MouseFunction;

/**
 *
 * @author João Rogério de Lima
 */
public class TelaMenuInicial extends JPanel{
     private static final long serialVersionUID = 1L;
    
     public TelaMenuInicial(JPanel jpanel) {
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
        
        JLabel imgfundoPrincipal = new JLabel();
        imgfundoPrincipal.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/imagens/img_consultorio002.png")));
        imgfundoPrincipal.setBounds(302, 38, 1238, 800);
        add(imgfundoPrincipal);
        
        btnConsulta.addMouseListener(new MouseFunction(btnConsulta, this));
        btnPaciente.addMouseListener(new MouseFunction(btnPaciente, this));
	btnMedico.addMouseListener(new MouseFunction(btnMedico, this));
	btnSair.addMouseListener(new MouseFunction(btnSair, this));
        
    }

}
