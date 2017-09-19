/*
 * Copyright (c) 2015. Panos Pelegris
 */

package panos.gui.test;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class MyTable extends JTable
{

  static class MyTableModel extends AbstractTableModel
  {
    static String[][] data = new String[][]{{"1","2","3"},
                                            {"4","5","6"},
                                            {"7","8","9"}};

    @Override
    public int getRowCount() {
      return 3;
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      return data[rowIndex][columnIndex];
    }

  }

  public MyTable() {
  }

  public MyTable(TableModel dm) {
    super(dm);
  }

  @Override
  protected JTableHeader createDefaultTableHeader() {
    return super.createDefaultTableHeader();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    MyTable myTable = new MyTable(new MyTableModel());

    ArrayList data = new ArrayList();
    data.add("1");
    data.add("2");
    data.add("3");

    String[] columns = new String[]{"AA","BB","CC"};


//    JTable table = new JTable(MyTableModel.data ,columns);
    JTable table = new JTable(new TableModel()
    {
      int[] data = {1,2,3,4,5,6,7,8,9};
      String[] columnNames = {"A","B","C"};


      @Override
      public int getRowCount() {
        return 3;
      }

      @Override
      public int getColumnCount() {
        return 3;
      }

      @Override
      public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        return data[((rowIndex + 1) * (columnIndex + 1))-1];
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

      }

      @Override
      public void addTableModelListener(TableModelListener l) {

      }

      @Override
      public void removeTableModelListener(TableModelListener l) {

      }
    });

    Enumeration<TableColumn> tableColumns = table.getColumnModel().getColumns();

    while (tableColumns.hasMoreElements()) {
      TableColumn tableColumn = tableColumns.nextElement();
      System.out.println("tableColumn = " + tableColumn);
      int width = 100;
      tableColumn.setPreferredWidth(width);
      tableColumn.setMaxWidth(width);
      tableColumn.setMinWidth(width);
    }


    System.out.println();


//    table.setTableHeader(null);

//    JTable table = new MyTable(new MyTableModel());


    frame.add(new JScrollPane(table));

    frame.pack();
    frame.setVisible(true);
  }
}
