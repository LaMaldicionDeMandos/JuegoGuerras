package org.pasut.games.guerra.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pasut.games.guerra.domain.Country;
import org.pasut.games.guerra.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("country")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class CountryResource {
	private static Logger log = LoggerFactory.getLogger(CountryResource.class);
	
	private final CountryService service;
	
	@Inject
	public CountryResource(CountryService service){
		this.service = service;
	}
	
	@POST
	@Path("new/{code}/{name}/{lat}/{lon}/{pbi}")
	public Country newCountry(@PathParam("code") String code,
								@PathParam("name") String name,
								@PathParam("lat") double lat,
								@PathParam("lon") double lon,
								@PathParam("pbi") double pbi){
		String message = String.format("New Country: {code: %1s, name: %2s, pbi: $%3$.2f}", code, name, pbi);
		Country country = new Country(code,name, pbi, lat, lon);
		country = service.newCountry(country);
		log.info(message);
		return country;
	}
	
	@GET
	@Path("get/{code}")
	public Country get(@PathParam("code") String code){
		log.info(String.format("GET Country: %s", code));
		return service.get(code);
	}
}
