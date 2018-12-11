package adms;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextArea;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.xml.soap.Detail;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.print.*;
import java.awt.print.PrinterJob;
import java.text.*;
import javafx.print.*;

import java.awt.PrintGraphics;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class guest_2 extends JFrame {

	private JPanel pane;
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
	protected JTextComponent table_details;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guest_0 frame = new guest_0();
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
	public guest_2(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bitopan\\Desktop\\project images\\23-512.png"));
		setTitle("AIRCRAFT DATA MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(SystemColor.inactiveCaptionBorder);
		lblName.setFont(new Font("Georgia", Font.BOLD, 30));
		lblName.setBounds(396, 218, 131, 39);
		pane.add(lblName);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setForeground(SystemColor.inactiveCaptionBorder);
		lblVersion.setFont(new Font("Georgia", Font.BOLD, 30));
		lblVersion.setBounds(1108, 218, 175, 38);
		pane.add(lblVersion);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setForeground(SystemColor.inactiveCaptionBorder);
		lblClass.setFont(new Font("Georgia", Font.BOLD, 30));
		lblClass.setBounds(403, 320, 124, 29);
		pane.add(lblClass);
		
		JLabel lblOrigin = new JLabel("ORIGIN");
		lblOrigin.setForeground(SystemColor.inactiveCaptionBorder);
		lblOrigin.setFont(new Font("Georgia", Font.BOLD, 30));
		lblOrigin.setBounds(386, 404, 141, 45);
		pane.add(lblOrigin);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setForeground(SystemColor.inactiveCaptionBorder);
		lblRole.setFont(new Font("Georgia", Font.BOLD, 30));
		lblRole.setBounds(1120, 402, 131, 49);
		pane.add(lblRole);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setForeground(SystemColor.inactiveCaptionBorder);
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 30));
		lblStatus.setBounds(396, 508, 131, 23);
		pane.add(lblStatus);
		
		JLabel lblManufacturer = new JLabel("MANUFACTURER");
		lblManufacturer.setForeground(SystemColor.inactiveCaptionBorder);
		lblManufacturer.setFont(new Font("Georgia", Font.BOLD, 30));
		lblManufacturer.setBounds(272, 582, 307, 41);
		pane.add(lblManufacturer);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setForeground(SystemColor.inactiveCaptionBorder);
		lblCountry.setFont(new Font("Georgia", Font.BOLD, 30));
		lblCountry.setBounds(1108, 520, 175, 33);
		pane.add(lblCountry);
		
		JLabel lblIntroduced = new JLabel("INTRODUCTION");
		lblIntroduced.setForeground(SystemColor.inactiveCaptionBorder);
		lblIntroduced.setFont(new Font("Georgia", Font.BOLD, 30));
		lblIntroduced.setBounds(1032, 315, 263, 39);
		pane.add(lblIntroduced);
		
		JLabel lblNotes = new JLabel("NOTES");
		lblNotes.setForeground(SystemColor.inactiveCaptionBorder);
		lblNotes.setFont(new Font("Georgia", Font.BOLD, 30));
		lblNotes.setBounds(396, 712, 131, 34);
		pane.add(lblNotes);
		
		tna = new JTextField();
		tna.setFont(new Font("Tahoma", Font.BOLD, 30));
		tna.setBounds(578, 218, 316, 39);
		pane.add(tna);
		tna.setColumns(10);
		
		tve = new JTextField();
		tve.setFont(new Font("Tahoma", Font.BOLD, 30));
		tve.setBounds(1333, 216, 281, 41);
		pane.add(tve);
		tve.setColumns(10);
		
		tcl = new JTextField();
		tcl.setFont(new Font("Tahoma", Font.BOLD, 30));
		tcl.setBounds(578, 310, 316, 39);
		pane.add(tcl);
		tcl.setColumns(10);
		
		tin = new JTextField();
		tin.setFont(new Font("Tahoma", Font.BOLD, 30));
		tin.setBounds(1333, 312, 281, 42);
		pane.add(tin);
		tin.setColumns(10);
		
		tor = new JTextField();
		tor.setFont(new Font("Tahoma", Font.BOLD, 30));
		tor.setBounds(578, 408, 316, 39);
		pane.add(tor);
		tor.setColumns(10);
		
		tro = new JTextField();
		tro.setFont(new Font("Tahoma", Font.BOLD, 30));
		tro.setBounds(1333, 405, 281, 40);
		pane.add(tro);
		tro.setColumns(10);
		
		tst = new JTextField();
		tst.setFont(new Font("Tahoma", Font.BOLD, 30));
		tst.setBounds(578, 491, 316, 45);
		pane.add(tst);
		tst.setColumns(10);
		
		tma = new JTextField();
		tma.setFont(new Font("Tahoma", Font.BOLD, 30));
		tma.setBounds(578, 582, 316, 45);
		pane.add(tma);
		tma.setColumns(10);
		
		tco = new JTextField();
		tco.setFont(new Font("Tahoma", Font.BOLD, 30));
		tco.setBounds(1333, 515, 281, 41);
		pane.add(tco);
		tco.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setForeground(UIManager.getColor("Button.foreground"));
		btnBack.setFont(new Font("Georgia", Font.BOLD, 26));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guest_0 ob=new guest_0();
				ob.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(787, 962, 141, 45);
		pane.add(btnBack);
		
		
		
		TextArea tno = new TextArea();
		tno.setFont(new Font("Tahoma", Font.BOLD, 30));
		tno.setBounds(578, 709, 963, 190);
		pane.add(tno);
		
		JLabel lblPaticularDetails = new JLabel("PATICULAR VERSION DETAILS");
		lblPaticularDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaticularDetails.setForeground(Color.WHITE);
		lblPaticularDetails.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblPaticularDetails.setBounds(0, 0, 1902, 116);
		pane.add(lblPaticularDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 129, 1890, 14);
		pane.add(separator);
		
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
			ps1.setInt(1, i);
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
			
			JButton btnPrint = new JButton("PRINT");
			btnPrint.setForeground(UIManager.getColor("Button.foreground"));
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PrinterJob job = PrinterJob.getPrinterJob();
		            job.setJobName("Print Data");
		            
		            job.setPrintable(new Printable(){
		            public int print(Graphics pg,PageFormat pf, int pageNum){
		                    pf.setOrientation(PageFormat.LANDSCAPE);
		                 if(pageNum>0){
		                    return Printable.NO_SUCH_PAGE;
		                }
		                
		                Graphics2D g2 = (Graphics2D)pg;
		                g2.translate(pf.getImageableX(), pf.getImageableY());
		                g2.scale(0.24,0.24);
		                
		                pane.paint(g2);
//		          
		               
		                return Printable.PAGE_EXISTS;
		                         
		                
		            }
		    });
		         
		        boolean ok = job.printDialog();
		        if(ok){
		        try{
		            
		        job.print();
		        }
		        catch (PrinterException ex){}
		        }
				}
			});
			btnPrint.setFont(new Font("Georgia", Font.BOLD, 26));
			btnPrint.setBounds(1167, 962, 141, 45);
			pane.add(btnPrint);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(Color.WHITE);
			separator_1.setToolTipText("");
			separator_1.setBounds(919, 186, 9, 730);
			pane.add(separator_1);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bitopan\\Desktop\\project images\\thumb-1920-74183.jpg"));
			lblNewLabel.setBounds(0, 0, 1902, 1033);
			pane.add(lblNewLabel);
			
			
			
			
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

	}
}
