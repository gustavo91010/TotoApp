/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.util;

import TudoApp.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gustavo
 */
public class TaskTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
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

    @Override // esse me retorna uma informação correspondente a uma linha e uma coluna especifica
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                // quando a coluna 1 eu pego o nome da minha tarefa que esta na posição rowIndex
                return tasks.get(rowIndex).getName();

            case 1:
                // quando a coluna 2 eu pego o nome da minha tarefa que esta na posição rowIndex
                return tasks.get(rowIndex).getDescription();
            case 2:
                return tasks.get(rowIndex).getDeadline();
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
