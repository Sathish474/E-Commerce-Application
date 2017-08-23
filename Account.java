/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

package FDU.STUDENT.NALABOTHULA;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import FDU.STUDENT.NALABOTHULA.*;

public class Account
{
	private String Username, Password, Password1, Name, u, p, id,EmpID, EmpEmail;

	public Account(String UN, String PassW, String PassW1, String NM, String empid, String Email) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
		EmpID = empid;
		EmpEmail = Email;
	}

public Account(String UN, String PassW, String PassW1, String NM) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
		}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

    public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT UserName FROM Account WHERE UserName ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(UserName, Password, Name, Employe_ID, Employe_Email) VALUES ('"+Username+ "','"+Password+"','"+Name+"','"+EmpID+"', '"+EmpEmail+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
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

	public boolean changePassword(String NewPassword) {	//5
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE UserName ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        if (Rslt.next()) {
				    SQL_Command = "UPDATE Account SET Password='"+NewPassword+"' WHERE UserName ='"+Username+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
				}
		}
	    catch(java.sql.SQLException e)		//5
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




	//Log-In
	public String LogIn(){
			boolean done = !Username.equals("") && !Password.equals("");
			boolean chk = false;
			String s ="";
			try{
				if(done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
						        Connection DBConn = ToDB.openConn();
						        Statement Stmt = DBConn.createStatement();
						        String SQL_Command = "SELECT UserName, Password, Employe_ID FROM Account WHERE UserName ='"+Username+"' AND Password='"+Password+"' "; //SQL query command
						        System.out.println(SQL_Command);
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        while(Rslt.next()){
			        u = Rslt.getString("UserName");
			        p = Rslt.getString("Password");
			        id = Rslt.getString("Employe_ID");
				}
			        System.out.println("u" +u);
			        System.out.println("p" +p);
			        System.out.println("id" +id);

			        //done = UserName.equals(u) && Password.equals(p);
			        //if(Username.equals(u) && Password.equals(p)){
						//chk = true;
					//}
					//else{chk = false;}
					if(id != null && !id.equals("")){
												s = "Employe,"+id;
											}
											else{
											s = "Customer,"+id;
						}

			        System.out.println("UserName" +Username);
			        System.out.println("Password" +Password);
					System.out.println("chk" +chk);
			        System.out.println("done" +done);
			        Stmt.close();
				    ToDB.closeConn();
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			return s;
		}

}