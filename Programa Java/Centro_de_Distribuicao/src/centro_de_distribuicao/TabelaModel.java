/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro_de_distribuicao ;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author desen
 */
public class TabelaModel extends AbstractTableModel {
    private String[] colunas = {"PID", "Nome Produto", "Quantidade Produto","Data de Entrega"};
    private ArrayList<DadosTabela_Lista> produtos;
    private final int COLUNA_PID=0,COLUNA_Nome=1,COLUNA_Quantidade=2, COLUNA_Data=3;
    
    public TabelaModel(ArrayList<DadosTabela_Lista> produtos){
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
       return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_PID:
                return Integer.class;
            case COLUNA_Nome:
                return String.class;
            case COLUNA_Quantidade:
                return Integer.class;
            case COLUNA_Data:
                return String.class;
            default:
                return String.class;
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DadosTabela_Lista produtoA = this.produtos.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_PID:
                return produtoA.getPid();
            case COLUNA_Nome:
                return produtoA.getPname();
            case COLUNA_Quantidade:
                return produtoA.getPavailability();
            case COLUNA_Data:
                return produtoA.getData();
                
        }
        return null;
    }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DadosTabela_Lista produtoA = this.produtos.get(rowIndex);
       
        switch (columnIndex) {
            case COLUNA_PID:
                produtoA.setPid((int) aValue);
                break;
            case COLUNA_Nome:
                produtoA.setPname(String.valueOf(aValue));
                break;
            case COLUNA_Quantidade:
                produtoA.setPavailability((int) aValue);
                break;
            case COLUNA_Data:
                produtoA.setData((Date) aValue);
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
