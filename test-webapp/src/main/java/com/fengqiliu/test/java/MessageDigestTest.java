package com.fengqiliu.test.java;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        digest();
	}

    private static void digest() throws NoSuchAlgorithmException, DigestException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        int md51 = md.digest("ABCDEa123abc        ".getBytes(),0,"ABCDEa123abc        ".length());
        int md52 = md.digest("ABCDFB123abc        ".getBytes(),0,"ABCDFB123abc        ".length());
        System.out.println(md51);
        System.out.println(md52);
    }

}
