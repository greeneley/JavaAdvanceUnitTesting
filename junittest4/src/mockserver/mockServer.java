package mockserver;

import java.io.IOException;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.integration.ClientAndServer;


public class mockServer { 
    //private static MockServerClient mockServer;

    public void testapi_POST() throws IOException {   
    	ClientAndServer mockClient = new ClientAndServer(5000);
    	try {
    		mockClient.when(HttpRequest.request().withMethod("GET"))
    				.respond(HttpResponse.response().withStatusCode(700).withBody("1"));
//    		HttpClient httpClient = new HttpClient();
//    		boolean rs = false;
//    		try {
//    			assertEquals(1, httpClient.post("http://localhost:5000/hs", "1", TestDemo.class).getT());
//    		} catch (Exception e) {
//    			rs = true;
//    		}
//    		assertEquals(true, rs);
    	} finally {
    		mockClient.stop(true);
    	}
		
    }
}