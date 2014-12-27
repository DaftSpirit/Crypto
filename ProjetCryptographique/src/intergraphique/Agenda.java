package intergraphique;

import javax.swing.JFrame;

public class Agenda extends JFrame{
	
	public Agenda(){
		//JFrame
		this.setTitle("Agenda électronique");
		this.setSize(600,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
}
}
