package adms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JSplitPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class disp_man extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disp_man frame = new disp_man();
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
	public disp_man() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(569, 404, 866, 350);
		contentPane.add(scrollPane);
		
		JTable tbf = new JTable();
		scrollPane.setViewportView(tbf);
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
		
		
		
		
			String query4="select mid as 'manufacturer_id',mname as 'manufacturer_name' from manufacturer";
			PreparedStatement ps4=con.prepareStatement(query4);
		
			ResultSet rs=ps4.executeQuery();
			tbf.setModel(DbUtils.resultSetToTableModel(rs));
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 30));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispoptn ob=new dispoptn();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(958, 878, 212, 75);
		contentPane.add(btnBack);
		
		JLabel lblCountryNames = new JLabel("MANUFACTURERS");
		lblCountryNames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryNames.setForeground(UIManager.getColor("Button.shadow"));
		lblCountryNames.setFont(new Font("Georgia", Font.BOLD, 60));
		lblCountryNames.setBounds(0, 13, 1902, 117);
		contentPane.add(lblCountryNames);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 143, 1902, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}
}
