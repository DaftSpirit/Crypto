package crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Crypter {
	
	private Key sKey;

	//private String target;
	/**
	 * Generate the key with the password using the RC4 algorithm
	 * @param password: password of the user
	 * @throws NoSuchAlgorithmException
	 */
	public Crypter(String password) throws NoSuchAlgorithmException{
		//this.target=aTarget;
		this.sKey=new SecretKeySpec(password.getBytes(),"RC4");
	}

	/**
	 * Encrypt the String
	 * @param name: name of the event
	 * @return The encrypted String as a byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] encrypt(String name) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		  // Getting a Cipher instanciation specialised in the RC4 algorithm
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation of the crypter to crypt with the sKey
		   rc4.init(Cipher.ENCRYPT_MODE, this.sKey);
		   // Crypting the String
		   // The crypting object will be initialised after the call.
		   return rc4.doFinal(name.getBytes());		
	}
	
	/**
	 * Decrypt the String
	 * @param buffer: the encrypted String
	 * @return The decrypted String
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypt(byte[] buffer) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		// Getting a Cipher instanciation specialised in the RC4 algorithm
		Cipher rc4 = Cipher.getInstance("RC4");
		// Getting the decrypting key
		// Initialisation of the crypter to decrypt with the decrypting key
	    rc4.init(Cipher.DECRYPT_MODE, this.sKey);
	    byte[] plainText = rc4.doFinal(buffer);
	    return new String(plainText);	    
	}
	
}
