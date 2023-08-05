import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
public class BankAccount {
	int balance;
	int previousTransactions;
	String customerName;
	String customerId;


	// Swing implementation

	// set frame
	static JFrame frame = new JFrame();

	// set panel to hold buttons
	static JPanel panel = new JPanel();

	static JLabel label = new JLabel();
	static JRadioButton checkBalance = new JRadioButton("Check Balance");
	static JRadioButton deposit = new JRadioButton("Deposit");
	static JRadioButton withdraw = new JRadioButton("Withdraw");
	static JRadioButton prevTransac = new JRadioButton("Previous Transaction");
	static JButton exit = new JButton("Exit");

	ButtonGroup group = new ButtonGroup();



	
	BankAccount() {
	//	 customerName = name;
	//	 customerId = id;


		// create frame
		frame  = new JFrame("Banking Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);

		// create label for title

		label = new JLabel("Banking Application");

		// create panel to hold buttons
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(label);

		// add buttons to panel
		panel.add(checkBalance);
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(prevTransac);
		panel.add(exit);

		exit.setBounds(40, 50, 60, 60);

		// group buttons together
		group.add(checkBalance);
		group.add(deposit);
		group.add(withdraw);
		group.add(prevTransac);
		group.add(exit);


		// Add an ActionListener to the buttons
		checkBalance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ImageIcon icon = new ImageIcon("money icon.jpeg");

				JOptionPane.showMessageDialog(frame, "Balance = $" + balance);
			}
		});

		deposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(frame, "Enter amount you wish to deposit ");

				if(input != null) {
					try {
						int intValue = Integer.parseInt(input);
						balance += intValue;
						previousTransactions = intValue;

						// Now you have the integer value in intValue
						// You can use it for further calculations or operations
					} catch (NumberFormatException ef) {
						System.out.println("Invalid input. Please enter a valid integer.");
					}
				}
			}
		});

		withdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String amount = JOptionPane.showInputDialog(frame, "Enter amount you wish to withdraw ");

				if(amount != null) {
					try {
						int intValue = Integer.parseInt(amount);
						balance -= intValue;
						previousTransactions = -intValue;

						// Now you have the integer value in intValue
						// You can use it for further calculations or operations
					} catch (NumberFormatException ef) {
						System.out.println("Invalid input. Please enter a valid integer.");
					}
				}
			}
		});


		prevTransac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(previousTransactions > 0) {
					JOptionPane.showMessageDialog(frame, "Deposited $" + previousTransactions);

				} else if(previousTransactions < 0) {
					JOptionPane.showMessageDialog(frame, "Withdrew $" + Math.abs(previousTransactions));

				} else {
					JOptionPane.showMessageDialog(frame, "No Previous Transactions." );

				}

			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Exit the application when the button is clicked
			}
		});



		// add panel to frame
		frame.add(panel);
		frame.setVisible(true);
	}
	
	/*
	 void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransactions = amount;
		}
		
	}
	
	public void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransactions = -amount;
		}
	}
	
	public void previousTransactions() {
		if(previousTransactions > 0) {
			System.out.println("Deposit: " + previousTransactions);
		}
		else if(previousTransactions < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransactions));
		} else {
			System.out.println("No transactions occured");
		}
	}
	
	public void showMenu() {



		char option = '/';
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your id is " + customerId);
		
		System.out.println();
		
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transactions");
		System.out.println("E. Exit");
		
		do {
			
			System.out.println("*************************");
			System.out.println("     Enter an Option     ");
			System.out.println("*************************");
			
			option = input.next().charAt(0);
			System.out.println();
			
			
			switch(option) {
			case 'A':
				System.out.println("Balance = " + balance);
				break;
			case 'B':
				System.out.print("Enter amount you wish to deposit >> ");
				int depAmount = input.nextInt();
				deposit(depAmount);
				System.out.println();
				break;
			case 'C':
				System.out.print("Enter amount you wish to withdraw >> ");
				int withAmount = input.nextInt();
				withdraw(withAmount);
				System.out.println();
				break;
			case 'D':
				previousTransactions();
				System.out.println();
				break;
			case 'E':
				System.out.print("");
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				break;
			}
			
		} while(option != 'E');
		
		System.out.println("Thank you for using our services. Please Come Again");
	}

	 */
	
	
}
