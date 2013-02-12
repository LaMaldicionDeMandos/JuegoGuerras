package org.pasut.games.guerra.domain.unit;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pasut.games.guerra.domain.GameDate;
import org.pasut.games.guerra.domain.LatLong;
import org.pasut.games.guerra.domain.unit.visibility.Visibility;

public abstract class Unit implements Visibility, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1656265710159397971L;

	private String countryCode;
	private String name;
	private String type;
	protected int speed;
	protected UnitState state = UnitState.UNAVAILABLE;
	protected GameDate date;
	
	public Unit(){}
	
	public Unit(String countryCode, String name, String type){
		this.countryCode = countryCode;
		this.name = name;
		this.type = type;
	}
	
	@JsonProperty("_id")
	abstract String getId();
	
	abstract protected Visibility getVisibility();
	
	public final double getLat(){
		return getVisibility().getLat();
	}
	
	public final double getLon(){
		return getVisibility().getLon();
	}
	
	public final LatLong getPosition(){
		return getVisibility().getPosition();
	}
	
	public final void setPosition(LatLong position){
		getVisibility().setPosition(position);
	}
	
	public boolean isVisible(Visibility visibility) {
		return getVisibility().isVisible(visibility);
	}

	public double getRatio() {
		return getVisibility().getRatio(); 
	}

	public int getLevel() {
		return getVisibility().getLevel();
	}
	
	public final String getCountryCode(){
		return this.countryCode;
	}
	
	public final String getName(){
		return name;
	}
	
	public final String getType(){
		return type;
	}
	
	public final UnitState getState(){
		return state;
	}
	
	public final GameDate getDate(){
		return date;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	abstract double getCost();
	
	abstract double getMaintenance();
	
	abstract int getContructionTime();
}
