package adms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class addframe extends JFrame {

	private JPanel contentPane;
	private JTextField ti;
	private JTextField tv;
	private JTextField tr;
	private JTextField fid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addframe frame = new addframe();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public addframe() {
		setTitle("AIRCRAFT  DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 104, 1902, 9);
		contentPane.add(separator);
		
		JLabel lblIndianmilitaryAircraft = new JLabel("AIRCRAFT DETAILS");
		lblIndianmilitaryAircraft.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndianmilitaryAircraft.setFont(new Font("Georgia", Font.BOLD, 60));
		lblIndianmilitaryAircraft.setBounds(0, 9, 1902, 82);
		contentPane.add(lblIndianmilitaryAircraft);
		
		JLabel tn = new JLabel("NAME");
		tn.setFont(new Font("Georgia", Font.BOLD, 20));
		tn.setBounds(251, 268, 73, 32);
		contentPane.add(tn);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setFont(new Font("Georgia", Font.BOLD, 20));
		lblRole.setBounds(1086, 268, 136, 33);
		contentPane.add(lblRole);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setFont(new Font("Georgia", Font.BOLD, 20));
		lblVersion.setBounds(229, 375, 127, 35);
		contentPane.add(lblVersion);
		
		JLabel lblNotes = new JLabel("NOTES");
		lblNotes.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNotes.setBounds(229, 566, 105, 46);
		contentPane.add(lblNotes);
		
		tr = new JTextField();
		tr.setBounds(1308, 270, 192, 32);
		contentPane.add(tr);
		tr.setColumns(10);
		
		tv = new JTextField();
		tv.setBounds(490, 378, 192, 32);
		contentPane.add(tv);
		tv.setColumns(10);
		
		JLabel lblManufacturer = new JLabel("MANUFACTURER");
		lblManufacturer.setFont(new Font("Georgia", Font.BOLD, 20));
		lblManufacturer.setBounds(1038, 445, 220, 32);
		contentPane.add(lblManufacturer);
		
		JLabel lblIntroduction = new JLabel("INTRODUCTION");
		lblIntroduction.setFont(new Font("Georgia", Font.BOLD, 20));
		lblIntroduction.setBounds(1038, 357, 192, 32);
		contentPane.add(lblIntroduction);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 20));
		lblStatus.setBounds(1066, 189, 164, 29);
		contentPane.add(lblStatus);
		
		ti = new JTextField();
		ti.setText("dd-mm-yyyy");
		ti.setBounds(1308, 359, 192, 32);
		contentPane.add(ti);
		ti.setColumns(10);
		
		JComboBox cb = new JComboBox();
		cb.setBackground(Color.WHITE);
		cb.setBounds(490, 270, 192, 32);
		//cb.add( "-select-");
		contentPane.add(cb);
		
		JComboBox cb1 = new JComboBox();
		cb1.setBounds(1308, 447, 192, 32);
		contentPane.add(cb1);
		
		TextArea tar = new TextArea();
		tar.setBounds(216, 641, 869, 134);
		contentPane.add(tar);
		
		JComboBox ts = new JComboBox();
		ts.setBackground(Color.WHITE);
		ts.setBounds(1308, 189, 192, 32);
		contentPane.add(ts);
		String[] ob1= {"-select-","ACTIVE","INACTIVE"};
		ts.setModel(new DefaultComboBoxModel(ob1));
		
		
		ArrayList<String> temp=new ArrayList();
		temp.add("-select");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select distinct mname from manufacturer";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				temp.add(rs.getString("mname"));
				
			}
			con.close();
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "database not linked");
		}
		cb1.setModel(new DefaultComboBoxModel(temp.toArray()));
		
		ArrayList<String> temp1=new ArrayList();
		temp1.add("-select-");
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
		
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Georgia", Font.BOLD, 30));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String ver,status,role,notes,name,manuf,intro;
				//int no=Integer.parseInt(no.getText());
				ver=tv.getText().toUpperCase();
				status=ts.getSelectedItem().toString();
				role=tr.getText().toUpperCase();
				intro=ti.getText().toUpperCase();
				notes=tar.getText().toUpperCase();
				name=cb.getSelectedItem().toString().toUpperCase();
				manuf=cb1.getSelectedItem().toString().toUpperCase();
				int ffid=Integer.parseInt(fid.getText());
				
				int i,j;
				i=j=0;
				if(ver.equals(null)|status.equals("-select-")|name.equals("-select-")|manuf.equals("-select-"))
				{
					
				}
				
				
				else
				{
					 try
							{
								Class.forName("com.mysql.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
								
								String query="SELECT `fid` FROM `finfo` WHERE name=(?)";
								PreparedStatement ps=con.prepareStatement(query);
								ps.setString(1, name);
								ResultSet rs=ps.executeQuery();
								
								while(rs.next())
								{
									i=rs.getInt("fid");
								}
								
								String query1="SELECT `mid` FROM `manufacturer` WHERE mname=(?)";
								PreparedStatement ps1=con.prepareStatement(query1);
								ps1.setString(1, manuf);
								ResultSet rs1=ps1.executeQuery();
								
								while(rs1.next())
								{
									j=rs1.getInt("mid");
								}
								int number=1;
								String query2="INSERT INTO `fversion`(`vid`, `version`, `role`, `mmid`, `ffid`, `note`, `status`, `intro`,`number`)"+" VALUES(?,?,?,?,?,?,?,?,?)";
								PreparedStatement ps2=con.prepareStatement(query2);
								ps2.setLong(1, ffid);
								ps2.setString(2, ver);
								ps2.setString(3, role);
								ps2.setInt(4, j);
								ps2.setInt(5, i);
								ps2.setString(6, notes);
								ps2.setString(7, status);
								ps2.setString(8, intro);
								ps2.setInt(9, number);
								
								ps2.execute();
								
								
								System.out.println("data inserted");
								JOptionPane.showMessageDialog(null, "data inserted sucessfully");
								con.close();
							}
							catch(Exception e1)
							{
								System.out.println(e1.getMessage());
							}
						
						addoptn op=new addoptn();
						op.setVisible(true);
						dispose();
						
				}
			
			
			}
			
			
		});
		btnAdd.setBounds(1373, 641, 127, 46);
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
		btnBack.setBounds(1373, 755, 127, 46);
		contentPane.add(btnBack);
		
		fid = new JTextField();
		fid.setBounds(490, 189, 192, 32);
		contentPane.add(fid);
		fid.setColumns(10);
		
		JLabel lblFid = new JLabel("FID");
		lblFid.setFont(new Font("Georgia", Font.BOLD, 20));
		lblFid.setBounds(272, 185, 127, 37);
		contentPane.add(lblFid);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		
		
	}
}
