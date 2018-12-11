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
import java.awt.Color;

@SuppressWarnings("serial")
public class addoptn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addoptn frame = new addoptn();
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
	public addoptn() {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1033);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewCountry = new JButton("ADD NEW COUNTRY");
		btnAddNewCountry.setBackground(Color.LIGHT_GRAY);
		btnAddNewCountry.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAddNewCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_country ob=new add_country();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnAddNewCountry.setBounds(590, 415, 661, 49);
		contentPane.add(btnAddNewCountry);
		
		JButton btnAddNewManufacturer = new JButton("ADD NEW MANUFACTURER");
		btnAddNewManufacturer.setBackground(Color.LIGHT_GRAY);
		btnAddNewManufacturer.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAddNewManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_manuf ob=new add_manuf();
				ob.setVisible(true);
				dispose();
			}
		});
		btnAddNewManufacturer.setBounds(590, 634, 661, 55);
		contentPane.add(btnAddNewManufacturer);
		
		JButton btnAddNewClass = new JButton("ADD NEW CLASS");
		btnAddNewClass.setBackground(Color.LIGHT_GRAY);
		btnAddNewClass.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAddNewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_class ob=new add_class();
				ob.setVisible(true);
				dispose();
				
				
			}
		});
		btnAddNewClass.setBounds(590, 531, 661, 49);
		contentPane.add(btnAddNewClass);
		
		JButton btnAddNewFlight = new JButton("ADD NEW FLIGHT DETAILS");
		btnAddNewFlight.setBackground(Color.LIGHT_GRAY);
		btnAddNewFlight.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAddNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_finfo ob=new add_finfo();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnAddNewFlight.setBounds(590, 209, 661, 49);
		contentPane.add(btnAddNewFlight);
		
		JButton btnAddNewFlight_1 = new JButton("ADD NEW FLIGHT VERSION");
		btnAddNewFlight_1.setBackground(Color.LIGHT_GRAY);
		btnAddNewFlight_1.setFont(new Font("Georgia", Font.BOLD, 40));
		btnAddNewFlight_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addframe ob=new addframe();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnAddNewFlight_1.setBounds(590, 310, 661, 49);
		contentPane.add(btnAddNewFlight_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 30));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminoptn ob=new adminoptn();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(825, 866, 153, 55);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\elegant-grey-illumination-background-presentations-powerpoint-backgrounds.jpg"));
		lblNewLabel.setBounds(0, 0, 1902, 1033);
		contentPane.add(lblNewLabel);
	}

}
