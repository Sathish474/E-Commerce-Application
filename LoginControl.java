/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import FDU.STUDENT.NALABOTHULA.*;

public class LoginControl
{
    private Account Acct;
    private Customer Cust;
    private Prod_Emp_Reln pemp;
    private SignUpBO sb;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String result = Acct.LogIn();
				                System.out.println("value is "+result);
				                if(result.contains(",")){
		                String[] s=result.split(",");
		                if(s[0].equals("customer")){
											 CustomerControl custControl = new CustomerControl(s[0]);
											 Prod_Cust_Reln PCR = new Prod_Cust_Reln(UName);
										}
										else if(s[0].equals("employee")){
											 EmployeControl empControl =new EmployeControl();
										}
								                }
								                else
								                {
								                  JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
								                }
								    }
}		/*String CustomerName = Acct.LogIn();
        if (!CustomerName.equals("")) {
            //System.out.println("successful!");
            //JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
        } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	*/



	/*if (Acct.LogIn())
								                JOptionPane.showMessageDialog(null, "Login Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
								            else
				                JOptionPane.showMessageDialog(null, "Login failed .", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				                */



