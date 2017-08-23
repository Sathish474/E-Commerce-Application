
import FDU.STUDENT.NALABOTHULA.Product;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Delete extends JPanel implements ActionListener
{
       private final JTextField field;
       private final JButton button;
       private Product p;

   public Delete()
   {
      field = new JTextField(15);
      button = new JButton("Delete");
      button.addActionListener(this);
      JPanel p1=new JPanel();
      p1.add(field);
      JPanel p2=new JPanel();
      p2.add(button);

      JPanel p4=new JPanel();
      p4.add(p1);
      p4.add(p2);
      add(p4);
   }

   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       if(o==button)
       {
           String prodID=field.getText();
           try{
               p=new Product(prodID,"","","");
               if(p.delPro())
               {
                   JOptionPane.showMessageDialog(this, "Product Deleted");
               }
        }
        catch(Exception e){e.printStackTrace();}
       }
   }
    /*public static void main(String [] args)
       { JFrame frame = new Delete(); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}
