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

@SuppressWarnings("serial")
public class modoptn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modoptn frame = new modoptn();
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
	public modoptn() {
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModifyAircraftName = new JButton("MODFIY AIRCRAFT NAME");
		btnModifyAircraftName.setFont(new Font("Georgia", Font.BOLD, 40));
		btnModifyAircraftName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod_fname ob=new mod_fname();
				ob.setVisible(true);
				setVisible(false);
				
			}
		});
		btnModifyAircraftName.setBounds(307, 233, 629, 55);
		contentPane.add(btnModifyAircraftName);
		
		JButton btnNewButton = new JButton("MODFIY VERSION");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod_ver ob=new mod_ver();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(307, 360, 629, 55);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 35));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminoptn ob=new adminoptn();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(12, 13, 167, 49);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\black-wallpaper-8.jpg"));
		lblNewLabel.setBounds(0, 0, 1181, 670);
		contentPane.add(lblNewLabel);
	}

}
