import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField deleteposition;
	private JTextField insertposition;
	private JTextField displaybox;
	private int arr[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 553);
		
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Array.class.getResource("/images/Arrays.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
				InputStream audioSrc = Array.class.getResourceAsStream("Array.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		JLabel lblNewLabel = new JLabel("ARRAY DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 17));
		lblNewLabel.setBounds(282, 26, 226, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterArrayLength = new JLabel("ENTER ARRAY LENGTH :");
		lblEnterArrayLength.setForeground(new Color(255, 0, 0));
		lblEnterArrayLength.setFont(new Font("Constantia", Font.BOLD, 14));
		lblEnterArrayLength.setBounds(63, 106, 170, 18);
		contentPane.add(lblEnterArrayLength);
		
		length = new JTextField();
		length.setBounds(289, 100, 219, 27);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton create = new JButton("CREATE ARRAY");
		create.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				// Code for creating array
				 String Len=length.getText();
				 int len=Integer.valueOf(Len);
				arr =new int[len];
				String message="Array of length "+len+" created";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		create.setForeground(new Color(210, 105, 30));
		create.setFont(new Font("Constantia", Font.BOLD, 14));
		create.setBounds(289, 154, 141, 27);
		contentPane.add(create);
		
		JLabel lblInsertAnInteger = new JLabel("INSERT AN INTEGER ELEMENT :");
		lblInsertAnInteger.setForeground(new Color(123, 104, 238));
		lblInsertAnInteger.setFont(new Font("Constantia", Font.BOLD, 14));
		lblInsertAnInteger.setBounds(63, 217, 222, 18);
		contentPane.add(lblInsertAnInteger);
		
		element = new JTextField();
		element.setBounds(289, 212, 100, 26);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code for insertion
				int elem=Integer.valueOf(element.getText());
				int pos=Integer.valueOf(insertposition.getText());
				arr[pos]=elem;
				String message="Element "+elem+" Inserted@position"+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				element.setText("");
				insertposition.setText("");
			}
		});
		insert.setForeground(new Color(148, 0, 211));
		insert.setFont(new Font("Constantia", Font.BOLD, 14));
		insert.setBounds(618, 213, 85, 27);
		contentPane.add(insert);
		
		JLabel lblDeletePosition = new JLabel("DELETE POSITION :");
		lblDeletePosition.setForeground(new Color(0, 0, 128));
		lblDeletePosition.setFont(new Font("Constantia", Font.BOLD, 14));
		lblDeletePosition.setBounds(63, 283, 215, 18);
		contentPane.add(lblDeletePosition);
		
		deleteposition = new JTextField();
		deleteposition.setColumns(10);
		deleteposition.setBounds(289, 278, 100, 26);
		contentPane.add(deleteposition);
		
		insertposition = new JTextField();
		insertposition.setColumns(10);
		insertposition.setBounds(511, 212, 71, 26);
		contentPane.add(insertposition);
		
		JLabel lblPosition = new JLabel("POSITION :");
		lblPosition.setForeground(new Color(123, 104, 238));
		lblPosition.setFont(new Font("Constantia", Font.BOLD, 14));
		lblPosition.setBounds(421, 217, 80, 18);
		contentPane.add(lblPosition);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code for Display array
				String msg="";
				for(int i=0;i<=arr.length-1;i++) {
					msg=msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		display.setForeground(new Color(0, 0, 139));
		display.setFont(new Font("Constantia", Font.BOLD, 14));
		display.setBounds(289, 336, 93, 27);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(253, 245, 230));
		displaybox.setColumns(10);
		displaybox.setBounds(135, 415, 436, 27);
		contentPane.add(displaybox);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code for deletion
				int pos=Integer.valueOf(deleteposition.getText());
				arr[pos]=0;
				String message="Element Deleted @ the position"+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				deleteposition.setText("");
			}
		});
		delete.setForeground(new Color(148, 0, 211));
		delete.setFont(new Font("Constantia", Font.BOLD, 14));
		delete.setBounds(421, 279, 87, 27);
		contentPane.add(delete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Array.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 14));
		btnBack.setBounds(642, 465, 71, 27);
		contentPane.add(btnBack);
	}
}
