package ch.scheissegal.crypt.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame{
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JTextArea cryptPwArea = new JTextArea();
	
	private JPanel controlPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
	
	private JTextField pwInputField = new JTextField(10);
	private JButton unlockButton = new JButton("unlock");
	
	private JTextField inputNewPasswordKind = new JTextField(10);
	private JPasswordField inputNewPassword = new JPasswordField(10);
	
	
	public Gui() {
		super("Password Lock");
		
		controlPanel.add(new JLabel("Input Password:"));
		controlPanel.add(pwInputField);
		controlPanel.add(unlockButton);
		controlPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		controlPanel.add(new JLabel("New Password:"));
		controlPanel.add(inputNewPasswordKind);
		controlPanel.add(inputNewPassword);
		
		controlPanel.setSize(new Dimension(100, 1));
		
		
		mainPanel.add(cryptPwArea, BorderLayout.CENTER);
		mainPanel.add(controlPanel, BorderLayout.WEST);
		
		this.add(mainPanel);
		
		
		
		this.setSize(new Dimension(640, 480));
	}
	
	
	public static void main(String[] args){
		new Gui().setVisible(true);
	}
	
	
}
