package intergraphique;

/* Classe pour l'interface principale avec le mot de passe
 * auteur: Axel 
 */

import javax.swing.JFrame;


public class Interface_P extends JFrame{
		
	public Interface_P(){		
		Panneau p = new Panneau(this);
		
		//JFrame
		this.setTitle("Agenda électronique");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);		
		
		//Panneau (JPanel)
		this.setContentPane(p);
		this.setVisible(true);		
	}
	
}
