package adms;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class mod_ver extends JFrame {

	private JPanel contentPane;
	private JTextField tv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mod_ver frame = new mod_ver();
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
	public mod_ver() {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb = new JComboBox();
		cb.setFont(new Font("Sylfaen", Font.BOLD, 12));
		cb.setBounds(982, 210, 433, 35);
		contentPane.add(cb);
		
		JComboBox cb1 = new JComboBox();
		cb1.setFont(new Font("Sylfaen", Font.BOLD, 12));
		cb1.setBounds(982, 360, 433, 38);
		contentPane.add(cb1);
		
		JComboBox cs = new JComboBox();
		cs.setFont(new Font("Sylfaen", Font.BOLD, 12));
		cs.setBounds(982, 540, 426, 35);
		contentPane.add(cs);
		
		tv = new JTextField();
		tv.setFont(new Font("Sylfaen", Font.BOLD, 12));
		tv.setBounds(982, 454, 426, 35);
		contentPane.add(tv);
		tv.setColumns(10);
		
		ArrayList<String> temp1=new ArrayList();
		ArrayList<String> temp2=new ArrayList();
		temp1.add("-select-");
		temp2.add("-select-");
		String[] ob1= {"-select-","ACTIVE","INACTIVE"};
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select distinct name from finfo";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				temp1.add(rs.getString("name"));
				
			}
			
			
			con.close();
			
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "database not linked");
		}
		cb.setModel(new DefaultComboBoxModel(temp1.toArray()));
		
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String ver = cb1.getSelectedItem().toString();
				String ver1=tv.getText();
				String status=cs.getSelectedItem().toString();
				
				try
				{	int i=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
					
					
					
					String query3="SELECT `vid` FROM `fversion` WHERE version=(?) ";
					PreparedStatement ps3=con.prepareStatement(query3);
					ps3.setString(1, ver);
					
					ResultSet rs3=ps3.executeQuery();
					
					while(rs3.next())
					{
						i=rs3.getInt("vid");
					}
					
					
					
					
					String query4="UPDATE `fversion` SET `version`=(?),`status`=(?) WHERE vid=(?)";
				
					PreparedStatement ps4=con.prepareStatement(query4);
					ps4.setString(1, ver1);
					ps4.setString(2, status);
					ps4.setInt(3,i);
				
					ps4.execute();
					
					JOptionPane.showMessageDialog(null, "Aircraft version modified");
					con.close();
					
				}
				catch(Exception e2)
				{
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(null, "Aircraft version not modified");
				}
				modoptn ob=new modoptn();
				ob.setVisible(true);
				dispose();
				

			}
		});
		btnNewButton.setBounds(982, 747, 175, 45);
		contentPane.add(btnNewButton);
		
		JButton btnFetchVersion = new JButton("FETCH VERSION");
		btnFetchVersion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFetchVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String ab=cb.getSelectedItem().toString();
				ArrayList<String> temp2=new ArrayList();
				
				temp2.add("-select-");
				try
				{	
					int i=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
					
					String query="SELECT `fid` FROM `finfo` WHERE name=(?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, ab);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						i=rs.getInt("fid");
					}
					String query5="select distinct version from fversion where ffid = (?)";
					PreparedStatement ps5=con.prepareStatement(query5);
					ps5.setInt(1,i);
					ResultSet rs5=ps5.executeQuery();
					
					while(rs5.next())
					{
						temp2.add(rs5.getString("version"));
						
					}
					
					con.close();
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "database not linked");
				}
				
				cb1.setModel(new DefaultComboBoxModel(temp2.toArray()));
				cs.setModel(new DefaultComboBoxModel(ob1));
				
			}
		});
		btnFetchVersion.setBounds(1197, 277, 221, 38);
		contentPane.add(btnFetchVersion);
		
		JLabel lblAirCraft = new JLabel("AIRCRAFT");
		lblAirCraft.setForeground(new Color(255, 0, 102));
		lblAirCraft.setFont(new Font("Georgia", Font.BOLD, 25));
		lblAirCraft.setBounds(583, 202, 175, 38);
		contentPane.add(lblAirCraft);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setForeground(new Color(255, 0, 102));
		lblVersion.setFont(new Font("Georgia", Font.BOLD, 25));
		lblVersion.setBounds(620, 359, 196, 29);
		contentPane.add(lblVersion);
		
		JLabel lblNewName = new JLabel("MODIFY VERSION NAME");
		lblNewName.setForeground(new Color(255, 0, 102));
		lblNewName.setFont(new Font("Georgia", Font.BOLD, 25));
		lblNewName.setBounds(520, 434, 342, 62);
		contentPane.add(lblNewName);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setForeground(new Color(255, 0, 102));
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 25));
		lblStatus.setBounds(643, 540, 148, 45);
		contentPane.add(lblStatus);
		
		JLabel lblUpdateAircraftVersion = new JLabel("UPDATE AIRCRAFT VERSION");
		lblUpdateAircraftVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateAircraftVersion.setForeground(UIManager.getColor("Button.shadow"));
		lblUpdateAircraftVersion.setFont(new Font("Georgia", Font.BOLD, 60));
		lblUpdateAircraftVersion.setBounds(0, 13, 1902, 102);
		contentPane.add(lblUpdateAircraftVersion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 128, 1878, 9);
		contentPane.add(separator);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modoptn ob=new modoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(982, 844, 175, 45);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("   ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		
		
	}

}
