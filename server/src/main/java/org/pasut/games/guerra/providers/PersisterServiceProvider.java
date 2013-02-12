package org.pasut.games.guerra.providers;

import org.pasut.persister.MongoPersisterService;
import org.pasut.persister.PersisterService;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class PersisterServiceProvider implements Provider<PersisterService> {
	private final String dbHost;
	private final String dbName;
	private final int dbPort;
	
	private PersisterService service;
	
	@Inject
	public PersisterServiceProvider(@Named("db.host") String dbHost, 
									@Named("db.name") String dbName,
									@Named("db.port") int dbPort){
		this.dbHost = dbHost;
		this.dbName = dbName;
		this.dbPort = dbPort;
		
	}
	
	synchronized public PersisterService get() {
		if(service == null) service = new MongoPersisterService(dbName, dbHost, dbPort); 
		return service;
	}

}
