import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CustomerPanel extends JPanel
{
	String name;
   public CustomerPanel(String n)
   {
      tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object

      tabPanel_1 = new CSearch();
      tabPanel_2 = new CustReview();

      tabbedPane.addTab("Search", tabPanel_1); //add GUI components to Tabbed Pane
      tabbedPane.setSelectedIndex(0);
      tabbedPane.addTab("Review", tabPanel_2);
      //show();
      add(tabbedPane);
   }

   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2;
}

class Prod_Cust_Reln extends JFrame
{
String name;
   public Prod_Cust_Reln(String n)
   {
	   name = n;
      setTitle("Product Review");
      setSize(800, 600);

      //get screen size and set the location of the frame
      /*Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 4, screenHeight / 5);*/

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });

      JPanel tabbedPanel = new CustomerPanel(name);
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(tabbedPanel);
      show();
   }
   /* public static void main(String [] args)
       { JFrame frame = new Prod_Cust_Reln(name); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}