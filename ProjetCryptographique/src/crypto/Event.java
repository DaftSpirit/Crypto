package crypto;

import java.util.Date;
import java.security.*;

import javax.crypto.*;

public class Event {
	
	private byte[] nameCrypted;
	
	private String name;
	private Date date;
	private boolean crypted;
	
	/**
	 * 	public Event()
	 * 	default constructor for non crypted events
	 * 	@param null
	 */
	public Event()
	{
		this.name = "default event";
		this.crypted = false;
		this.date = new Date();	//unix time, initialized at the time of creation
	}
	
	/**
	 * public Event(boolean)
	 * debug constructor for tests and debug
	 * @param crypted defines if the event is crypted or not
	 */
	public Event(boolean crypted)
	{
		this.name = "debug event";
		this.date = new Date();
		this.crypted = crypted;
	}
	
	/**
	 * constructor used by gui for the typical use
	 * @param name : the name of the event
	 * @param date : date of event
	 * @param crypted : if the event is crypted or not
	 */
	public Event(String name, Date date, boolean crypted)
	{
		this.crypted = crypted;
		this.name = name;
		this.date = date;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isCrypted()
	{
		return this.crypted;
	}
	
	public void encrypt() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		encryptName();
		encryptDate();
		System.out.println("encrytp");
	}

	private void encryptDate() 
	{
		// TODO Auto-generated method stub
		
	}

	/*
	 * author : Axel
	 * J'ai copié chapitre II du cour : Chiffrage du contenu d'un String avec RC4
	 * Après faut voir comment décrypter ce qui est crypter.( sauvegarder la clé avec un return ou une donnée membre ?)
	 */
	
	private void encryptName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		// Obtention d'un générateur de clés pour RC4
		   KeyGenerator kg = KeyGenerator.getInstance("RC4");
		   // Spécification longueur de la clé
		   kg.init(128);
		   // Génération de la clé secrète
		   SecretKey sKey = kg.generateKey();
		   // Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation du chiffreur en mode chiffrage avec la clé sKey
		   rc4.init(Cipher.ENCRYPT_MODE, sKey);
		   // Chiffrage du contenu du String. Au retour de l'appel
		   // l'objet chiffreur sera remis en son état initial
		   byte[] c5 = rc4.doFinal(name.getBytes());		
		   this.nameCrypted = c5;
		   this.crypted = true;
	}			
	
	
	/*
	 * Affiche le name si crypted = false sinon namecrypted
	 * author : Axel
	 */
	
	@Override
	public String toString() {
		if(!this.crypted)
			return "Event [name=" + name + ", date=" + date.toString() + ", crypted="
					+ crypted + "]";
			else
				return "Event [name=" + nameCrypted + ", date=" + date.toString() + ", crypted="
				+ crypted + "]";

	}	

}
