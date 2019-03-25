package db.com.test;

import java.util.HashMap;
import java.util.Map;

public class DataMain {

	public static void main(String[] args) {
		
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", "test@test.com");
		user.put("socialtype", "local");
		
		DataDAO dataDAO = new DataDAO();
		DataDTO dataDTO = dataDAO.selectData(user);
		
		System.out.println("dataDTO : " + dataDTO.dataToString());
		
		
	}
}
