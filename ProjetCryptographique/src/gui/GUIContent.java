package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * class Panel for Jframe Interface_P
 * @author Axel
 */
public class GUIContent extends JPanel{	
	
	/**
	 * pulic panneau(JFrame f)
	 * default constructor 
	 * @param f : refrence JFrame contains Panneau
	 */
	
	public GUIContent(JFrame f){
		JLabel l1 = new JLabel("<html>"
				+ "<h1 style=\"text-align:center;text-indent:25px; font-family:Times new Roman;\">Bonjour</h1><br>"
				+ "<p style=\"text-align:center; font-family:Times new Roman;font-size:15px\"> * Tapez votre mot de passe *</p><br>"
				+ "<br></html>");
		JLabel l3 = new JLabel("Mot de passe: ");
				
		JPasswordField pw = new JPasswordField();
		
		Button b = new Button("Sign In",f,pw);
		
		this.setBackground(Color.orange);
		b.setBackground(Color.red);
		l1.setForeground(Color.black);
		
		this.setLayout(new BorderLayout());
		
		this.add(l1,BorderLayout.NORTH);
		this.add(l3,BorderLayout.WEST);
		this.add(pw,BorderLayout.CENTER);
		this.add(b,BorderLayout.SOUTH);					
	}	
}
