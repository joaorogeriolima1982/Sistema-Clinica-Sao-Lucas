/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mouse;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import view.TelaMenuInicial;
import view.TelaConsulta;
import view.TelaPaciente;
import view.TelaMedico;



/**
 *
 * @author João Rogério de Lima
 */
public class MouseFunction extends MouseAdapter{
    private JButton btnalterarCor;
    private Color c;
    
    public MouseFunction(JButton btnConsulta, TelaConsulta telaconsulta) {
		btnalterarCor = btnConsulta;
		
	}

    public MouseFunction(JButton btnPaciente, TelaPaciente telapaciente) {
		btnalterarCor =  btnPaciente;
		
	}

     public MouseFunction(JButton btnMedico, TelaMedico telamedico) {
		btnalterarCor = btnMedico;
		
	}

     public MouseFunction(JButton btnSair, TelaMenuInicial telamenuinicial) {
		btnalterarCor = btnSair;
		
	}
     
	@Override
	public void mouseExited(MouseEvent e) {
		btnalterarCor.setBackground(c);
	}
                                                                                 
	@Override
	public void mouseEntered(MouseEvent e) {
		if (btnalterarCor.getBackground() == Color.white) {
			btnalterarCor.setBackground(new Color(204, 255, 204));
			c = Color.white;
		}else if(btnalterarCor.getBackground() != Color.white){
                    btnalterarCor.setBackground(new Color(204, 204, 255));
                        c = new Color(204, 204, 255);
                }
                
	}
        
}
