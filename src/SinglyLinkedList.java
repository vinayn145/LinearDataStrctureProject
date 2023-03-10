import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.xml.soap.Node;
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

public class SinglyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField rearelement;
	private JTextField front;
	private JTextField displaybox;
	class Node{
		int data;
		Node link;
	}
	private Node first;
	Node temp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 505);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						SinglyLinkedList.class.getResource("/images/Singly.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
				InputStream audioSrc = SinglyLinkedList.class.getResourceAsStream("Singly.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		JLabel lblNewLabel = new JLabel("SINGLY LINKED LIST DATASTRUCTURE");
		lblNewLabel.setBounds(200, 6, 369, 27);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT :");
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setBounds(92, 74, 177, 20);
		contentPane.add(lblNewLabel_1);

		rearelement = new JTextField();
		rearelement.setBackground(new Color(255, 250, 205));
		rearelement.setBounds(299, 69, 248, 27);
		contentPane.add(rearelement);
		rearelement.setColumns(10);

		JButton btnNewButton = new JButton("INSERT REAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert rear code
				Node temp;
				int elem=Integer.valueOf(rearelement.getText());
				Node newnode=new Node();
				newnode.data=elem;
				newnode.link=null;
				if(first==null) {
					first=newnode;
				}
				else {
					temp=first;
					while(temp.link!=null) {
						temp=temp.link;
					}
					temp.link=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insertion succesful");
					rearelement.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Constantia", Font.BOLD, 14));
		btnNewButton.setBounds(588, 71, 127, 27);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT :");
		lblNewLabel_1_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(92, 135, 177, 20);
		contentPane.add(lblNewLabel_1_1);

		front = new JTextField();
		front.setColumns(10);
		front.setBackground(new Color(255, 250, 205));
		front.setBounds(299, 130, 248, 27);
		contentPane.add(front);

		JButton Front  = new JButton("INSERT FRONT");
		Front.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert front code
				int elem=Integer.valueOf(front.getText());
				Node newnode=new Node();
				newnode.data=elem;
				newnode.link=null;
				if(first==null) {
					first=newnode;
				}
				else {
					newnode.link=first;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insertion succesful");
					front.setText("");
				}
			}
		});
		Front.setFont(new Font("Constantia", Font.BOLD, 14));
		Front.setBounds(588, 132, 139, 27);
		contentPane.add(Front);

		JButton deletefront = new JButton("DELETE FRONT");
		deletefront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete front code
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane, "Deletion not Possible");
				}
				else if(first.link==null) {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=first.link;
				}
			}
		});
		deletefront.setFont(new Font("Constantia", Font.BOLD, 14));
		deletefront.setBounds(325, 254, 141, 27);
		contentPane.add(deletefront);

		JButton deleterear = new JButton("DELETE REAR");
		deleterear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete rear code
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane, "Deletion not Possible");
				}
				else if(first.link==null) {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else {
					temp=first;
					while(temp.link.link!=null) {
						temp=temp.link;
					}
					String msg="Element deleted is "+temp.link.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					temp.link=null;
				}
			}

		});
		deleterear.setFont(new Font("Constantia", Font.BOLD, 14));
		deleterear.setBounds(325, 197, 129, 27);
		contentPane.add(deleterear);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display code
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane, "Display not Possible");
				}
				else if(first.link==null) {
					String msg="";
					msg=msg+first.data;
					displaybox.setText(msg);
				}
				else {
					temp=first;
					String msg="";
					while(temp!=null) {
						msg=msg+" "+temp.data;
						displaybox.setText(msg);
						temp=temp.link;
					}
				}
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 14));
		display.setBounds(325, 313, 93, 27);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setColumns(10);
		displaybox.setBackground(new Color(255, 250, 240));
		displaybox.setBounds(171, 363, 487, 27);
		contentPane.add(displaybox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinglyLinkedList.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Constantia", Font.BOLD, 15));
		btnBack.setBounds(673, 418, 75, 27);
		contentPane.add(btnBack);
	}

}
