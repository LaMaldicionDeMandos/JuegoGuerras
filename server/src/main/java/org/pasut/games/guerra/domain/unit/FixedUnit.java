package org.pasut.games.guerra.domain.unit;


public abstract class FixedUnit extends Unit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5124426629483299994L;
	
	public FixedUnit(){}
	
	public FixedUnit(String countryCode, String name, String type){
		super(countryCode, name, type);
	}
	
	@Override
	public int getSpeed(){
		return 0;
	}

}
