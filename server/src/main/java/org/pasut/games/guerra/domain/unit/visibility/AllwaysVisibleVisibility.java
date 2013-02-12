package org.pasut.games.guerra.domain.unit.visibility;

import org.pasut.games.guerra.domain.LatLong;
import org.pasut.persister.Entity;

@Entity("test")
public class AllwaysVisibleVisibility extends BasicVisibility {
	
	public AllwaysVisibleVisibility(){}
	
	public AllwaysVisibleVisibility(double lat, double lon){
		super(lat, lon, 0, 0);
		type = VisibilityType.ALLWAYS;
	}
	
	public AllwaysVisibleVisibility(LatLong position){
		super(position, 0, 0);
		type = VisibilityType.ALLWAYS;
	}
	
	@Override
	public boolean isVisible(Visibility visibility){
		return true;
	}
	
	@Override
	public VisibilityType getType(){
		return this.type;
	}
}
