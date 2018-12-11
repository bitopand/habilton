package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class dis_country extends JFrame {

	private JPanel contentPane;
	private JTable tbf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dis_country frame = new dis_country();
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
	public dis_country() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 394, 1016, 294);
		contentPane.add(scrollPane);
		
		tbf = new JTable();
		scrollPane.setViewportView(tbf);
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
		
		
		
		
			String query4="select * from country";
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
		btnBack.setFont(new Font("Georgia", Font.BOLD, 40));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispoptn ob=new dispoptn();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(887, 843, 203, 64);
		contentPane.add(btnBack);
		
		JLabel lblCountryNames = new JLabel("COUNTRY NAMES");
		lblCountryNames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryNames.setForeground(UIManager.getColor("RadioButton.shadow"));
		lblCountryNames.setFont(new Font("Georgia", Font.BOLD, 60));
		lblCountryNames.setBounds(0, 20, 1902, 113);
		contentPane.add(lblCountryNames);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 146, 1902, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}
}
