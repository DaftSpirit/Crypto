package crypto;

import java.util.Date;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Event {
		
	private SecretKey sKey;
	
	private String name;
	private String description;
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
		this.setDescription("default event description");
		this.crypted = false;
		this.date = new Date();	//unix time, initialized at the time of creation
		this.sKey = key();
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
		this.setDescription("default event description");
		this.date = new Date();
		this.crypted = crypted;
		this.sKey = key();
		
	}
	
	/**
	 * constructor used by gui for the typical use
	 * @param name : the name of the event
	 * @param date : date of event
	 * @param crypted : if the event is crypted or not
	 * @throws NoSuchAlgorithmException 
	 */
	public Event(String name, String description, Date date, boolean crypted) throws NoSuchAlgorithmException
	{
		this.crypted = crypted;
		this.name = name;
		this.setDescription(description);
		this.date = date;
		this.sKey = key();
	}
	
	private SecretKey key() throws NoSuchAlgorithmException{
		// Obtention d'un générateur de clés pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Spécification longueur de la clé
		kg.init(128);
		// Génération de la clé secrète
		return kg.generateKey();
		
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public SecretKey getKey(){
		return sKey;
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

	/**
	 * author : Axel
	 * J'ai copié chapitre II du cour : Chiffrage du contenu d'un String avec RC4
	 * Aprés faut voir comment décrypter ce qui est crypter.( sauvegarder la clé avec un return ou une donn�e membre ?)
	 */
	
	private void encryptName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		   // Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation du chiffreur en mode chiffrage avec la clé sKey
		   rc4.init(Cipher.ENCRYPT_MODE, sKey);
		   // Chiffrage du contenu du String. Au retour de l'appel
		   // l'objet chiffreur sera remis en son état initial
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
		
	private void decryptDate() {
		// TODO Auto-generated method stub
		
	}

	private void decryptName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] buffer = name.getBytes();
		// Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		Cipher rc4 = Cipher.getInstance("RC4");
		//Obtention de la clé de décryptage
		Key decryptionKey = new SecretKeySpec(sKey.getEncoded(), sKey.getAlgorithm());
		// Initialisation du chiffreur en mode dechiffrage avec la clé decryptKey
	    rc4.init(Cipher.DECRYPT_MODE, decryptionKey);
	    byte[] plainText = rc4.doFinal(buffer);
	    name = new String(plainText);	    
	}

	@Override
	public String toString() {
			return "Event [name=" + name + ", description=" +description +", date=" + date.toString() + ", crypted="
					+ crypted + "]";	

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
