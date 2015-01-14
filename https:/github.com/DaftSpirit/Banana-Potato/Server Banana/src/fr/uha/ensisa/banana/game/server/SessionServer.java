package fr.uha.ensisa.banana.game.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Collection;

import fr.uha.ensisa.banana.game.model.Account;
import fr.uha.ensisa.banana.game.model.Product;
import fr.uha.ensisa.banana.game.model.User;
import fr.uha.ensisa.banana.network.FileHelper;
import fr.uha.ensisa.banana.network.Protocol;

public class SessionServer {

	private Socket connection;
	private Document document;
	
	public SessionServer (Document document, Socket connection) {
		this.document = document;
		this.connection = connection;
	}
	
	public boolean operate() {
		try {
			Writer writer = new Writer (connection.getOutputStream());
			Reader reader = new Reader (connection.getInputStream());
			reader.receive ();
			switch (reader.getType ()) {
			case 0 : return false; // socket closed
			case -1 :
				break;
			default: return false; // connection jammed
			}
			writer.send ();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
