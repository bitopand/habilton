package adms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;



@SuppressWarnings("serial")
public class login extends JFrame {

	
	private JPanel contentPane;
	private JTextField tu;
	private JPasswordField tp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT MANAGMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Georgia", Font.BOLD, 40));
		lblUserName.setBounds(645, 354, 277, 57);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD\r\n");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 40));
		lblPassword.setBounds(646, 471, 298, 72);
		contentPane.add(lblPassword);
		
		tu = new JTextField();
		tu.setFont(new Font("Tahoma", Font.BOLD, 25));
		tu.setBounds(1036, 353, 342, 38);
		contentPane.add(tu);
		tu.setColumns(10);
		
		tp = new JPasswordField();
		tp.setFont(new Font("Tahoma", Font.BOLD, 25));
		tp.setBounds(1036, 493, 342, 38);
		contentPane.add(tp);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Georgia", Font.BOLD, 30));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				String name,paswd;
				name=tu.getText();
				paswd=tp.getText();
				
				
				
				
				try
				{
					
					
					
					
					
				    if( paswd.equals("1234") && name.equals("admin"))
					{
						
						JOptionPane.showMessageDialog(null, "login admin sucessfull");
						adminoptn op=new adminoptn();
						op.setVisible(true);
						dispose();
						
					}
				    else
					{
						JOptionPane.showMessageDialog(null, "login unsucessfull");
					}
				    
					
				   
					
					
					

				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
				
				
				
				
			
				
				
					
			} 
		});
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel_1.setBounds(0, 27, 1902, 114);
		contentPane.add(lblNewLabel_1);
		btnLogin.setBounds(984, 777, 157, 57);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 30));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_0 ob=new login_0();
				ob.setVisible(true);
				dispose();			}
		});
		btnBack.setBounds(984, 870, 157, 57);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}

}
