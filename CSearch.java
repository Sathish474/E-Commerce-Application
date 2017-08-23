
import FDU.STUDENT.NALABOTHULA.Product;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import FDU.STUDENT.NALABOTHULA.*;


public class CSearch extends JPanel implements ActionListener
{
       private final JTable table;
       private final JTextField field;
       private final JButton search;
       String id, name, cost, descp;

   public CSearch()
   {
      field = new JTextField(15);
      search = new JButton("Search");
      table = new JTable();
      search.addActionListener(this);
      JPanel p1=new JPanel();
      p1.add(field);
      JPanel p2=new JPanel();
      p2.add(search);

      //Create the scroll pane and add it to the table.
      JScrollPane scrollPane = new JScrollPane(table);

      //Add the scroll pane to this window.
      JPanel p3=new JPanel();
      p3.add(scrollPane);
      JPanel p4=new JPanel();
      p4.add(p1);
      p4.add(p2);
      p4.add(p3);
      add(p4);
   }

   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       if(o==search)
       {
           String prodID=field.getText();
           DefaultTableModel dtm=new DefaultTableModel();
           dtm.addColumn("Product ID");
           dtm.addColumn("Product Name");
           dtm.addColumn("Product Cost");
           dtm.addColumn("Product Description");

           try{
		              DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		   		   Connection DBConn = ToDB.openConn();
		   		   Statement Stmt = DBConn.createStatement();
		   		   String SQL_Command = "SELECT Prod_ID, Prod_Name, Prod_Price, Prod_Descriptionn FROM Product WHERE Prod_ID ='"+prodID+"' "; //SQL query command
		   		   System.out.println(SQL_Command);
		   		   ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		   		   while(Rslt.next()){
		   		   id = Rslt.getString("Prod_ID");
		   		   name = Rslt.getString("Prod_Name");
		   		   cost = Rslt.getString("Prod_Price");
		   		   descp = Rslt.getString("Prod_Description");
		   	   }


               Vector v=new Vector();
               v.add(id);
               v.add(name);
               v.add(cost);
               v.add(descp);

               dtm.addRow(v);

        }
        catch(Exception e){e.printStackTrace();}
        table.setModel(dtm);
        //table.setPreferredScrollableViewportSize(new Dimension(320, 160));
       }
   }
    /*public static void main(String [] args)
       { JFrame frame = new Search(); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}
