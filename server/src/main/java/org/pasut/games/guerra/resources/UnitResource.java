package org.pasut.games.guerra.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pasut.games.guerra.domain.Country;
import org.pasut.games.guerra.domain.unit.Unit;
import org.pasut.games.guerra.services.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("unit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UnitResource {
	private static Logger log = LoggerFactory.getLogger(UnitResource.class);
	
	private final UnitService service;
	
	@Inject
	public UnitResource(UnitService service){
		this.service = service;
	}
	
	@GET
	@Path("get/{code}")
	public List<Unit> get(@PathParam("code") String countryCode){
		log.info(String.format("Finding units to %s", countryCode));
		List<Unit> list = service.findUnits(countryCode);
		log.info(String.format("Found %d units", list.size()));
		return list;
	}
	
	@POST
	@Path("buy/centralBase/{code}/{level}/{lat}/{lon}")
	public Country buyCentralBase(	@PathParam("code") String countryCode, 
									@PathParam("level") int level,
									@PathParam("lat") double lat,
									@PathParam("lon") double lon
									){
		log.info(String.format("Buy Central Base level %d to country %s", level, countryCode));
		return service.buyCentralBase(countryCode, level, lat, lon);
	}
}
