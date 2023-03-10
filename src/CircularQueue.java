import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
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

public class CircularQueue extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField displaybox;
	private int cq[];
	private int size;
	private int r=-1;
	private int f=0;
	private int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 480);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						CircularQueue.class.getResource("/images/CircularQueue.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
				InputStream audioSrc = CircularQueue.class.getResourceAsStream("Circular.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		JLabel lblNewLabel = new JLabel("CIRCULAR QUEUE STRUCTURE");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setBounds(219, 32, 288, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE :");
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_1.setBounds(138, 95, 150, 19);
		contentPane.add(lblNewLabel_1);

		length = new JTextField();
		length.setBounds(326, 90, 203, 27);
		contentPane.add(length);
		length.setColumns(10);

		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create Queue Code
				size=Integer.valueOf(length.getText());
				cq=new int[size];
				String message="Circular Queue of size "+size+" Created";
				JOptionPane.showMessageDialog(contentPane,message );
			}
		});
		create.setFont(new Font("Constantia", Font.PLAIN, 14));
		create.setForeground(new Color(160, 82, 45));
		create.setBounds(278, 138, 145, 27);
		contentPane.add(create);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT :");
		lblNewLabel_1_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(138, 190, 157, 19);
		contentPane.add(lblNewLabel_1_1);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(326, 185, 145, 27);
		contentPane.add(element);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert code here
				int elem;
				if(count==size) {
					JOptionPane.showMessageDialog(contentPane, "Insertion not Possible");
				}
				else {
					elem=Integer.valueOf(element.getText());
					r=(r+1)%size;
					cq[r]=elem;
					count++;
					JOptionPane.showMessageDialog(contentPane, "Insertion Successfull");
					element.setText("");
				}
			}
		});
		insert.setForeground(new Color(255, 69, 0));
		insert.setFont(new Font("Constantia", Font.PLAIN, 14));
		insert.setBounds(513, 186, 85, 27);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete code here
				if(count==0) {
					JOptionPane.showMessageDialog(contentPane, "Deletion not Possible");
				}
				else {
					String msg="Element deleted is "+cq[f];
					JOptionPane.showMessageDialog(contentPane,msg);
					f=(f+1)%size;
					count--;
				}
			}
		});
		delete.setForeground(new Color(255, 69, 0));
		delete.setFont(new Font("Constantia", Font.PLAIN, 14));
		delete.setBounds(308, 249, 89, 27);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display code here
				String msg="";
				int f1=f;
				if(count==0) {
					JOptionPane.showMessageDialog(contentPane, "Display not Possible");
				}
				else {
					for (int i=1; i<=count; i++) {
						msg=msg+" "+cq[f1];
						f1=(f1+1)%size;
					}
					displaybox.setText(msg);
				}
			}
		});
		display.setForeground(new Color(255, 69, 0));
		display.setFont(new Font("Constantia", Font.PLAIN, 14));
		display.setBounds(308, 306, 93, 27);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(255, 250, 205));
		displaybox.setColumns(10);
		displaybox.setBounds(150, 365, 436, 27);
		contentPane.add(displaybox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircularQueue.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Constantia", Font.PLAIN, 14));
		btnBack.setBounds(613, 406, 75, 27);
		contentPane.add(btnBack);
	}
}
