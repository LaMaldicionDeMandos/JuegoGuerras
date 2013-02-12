package org.pasut.games.guerra.modules;

import org.pasut.games.guerra.resources.CountryResource;
import org.pasut.games.guerra.resources.UnitResource;

import com.google.inject.AbstractModule;

public class ResourcesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CountryResource.class);
		bind(UnitResource.class);
	}

}
