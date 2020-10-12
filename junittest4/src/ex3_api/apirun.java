package ex3_api;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class apirun {
	/*
	 * 1. API Login url api: https://afe9033d4a27.ngrok.io/api/loginUser json format
	 * input: {"email":"m@2", "password" : "2"} json format output: { "rep": {
	 * "result": "0", "message": { "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6Ik...",
	 * "rule": 0, "id": "m@2", "card": [ { "type": "1", "lic": "a", "exp":
	 * "2020-07-29" }, ... ], "cardset": "a#b#c#e#", "scanner": "" } } }
	 * 
	 * 2. API Update Card url api: https://afe9033d4a27.ngrok.io/api/setcard json
	 * format input: { "token":"eyJhbGciOiJIUzI1N...", "email":"m@2", "key":"a#c#e#"
	 * } json format output: { "rep": { "result": "0", "message": { "trans":
	 * "txtid: 0dd4eaff501e...", "msg": "Transaction..." } } }
	 */
	@Test
	public void test_PASS_API_loggin() throws IOException {
//		String expected = "";
//
//        HttpPost post = new HttpPost("https://afe9033d4a27.ngrok.io/api/loginUser");
//        List<NameValuePair> urlParameters = new ArrayList<>();
//        urlParameters.add(new BasicNameValuePair("email", "m@2"));
//        urlParameters.add(new BasicNameValuePair("password", "2"));
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault();
//             CloseableHttpResponse response = httpClient.execute(post)) {
//
//            System.out.println(EntityUtils.toString(response.getEntity()));
//            
//        }
//		assertEquals(expected, "");
		
		
	}
	@Test
	public void test_PASS_API_setcard() throws IOException {
		
	}
	
}
