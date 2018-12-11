package adms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

@SuppressWarnings("serial")
public class add_class extends JFrame {

	private JPanel contentPane;
	private JTextField cid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_class frame = new add_class();
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
	public add_class() {
		setFont(new Font("Georgia", Font.ITALIC, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassId = new JLabel("CLASS ID");
		lblClassId.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblClassId.setForeground(Color.WHITE);
		lblClassId.setBounds(590, 309, 218, 50);
		contentPane.add(lblClassId);
		
		cid = new JTextField();
		cid.setFont(new Font("Tahoma", Font.BOLD, 25));
		cid.setBackground(Color.GRAY);
		cid.setForeground(Color.BLACK);
		cid.setBounds(965, 309, 383, 50);
		contentPane.add(cid);
		cid.setColumns(10);
		
		JLabel lblCountryName = new JLabel("CLASS NAME");
		lblCountryName.setForeground(SystemColor.control);
		lblCountryName.setFont(new Font("Constantia", Font.BOLD, 40));
		lblCountryName.setBounds(579, 447, 271, 50);
		contentPane.add(lblCountryName);
		
		JTextField tc = new JTextField();
		tc.setForeground(Color.WHITE);
		tc.setBackground(SystemColor.controlShadow);
		tc.setFont(new Font("Times New Roman", Font.BOLD, 25));
		tc.setBounds(965, 437, 383, 54);
		contentPane.add(tc);
		tc.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(SystemColor.controlShadow);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String clas=tc.getText();
				String a=cid.getText();
				int ciid=Integer.parseInt(a);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
				
					String query="INSERT INTO `class`(`fcid`, `fclass`)"+" VALUES (?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setLong(1, ciid);
					ps.setString(2, clas.toUpperCase());
					
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
		btnAdd.setBounds(1024, 766, 160, 50);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(SystemColor.controlShadow);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addoptn ob=new addoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(690, 766, 160, 50);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBackground(SystemColor.controlShadow);
		label.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		label.setBounds(0, 0, 1902, 1033);
		contentPane.add(label);
	}

}
