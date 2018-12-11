package adms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class guest_0 extends JFrame {


	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	private JLabel lblDetailsOfAll;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guest_0 frame = new guest_0();
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
	public guest_0() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 323, 967, 441);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
		
			
			
			String query4="select name, version,role,note,status from finfo i inner join fversion v on i.fid=v.ffid order by name";
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
		cb.setBounds(1402, 383, 335, 33);
		contentPane.add(cb);
		
		
		
		ArrayList<String> temp1=new ArrayList();
		temp1.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select distinct name from finfo order by name";
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
		
		
		
		
		
		
		JLabel lblSearchByName = new JLabel("SEARCH BY NAME FOR MORE DETAILS");
		lblSearchByName.setForeground(UIManager.getColor("Button.shadow"));
		lblSearchByName.setFont(new Font("Georgia", Font.BOLD, 20));
		lblSearchByName.setBounds(1357, 308, 434, 44);
		contentPane.add(lblSearchByName);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Georgia", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String name=cb.getSelectedItem().toString();
				
				
				System.out.println(name);
				
				
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
					
					
					guest_1 ob=new guest_1(i);
					ob.setVisible(true);
					dispose();
					
					
					
					
					con.close();
					
				}
				catch(Exception e2)
				{
					System.out.println(e2.getMessage());
				}
				
				
				
			}
		});
		btnSearch.setBounds(1504, 446, 142, 44);
		contentPane.add(btnSearch);
		
		lblDetailsOfAll = new JLabel("DETAILS OF ALL AIRCRAFTS");
		lblDetailsOfAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailsOfAll.setForeground(UIManager.getColor("Button.shadow"));
		lblDetailsOfAll.setFont(new Font("Georgia", Font.BOLD, 60));
		lblDetailsOfAll.setBounds(0, 13, 1902, 118);
		contentPane.add(lblDetailsOfAll);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_0 ob=new login_0();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(1515, 532, 112, 44);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(0, 170, 1902, 12);
		contentPane.add(separator);
		
		
		
		
	}
}
