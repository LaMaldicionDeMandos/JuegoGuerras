package org.pasut.games.guerra.services;

import java.util.ArrayList;
import java.util.List;

import org.pasut.games.guerra.domain.unit.CenterFlag;
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
	}
	
	public List<Unit> findUnits(String countryCode){
		List<Unit> list = new ArrayList<Unit>(); 
		for(Class<? extends Unit> clazz : unitTypes){
			List<? extends Unit> units = db.find(clazz, new Equal("countryCode", countryCode));
			list.addAll(units);
		}
		return list;
	}
}
