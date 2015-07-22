package com.fengqiliu.test.java;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


public class FileTest {
	
	
		
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\git.txt");
		System.out.println(file.getParentFile());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
//				System.out.println(System.getProperty("user.home"));
//				System.out.println(System.getProperty("java.io.tmpdir"));
//				
//				System.out.println("File.pathSeparator=" + File.pathSeparator);
//				System.out.println("File.pathSeparatorChar=" + File.pathSeparatorChar);
//				System.out.println("File.separator=" + File.separator);
//				System.out.println("File.separatorChar=" + File.separatorChar);
//				System.out.println(File.createTempFile("datamonitor", null).getPath());
				
//				unCompressGZIP(new File("C:\\Users\\Administrator\\AppData\\Local\\Temp\\datamonitor_1503537707770902895.gz"));

	}
	
	private static File unCompressGZIP(File gzipFile){

		File unCompressedFile = null;
		try {
			GZIPInputStream gzi = new GZIPInputStream(new FileInputStream(gzipFile));

			String gzipPath = gzipFile.getPath();
			unCompressedFile = new File(gzipPath.substring(0, gzipPath.lastIndexOf('.')) + ".tmp");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(unCompressedFile));
			int b;
			byte[] buffer = new byte[1024 * 100];

			while ((b = gzi.read(buffer)) > 0) {
				bos.write(buffer, 0, b);
			}
			gzi.close();
			bos.close();
		} catch (Exception err) {
		}
		return unCompressedFile;

	}
}
