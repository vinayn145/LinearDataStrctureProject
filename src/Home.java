import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Home extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Home.class.getResource("/images/Home.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};  
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			InputStream audioSrc = Home.class.getResourceAsStream("Home.wav");
			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}



		JLabel lblNewLabel = new JLabel("CHOOSE A DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 13));
		lblNewLabel.setBounds(107, 24, 194, 19);
		contentPane.add(lblNewLabel);

		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// PLACE ARRAY CODE OPENING HERE
				new Array().setVisible(true);
			}
		});
		array.setForeground(new Color(255, 0, 0));
		array.setFont(new Font("Constantia", Font.BOLD, 12));
		array.setBounds(167, 64, 73, 23);
		contentPane.add(array);

		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE STACK CODE OPENING HERE
				new Stack().setVisible(true);
			}
		});
		stack.setForeground(new Color(128, 0, 0));
		stack.setFont(new Font("Constantia", Font.BOLD, 10));
		stack.setBounds(66, 116, 71, 23);
		contentPane.add(stack);

		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE QUEUE CODE OPENING HERE
				new Queue().setVisible(true);
			}
		});
		queue.setForeground(new Color(0, 0, 139));
		queue.setFont(new Font("Constantia", Font.BOLD, 10));
		queue.setBounds(268, 116, 75, 23);
		contentPane.add(queue);

		JButton Cqueue = new JButton("CIRCULARQUEUE");
		Cqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE CIRCULARQUEUE CODE OPENING HERE
				new CircularQueue().setVisible(true);
			}
		});
		Cqueue.setForeground(new Color(255, 0, 255));
		Cqueue.setFont(new Font("Constantia", Font.BOLD, 10));
		Cqueue.setBounds(38, 171, 139, 23);
		contentPane.add(Cqueue);

		JButton sll = new JButton("SINGLYLINKEDLIST");
		sll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE SINGLY Linked list CODE OPENING HERE
				new SinglyLinkedList().setVisible(true);
			}
		});
		sll.setForeground(new Color(85, 107, 47));
		sll.setFont(new Font("Constantia", Font.BOLD, 10));
		sll.setBounds(231, 171, 147, 23);
		contentPane.add(sll);

		JButton dll = new JButton("DOUBLYLINKEDLIST");
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE DOUBLY Linked list CODE OPENING HERE
				new DoublyLinkedList().setVisible(true);
			}
		});
		dll.setForeground(new Color(153, 50, 204));
		dll.setFont(new Font("Constantia", Font.BOLD, 10));
		dll.setBounds(128, 217, 155, 23);
		contentPane.add(dll);
	}
}
