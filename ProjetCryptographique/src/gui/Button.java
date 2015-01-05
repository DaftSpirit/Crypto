package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

/**
 * class bouton extends JButton
 * 
 * @author Axel
 */

public class Button extends JButton implements MouseListener {

	private String name;
	private JFrame f;
	private JPasswordField pw;

	// le mot de passe se trouve ici -> il faudra bien sur le déplacer
	private String password = "motdepasse";

	/**
	 * public Bouton(String,JFrame,JPassword)
	 * 
	 * @param str
	 *            : name of button
	 * @param f
	 *            : Jframe reference contains Bouton
	 * @param pw
	 *            : Jpassword reference contain the user password
	 */

	public Button(String str, JFrame f, JPasswordField pw) {
		super(str);
		this.name = str;
		this.f = f;
		this.pw = pw;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (new String(pw.getPassword()).equals(password)) {
			Agenda a = new Agenda();
			f.dispose();
		} else
			this.setText("Mot de passe incorrect");
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
