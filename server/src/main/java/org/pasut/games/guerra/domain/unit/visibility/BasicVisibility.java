package org.pasut.games.guerra.domain.unit.visibility;

import org.pasut.games.guerra.domain.LatLong;
import org.pasut.persister.Entity;

@Entity("test")
public class BasicVisibility extends AbstractVisibility {
	protected VisibilityType type;
	
	public BasicVisibility(){}
	
	public BasicVisibility(double lat, double lon, double ratio, int level){
		super(lat, lon, ratio, level);
		type = VisibilityType.BASIC;
	}
	
	public BasicVisibility(LatLong position, double ratio, int level){
		super(position, ratio, level);
		type = VisibilityType.BASIC;
	}
	
	public VisibilityType getType(){
		return type;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof BasicVisibility)) return false;
		BasicVisibility v = (BasicVisibility)o;
		return this.getPosition().equals(v.getPosition()) && this.getRatio()==v.getRatio() && this.getLevel()==v.getLevel() && this.getType().equals(v.getType());
	}
	
	@Override
	public int hashCode(){
		return Double.valueOf(this.getLat()*this.getLon()*this.getRatio()*this.getLevel()*this.getType().getType()).intValue();
	}
}
