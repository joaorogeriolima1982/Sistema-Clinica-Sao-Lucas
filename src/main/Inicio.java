/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.CardLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.TelaMenuInicial;
import view.TelaConsulta;
import view.TelaLogin;
import view.TelaPaciente;
import view.TelaMedico;


/**
 *
 * @author João Rogério de Lima
 */
public class Inicio  extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel jpanel;
    private CardLayout cardLayout;
  
    public Inicio(){
        
        setTitle("Clínica São Lucas");
        setSize(1538, 800);
        setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        cardLayout = new CardLayout();
        jpanel = new JPanel(cardLayout);
	add(jpanel);
        
        jpanel.add(new TelaLogin(jpanel), "telalogin");
        jpanel.add(new TelaMenuInicial(jpanel), "telamenuinicial");
        jpanel.add(new TelaConsulta(jpanel), "telaconsulta");
        jpanel.add(new TelaPaciente(jpanel), "telapaciente");
        jpanel.add(new TelaMedico(jpanel), "telamedico");
        
        cardLayout.show(jpanel, "telalogin");  
             
    }
    
}