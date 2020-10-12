package appconnectdb;

import couchdbtasks.couchdbconnect;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


import couchdbtasks.couchdbconnect;

public class testconnectdb {
	Gson gson = new Gson();
	
    Map<String, Object> map = new HashMap<String, Object>();
    Map<String, Object> cardobj = new HashMap<String, Object>();
    
    //all entities
    public class jsonRes {
    	public int total_rows;
    	public int offset;
    	public jsonObj[] rows;
    }
    public class jsonObj {
    	public String id;
    	public String key;
    	public objCardVal value;
    	public objCardDoc doc;
    }
    public class objCardVal {
    	public String _id;
    	public String _rev;
    	public objCard card;
    }
    public class objCardDoc {
    	public String _id;
    	public String _rev;
    	public objCard card;
    }
    public class objCard {
    	public String cardname;
    	public String cardrole;
    }
    
    @Test
    public void connectJUDB() throws InterruptedException, IOException {
    	//connect to db
    	String DBconnectStatus = couchdbconnect.doconnect();
	    
    	//get all data from db
    	String DBurl = "http://juad:ju123@3.0.94.172:5984/judb/_all_docs?include_docs=true";
    	String jsonOut = couchdbpost.httppost(DBurl,"GET","{}");
    	jsonRes ResVar = gson.fromJson(jsonOut, jsonRes.class);
	    
    	//show result all data from db
    	System.out.println("All doc from JUDB with count: "+ ResVar.total_rows);
    	for (int i=0; i < ResVar.rows.length ; i++)
        {  
    		System.out.println("Rec: "+ i + " has Name:" + ResVar.rows[i].doc.card.cardname);
    		System.out.println("Rec: "+ i + " has Role:" + ResVar.rows[i].doc.card.cardrole);
    		
        }
   
    	//update old record
    	map = new HashMap<String, Object>();
    	map.put("_id", ResVar.rows[0].doc._id);
    	map.put("_rev", ResVar.rows[0].doc._rev);
    	map.put("card", cardobj);
    	couchdbconnect.couchdbclientJUDBupdate(map);
    	
    	//insert new record
    	//build obj new record
    	cardobj = new HashMap<String, Object>();
    	cardobj.put("cardname", "toto");
    	cardobj.put("cardrole", "toto");
    	map = new HashMap<String, Object>();
    	map.put("card", cardobj);
    	couchdbconnect.couchdbclientJUDBsave(map);
	   
    	//Testcase PASS/FAIL
    	//check connection
    	Assert.assertEquals("Connected to DB JUDB!", DBconnectStatus);
    }

    
}