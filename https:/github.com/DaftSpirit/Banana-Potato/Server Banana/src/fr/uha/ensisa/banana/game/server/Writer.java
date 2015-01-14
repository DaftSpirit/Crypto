package fr.uha.ensisa.banana.game.server;

import java.io.OutputStream;
import java.util.Collection;

import fr.uha.ensisa.banana.network.BasicAbstractWriter;
import fr.uha.ensisa.banana.network.Protocol;

public class Writer extends BasicAbstractWriter {

	public Writer(OutputStream outputStream) {
		super (outputStream);
	}

}
