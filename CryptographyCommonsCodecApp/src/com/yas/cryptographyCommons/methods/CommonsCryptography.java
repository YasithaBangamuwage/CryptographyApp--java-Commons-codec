package com.yas.cryptographyCommons.methods;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Cryptography using commons codec.
 * 
 * @author YAS
 * @version 1.0
 */
public class CommonsCryptography {

	private static final String UNICODE_FORMAT = "UTF8";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private static final String SECRECT_KEY = "YASCommonsCodecCriptographyKey";
	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	byte[] arrayBytes;
	private String myEncryptionScheme;
	SecretKey key;

	/**
	 * Default constructor.
	 * 
	 * @throws Exception
	 */
	public CommonsCryptography() throws Exception {

		myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		arrayBytes = SECRECT_KEY.getBytes(UNICODE_FORMAT);
		ks = new DESedeKeySpec(arrayBytes);
		skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		cipher = Cipher.getInstance(myEncryptionScheme);
		key = skf.generateSecret(ks);
	}

	/**
	 * Do encryption.
	 * 
	 * @param unencryptedString
	 *            string value to encrypt.
	 * @return encrypted string value.
	 */
	public String commonsEncryption(String unencryptedString) {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encodeBase64(encryptedText));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * Do decryption.
	 * 
	 * @param encryptedString
	 *            encrypted string value.
	 * @return encrypted string value.
	 */
	public String commonsDecryption(String encryptedString) {
		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] es = encryptedString.getBytes();
			byte[] encryptedText = Base64.decodeBase64(es);
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedText;
	}
}
