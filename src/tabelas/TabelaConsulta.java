/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelas;

import model.Consulta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Rogério de Lima
 */
public class TabelaConsulta extends AbstractTableModel{
    private ArrayList<Consulta> dados = new ArrayList<>();
    private String[] colunas = {"ID", "HORÁRIO", "PACIENTE", "MÉDICO", "EXAME", "DATA"};

    public ArrayList<Consulta> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Consulta> dados) {
        this.dados = dados;
    }
    
    @Override
    public String getColumnName(int column) {
		return colunas[column];

    }

    @Override
    public int getRowCount() {
       return dados.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
		case 0:
			return dados.get(linha).getId(); 
		case 1:
			return dados.get(linha).getHorario(); 
		case 2:
			return dados.get(linha).getPaciente(); 
		case 3:
			return dados.get(linha).getMedico();
		case 4:
			return dados.get(linha).getExame();
		case 5:
			return dados.get(linha).getData();
	}

		return null;
    }
    
    public void adicionarLinha(Consulta consulta) {            
		this.dados.add(consulta);
		this.fireTableDataChanged(); 
	}

	public void removerLinha(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
                
		
	}

	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		switch (coluna) {
		case 0:
			dados.get(linha).setId(Integer.parseInt((String) valor)); 
                        break;
		case 1:
			dados.get(linha).setHorario((String) valor); 
			break;
		case 2:
			dados.get(linha).setPaciente((String) valor); 
			break;
		case 3:
			dados.get(linha).setMedico((String) valor);
			break;
		case 4:
			dados.get(linha).setExame((String) valor);
			break;
		case 5:
			dados.get(linha).setData((String) valor);

		}

		this.fireTableRowsUpdated(linha, linha);
	}

	public void limparTabela(int linha) {
		dados.removeAll(dados);
		this.fireTableRowsDeleted(linha, linha);
	}

}
    

