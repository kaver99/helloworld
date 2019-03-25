import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.mnwise.util.DateUtil;


public class DateTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		GregorianCalendar today = new GregorianCalendar ( ); 
		StringBuffer sbDate = new StringBuffer();
		 
		int year = today.get ( today.YEAR );
		int month = today.get ( today.MONTH ) +1;
		int day = today.get ( today.DAY_OF_MONTH ) - 7; 
		
		sbDate.append ( year );
		if ( month < 10 ) {
			sbDate.append ( "0" );
		}
		sbDate.append ( month );
		if ( day  < 10 ) {
			sbDate.append ( "0" );
		}
		sbDate.append ( day );
		
		System.out.println("Year : " + year);
		System.out.println("Month : " + month);
		System.out.println("Day : " + day);
		

		System.out.println("Date : " + year+month+day);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		int dTime = Integer.parseInt(formatter.format ( currentTime ))-7;
		System.out.println ( dTime ); 
				
		String dddd = DateUtil.dateToString("yyyyMMdd", DateUtil.minusDay(new java.util.Date(), "7"));
		
		System.out.println("dddd : " + dddd);
	}
	
	
}
