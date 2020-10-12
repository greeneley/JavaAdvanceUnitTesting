package mockserver;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.jetty.client.HttpClient;
import org.junit.Test;

public class testMockServer {
    @Test
    public void test_MockServer() throws IOException {   

    	mockServer myMockServer = new mockServer();
    	myMockServer.testapi_POST();
    	
    	
		HttpClient httpClient = new HttpClient();
		boolean rs = false;
		
		try {
			
			assertEquals("1", httpClient.GET("http://localhost:5000/hs"));
		} catch (Exception e) {
			rs = true;
		}
		assertEquals(true, rs);
		
    }
}
