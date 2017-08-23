/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*****************************************************************************/

package FDU.STUDENT.NALABOTHULA;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import FDU.STUDENT.NALABOTHULA.*;

public class Maintanance
{
	private String Maintanance_ID, Maintanance_Name,Product_ID, Employe_ID;

	public Maintanance(String Ma_ID, String Ma_Name, String Pro_ID, String Emp_ID) {
		Maintanance_ID = Ma_ID;
		Maintanance_Name = Ma_Name;
		Product_ID = Pro_ID;
		Employe_ID = Emp_ID;

	}


    public boolean view() {
		boolean done = !Maintanance_ID.equals("");
		try{
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
                String SQL_Command = "SELECT * FROM Maintanance WHERE Main_ID = '"+Maintanance_ID+"'";
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				     SQL_Command = "INSERT INTO  Maintanance(Main_ID,Main_Name, Prod_ID, Employe_ID) VALUES ('"+Maintanance_ID+ "','"+Maintanance_Name+"','"+Product_ID+"','"+Employe_ID+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
			catch(java.sql.SQLException e){
				System.out.println("SQLException: " + e);
			}
	    return done;
	}

}