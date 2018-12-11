package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class mod_fname extends JFrame {

	private JPanel contentPane;
	private JTextField tn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mod_fname frame = new mod_fname();
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
	public mod_fname() {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb = new JComboBox();
		cb.setFont(new Font("Sylfaen", Font.BOLD, 12));
		cb.setBounds(953, 379, 408, 38);
		contentPane.add(cb);
		
		tn = new JTextField();
		tn.setFont(new Font("Sylfaen", Font.BOLD, 12));
		tn.setBounds(953, 471, 408, 38);
		contentPane.add(tn);
		tn.setColumns(10);
		
		JLabel lblAircraftName = new JLabel("AIRCRAFT NAME");
		lblAircraftName.setForeground(UIManager.getColor("Button.shadow"));
		lblAircraftName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblAircraftName.setBounds(468, 371, 299, 46);
		contentPane.add(lblAircraftName);
		
		JLabel lblModifiedName = new JLabel("MODIFIED NAME");
		lblModifiedName.setForeground(UIManager.getColor("Button.shadow"));
		lblModifiedName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblModifiedName.setBounds(479, 471, 319, 38);
		contentPane.add(lblModifiedName);
		
		ArrayList<String> temp1=new ArrayList();
		temp1.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select name from finfo";
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
		
		JButton btnUpdate = new JButton("UPDATE\r\n");
		btnUpdate.setFont(new Font("Georgia", Font.BOLD, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String name = cb.getSelectedItem().toString();
				String name1=tn.getText();
				
				try
				{	int i=0;
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
					
					
					String query2="UPDATE `finfo` SET `name`=(?) WHERE fid = (?)";
							
					PreparedStatement ps2=con.prepareStatement(query2);
					ps2.setString(1, name1);
					ps2.setInt(2,i);
					ps2.execute();
					
					JOptionPane.showMessageDialog(null, "Aircraft name modified");
					con.close();
					
				}
				catch(Exception e2)
				{
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(null, "Aircraft name not modified");
				}
				modoptn ob=new modoptn();
				ob.setVisible(true);
				dispose();
				
				
			}
		});
		btnUpdate.setBounds(890, 677, 195, 78);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE AIRCRAFT");
		lblNewLabel_1.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel_1.setBounds(0, 13, 1902, 107);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 145, 1902, 13);
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
		btnBack.setBounds(890, 850, 195, 60);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}
}
