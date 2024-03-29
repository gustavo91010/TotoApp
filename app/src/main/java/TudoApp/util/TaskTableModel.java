/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.util;

import TudoApp.model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gustavo
 */
public class TaskTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Descri��o", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
    private List<Task> tasks = new ArrayList<>();

    @Override // me diz quntas linhas minha tabela vai ter, e eu quero um numero de linhas igual a o numero de tarefas no meu projeto
    public int getRowCount() {

        return tasks.size();

    }

    @Override // quantas colunas eu vou ter
    public int getColumnCount() {
        return columns.length;

    }
    
    @Override
    public String getColumnName(int columnIndex){
        
        
        return columns[columnIndex];
    }
    
     
    
    @Override // esse metodo permite que a coluna escolhida seja editavel
    public boolean isCellEditable( int rowIndex, int columnIndex ){
        if(columnIndex == 3){
            return true;
        }
        
        return false;
    }

    @Override // qual a classe do componente que esta referido na coluna
    public Class<?>  getColumnClass( int columnIndex ){
        
        if ( tasks.isEmpty() ){
        
        return Object.class;
    }
        return this.getValueAt(0, columnIndex).getClass();
        // ele va dizer o tipo do dado da coluna, se � String, int, boolean ou etc.
        
    }
    
    @Override // esse me retorna uma informa��o correspondente a uma linha e uma coluna especifica
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                // quando a coluna 1 eu pego o nome da minha tarefa que esta na posi��o rowIndex
                return tasks.get(rowIndex).getName();

            case 1:
                // quando a coluna 2 eu pego o nome da minha tarefa que esta na posi��o rowIndex
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yy");
                return sdf.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).getIsCompleted();
            case 4:
                return " ";
            case 5:
                return " ";
            default:
                return "Dados nao encontrados";
        }
        
            }
    
    
    
    
    @Override // esse metodo marca a columna "tarefa concluida" , com true or false
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
       
        // o cash (boolean) esta convertendo pra boolean o object aValue
        // e salvo na list tasks
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
        
        
    }
    

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
