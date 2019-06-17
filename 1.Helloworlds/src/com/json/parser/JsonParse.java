package com.json.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParse {

	/** Json Data **/
	static String jsonData = "{\"books\":[{\"genre\":\"소설\",\"price\":\"100\",\"name\":\"사람은 무엇으로 사는가?\",\"writer\":\"톨스토이\",\"publisher\":\"톨스토이 출판사\"},{\"genre\":\"소설\",\"price\":\"300\",\"name\":\"홍길동전\",\"writer\":\"허균\",\"publisher\":\"허균 출판사\"},{\"genre\":\"소설\",\"price\":\"900\",\"name\":\"레미제라블\",\"writer\":\"빅토르 위고\",\"publisher\":\"빅토르 위고 출판사\"}],\"persons\":[{\"nickname\":\"남궁민수\",\"age\":\"25\",\"name\":\"송강호\",\"gender\":\"남자\"},{\"nickname\":\"예니콜\",\"age\":\"21\",\"name\":\"전지현\",\"gender\":\"여자\"}]}";
	/**
	 * {"books":[
	 * 				{	"genre":"소설"
	 * 				  , "price":"100"
	 * 				  , "name":"사람은 무엇으로 사는가?"
	 *				  , "writer":"톨스토이"
	 *				  , "publisher":"톨스토이 출판사"
	 *				}
	 *			   ,{	"genre":"소설"
	 *				  , "price":"300"
	 *				  , "name":"홍길동전"
	 *				  , "writer":"허균"
	 *				  , "publisher":"허균 출판사"
	 *				}
	 *			   ,{	"genre":"소설"
	 *				  , "price":"900"
	 *				  , "name":"레미제라블"
	 *				  , "writer":"빅토르 위고"
	 *				  , "publisher":"빅토르 위고 출판사"
	 *				}
	 *			]
	 *	, "persons":[
	 *					{	"nickname":"남궁민수"
	 *					  , "age":"25"
	 *					  , "name":"송강호"
	 *					  , "gender":"남자"
	 *					}
	 *				   ,{	"nickname":"예니콜"
	 *					  , "age":"21"
	 *					  , "name":"전지현"
	 *					  , "gender":"여자"
	 *					}
	 *				]
	 * }
	 */
	
	
	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
		try {
			// --------------------------------------------------------------
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
			// --------------------------------------------------------------
			
			JSONObject jsonBookObj  = null;
			// --------------------------------------------------------------
			JSONArray jsonBookArr = (JSONArray) jsonObject.get("books");
			
			for(int i = 0; i < jsonBookArr.size(); i++) {
				jsonBookObj = (JSONObject) jsonBookArr.get(i);
				
				System.out.println(jsonBookObj.get("name"));
				
			}
			// --------------------------------------------------------------
			
			System.out.println("--------------------------------------------------------------");
			
			JSONObject jsonPersonObj = null;
			// --------------------------------------------------------------
			JSONArray jsonPersonsArr = (JSONArray) jsonObject.get("persons");
			
			for(int i = 0; i < jsonPersonsArr.size(); i++) {
				jsonPersonObj = (JSONObject) jsonPersonsArr.get(i);
				
				System.out.println(jsonPersonObj.get("nickname"));
				
			}
			// --------------------------------------------------------------
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
