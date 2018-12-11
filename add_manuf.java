package adms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class add_manuf extends JFrame {

	private JPanel contentPane;
	private JTextField mid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_manuf frame = new add_manuf();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public add_manuf() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCountryName = new JLabel("MANUFACTURER NAME");
		lblCountryName.setForeground(new Color(255, 0, 102));
		lblCountryName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCountryName.setBounds(470, 262, 393, 36);
		contentPane.add(lblCountryName);
		
		JTextField tc = new JTextField();
		tc.setBounds(977, 268, 348, 36);
		contentPane.add(tc);
		tc.setColumns(10);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(977, 400, 348, 36);
		contentPane.add(cb);
		
		ArrayList<String> temp=new ArrayList();
		temp.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select DISTINCT cname from country ORDER BY CNAME";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				temp.add(rs.getString("cname"));
				
			}
			con.close();
			
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "database not linked");
		}
		cb.setModel(new DefaultComboBoxModel(temp.toArray()));
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Georgia", Font.BOLD, 30));
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	int i = 0;
				String country=tc.getText();
				String manu=cb.getSelectedItem().toString();
				int miid=Integer.parseInt(mid.getText());
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
					
				    String query="SELECT `cid` FROM `country` WHERE cname=(?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, manu);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						i=rs.getInt(1);
					}
					
					String query1="INSERT INTO `manufacturer`(`mid`, `mname`, `cnid`)"+" VALUES (?,?,?)";
					PreparedStatement ps1=con.prepareStatement(query1);
					
					ps1.setLong(1,miid);
					ps1.setString(2,country);
					if(i!=0)ps1.setInt(3,i);
					
					ps1.execute();
				
				
					
					
					
					JOptionPane.showMessageDialog(null, "data inserted sucessfully");
					con.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "data insertion unsucessfull");
				}
				
				addoptn op=new addoptn();
				op.setVisible(true);
				dispose();
				
				
			}
			
			
			
			
		});
		btnAdd.setBounds(1231, 713, 158, 58);
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
		btnBack.setBounds(491, 713, 158, 58);
		contentPane.add(btnBack);
		
		
		JLabel lblCountry = new JLabel("COUNTRY\r\n");
		lblCountry.setForeground(new Color(255, 0, 102));
		lblCountry.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCountry.setBounds(548, 388, 256, 69);
		contentPane.add(lblCountry);
		
		mid = new JTextField();
		mid.setBounds(977, 148, 348, 36);
		contentPane.add(mid);
		mid.setColumns(10);
		
		JLabel lblMid = new JLabel("MID");
		lblMid.setForeground(new Color(255, 0, 102));
		lblMid.setFont(new Font("Georgia", Font.BOLD, 30));
		lblMid.setBounds(591, 139, 135, 42);
		contentPane.add(lblMid);
		
		JLabel lblNewLabel = new JLabel("     ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		
	}
}
