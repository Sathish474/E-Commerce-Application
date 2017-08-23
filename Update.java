
import FDU.STUDENT.NALABOTHULA.Product;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import FDU.STUDENT.NALABOTHULA.*;



public class Update extends JPanel implements ActionListener
{
       private final JLabel Prod_ID, Prod_Name, Prod_Price, Prod_Desc, Prod_Search;
	   private final JTextField ProdID, ProdName, ProdPrice, ProdDesc, ProdSearch;
       private final JButton add, get;
       String id, name, cost, descp;

   public Update()
   {
      setLayout(null);
      Prod_Search=new JLabel("Search");
      Prod_ID=new JLabel("Product ID");
	  Prod_Name=new JLabel("Product Name");
	  Prod_Price=new JLabel("Product Cost");
	  Prod_Desc=new JLabel("Description");

	  ProdSearch=new JTextField(15);
	  ProdID= new JTextField(15);
	  ProdName= new JTextField(15);
	  ProdPrice= new JTextField(15);
	  ProdDesc= new JTextField(15);

      add = new JButton("Add");
      get= new JButton("Get");
      add.addActionListener(this);
      get.addActionListener(this);

      Prod_Search.setBounds(90,10,60,30);
      ProdSearch.setBounds(150,10,70,30);
      get.setBounds(220, 10, 60, 30);

      //JPanel p1=new JPanel();
      Prod_ID.setBounds(30, 60, 60, 30);
      ProdID.setBounds(90, 60, 60, 30);

      Prod_Name.setBounds(170, 60, 85, 30);
      ProdName.setBounds(255, 60, 100, 30);


      Prod_Price.setBounds(30, 110, 60, 30);
      ProdPrice.setBounds(90, 110, 60, 30);

      Prod_Desc.setBounds(170, 110, 85, 30);
      ProdDesc.setBounds(255, 110, 100, 30);

      add.setBounds(170, 260, 60, 30);

      add(Prod_Search);
      add(ProdSearch);
      add(get);

      add(Prod_ID);
      add(ProdID);
      add(Prod_Name);
      add(ProdName);
      add(Prod_Price);
      add(ProdPrice);
      add(Prod_Desc);
      add(ProdDesc);
      add(add);
       //JScrollPane jsp=new JScrollPane();
       //jsp.add(p1);
       //add(p1);
   }

   public void actionPerformed(ActionEvent ae)
   {
       Object o=ae.getSource();
       if(o==add)
       {
           String pid=ProdID.getText();
           String pname=ProdName.getText();
           String pcost=ProdPrice.getText();
           String pdesc=ProdDesc.getText();

           Product p=new Product(pid,pname,pcost,pdesc);
           //int i=p.addProduct();
           if(p.updPro())
           {
               JOptionPane.showMessageDialog(this, "Product Details Added Successfully");
           }
       }
       else if(o==get)
       {
           String pid=ProdSearch.getText();
           /*Product prod=new Product();
           ArrayList<Product> product=prod.searchByName(pid);
           Product p=product.get(0);
           if(p!=null){
           ProdID.setText(p.getProductID());
           ProdName.setText(p.getProductName());
           ProdQty.setText(p.getProductDescription());
           ProdPrice.setText(p.getProductDepartment());
           ProdDesc.setText(p.getProductSize());*/


try{
           DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		   Connection DBConn = ToDB.openConn();
		   Statement Stmt = DBConn.createStatement();
		   String SQL_Command = "SELECT Prod_ID, Prod_Name, Prod_Price, Prod_Description FROM Product WHERE Prod_ID ='"+pid+"' "; //SQL query command
		   System.out.println(SQL_Command);
		   ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		   while(Rslt.next()){
		   id = Rslt.getString("Prod_ID");
		   name = Rslt.getString("Prod_Name");
		   cost = Rslt.getString("Prod_Price");
		   descp = Rslt.getString("Prod_Description");
	   }
   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
		   ProdID.setText(id);
		   ProdName.setText(name);
		   ProdPrice.setText(cost);
           ProdDesc.setText(descp);



       }
   }
   /* public static void main(String [] args)
       { JFrame frame = new Update(); //initialize a JFrame object
         frame.show(); //display the frame
    }*/
}