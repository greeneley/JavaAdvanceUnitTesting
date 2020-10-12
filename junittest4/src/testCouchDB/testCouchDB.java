package testCouchDB;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import appconnectdb.couchdbpost;
import appconnectdb.testconnectdb.jsonRes;
import couchdbtasks.couchdbconnect;

public class testCouchDB {
	@Test
	public void test_DB_PASS_connectionfirst() throws Exception {
		String DBconnectStatus = couchdbconnect.doconnect();
		Assert.assertEquals("Connected to DB JUDB!", DBconnectStatus);
	}

	@Test
	public void test_DB_PASS_addnew() throws Exception {
		String DBconnectStatus = couchdbconnect.doconnect();
		// add new element
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> cardobj = new HashMap<String, Object>();

		cardobj = new HashMap<String, Object>();
		cardobj.put("cardname", "toto");
		cardobj.put("cardrole", "toto");
		map = new HashMap<String, Object>();
		map.put("card", cardobj);
		couchdbconnect.couchdbclientJUDBsave(map);

		// show result all data from db
		Gson gson = new Gson();
		String DBurl = "http://juad:ju123@3.0.94.172:5984/judb/_all_docs?include_docs=true";
		String jsonOut = couchdbpost.httppost(DBurl, "GET", "{}");
		jsonRes ResVar = gson.fromJson(jsonOut, jsonRes.class);

		// show result all data from db
		System.out.println("All doc from JUDB with count: " + ResVar.total_rows);
		for (int i = ResVar.rows.length - 1; i < ResVar.rows.length; i++) {
			System.out.println("Rec: " + i + " has Name:" + ResVar.rows[i].doc.card.cardname);
			System.out.println("Rec: " + i + " has Role:" + ResVar.rows[i].doc.card.cardrole);
		}

		Assert.assertEquals("Connected to DB JUDB!", DBconnectStatus);

	}

}
