/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import FDU.STUDENT.NALABOTHULA.*;

class SignUpPanel extends JPanel implements ActionListener
{
    private JButton RegisterButton;
    private JTextField UsernameField, NameField, EmailField, AddField, PhoneField, EmployeField;
    private JPasswordField PasswordField, PasswordField1;
    private String UName, PsWord, PsWord1, Name, Email1, Add, Phone, EmpID;
    private Account Acct;
private Customer Cust;
private Employe Emp;


    public SignUpPanel()
    {
        RegisterButton = new JButton("Register"); //initializing two button references

        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        PasswordField1 = new JPasswordField(15);
        NameField = new JTextField(15);
        EmailField = new JTextField(15);
        AddField = new JTextField(15);
        PhoneField = new JTextField(15);
        EmployeField = new JTextField(15);


        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel PasswordLabel1 = new JLabel("Re-enter Password");
        JLabel NameLabel = new JLabel("Name");
        JLabel EmailLabel = new JLabel("Email");
        JLabel AddLabel = new JLabel("Address");
        JLabel PhoneLabel = new JLabel("Phone");
        JLabel EmployeLabel = new JLabel("Employe_ID");

        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel PasswordPanel1 = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel EmailPanel = new JPanel();
        JPanel AddPanel = new JPanel();
        JPanel PhonePanel = new JPanel();
        JPanel EmployePanel = new JPanel();

        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        PasswordPanel1.add(PasswordLabel1);
        PasswordPanel1.add(PasswordField1);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        EmailPanel.add(EmailLabel);
        EmailPanel.add(EmailField);
        AddPanel.add(AddLabel);
        AddPanel.add(AddField);
        PhonePanel.add(PhoneLabel);
        PhonePanel.add(PhoneField);
        EmployePanel.add(EmployeLabel);
        EmployePanel.add(EmployeField);

        add(UsernamePanel);
        add(PasswordPanel);
        add(PasswordPanel1);
        add(NamePanel);
        add(EmailPanel);
        add(AddPanel);
        add(PhonePanel);
        add(EmployePanel);

        add(RegisterButton);  //add the two buttons on to this panel
        RegisterButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Register")) { //determine which button is clicked
            UName = UsernameField.getText(); //take actions
            PsWord =PasswordField.getText();
            PsWord1 = PasswordField1.getText();
            Name = NameField.getText();
            Email1 = EmailField.getText();
            Add = AddField.getText();
            Phone = PhoneField.getText();
            EmpID = EmployeField.getText();
		if(EmpID.equals("")){
							String N = "NULL";
							  Acct = new Account(UName, PsWord, PsWord1, Name, EmpID, Email1 );
            					Cust = new Customer(UName,PsWord, PsWord1,Name, Email1, Add, Phone);
							if (Acct.signUp()) //Cust.signUp() &&
							                JOptionPane.showMessageDialog(null, "Account has been created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
							            else
			                JOptionPane.showMessageDialog(null, "Account creation failed .", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						}
		else if(!(EmpID.equals(""))){
							Acct = new Account(UName, PsWord, PsWord1, Name, EmpID, Email1 );
							Emp = new Employe(EmpID, PsWord, PsWord1, Name, Email1, Phone);
							if (Acct.signUp()) //Emp.signUp() &&
							                JOptionPane.showMessageDialog(null, "Created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
							            else
			                JOptionPane.showMessageDialog(null, "Creation failed ", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}


    }
}
/*
    public String getUsername() {
		return UName;
	};

	public String getPassword() {
	    return PsWord;
	}

	public String getPassword1() {
	    return PsWord1;
	}*/
}

public class SignUpBO extends JFrame
{
    private SignUpPanel SU_Panel;

    public SignUpBO()
    {
        setTitle("Sign Up");
        setSize(330, 360);

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
         SU_Panel = new SignUpPanel();
         contentPane.add(SU_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new SignUpBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

