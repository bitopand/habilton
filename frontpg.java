package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class frontpg {

	private JFrame frmAircraftDataManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontpg window = new frontpg();
					window.frmAircraftDataManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frontpg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAircraftDataManagement = new JFrame();
		frmAircraftDataManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		frmAircraftDataManagement.setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		frmAircraftDataManagement.getContentPane().setBackground(new Color(245, 245, 220));
		frmAircraftDataManagement.setBounds(100, 100, 1920, 1080);
		frmAircraftDataManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAircraftDataManagement.getContentPane().setLayout(null);
		
		Button button = new Button("START");
		button.setForeground(UIManager.getColor("Button.highlight"));
		button.setBackground(UIManager.getColor("Button.shadow"));
		button.setFont(new Font("Cambria", Font.BOLD, 38));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage ob=new homepage();
				ob.setVisible(true);
				frmAircraftDataManagement.dispose();
			}
		});
		button.setBounds(870, 676, 211, 72);
		frmAircraftDataManagement.getContentPane().add(button);
		
		JLabel lblDbmsProject = new JLabel("DATABASE MANAGEMENT SYSTEM ");
		lblDbmsProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblDbmsProject.setForeground(SystemColor.inactiveCaptionBorder);
		lblDbmsProject.setFont(new Font("Felix Titling", Font.BOLD, 60));
		lblDbmsProject.setBounds(24, 161, 1902, 105);
		frmAircraftDataManagement.getContentPane().add(lblDbmsProject);
		
		JLabel lblA = new JLabel("A MINI PROJECT ON ");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setForeground(SystemColor.textHighlightText);
		lblA.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblA.setBounds(-12, 98, 1902, 83);
		frmAircraftDataManagement.getContentPane().add(lblA);
		
		JLabel lblNewLabel_2 = new JLabel("AIRCRAFT DATA MANAGEMENT SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 72));
		lblNewLabel_2.setBounds(0, 291, 1926, 310);
		frmAircraftDataManagement.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(SystemColor.textText);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\562f9979bd5ef3b87175609fcebef393.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);

		frmAircraftDataManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblAircraftDataManagement = new JLabel("AIRCRAFT DATA MANAGEMENT SYSTEM");
		lblAircraftDataManagement.setForeground(Color.GRAY);
		lblAircraftDataManagement.setFont(new Font("Georgia", Font.BOLD, 25));
		lblAircraftDataManagement.setBounds(262, 161, 795, 49);
		frmAircraftDataManagement.getContentPane().add(lblAircraftDataManagement);
		
		JLabel lblAircraftDataManagement_1 = new JLabel("AIRCRAFT DATA MANAGEMENT SYSTEM");
		lblAircraftDataManagement_1.setBounds(680, 181, 56, 16);
		frmAircraftDataManagement.getContentPane().add(lblAircraftDataManagement_1);
	}
}
