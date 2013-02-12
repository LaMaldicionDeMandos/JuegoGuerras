package org.pasut.games.guerra.services;

import org.pasut.games.guerra.domain.Country;
import org.pasut.games.guerra.domain.LatLong;
import org.pasut.games.guerra.domain.unit.CenterFlag;
import org.pasut.persister.PersisterService;
import org.pasut.persister.operators.Equal;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CountryService {
	private final PersisterService db;
	
	@Inject
	public CountryService(PersisterService db){
		this.db = db;
	}
	
	public Country newCountry(Country country){
		country = db.insert(country);
		CenterFlag flag = new CenterFlag(country.getCode(), country.getCode() + " Center", new LatLong(country.getLat(), country.getLon()));
		db.insert(flag);
		return country;
	}
	
	public Country get(String countryCode){
		Country country = db.find(Country.class, new Equal("code", countryCode)).get(0);
		return country;
	}
}
