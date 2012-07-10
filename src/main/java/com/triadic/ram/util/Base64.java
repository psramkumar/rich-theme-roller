/**
 * 
 */
package com.triadic.ram.util;

/**
 * @author Z926568
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;


/** Code written, owned, and licensed by TransitTrack, Inc dba Uduwa **/

public class Base64 {

	/**
	 * ALTERNATIVES
	 * 
	 * Apache Commons Codec project will do the job.
	 * 
	 * byte[] bytes = loadFile(file); //all chars in encoded are guaranteed to
	 * be 7-bit ASCII byte[] encoded = Base64.encodeBase64(bytes); String
	 * printMe = new String(encoded, "US-ASCII"); System.out.println(printMe);
	 * byte[] decoded = Base64.decodeBase64(encoded);
	 * 
	 * 
	 */

	public static byte[] decode(String input) throws SecurityException {
		try {
			byte[] decoded = DatatypeConverter.parseBase64Binary(input);
			return decoded;
		} catch (Exception e) {
			throw new SecurityException(e.getMessage(), e);
		}
		// alternative can use
	}

	public static String encode(byte[] input) throws SecurityException {
		try {
			String encoded = DatatypeConverter.printBase64Binary(input);
			return encoded;
		} catch (Exception e) {
			throw new SecurityException(e.getMessage(), e);
		}
		// alternative can use
	}

	public static void main(String arg[]) throws Exception {
		File f = new File("C:/Users/Z926568/Downloads/HTMLTemplates/images/global/ul_bullet.gif");
		System.out.println(encode(getBytesFromFile(f)));
	}

	private  static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();

		if (length > Integer.MAX_VALUE) {
		}

		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "	+ file.getName());
		}
		is.close();
		return bytes;
	}

}




