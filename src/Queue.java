import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
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

public class Queue extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField displaybox;
	private int q[];
	private int size;
	private int r=-1;
	private int f=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 560);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Queue.class.getResource("/images/Queue.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
				InputStream audioSrc = Queue.class.getResourceAsStream("Queue.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		JLabel lblNewLabel = new JLabel("QUEUE DATASTRUCTURE");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setBounds(235, 44, 240, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE :");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_1.setBounds(137, 116, 150, 19);
		contentPane.add(lblNewLabel_1);

		length = new JTextField();
		length.setBounds(318, 111, 217, 27);
		contentPane.add(length);
		length.setColumns(10);

		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// QUEUE code
				size=Integer.valueOf(length.getText());
				q=new int[size];
				String message="Queue of size "+size+" Created";
				JOptionPane.showMessageDialog(contentPane,message );
			}
		});
		create.setForeground(new Color(0, 0, 0));
		create.setFont(new Font("Constantia", Font.BOLD, 15));
		create.setBounds(284, 170, 155, 29);
		contentPane.add(create);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT :");
		lblNewLabel_1_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(137, 239, 157, 19);
		contentPane.add(lblNewLabel_1_1);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(321, 233, 93, 29);
		contentPane.add(element);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// INSERT CODE
				int elem;
				if(r==size-1){
					JOptionPane.showMessageDialog(contentPane, "Insertion not Possible");
				}
				else{
					elem=Integer.valueOf(element.getText());
					++r;
					q[r]=elem;
					JOptionPane.showMessageDialog(contentPane, "Insertion Successfull");
					element.setText("");
				}
			}
		});
		insert.setForeground(Color.BLACK);
		insert.setFont(new Font("Constantia", Font.BOLD, 15));
		insert.setBounds(470, 234, 91, 29);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DELETE Code
				if(r==-1|| f>r){
					JOptionPane.showMessageDialog(contentPane, "Deletion not Possible");
				}
				else{
					String msg="Element deleted is:"+q[f];
					JOptionPane.showMessageDialog(contentPane,msg);
					++f;
				}
			}
		});
		delete.setForeground(Color.BLACK);
		delete.setFont(new Font("Constantia", Font.BOLD, 15));
		delete.setBounds(321, 308, 93, 29);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg="";

				// Display code
				if(r==-1|| f>r){
					JOptionPane.showMessageDialog(contentPane, "Display not Possible");
				}
				else{
					for(int i=f;i<=r;i++){
						msg=msg+" "+q[i];
					}
					displaybox.setText(msg);	
				}
			}
		});
		display.setForeground(Color.BLACK);
		display.setFont(new Font("Constantia", Font.BOLD, 15));
		display.setBounds(313, 376, 101, 29);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(255, 250, 250));
		displaybox.setColumns(10);
		displaybox.setBounds(174, 428, 387, 29);
		contentPane.add(displaybox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queue.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 15));
		btnBack.setBounds(640, 471, 75, 29);
		contentPane.add(btnBack);
	}
}
