package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class fdisplay extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	private JLabel lblDetailsOfAll;
	private JLabel lblNewLabel;
	private final JSeparator separator = new JSeparator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fdisplay frame = new fdisplay();
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
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public fdisplay() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 275, 919, 583);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
		
			
			
			String query4="CALL `fulldetail`()";
			PreparedStatement ps4=con.prepareStatement(query4);
		
			ResultSet rs=ps4.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
		
		cb = new JComboBox();
		cb.setBounds(1437, 387, 287, 38);
		contentPane.add(cb);
		
		
		
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
		
		
		
		
		
		
		JLabel lblSearchByName = new JLabel("Search by name for more details:");
		lblSearchByName.setForeground(UIManager.getColor("Button.shadow"));
		lblSearchByName.setFont(new Font("Georgia", Font.BOLD, 22));
		lblSearchByName.setBounds(1383, 285, 385, 38);
		contentPane.add(lblSearchByName);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Georgia", Font.BOLD, 26));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String name=cb.getSelectedItem().toString();
				
				
				if(name.equals("-select-"))
				{
					
				}
				
				else
				{	
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
						
						System.out.println(i);
						serchdiplay ob=new serchdiplay(i);
						ob.setVisible(true);
						dispose();
						
						
						
						
						con.close();
						
					}
					catch(Exception e2)
					{
						System.out.println(e2.getMessage());
					}
				}
				
				
			}
		});
		btnSearch.setBounds(1505, 493, 186, 38);
		contentPane.add(btnSearch);
		
		lblDetailsOfAll = new JLabel("DETAILS OF ALL AIRCRAFTS");
		lblDetailsOfAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailsOfAll.setForeground(UIManager.getColor("Button.shadow"));
		lblDetailsOfAll.setFont(new Font("Georgia", Font.BOLD, 60));
		lblDetailsOfAll.setBounds(0, 13, 1902, 110);
		contentPane.add(lblDetailsOfAll);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 28));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispoptn ob=new dispoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(1526, 615, 136, 51);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		separator.setBounds(0, 162, 1902, 14);
		contentPane.add(separator);
		
		
		
		
		
	}
}
