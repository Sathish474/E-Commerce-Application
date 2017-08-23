import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EmployePanel extends JPanel
{
   public EmployePanel()
   {
      tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object

      tabPanel_1 = new Search();
      tabPanel_2 = new Delete();
      tabPanel_3 = new Update();
      tabPanel_4 = new Insert();

      tabbedPane.addTab("Search", tabPanel_1); //add GUI components to Tabbed Pane
      tabbedPane.setSelectedIndex(0);
      tabbedPane.addTab("Delete", tabPanel_2);
      tabbedPane.addTab("Update", tabPanel_3);
      tabbedPane.addTab("Insert", tabPanel_4);
      //show();
      add(tabbedPane);
   }

   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2, tabPanel_3,tabPanel_4;
}

/*class Prod_Emp_Reln extends JFrame
{
   public Prod_Emp_Reln()
   {
      setTitle("Product Maintanence");
      setSize(800, 600);

      //get screen size and set the location of the frame
      /*Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 4, screenHeight / 5);*/

     /* addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });

      JPanel tabbedPanel = new EmployeePanel();
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(tabbedPanel);
      pack();
   }
    public static void main(String [] args)
       { JFrame frame = new Prod_Emp_Reln(); //initialize a JFrame object
         frame.show(); //display the frame
    }
}*/

public class Prod_Emp_Reln extends JFrame
{
    private EmployePanel SU_Panel;

    public Prod_Emp_Reln()
    {
        setTitle("Sign Up");
        setSize(800, 600);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         SU_Panel = new EmployePanel();
         contentPane.add(SU_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new Prod_Emp_Reln(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

