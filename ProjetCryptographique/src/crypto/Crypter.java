package crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypter {

	private Key sKey;

	/**
	 * Generate the key with the password using the RC4 algorithm
	 * 
	 * @param password
	 *            : password of the user
	 * @throws NoSuchAlgorithmException
	 */
	public Crypter(String password) throws NoSuchAlgorithmException {
		// this.target=aTarget;
		this.sKey = new SecretKeySpec(password.getBytes(), "RC4");
	}

	/**
	 * Encrypt the Event
	 * 
	 * @param e
	 *            : Event to encrypt
	 * @return Event encrypted
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public EventCrypted encryptEvent(Event e) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		byte[] nameCrypted = encrypt(e.name);
		byte[] descriptionCrypted = encrypt(e.description);
		byte[] dateCrypted = encryptDate(e.date);

		//wipping Event e :
		e=new Event(null, null, null);
		return new EventCrypted(nameCrypted, descriptionCrypted, dateCrypted);
	}

	public Event decryptEvent(EventCrypted ec) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		String name = decrypt(ec.getName());
		String description = decrypt(ec.getDescription());
		Date date = decryptDate(ec.getDate());

		return new Event(name, description, date);
	}

	/**
	 * Encrypt a String
	 * 
	 * @param name
	 *            : name of the event
	 * @return The encrypted String as a byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] encrypt(String name) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// Getting a Cipher instanciation specialised in the RC4 algorithm
		Cipher rc4 = Cipher.getInstance("RC4");
		// Initialisation of the crypter to crypt with the sKey
		rc4.init(Cipher.ENCRYPT_MODE, this.sKey);
		// Crypting the String
		// The crypting object will be initialised after the call.
		return rc4.doFinal(name.getBytes());
	}

	/**
	 * Decrypt a String
	 * 
	 * @param buffer
	 *            : the encrypted String
	 * @return The decrypted String
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private String decrypt(byte[] buffer) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// Getting a Cipher instanciation specialised in the RC4 algorithm
		Cipher rc4 = Cipher.getInstance("RC4");
		// Getting the decrypting key
		// Initialisation of the crypter to decrypt with the decrypting key
		rc4.init(Cipher.DECRYPT_MODE, this.sKey);
		byte[] plainText = rc4.doFinal(buffer);
		return new String(plainText);
	}
	
	/**
	 * Decrypt a date
	 * @param buffer : the encrypted date;
	 * @return A new Date pointing the same time as buffer
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private Date decryptDate(byte[] buffer) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// Getting a Cipher instanciation specialised in the RC4 algorithm
		Cipher rc4 = Cipher.getInstance("RC4");
		// Getting the decrypting key
		// Initialisation of the crypter to decrypt with the decrypting key
		rc4.init(Cipher.DECRYPT_MODE, this.sKey);
		byte[] plainText = rc4.doFinal(buffer);
		String dateTxt = new String(plainText);
		Long date = Long.parseLong(dateTxt);
		return new Date(date);
	}

	/**
	 * Encrypt a date
	 * @param date	: Event date
	 * @return	the encrypted Date as a byte[]
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	private byte[] encryptDate(Date date) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		// Getting a Cipher instanciation specialised in the RC4 algorithm
		Cipher rc4 = Cipher.getInstance("RC4");
		// Getting the decrypting key
		// Initialisation of the crypter to decrypt with the decrypting key
		rc4.init(Cipher.ENCRYPT_MODE, this.sKey);
		// creating a byte[] from date 
		byte[] dateTxt = new Long(date.getTime()).toString().getBytes();
		byte[] plainText = rc4.doFinal(dateTxt);
		return plainText;
	}
}
