package fr.ensisa.hassenforder.game.client;

import java.io.InputStream;

import fr.uha.ensisa.banana.network.BasicAbstractReader;
import fr.uha.ensisa.banana.network.Protocol;

public class Reader extends BasicAbstractReader {

	public Reader(InputStream inputStream) {
		super (inputStream);
	}

	public void receive() {
		type = readInt ();
		switch (type) {
		case 0:
			break;
		}
	}

}
