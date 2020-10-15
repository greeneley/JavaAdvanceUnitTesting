package lightcouchdb;

import org.lightcouch.CouchDbClient;

public class startLightCouchDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CouchDbClient dbClient = new CouchDbClient("db-name", true, "http", "127.0.0.1", 5984, "username", "secret");
		
	}

}
