package testes;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gelvazio.camargo
 */
public class JTableButtonModel extends AbstractTableModel {

    // devia passar o codigo da vaga dentro do JButton, o codigo da pessoa logada
   private Object[][] rows = {
       {"Button1484", new JButtonVagasEmpresa("Button11", 1,1)},
       {"Button2", new JButtonVagasEmpresa("Button2", 1,1)},
       {"Button3", new JButtonVagasEmpresa("Button3", 1,1)}, 
       {"Button4", new JButtonVagasEmpresa("Button4", 1,1)}
   };
   
   private String[] columns = {"Count", "Buttons"};
   
   public String getColumnName(int column) {
      return columns[column];
   }
   public int getRowCount() {
      return rows.length;
   }
   public int getColumnCount() {
      return columns.length;
   }
   public Object getValueAt(int row, int column) {
      return rows[row][column];
   }
   public boolean isCellEditable(int row, int column) {
      return false;
   }
   public Class getColumnClass(int column) {
      return getValueAt(0, column).getClass();
   }

    public JTableButtonModel() {
    }
   
   
}
