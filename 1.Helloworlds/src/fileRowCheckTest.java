import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class fileRowCheckTest {

    public static void main(String[] args) throws IOException {
        int lineCnt = 0;
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
         
        File file = fc.getSelectedFile();
        BufferedReader in = null; 
        try {
            in = new BufferedReader(new FileReader(file));
            in.toString().trim(); 
            
            while(in.readLine() != null) {
                lineCnt++;
            }

        } catch(Exception ex) { ex.printStackTrace();   
        } finally {
        	in.close();
		}
         
        System.out.println(lineCnt);
    }
	
}
