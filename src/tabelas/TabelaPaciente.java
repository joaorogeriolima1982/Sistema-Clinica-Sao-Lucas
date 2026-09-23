/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelas;

import model.Paciente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Rogério de Lima
 */
public class TabelaPaciente extends AbstractTableModel{
    private ArrayList<Paciente> dados = new ArrayList<>();
    private String[] colunas = {"ID", "NOME", "CPF", "TELEFONE", "E-MAIL"};

    public ArrayList<Paciente> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Paciente> dados) {
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
			return dados.get(linha).getNome(); 

		case 2:
			return dados.get(linha).getCpf(); 

		case 3:
			return dados.get(linha).getTelefone();
                        
		case 4:
			return dados.get(linha).getEmail();
		}

		return null;
    }
    
    public void adicionarLinha(Paciente paciente) {
		this.dados.add(paciente);
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
		case 1:
			dados.get(linha).setNome((String) valor); 
			break;
		case 2:
			dados.get(linha).setCpf((String) valor); 
			break;
		case 3:
			dados.get(linha).setTelefone((String) valor);
			break;
		case 4:
			dados.get(linha).setEmail((String) valor);
			break;
		}

		this.fireTableRowsUpdated(linha, linha);
	}

    public void limparTabela(int linha) {
		dados.removeAll(dados);
		this.fireTableRowsDeleted(linha, linha);

    }
}
    

