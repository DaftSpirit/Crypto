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
		// Obtention d'un g�n�rateur de cl�s pour RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		// Sp�cification longueur de la cl�
		kg.init(128);
		// G�n�ration de la cl� secr�te
		return kg.generateKey();
		
	}

	public byte[] encrypt(String name) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		  // Obtention d'une instance de Cipher sp�cialis�e pour l'algorithme RC4
		   Cipher rc4 = Cipher.getInstance("RC4");
		   // Initialisation du chiffreur en mode chiffrage avec la cl� sKey
		   rc4.init(Cipher.ENCRYPT_MODE, this.sKey);
		   // Chiffrage du contenu du String. Au retour de l'appel
		   // l'objet chiffreur sera remis en son �tat initial
		   return rc4.doFinal(name.getBytes());		
	}
	
	public String decrypt(byte[] buffer) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		// Obtention d'une instance de Cipher sp�cialis�e pour l'algorithme RC4
		Cipher rc4 = Cipher.getInstance("RC4");
		//Obtention de la cl� de d�cryptage
		//Key decryptionKey = new SecretKeySpec(this.sKey.getEncoded(), this.sKey.getAlgorithm());
		// Initialisation du chiffreur en mode dechiffrage avec la cl� decryptKey
	    rc4.init(Cipher.DECRYPT_MODE, this.sKey);
	    byte[] plainText = rc4.doFinal(buffer);
	    return new String(plainText);	    
	}
	
}
