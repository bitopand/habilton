package adms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class display_detail extends JFrame {

	private JPanel contentPane;
	private JTextField tna;
	private JTextField tve;
	private JTextField tcl;
	private JTextField tin;
	private JTextField tor;
	private JTextField tro;
	private JTextField tst;
	private JTextField tma;
	private JTextField tco;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display_detail frame = new display_detail(10);
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
	@SuppressWarnings("unused")
	public display_detail(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Georgia", Font.BOLD, 20));
		lblName.setForeground(UIManager.getColor("Button.shadow"));
		lblName.setBounds(241, 201, 89, 14);
		contentPane.add(lblName);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setFont(new Font("Georgia", Font.BOLD, 20));
		lblVersion.setForeground(UIManager.getColor("Button.shadow"));
		lblVersion.setBounds(1117, 201, 124, 14);
		contentPane.add(lblVersion);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setFont(new Font("Georgia", Font.BOLD, 20));
		lblClass.setForeground(UIManager.getColor("Button.shadow"));
		lblClass.setBounds(241, 274, 89, 17);
		contentPane.add(lblClass);
		
		JLabel lblOrigin = new JLabel("ORIGIN");
		lblOrigin.setFont(new Font("Georgia", Font.BOLD, 20));
		lblOrigin.setForeground(UIManager.getColor("Button.shadow"));
		lblOrigin.setBounds(229, 345, 101, 27);
		contentPane.add(lblOrigin);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setFont(new Font("Georgia", Font.BOLD, 20));
		lblRole.setForeground(UIManager.getColor("Button.shadow"));
		lblRole.setBounds(1133, 351, 124, 14);
		contentPane.add(lblRole);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 20));
		lblStatus.setForeground(new Color(160, 160, 160));
		lblStatus.setBounds(1133, 431, 124, 17);
		contentPane.add(lblStatus);
		
		JLabel lblManufacturer = new JLabel("MANUFACTURER");
		lblManufacturer.setFont(new Font("Georgia", Font.BOLD, 20));
		lblManufacturer.setForeground(UIManager.getColor("Button.shadow"));
		lblManufacturer.setBounds(1092, 514, 218, 19);
		contentPane.add(lblManufacturer);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setFont(new Font("Georgia", Font.BOLD, 20));
		lblCountry.setForeground(UIManager.getColor("Button.shadow"));
		lblCountry.setBounds(219, 431, 124, 27);
		contentPane.add(lblCountry);
		
		JLabel lblIntroduced = new JLabel("INTRODUCED");
		lblIntroduced.setFont(new Font("Georgia", Font.BOLD, 20));
		lblIntroduced.setForeground(UIManager.getColor("Button.shadow"));
		lblIntroduced.setBounds(1102, 288, 166, 14);
		contentPane.add(lblIntroduced);
		
		JLabel lblNotes = new JLabel("NOTES");
		lblNotes.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNotes.setForeground(UIManager.getColor("Button.shadow"));
		lblNotes.setBounds(229, 569, 124, 39);
		contentPane.add(lblNotes);
		
		tna = new JTextField();
		tna.setEditable(false);
		tna.setBounds(447, 193, 264, 34);
		contentPane.add(tna);
		tna.setColumns(10);
		
		tve = new JTextField();
		tve.setEditable(false);
		tve.setBounds(1354, 193, 264, 34);
		contentPane.add(tve);
		tve.setColumns(10);
		
		tcl = new JTextField();
		tcl.setEditable(false);
		tcl.setBounds(447, 267, 264, 34);
		contentPane.add(tcl);
		tcl.setColumns(10);
		
		tin = new JTextField();
		tin.setEditable(false);
		tin.setBounds(1354, 267, 264, 34);
		contentPane.add(tin);
		tin.setColumns(10);
		
		tor = new JTextField();
		tor.setEditable(false);
		tor.setBounds(447, 343, 264, 39);
		contentPane.add(tor);
		tor.setColumns(10);
		
		tro = new JTextField();
		tro.setEditable(false);
		tro.setBounds(1354, 343, 264, 34);
		contentPane.add(tro);
		tro.setColumns(10);
		
		tst = new JTextField();
		tst.setEditable(false);
		tst.setBounds(1354, 414, 264, 34);
		contentPane.add(tst);
		tst.setColumns(10);
		
		tma = new JTextField();
		tma.setEditable(false);
		tma.setBounds(1354, 508, 264, 34);
		contentPane.add(tma);
		tma.setColumns(10);
		
		tco = new JTextField();
		tco.setEditable(false);
		tco.setBounds(447, 431, 264, 34);
		contentPane.add(tco);
		tco.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Georgia", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fdisplay ob=new fdisplay();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(970, 972, 131, 48);
		contentPane.add(btnBack);
		
		
		
		TextArea tno = new TextArea();
		tno.setEditable(false);
		tno.setBounds(359, 595, 879, 185);
		contentPane.add(tno);
		
		JLabel lblPaticularDetails = new JLabel("PATICULAR VERSION DETAILS");
		lblPaticularDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaticularDetails.setForeground(UIManager.getColor("Button.shadow"));
		lblPaticularDetails.setFont(new Font("Georgia", Font.BOLD, 60));
		lblPaticularDetails.setBounds(0, 0, 1902, 69);
		contentPane.add(lblPaticularDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 82, 1902, 14);
		contentPane.add(separator);
		
		String name,ver,clas,intro,ori,role,sta,manuf,coun,notes;
		name=ver=clas=intro=ori=role=sta=manuf=coun=notes=null;
		int no,mid = 0,fid = 0,cid,oid,fcid;
		no=mid =fid =cid=oid=fcid=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adms1","root","");
			
			String q1="SELECT `vid`, `version`, `role`, `mmid`, `ffid`, `note`, `status`, `intro`, `Number` FROM `fversion` where vid=(?)";
			PreparedStatement ps1=con.prepareStatement(q1);
			ps1.setInt(1,i);
			ResultSet r1=ps1.executeQuery();
			while(r1.next())
			{
				ver=r1.getString("version");
				role=r1.getString("role");
				notes=r1.getString("note");
				intro=r1.getString("intro");
				sta=r1.getString("status");
				fid=r1.getInt("ffid");
				mid=r1.getInt("mmid");
				no=r1.getInt("Number");
				
				
			}
			
			
			String q3="SELECT  `mname`, `cnid` FROM `manufacturer` WHERE mid=(?)";
			PreparedStatement ps3=con.prepareStatement(q3);
			ps3.setInt(1, mid);
			ResultSet r11=ps3.executeQuery();
			while(r11.next())
			{
				manuf=r11.getString("mname");
				
				cid=r11.getInt("cnid");
				
				
			}
			
			String q4="SELECT `cname` FROM `country` WHERE cid=(?)";
			PreparedStatement ps4=con.prepareStatement(q4);
			ps4.setInt(1, cid);
			ResultSet r2=ps4.executeQuery();
			while(r2.next())
			{
				coun=r2.getString("cname");
								
			}
			
			
			
			String q2="SELECT  `name`, `cnid`, `fclid` FROM `finfo` WHERE  fid=(?)";
			PreparedStatement ps2=con.prepareStatement(q2);
			ps2.setInt(1,fid);
			ResultSet r111=ps2.executeQuery();
			while(r111.next())
			{
				name=r111.getString("name");
				
				oid=r111.getInt("cnid");
				fcid=r111.getInt("fclid");
				
				
			}
			String q5="SELECT `cname` FROM `country` WHERE cid=(?)";
			PreparedStatement ps5=con.prepareStatement(q5);
			ps5.setInt(1, oid);
			ResultSet r3=ps5.executeQuery();
			while(r3.next())
			{
				ori=r3.getString("cname");
								
			}
			
			String q6="SELECT  `fclass` FROM `class` WHERE  fcid=(?)";
			PreparedStatement ps6=con.prepareStatement(q6);
			ps6.setInt(1, fcid);
			ResultSet r4=ps6.executeQuery();
			while(r4.next())
			{
				clas=r4.getString("fclass");
								
			}
			
			
			tna.setText(name);
			tve.setText(ver);
			tcl.setText(clas);
			tin.setText(intro);
			tor.setText(ori);
			tro.setText(role);
			tst.setText(sta);
			tma.setText(manuf);
			tco.setText(coun);
			tno.setText(notes);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 20));
			lblNewLabel.setIcon(null);
			lblNewLabel.setBounds(0, 0, 1181, 670);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\thumb-1920-74183.jpg"));
			lblNewLabel_1.setBounds(0, 0, 1902, 1033);
			contentPane.add(lblNewLabel_1);
			
			
			
			
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
	}
}
