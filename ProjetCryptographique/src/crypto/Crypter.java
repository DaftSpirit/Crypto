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
	
	public Crypter(String password) throws NoSuchAlgorithmException{
		//this.target=aTarget;
		this.sKey=new SecretKeySpec(password.getBytes(),"RC4");
	}
	
	private SecretKey generateSecretKey() throws NoSuchAlgorithmException{
		// Obtention d'un générateur de clés pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Spécification longueur de la clé
		kg.init(128);
		// Génération de la clé secrète
		return kg.generateKey();
		
	}

	public byte[] encrypt(String name) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		  // Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation du chiffreur en mode chiffrage avec la clé sKey
		   rc4.init(Cipher.ENCRYPT_MODE, this.sKey);
		   // Chiffrage du contenu du String. Au retour de l'appel
		   // l'objet chiffreur sera remis en son état initial
		   return rc4.doFinal(name.getBytes());		
	}
	
	public String decrypt(byte[] buffer) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		// Obtention d'une instance de Cipher spécialisée pour l'algorithme RC4
		Cipher rc4 = Cipher.getInstance("RC4");
		//Obtention de la clé de décryptage
		//Key decryptionKey = new SecretKeySpec(this.sKey.getEncoded(), this.sKey.getAlgorithm());
		// Initialisation du chiffreur en mode dechiffrage avec la clé decryptKey
	    rc4.init(Cipher.DECRYPT_MODE, this.sKey);
	    byte[] plainText = rc4.doFinal(buffer);
	    return new String(plainText);	    
	}
	
}
