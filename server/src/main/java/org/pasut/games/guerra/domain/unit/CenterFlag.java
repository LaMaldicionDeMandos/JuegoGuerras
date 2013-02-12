package org.pasut.games.guerra.domain.unit;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pasut.games.guerra.domain.LatLong;
import org.pasut.games.guerra.domain.unit.visibility.AllwaysVisibleVisibility;
import org.pasut.games.guerra.domain.unit.visibility.Visibility;
import org.pasut.persister.Entity;

@Entity("center_flag_unit")
public class CenterFlag extends FixedUnit {
	private final static String TYPE = "CenterFlag";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5648399208170740921L;
	
	@JsonProperty("_id")
	private String id;
	private AllwaysVisibleVisibility visibility;
	public CenterFlag(){}
	
	public CenterFlag(String countryCode, String name, LatLong position){
		super(countryCode, name, TYPE);
		this.state = UnitState.UNAVAILABLE;
		this.speed = 0;
		this.visibility = new AllwaysVisibleVisibility(position);
	}

	@Override
	public Visibility getVisibility() {
		return this.visibility;
	}

	@Override
	public double getCost() {
		return 0;
	}

	@Override
	public double getMaintenance() {
		return 0;
	}

	@Override
	@JsonProperty("_id")
	String getId() {
		return id;
	}

	@Override
	public int getContructionTime() {
		return 0;
	}

}
