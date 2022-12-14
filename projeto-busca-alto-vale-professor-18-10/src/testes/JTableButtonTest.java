package testes;

/**
 *
 * @author gelvazio.camargo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableButtonTest extends JFrame {
   private JTable table;
   private JScrollPane scrollPane;
   public JTableButtonTest() {
      setTitle("JTableButton Test");
      TableCellRenderer tableRenderer;
      table = new JTable(new JTableButtonModel());
      tableRenderer = table.getDefaultRenderer(JButton.class);
      table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
      scrollPane = new JScrollPane(table);
      add(scrollPane, BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setSize(400, 300);
      setVisible(true);
   }
   public static void main(String[] args) {
      new JTableButtonTest();
   }
}
