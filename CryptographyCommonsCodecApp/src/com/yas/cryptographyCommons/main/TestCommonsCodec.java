package com.yas.cryptographyCommons.main;

import com.yas.cryptographyCommons.methods.CommonsCryptography;

/**
 * Test commons codec cryptography.
 * @author YAS
 *@version 1.0
 */
public class TestCommonsCodec {

	public static void main(String[] args) throws Exception {

		CommonsCryptography cCripto= new CommonsCryptography();

	        String target="THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
	        String encrypted=cCripto.commonsEncryption(target);
	        String decrypted=cCripto.commonsDecryption(encrypted);

	        System.out
			.println("==================Commons codec Cryptography start=============================");
	        System.out.println("Input text      : "+ target);
	        System.out.println("After encrypted : " + encrypted);
	        System.out.println("After decrypted : " + decrypted);
	        System.out
			.println("==================Commons codec Cryptography end===============================");
	}

}
