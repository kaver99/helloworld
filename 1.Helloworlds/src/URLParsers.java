import java.net.MalformedURLException;
import java.net.URL;

public class URLParsers {

	public static void main(String[] args) {
	    final String urlString = "http://127.0.0.1:8080/blah";
	    URL url = null;
	    
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    final String host = url.getHost();
	    
	    System.out.println("HOST : " + host);
		
		
	}
	
}
