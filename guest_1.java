package adms;

import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class guest_1 extends JFrame {

	private JPanel contentPane;

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
	public guest_1(int i) {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 301, 923, 573);
		contentPane.add(scrollPane);
		
		JTable tb = new JTable();
		scrollPane.setViewportView(tb);
		
		
		JComboBox cb = new JComboBox();
		cb.setBounds(1361, 301, 417, 53);
		contentPane.add(cb);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setFont(new Font("Georgia", Font.BOLD, 26));
		btnDisplay.setForeground(new Color(0, 0, 0));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				String name=cb.getSelectedItem().toString();
				
				
				if(name.equals("-select-"))
				{
					
				}
				
				else
				{	
					try
					
					{	int j=0;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
						
						String query="SELECT `vid` FROM `fversion` WHERE version=(?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, name);
						ResultSet rs=ps.executeQuery();
						
						while(rs.next())
						{
							j=rs.getInt("vid");
						}
						
						
						guest_2 ob=new guest_2(j);
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
		btnDisplay.setBounds(1461, 388, 223, 53);
		contentPane.add(btnDisplay);
		
		System.out.println(i);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
		
			
			
			String query4="select name, version,role,note,status from finfo i inner join fversion v on i.fid=v.ffid and ffid=(?)";
			PreparedStatement ps4=con.prepareStatement(query4);
			ps4.setInt(1, i);
			ResultSet rs=ps4.executeQuery();
			tb.setModel(DbUtils.resultSetToTableModel(rs));
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
		
		ArrayList<String> temp1=new ArrayList();
		temp1.add("-select-");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String query="select version from fversion where ffid=(?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				temp1.add(rs.getString("version"));
				
			}
			
			con.close();
			
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "database not linked");
		}
				
		cb.setModel(new DefaultComboBoxModel(temp1.toArray()));
		
		JLabel lblDetailsOfA = new JLabel("DETAILS OF A PARTICULAR AIRCRAFT");
		lblDetailsOfA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailsOfA.setForeground(UIManager.getColor("Button.shadow"));
		lblDetailsOfA.setFont(new Font("Georgia", Font.BOLD, 60));
		lblDetailsOfA.setBounds(0, 37, 1902, 78);
		contentPane.add(lblDetailsOfA);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}

}
