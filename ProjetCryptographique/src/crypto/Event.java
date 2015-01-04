package crypto;

import java.util.Date;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Event {
		
	private SecretKey sKey;
	
	private String name;
	private Date date;
	private boolean crypted;
	
	/**
	 * 	public Event()
	 * 	default constructor for non crypted events
	 * 	@param null
	 * @throws NoSuchAlgorithmException 
	 */
	public Event() throws NoSuchAlgorithmException
	{
		this.name = "default event";
		this.crypted = false;
		this.date = new Date();	//unix time, initialized at the time of creation
		// Obtention d'un g�n�rateur de cl�s pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Sp�cification longueur de la cl�
		kg.init(128);
		// G�n�ration de la cl� secr�te
		this.sKey = kg.generateKey();
	}
	
	/**
	 * public Event(boolean)
	 * debug constructor for tests and debug
	 * @param crypted defines if the event is crypted or not
	 * @throws NoSuchAlgorithmException 
	 */
	public Event(boolean crypted) throws NoSuchAlgorithmException
	{
		this.name = "debug event";
		this.date = new Date();
		this.crypted = crypted;
		// Obtention d'un g�n�rateur de cl�s pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Sp�cification longueur de la cl�
		kg.init(128);
		// G�n�ration de la cl� secr�te
		this.sKey = kg.generateKey();
	}
	
	/**
	 * constructor used by gui for the typical use
	 * @param name : the name of the event
	 * @param date : date of event
	 * @param crypted : if the event is crypted or not
	 * @throws NoSuchAlgorithmException 
	 */
	public Event(String name, Date date, boolean crypted) throws NoSuchAlgorithmException
	{
		this.crypted = crypted;
		this.name = name;
		this.date = date;
		// Obtention d'un g�n�rateur de cl�s pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Sp�cification longueur de la cl�
		kg.init(128);
		// G�n�ration de la cl� secr�te
		this.sKey = kg.generateKey();
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
		this.crypted = true;
	}

	private void encryptDate() 
	{
		// TODO Auto-generated method stub
		
	}

	/*
	 * author : Axel
	 * J'ai copi� chapitre II du cour : Chiffrage du contenu d'un String avec RC4
	 * Apr�s faut voir comment d�crypter ce qui est crypter.( sauvegarder la cl� avec un return ou une donn�e membre ?)
	 */
	
	private void encryptName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		   // Obtention d'une instance de Cipher sp�cialis�e pour l'algorithme RC4
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation du chiffreur en mode chiffrage avec la cl� sKey
		   rc4.init(Cipher.ENCRYPT_MODE, sKey);
		   // Chiffrage du contenu du String. Au retour de l'appel
		   // l'objet chiffreur sera remis en son �tat initial
		   byte[] c5 = rc4.doFinal(name.getBytes());		
		   this.name = new String(c5);
	}			
	
	public void decrypt() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
	{
		decryptName();
		decryptDate();
		System.out.println("decrytp");
		this.crypted = false;
	}
	
	/*
	 * Affiche le name si crypted = false sinon namecrypted
	 * author : Axel
	 */
	
	private void decryptDate() {
		// TODO Auto-generated method stub
		
	}

	private void decryptName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] buffer = name.getBytes();
		// Obtention d'une instance de Cipher sp�cialis�e pour l'algorithme RC4
		Cipher rc4 = Cipher.getInstance("RC4");
		//Obtention de la cl� de d�cryptage
		Key decryptionKey = new SecretKeySpec(sKey.getEncoded(), sKey.getAlgorithm());
		// Initialisation du chiffreur en mode dechiffrage avec la cl� decryptKey
	    rc4.init(Cipher.DECRYPT_MODE, decryptionKey);
	    byte[] plainText = rc4.doFinal(buffer);
	    name = new String(plainText);	    
	}

	@Override
	public String toString() {
			return "Event [name=" + name + ", date=" + date.toString() + ", crypted="
					+ crypted + "]";	

	}	

}
