package crypto;

import java.util.Date;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class EventCrypter {

	private SecretKey Key;
	private String password = "password";
	private byte[] cryptedName;

	private String name;
	private String description;
	private Date date;
	private boolean crypted;

	/**
	 * public Event() default constructor for non crypted events
	 * 
	 * @param null
	 * @throws NoSuchAlgorithmException
	 */
	public EventCrypter() throws NoSuchAlgorithmException {
		this.name = "default event";
		this.setDescription("default event description");
		this.crypted = false;
		this.date = new Date(); // unix time, initialized at the time of
								// creation
		//this.Key = key();
	}

	/**
	 * public Event(boolean) debug constructor for tests and debug
	 * 
	 * @param crypted
	 *            defines if the event is crypted or not
	 * @throws NoSuchAlgorithmException
	 */
	public EventCrypter(boolean crypted) throws NoSuchAlgorithmException {
		this.name = "debug event";
		this.setDescription("default event description");
		this.date = new Date();
		this.crypted = crypted;
		//this.Key = key();
	}

	/**
	 * constructor used by gui for the typical use
	 * 
	 * @param name
	 *            : the name of the event
	 * @param date
	 *            : date of event
	 * @param crypted
	 *            : if the event is crypted or not
	 * @throws NoSuchAlgorithmException
	 */
	public EventCrypter(String name, String description, Date date, boolean crypted)
			throws NoSuchAlgorithmException {
		this.crypted = crypted;
		this.name = name;
		this.setDescription(description);
		this.date = date;
		//this.sKey = key();
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * @return the name of event
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return true if is crypted
	 */
	public boolean isCrypted() {
		return this.crypted;
	}

	public void encrypt() throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		encryptName();
		encryptDate();
		System.out.println("encrytp");
		this.crypted = true;
	}

	private void encryptDate() {
		// TODO Auto-generated method stub

	}

	/**
	 * @author scrutch
	 * Instanciate the crypted name and put its result in the variable name
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private void encryptName() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		Crypter cr = new Crypter(password);
		cryptedName = cr.encrypt(this.name);
		this.name = cryptedName.toString();
		//System.out.println(cryptedName);
		//System.out.println(name);
	}
	
	/**
	 * @author scrutch
	 * Takes the crypted name, decrypts it and put it in the variable name
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 */
	public void decrypt() throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException {
		decryptName();
		decryptDate();
		System.out.println("decrytp");
		this.crypted = false;
	}

	private void decryptDate() {
		// TODO Auto-generated method stub

	}

	private void decryptName() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException {
		Crypter cr = new Crypter(password);
		String decryptingName = cr.decrypt(cryptedName);
		//System.out.println(decryptingName);
		this.name = decryptingName;
		//System.out.println(name);
		/*
		byte[] buffer = name.getBytes();
		// Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		Cipher rc4 = Cipher.getInstance("RC4");
		// Obtention de la clé de décryptage
		Key decryptionKey = new SecretKeySpec(sKey.getEncoded(),
				sKey.getAlgorithm());
		// Initialisation du chiffreur en mode dechiffrage avec la clé
		// decryptKey
		rc4.init(Cipher.DECRYPT_MODE, decryptionKey);
		byte[] plainText = rc4.doFinal(buffer);
		name = new String(plainText);
		*/
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", description=" + description
				+ ", date=" + date.toString() + ", crypted=" + crypted + "]";

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
