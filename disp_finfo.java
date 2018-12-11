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
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class disp_finfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disp_finfo frame = new disp_finfo();
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
	public disp_finfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(544, 335, 896, 436);
		contentPane.add(scrollPane);
		
		JTable tbf = new JTable();
		scrollPane.setViewportView(tbf);
		
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
		
		
		
		
			String query4="CALL `getall`()";
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
		btnBack.setForeground(UIManager.getColor("Button.shadow"));
		btnBack.setFont(new Font("Georgia", Font.BOLD, 35));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispoptn ob=new dispoptn();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(931, 871, 170, 67);
		contentPane.add(btnBack);
		
		JLabel lblCountryNames = new JLabel("AIRCRAFTS");
		lblCountryNames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryNames.setForeground(UIManager.getColor("Button.shadow"));
		lblCountryNames.setBackground(UIManager.getColor("Button.light"));
		lblCountryNames.setFont(new Font("Georgia", Font.BOLD, 60));
		lblCountryNames.setBounds(0, 13, 1902, 139);
		contentPane.add(lblCountryNames);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 165, 1892, 15);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(UIManager.getColor("Button.shadow"));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}

}
