package appconnectdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class couchdbpost {
	public static String httppost(String urlpost, String method, String json) throws InterruptedException, IOException {
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = null;
	    HttpGet httpget = null;
	    
	    StringEntity requestEntity = new StringEntity(
	    		json,
	    	    ContentType.APPLICATION_JSON);
	    
	    String strresponse = "";
	    org.apache.http.HttpResponse response = null;
	    //jsonpostresponse resjson = null;
	    try {
	    	
	        if (method == "POST")
	        {
	        	httppost = new HttpPost(urlpost);
	        	httppost.setEntity(requestEntity);
	        	response = httpclient.execute(httppost);
	    	}
	        else if (method == "GET")
	        {	
	        	httpget = new HttpGet(urlpost);
	        	response = httpclient.execute(httpget);
	        }
	        // Execute HTTP Post Request
	        InputStream inputStream = response.getEntity().getContent(); //Get the data in the entity
	        //Reader reader = new InputStreamReader(source);
	        
	        //BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputStream));
	        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
	
	        StringBuilder stringbuilder = new StringBuilder();
	 
	        String currentline = null;
	        
	        try {
	            while ((currentline = bufferedreader.readLine()) != null) {
	            	stringbuilder.append(currentline + "\n");
	            }
	        } catch (IOException e) {
	        	System.out.println("IOException------" + e);
	            e.printStackTrace();
	        }

	        strresponse = stringbuilder.toString();
	        inputStream.close();  
	        
	    } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	    	System.out.println("ClientProtocolException------"+e);
	    }
		return strresponse;
	}
}
