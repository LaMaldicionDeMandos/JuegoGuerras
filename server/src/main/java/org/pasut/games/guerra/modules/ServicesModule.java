package org.pasut.games.guerra.modules;

import org.pasut.games.guerra.services.CountryService;
import org.pasut.games.guerra.services.UnitService;

import com.google.inject.AbstractModule;

public class ServicesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CountryService.class);
		bind(UnitService.class);
	}

}
