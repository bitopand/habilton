package adms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login lg=new login();
				lg.setVisible(true);
			}
		});
		btnAdmin.setBackground(new Color(169, 169, 169));		btnAdmin.setForeground(new Color(153, 0, 0));
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 45));
		btnAdmin.setBounds(740, 202, 210, 64);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("AIRCRAFT DATA MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 50));
		lblNewLabel.setBounds(466, 42, 1134, 104);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("GUEST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guest_0 ob=new guest_0();
				ob.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(169, 169, 169));
		btnNewButton.setForeground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 45));
		btnNewButton.setBounds(1099, 202, 210, 64);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel_1);
	}
}
