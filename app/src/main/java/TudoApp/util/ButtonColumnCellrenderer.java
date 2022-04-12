/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TudoApp.util;
 
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gustavo
 */
public class ButtonColumnCellrenderer extends DefaultTableCellRenderer {
    
    private String buttonType;
    
    public ButtonColumnCellrenderer(String buttonType){
        this.buttonType= buttonType;
    }

    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label= (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // o codigo acima, e referente ao que seria renderizado na tela, e a gente nao fizesse nenhuma modificação
        label.setHorizontalAlignment(JLabel.CENTER);
        // centralizar a label
        
        
        label.setIcon(new javax.swing.ImageIcon( getClass().getResource( "/" +  buttonType +  ".png" ) ));
        // setando um incone na label
        //no recurso setIcon, no pacote javax.swing uso o recurso Imagelcom, dai entro nessa classe e no endereço de onde esta o incone
        
        
        return label;
          
        
    }
    
    
    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }
    
    
}
