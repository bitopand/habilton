package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class add_country extends JFrame {

	private JPanel contentPane;
	private JTextField tc;
	private JTextField cid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_country frame = new add_country();
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
	public add_country() {
		setForeground(UIManager.getColor("CheckBox.foreground"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCountryName = new JLabel("COUNTRY NAME");
		lblCountryName.setForeground(UIManager.getColor("Button.shadow"));
		lblCountryName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCountryName.setBounds(542, 434, 314, 35);
		contentPane.add(lblCountryName);
		
		tc = new JTextField();
		tc.setForeground(UIManager.getColor("Button.foreground"));
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tc.setBounds(979, 434, 405, 41);
		contentPane.add(tc);
		tc.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Georgia", Font.BOLD, 30));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String country=tc.getText();
				int ciid=Integer.parseInt(cid.getText());
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
				
					String query="INSERT INTO `country`(`CID`, `CNAME`)"+" VALUES (?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setLong(1, ciid);
					ps.setString(2, country.toUpperCase());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "data inserted sucessfully");
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "data insertion unsucessfull");
				}
				addoptn op=new addoptn();
				op.setVisible(true);
				dispose();
				
			}
		});
		btnAdd.setBounds(1080, 656, 137, 60);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 30));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addoptn ob=new addoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(688, 656, 137, 60);
		contentPane.add(btnBack);
		
		JLabel lblCid = new JLabel("CID");
		lblCid.setForeground(UIManager.getColor("Button.shadow"));
		lblCid.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCid.setBounds(650, 248, 101, 41);
		contentPane.add(lblCid);
		
		cid = new JTextField();
		cid.setForeground(UIManager.getColor("Button.foreground"));
		cid.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		cid.setBounds(979, 251, 405, 41);
		contentPane.add(cid);
		cid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}
}
