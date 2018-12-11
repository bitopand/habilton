package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings("serial")
public class login_0 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_0 frame = new login_0();
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
	public login_0() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setFont(new Font("Georgia", Font.BOLD, 50));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login ob=new login();
				ob.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setBounds(539, 92, 270, 71);
		contentPane.add(btnAdmin);
		
		JButton btnGuest = new JButton("GUEST");
		btnGuest.setFont(new Font("Georgia", Font.BOLD, 50));
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guest_0 ob=new guest_0();
				ob.setVisible(true);
				dispose();
			}
		});
		btnGuest.setBounds(1144, 92, 241, 71);
		contentPane.add(btnGuest);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
		
		JLabel lblAircraftDataManagement = new JLabel("AIRCRAFT DATA MANAGEMENT SYSTEM");
		lblAircraftDataManagement.setFont(new Font("Georgia", Font.PLAIN, 30));
		lblAircraftDataManagement.setBounds(256, 64, 804, 95);
		contentPane.add(lblAircraftDataManagement);
	}
}
