package org.pasut.games.guerra.services;

import java.util.ArrayList;
import java.util.List;

import org.pasut.games.guerra.domain.Country;
import org.pasut.games.guerra.domain.LatLong;
import org.pasut.games.guerra.domain.unit.CenterFlag;
import org.pasut.games.guerra.domain.unit.CentralBase;
import org.pasut.games.guerra.domain.unit.Unit;
import org.pasut.persister.PersisterService;
import org.pasut.persister.operators.Equal;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class UnitService {
	private final PersisterService db;
	private final List<Class<? extends Unit>> unitTypes;
	
	@Inject
	public UnitService(PersisterService db){
		this.db = db;
		unitTypes = new ArrayList<Class<? extends Unit>>();
		unitTypes.add(CenterFlag.class);
		unitTypes.add(CentralBase.class);
	}
	
	public List<Unit> findUnits(String countryCode){
		List<Unit> list = new ArrayList<Unit>(); 
		for(Class<? extends Unit> clazz : unitTypes){
			List<? extends Unit> units = db.find(clazz, new Equal("countryCode", countryCode));
			list.addAll(units);
		}
		return list;
	}
	
	public Country buyCentralBase(String countryCode, int level, double lat, double lon){
		Country country = db.find(Country.class, new Equal("code", countryCode)).get(0);
		CentralBase cb = new CentralBase(countryCode, countryCode + "Central Base", new LatLong(lat, lon), level);
		db.insert(cb);
		country.addDynamicCost(cb.getCost());
		db.update(country);
		return country;
	}
}
