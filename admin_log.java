package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class admin_log extends JFrame {

	private JPanel contentPane;
	private JTable tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_log frame = new admin_log();
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
	public admin_log() {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminoptn ob=new adminoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(804, 768, 282, 68);
		contentPane.add(btnBack);
		
		JLabel lblAdminLog = new JLabel("ADMIN LOG");
		lblAdminLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLog.setForeground(UIManager.getColor("RadioButton.shadow"));
		lblAdminLog.setFont(new Font("Georgia", Font.BOLD, 60));
		lblAdminLog.setBounds(0, 18, 1902, 54);
		contentPane.add(lblAdminLog);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 149, 1902, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(503, 295, 911, 337);
		contentPane.add(scrollPane);
		
		tb = new JTable();
		scrollPane.setViewportView(tb);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
		
		
		
		
			String query4="select * from admin_log";
			PreparedStatement ps4=con.prepareStatement(query4);
		
			ResultSet rs=ps4.executeQuery();
			tb.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
			lblNewLabel.setBounds(0, 0, 1902, 1033);
			contentPane.add(lblNewLabel);
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
	}
}
