package intergraphique;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class Bouton extends JButton implements MouseListener{

	  private String name;
	  private String password="motdepasse";		
	  private JFrame f;
	  private JPasswordField pw;
			  
	  public Bouton(String str, JFrame f, JPasswordField pw){
	    super(str);
	    this.name = str;
	    this.f=f;
	    this.pw=pw;
	    this.addMouseListener(this);
	  }

	@Override
	public void mouseClicked(MouseEvent arg0) {			
		if(new String(pw.getPassword()).equals(password))
		{
			Agenda a = new Agenda();
			f.dispose();
		}		
		else this.setText("Mot de passe incorrect");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setText("Sign In");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub			
	}
	    
}

