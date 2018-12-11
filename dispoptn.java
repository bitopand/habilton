package adms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class dispoptn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dispoptn frame = new dispoptn();
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
	public dispoptn() {
		setTitle("AIRCRAFT  DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCountry = new JButton("COUNTRY");
		btnCountry.setFont(new Font("Georgia", Font.BOLD, 40));
		btnCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dis_country ob=new dis_country();
				ob.setVisible(true);
				dispose();
			}
		});
		btnCountry.setBounds(377, 85, 272, 55);
		contentPane.add(btnCountry);
		
		JButton btnClass = new JButton("CLASS");
		btnClass.setFont(new Font("Georgia", Font.BOLD, 40));
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disp_class ob=new disp_class();
				ob.setVisible(true);
				dispose();
			}
		});
		btnClass.setBounds(1626, 85, 250, 55);
		contentPane.add(btnClass);
		
		JButton btnManufacturer = new JButton("MANUFACTURER");
		btnManufacturer.setFont(new Font("Georgia", Font.BOLD, 40));
		btnManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disp_man ob=new disp_man();
				ob.setVisible(true);
				dispose();
			}
		});
		btnManufacturer.setBounds(1102, 85, 430, 55);
		contentPane.add(btnManufacturer);
		
		JButton btnAirCraft = new JButton("AIRCRAFT");
		btnAirCraft.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAirCraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disp_finfo ob=new disp_finfo();
				ob.setVisible(true);
				dispose();
			}
		});
		btnAirCraft.setBounds(740, 85, 272, 55);
		contentPane.add(btnAirCraft);
		
		JButton btnVersion = new JButton("VERSION");
		btnVersion.setFont(new Font("Georgia", Font.BOLD, 40));
		btnVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fdisplay ob=new fdisplay();
				ob.setVisible(true);
				dispose();
				
				
			}
		});
		btnVersion.setBounds(30, 89, 272, 47);
		contentPane.add(btnVersion);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminoptn ob=new adminoptn();
				ob.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(998, 849, 179, 55);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\1.jpg"));
		label.setBounds(0, 0, 1902, 1033);
		contentPane.add(label);
	}

}
