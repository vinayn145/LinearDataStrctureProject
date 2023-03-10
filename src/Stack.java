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

public class Stack extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField displaybox;
	private int s[];
	private int size;
	private int top=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 595);
		
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Stack.class.getResource("/images/Stack.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
				InputStream audioSrc = Stack.class.getResourceAsStream("Stack.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		JLabel Enter = new JLabel("ENTER THE STACK SIZE :");
		Enter.setBounds(153, 111, 246, 18);
		Enter.setForeground(new Color(160, 82, 45));
		Enter.setFont(new Font("Constantia", Font.BOLD, 16));
		contentPane.add(Enter);

		JLabel jlabel = new JLabel("STACK DATA STRUCTURE");
		jlabel.setBounds(245, 22, 246, 27);
		jlabel.setForeground(new Color(255, 0, 0));
		jlabel.setFont(new Font("Algerian", Font.BOLD, 19));
		contentPane.add(jlabel);

		length = new JTextField();
		length.setBounds(368, 109, 154, 19);
		contentPane.add(length);
		length.setColumns(10);

		JButton create = new JButton("CREATE STACK");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Create a Stack
				size=Integer.valueOf(length.getText());
				s=new int[size];
				String message="Stack of size "+size+" Created";
				JOptionPane.showMessageDialog(contentPane,message );
			}
		});
		create.setFont(new Font("Constantia", Font.BOLD, 14));
		create.setForeground(new Color(0, 0, 205));
		create.setBounds(291, 171, 139, 27);
		contentPane.add(create);

		JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT :");
		lblEnterAnElement.setForeground(new Color(220, 20, 60));
		lblEnterAnElement.setFont(new Font("Constantia", Font.BOLD, 16));
		lblEnterAnElement.setBounds(153, 239, 246, 18);
		contentPane.add(lblEnterAnElement);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(368, 237, 154, 19);
		contentPane.add(element);

		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Push code
				int elem;
				if(top==size-1){
					JOptionPane.showMessageDialog(contentPane, "Push not Possible");
				}
				else{
					elem=Integer.valueOf(element.getText());
					++top;
					s[top]=elem;
					JOptionPane.showMessageDialog(contentPane, "Push Successfull");
					element.setText("");
				}
			}
		});
		push.setForeground(new Color(65, 105, 225));
		push.setFont(new Font("Constantia", Font.BOLD, 14));
		push.setBounds(562, 235, 73, 27);
		contentPane.add(push);

		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Pop code
				if(top==-1){
					JOptionPane.showMessageDialog(contentPane, "Pop not Possible");

				}
				else{
					String msg="Element deleted is:"+s[top];
					JOptionPane.showMessageDialog(contentPane,msg);
					--top;
				}
			}
		});
		pop.setForeground(new Color(65, 105, 225));
		pop.setFont(new Font("Constantia", Font.BOLD, 14));
		pop.setBounds(314, 317, 73, 27);
		contentPane.add(pop);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display code
				String msg="";
				if(top==-1){
					JOptionPane.showMessageDialog(contentPane, "Display not possible");
				}
				else{
					for (int i = top; i>=0; i--) {
						msg=msg+" "+s[i];
					}
					displaybox.setText(msg);
				}
			}
		});
		display.setForeground(new Color(0, 0, 205));
		display.setFont(new Font("Constantia", Font.BOLD, 14));
		display.setBounds(291, 394, 139, 27);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(175, 238, 238));
		displaybox.setColumns(10);
		displaybox.setBounds(168, 466, 387, 19);
		contentPane.add(displaybox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 14));
		btnBack.setBounds(670, 509, 71, 27);
		contentPane.add(btnBack);
	}

}
