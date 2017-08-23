 /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

package FDU.STUDENT.NALABOTHULA;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import FDU.STUDENT.NALABOTHULA.*;

public class Review
{
	private String Review_No, Product_ID, Customer_ID,Review_Description ;

	public Review(String Ri_No, String Prod_ID, String Cust_ID, String Ri_Descr) {
		Review_No = Ri_No;
		Product_ID = Prod_ID;
		Customer_ID = Cust_ID;
		Review_Description = Ri_Descr;

	}
public boolean addPro() {

		boolean done = !Review_No.equals("") && !Product_ID.equals("") && !Customer_ID.equals("") && !Review_Description.equals("");
		System.out.println("done1" +done);
		try {
		    if (done) {
				System.out.println("done" +done);
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Review_No, Prod_ID, Cust_ID, Review_Description FROM Prod_Cust_Reln WHERE Prod_ID ='"+Product_ID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Prod_Cust_Reln(Review_No, Prod_ID, Cust_ID, Review_Description) VALUES ('"+Review_No+ "','"+Product_ID+"','"+Customer_ID+"','"+Review_Description+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println("Query" +SQL_Command);
				    JOptionPane.showMessageDialog(null, "Thank you for your Review", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else{
					JOptionPane.showMessageDialog(null, "Insertion Failed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}


}

