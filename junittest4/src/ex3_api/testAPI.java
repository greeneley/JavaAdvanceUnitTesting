package ex3_api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.gson.Gson;

import appconnectdb.couchdbpost;

@FixMethodOrder(MethodSorters.DEFAULT.NAME_ASCENDING)

public class testAPI {
	Gson gson = new Gson();
	public static String keytoken = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> cardobj = new HashMap<String, Object>();
	/*
	{
	    "rep": {
	        "result": "0",
	        "message": {
	            "trans": "txtid: 3bdd3384163d71df59ee444d7f93c26096e073b785741a60c1c89d9777aea024",
	            "msg": "Transaction [Set qualifications [a#c#e#]#m@2] has been submitted to blockchain"
	        }
	    }
	}*/
	// update card reply
	public class jsonRep2 {
		public objRep2 rep;
	}

	public class objRep2 {
		public String result;
		public messageObj2 message;
	}

	public class messageObj2 {
		public String trans;
		public String msg;
	}
	/*
	 * { "rep": { "result": "0", "message": { "token":
	 * "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Im1AMiIsImlhdCI6MTYwMjQ5MDAyNCwiZXhwIjoxNjAyNTA0NDI0fQ.FumIwCp3Ha6TdqgKYhAfKLDnk3zLMWzJUTJ5FUkkypA",
	 * "rule": 0, "id": "m@2", "card": [ { "type": "1", "lic": "a", "exp":
	 * "2020-07-29" }, { "type": "1", "lic": "b", "exp": "2020-07-18" }, { "type":
	 * "2", "lic": "c", "exp": "2020-07-29" }, { "type": "2", "lic": "d", "exp":
	 * "2020-07-29" }, { "type": "2", "lic": "e", "exp": "2020-07-29" } ],
	 * "cardset": "a#c#e#", "scanner": "" } } }
	 */
	// login reply
	public class jsonRep {
		public objRep rep;
	}

	public class objRep {
		public String result;
		public messageObj message;
	}

	public class messageObj {
		public String token;
		public int rule;
		public String id;
		public objCardVal[] card;
		public String cardset;
		public String scanner;

	}

	public class objCardVal {
		public String type;
		public String lic;
		public String exp;
	}

	@Test
	public void test_PASS_API_1() throws InterruptedException, IOException {

		// get all data from db
		String DBurl = "https://afe9033d4a27.ngrok.io/api/loginUser";
		String jsonOut = couchdbpost.httppost(DBurl, "POST", "{\"email\":\"m@2\", \"password\" : \"2\"}");
		jsonRep ResVar = gson.fromJson(jsonOut, jsonRep.class);

		// show result all data from db
		keytoken = ResVar.rep.message.token;
		System.out.println(keytoken);
		System.out.println("Login doc: " + gson.toJson(ResVar));

//		Assert.assertEquals("Connected to DB JUDB!", DBconnectStatus);
	}

	@Test
	public void test_PASS_API_2() throws InterruptedException, IOException {

		// get all data from db
		String DBurl = "https://afe9033d4a27.ngrok.io/api/setcard";

		String jsonOut = couchdbpost.httppost(DBurl, "POST",
				"{\"token\":\"" + keytoken + "\", \"email\":\"m@2\", \"key\":\"a#c#e#\"}");
		jsonRep2 ResVar = gson.fromJson(jsonOut, jsonRep2.class);

		// show result all data from db
//		keytoken = ResVar.rep.message.token;
		System.out.println("Update card doc: " + gson.toJson(ResVar));

	}
}
