/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelas;

import model.HistoricoConsultas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Rogério de Lima
 */
public class TabelaHistoricoConsultas extends AbstractTableModel{
    private ArrayList<HistoricoConsultas> dados = new ArrayList<>();
    private String[] colunas = {"ID", "HORÁRIO", "PACIENTE", "MÉDICO", "EXAME", "DATA"};

    public ArrayList<HistoricoConsultas> getDados() {
        return dados;
    }

    public void setDados(ArrayList<HistoricoConsultas> dados) {
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
			return dados.get(linha).getNomePaciente(); 
		case 3:
			return dados.get(linha).getNomeMedico();
		case 4:
			return dados.get(linha).getExame();
		case 5:
			return dados.get(linha).getData();
	}

		return null;
    }
    
    public void adicionarLinha(HistoricoConsultas historicoconsultas) {            
		this.dados.add(historicoconsultas);
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
			dados.get(linha).setNomePaciente((String) valor); 
			break;
		case 3:
			dados.get(linha).setNomeMedico((String) valor);
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
