package intergraphique;

/**
 * class for interface with password 
 * @author Axel 
 */

import javax.swing.JFrame;


public class Interface_P extends JFrame{
		
	/** 
	 * Interface_P()
	 * default constructor for JFrame 
	 * @param null
	 */
	
	public Interface_P(){		
		Panneau p = new Panneau(this);
		
		//JFrame
		this.setTitle("Agenda Electronique");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);		
		
		//Panneau (JPanel)
		this.setContentPane(p);
		this.setVisible(true);		
	}
	
}
