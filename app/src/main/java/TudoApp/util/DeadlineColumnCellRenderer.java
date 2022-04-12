/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.util;

import TudoApp.model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gustavo
 */
// essa classe vai customizar a celula/ coluna desejada
// o java ja tem uma classe que customiza\renderiza as colunas por padrao
// aolica ela na classe MainScreen linha ... 505
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {
    
  public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
      
      JLabel label;
      label= (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
              // o codigo acima, e referente ao que seria renderizado na tela, e a gente nao fizesse nenhuma modificação
              
      // ajutando o compondnte para ser impresso no centro da celula
      label.setHorizontalAlignment(CENTER);
      
      TaskTableModel taskModel= (TaskTableModel) table.getModel();
      // taskTableModel é a minha classe da lista de tarefas
      
      Task task= taskModel.getTasks().get(row);
      // esse aqui em cima, é uma linha especifica da minha lista de tarefas
      
      // na tarefa, eu pego a coluna que quero(deadline) e faço a jogada...
      // se a data na lista de tarefas for maior que hoje...
      if( task.getDeadline().after(new Date()) ){
          label.setBackground(Color.green);
          
      }else{
          label.setBackground(Color.red);
          
      }
      
      return label;     
      
      
  }
    
}
