package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class adminoptn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminoptn frame = new adminoptn();
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
	public adminoptn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT  SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(UIManager.getColor("TextArea.selectionBackground"));
		btnAdd.setBackground(SystemColor.textText);
		btnAdd.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addoptn ob=new addoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnAdd.setBounds(565, 115, 291, 68);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(UIManager.getColor("TextArea.selectionBackground"));
		btnUpdate.setBackground(SystemColor.textText);
		btnUpdate.setFont(new Font("Georgia", Font.BOLD, 40));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					modoptn ob=new modoptn();
					ob.setVisible(true);
					dispose();
				
			}
		});
		btnUpdate.setBounds(1418, 115, 291, 68);
		contentPane.add(btnUpdate);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setForeground(UIManager.getColor("TextArea.selectionBackground"));
		btnDisplay.setBackground(SystemColor.textText);
		btnDisplay.setFont(new Font("Georgia", Font.BOLD, 40));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispoptn ob=new dispoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnDisplay.setBounds(1001, 115, 291, 68);
		contentPane.add(btnDisplay);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.setForeground(UIManager.getColor("TextArea.selectionBackground"));
		btnLogOut.setBackground(SystemColor.textText);
		btnLogOut.setFont(new Font("Georgia", Font.BOLD, 40));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_0 ob=new login_0();
				ob.setVisible(true);
				
				dispose();
			}
		});
		btnLogOut.setBounds(794, 302, 291, 74);
		contentPane.add(btnLogOut);
		
		JButton btnLogs = new JButton("LOGS");
		btnLogs.setForeground(UIManager.getColor("TextArea.selectionBackground"));
		btnLogs.setBackground(SystemColor.textText);
		btnLogs.setFont(new Font("Georgia", Font.BOLD, 40));
		btnLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_log ob=new admin_log();
				ob.setVisible(true);
				dispose();
						
			}
		});
		btnLogs.setBounds(1197, 305, 291, 68);
		contentPane.add(btnLogs);
		
		JLabel lblNewLabel = new JLabel("   ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\image-45949018-white-hd-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}

}
