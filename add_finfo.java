package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class add_finfo extends JFrame {

	private JPanel contentPane;
	private JTextField tn;
	private JTextField xc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_finfo frame = new add_finfo();
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
	public add_finfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT  DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		xc = new JTextField();
		xc.setBounds(1018, 131, 291, 35);
		contentPane.add(xc);
		xc.setColumns(10);
		
		tn = new JTextField();
		tn.setBounds(1018, 233, 291, 35);
		contentPane.add(tn);
		tn.setColumns(10);
		
		JLabel lblFlightName = new JLabel("FLIGHT NAME");
		lblFlightName.setForeground(new Color(255, 0, 102));
		lblFlightName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblFlightName.setBounds(594, 229, 264, 30);
		contentPane.add(lblFlightName);
		
		JComboBox mc = new JComboBox();
		mc.setBounds(1018, 327, 291, 35);
		contentPane.add(mc);
		
		JComboBox ccc = new JComboBox();
		ccc.setBounds(1018, 445, 291, 35);
		contentPane.add(ccc);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setForeground(new Color(255, 0, 102));
		lblCountry.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCountry.setBounds(594, 340, 214, 30);
		contentPane.add(lblCountry);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setForeground(new Color(255, 0, 102));
		lblClass.setFont(new Font("Georgia", Font.BOLD, 30));
		lblClass.setBounds(594, 458, 128, 40);
		contentPane.add(lblClass);
		
		ArrayList<String> temp=new ArrayList();
		temp.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select  distinct cname from country order by cname";
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
		mc.setModel(new DefaultComboBoxModel(temp.toArray()));
		
		ArrayList<String> temp1=new ArrayList();
		temp1.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select distinct fclass from class order by fclass";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				temp1.add(rs.getString("fclass"));
				
			}
			con.close();
			
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "database not linked");
		}
		ccc.setModel(new DefaultComboBoxModel(temp1.toArray()));
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Georgia", Font.BOLD, 20));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int fid=Integer.parseInt(xc.getText());
				String name=tn.getText();
				String manu=mc.getSelectedItem().toString().toUpperCase();
				String cls=ccc.getSelectedItem().toString().toUpperCase();
				int i = 0,j = 0;
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
					
				
					
				    String query="SELECT `fcid` FROM `class` WHERE fclass=(?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, cls);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						i=rs.getInt("fcid");
					}
					System.out.println(i);
					String query1="SELECT `cid` FROM `country` WHERE cname=(?)";
					PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1, manu);
					ResultSet rs1=ps1.executeQuery();
					
					while(rs1.next())
					{
						j=rs1.getInt("cid");
					}
					System.out.println(j);
					String query2=("INSERT INTO `finfo`(`fid`, `name`, `cnid`, `fclid`)"+"values(?,?,?,?)");
					PreparedStatement ps2=con.prepareStatement(query2);
					
					ps2.setLong(1,fid);
					ps2.setString(2 ,name.toUpperCase());
					
					if(j!=0)ps2.setInt(3, j);
					if(i!=0)ps2.setInt(4, i);
					
					ps2.execute();
				
					
					
					
					JOptionPane.showMessageDialog(null, "data inserted sucessfully");
					con.close();
				}
				catch(Exception e2)
				{
					System.out.println(+i+""+j+""+manu+""+cls);
					JOptionPane.showMessageDialog(null, "data insertion unsucessfull or"+e2.getMessage());
				}
				addoptn op=new addoptn();
				op.setVisible(true);
				dispose();
				
				
			}
		});
		btnSubmit.setBounds(1298, 818, 141, 56);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addoptn ob=new addoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(548, 818, 138, 56);
		contentPane.add(btnBack);
		
		JLabel lblFlightId = new JLabel("FLIGHT ID");
		lblFlightId.setForeground(new Color(255, 0, 102));
		lblFlightId.setFont(new Font("Georgia", Font.BOLD, 30));
		lblFlightId.setBounds(594, 125, 214, 34);
		contentPane.add(lblFlightId);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}
}
