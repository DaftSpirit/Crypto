package fr.ensisa.hassenforder.game.client;

import java.io.OutputStream;

import fr.uha.ensisa.banana.network.BasicAbstractWriter;
import fr.uha.ensisa.banana.network.Protocol;

public class Writer extends BasicAbstractWriter {

	public Writer(OutputStream outputStream) {
		super (outputStream);
	}

}
