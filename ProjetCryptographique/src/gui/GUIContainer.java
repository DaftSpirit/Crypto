package gui;

/**
 * class for interface with password 
 * @author Axel 
 */

import javax.swing.JFrame;

public class GUIContainer extends JFrame {

	/**
	 * Interface_P() default constructor for JFrame
	 * 
	 * @param null
	 */

	public GUIContainer() {
		GUIContent p = new GUIContent(this);

		// JFrame
		this.setTitle("Agenda Electronique");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Panneau (JPanel)
		this.setContentPane(p);
		this.setVisible(true);
	}

}
