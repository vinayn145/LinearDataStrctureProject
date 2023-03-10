import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class DoublyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField rearelement;
	private JTextField frontelement;
	private JTextField displaybox;
	class Node{
		Node prelink;
		int data;
		Node nextlink;
	}
	private Node first;
	Node temp ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
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
	public DoublyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 538);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						DoublyLinkedList.class.getResource("/images/Doubly.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		}; 
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
			 
				InputStream audioSrc = DoublyLinkedList.class.getResourceAsStream("Doubly.wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		JLabel lblNewLabel = new JLabel("DOUBLY LINKED LIST DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setBounds(195, 30, 376, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT :");
		lblNewLabel_1.setForeground(new Color(255, 0, 255));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 82, 177, 20);
		contentPane.add(lblNewLabel_1);

		rearelement = new JTextField();
		rearelement.setBounds(256, 77, 177, 27);
		contentPane.add(rearelement);
		rearelement.setColumns(10);

		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert rear operation code
				Node temp;
				int elem=Integer.valueOf(rearelement.getText());
				Node newnode = new Node();
				newnode.data=elem;
				newnode.prelink=null;
				newnode.nextlink=null;
				if(first==null) {
					first=newnode;
				}
				else {
					temp=first;
					while(temp.nextlink!=null) {
						temp=temp.nextlink;
					}
					temp.nextlink=newnode;
					newnode.prelink=temp;
					JOptionPane.showMessageDialog(contentPane, "Insertion Succesful");
					rearelement.setText("");
				}
			}
		});
		insertrear.setFont(new Font("Constantia", Font.BOLD, 14));
		insertrear.setForeground(new Color(0, 0, 0));
		insertrear.setBounds(483, 80, 127, 27);
		contentPane.add(insertrear);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT :");
		lblNewLabel_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(51, 150, 177, 20);
		contentPane.add(lblNewLabel_1_1);

		frontelement = new JTextField();
		frontelement.setColumns(10);
		frontelement.setBounds(256, 146, 177, 27);
		contentPane.add(frontelement);

		JButton insertfront = new JButton("INSERT FRONT");
		insertfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Front operation code
				int elem=Integer.valueOf(frontelement.getText());
				Node newnode=new Node();
				newnode.data=elem;
				newnode.prelink=null;
				newnode.nextlink=null;
				if(first==null) {
					first=newnode;
				}
				else {
					newnode.nextlink=first;
					first.prelink=newnode;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insertion succesful");
					frontelement.setText("");
				}
			}
		});
		insertfront.setForeground(Color.BLACK);
		insertfront.setFont(new Font("Constantia", Font.BOLD, 14));
		insertfront.setBounds(483, 148, 139, 27);
		contentPane.add(insertfront);

		JButton deleterear = new JButton("DELETE REAR");
		deleterear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete rear operation code
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Deletion not Possible");
				}
				else if(first.nextlink==null) {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else {
					temp=first;
					while(temp.nextlink.nextlink!=null) {
						temp=temp.nextlink;
					}
					String msg="Element deleted is "+temp.nextlink.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					temp.nextlink=null;
				}
			}
		});
		deleterear.setForeground(Color.BLACK);
		deleterear.setFont(new Font("Constantia", Font.BOLD, 14));
		deleterear.setBounds(266, 212, 129, 27);
		contentPane.add(deleterear);

		JButton deletefront = new JButton("DELETE FRONT");
		deletefront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete front operation code
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Deletion not Possible");
				}
				else if(first.nextlink==null) {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else {
					String msg="Element deleted is "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=first.nextlink;
					first.prelink=null;
				}
			}
		});
		deletefront.setForeground(Color.BLACK);
		deletefront.setFont(new Font("Constantia", Font.BOLD, 14));
		deletefront.setBounds(266, 272, 141, 27);
		contentPane.add(deletefront);

		JButton displayforword = new JButton("DISPLAY FORWARD");
		displayforword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display forward code

				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Display not Possible");
				}
				else if(first.nextlink==null) {
					String msg="";
					msg=msg+first.data;
					displaybox.setText(msg);
				}
				else {
					temp=first;
					String msg="";
					while(temp!=null) {
						msg=msg+" "+temp.data;
						temp=temp.nextlink;
					}
					displaybox.setText(msg);

				}
			}
		});
		displayforword.setForeground(Color.BLACK);
		displayforword.setFont(new Font("Constantia", Font.BOLD, 15));
		displayforword.setBounds(146, 329, 181, 27);
		contentPane.add(displayforword);

		JButton displayreverse = new JButton("DISPLAY REVERSE");
		displayreverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display Reverse code
				Node temp;
				if(first==null) {
					JOptionPane.showMessageDialog(contentPane,"Display not Possible");
				}
				else if(first.nextlink==null) {
					String msg="";
					msg=msg+first.data;
					displaybox.setText(msg);
				}
				else {
					temp=first;
					while(temp.nextlink!=null) {
						temp=temp.nextlink;
					}
					String msg="";
					while(temp!=null) {
						msg=msg+" "+temp.data;
						temp=temp.prelink;
					}
					displaybox.setText(msg);
				}
			}
		});
		displayreverse.setForeground(Color.BLACK);
		displayreverse.setFont(new Font("Constantia", Font.BOLD, 15));
		displayreverse.setBounds(353, 329, 167, 27);
		contentPane.add(displayreverse);

		displaybox = new JTextField();
		displaybox.setBounds(107, 391, 534, 27);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoublyLinkedList.this.dispose();
				new Home().setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 14));
		btnBack.setBounds(659, 440, 71, 27);
		contentPane.add(btnBack);
	}

}
