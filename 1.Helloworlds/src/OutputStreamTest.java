import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class OutputStreamTest {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		OutputStream out = null;
		
		
		String filePath = "";
		File file = new File(filePath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			int filelen = 0;
			while((filelen = br.read()) != -1) {
				System.out.println(filelen);
			}
			
			br.close();
			out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
