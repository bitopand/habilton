package adms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class disp_version extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disp_version frame = new disp_version();
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
	public disp_version() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(527, 270, 963, 516);
		contentPane.add(scrollPane);
		
		JTable tbf = new JTable();
		scrollPane.setViewportView(tbf);
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
		
		
		
		
			String query4="select * from fversion";
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
		btnBack.setBounds(965, 904, 158, 54);
		contentPane.add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 1902, 15);
		contentPane.add(separator);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setForeground(UIManager.getColor("Button.shadow"));
		lblVersion.setFont(new Font("Georgia", Font.BOLD, 60));
		lblVersion.setBounds(0, 13, 1902, 122);
		contentPane.add(lblVersion);
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel_1);
	}
}
