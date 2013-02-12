package org.pasut.games.guerra.domain.unit.visibility;

import org.pasut.games.guerra.domain.LatLong;

public abstract class AbstractVisibility implements Visibility {
	protected LatLong position;
	protected double ratio;
	protected int level;

	protected AbstractVisibility(){}
	
	public AbstractVisibility(double lat, double lon, double ratio, int level){
		this(new LatLong(lat, lon), ratio, level);
	}
	
	public AbstractVisibility(LatLong position, double ratio, int level){
		this.position = position;
		this.ratio = ratio;
		this.level = level;
	}
	
	public boolean isVisible(Visibility visibility) {
		double distance = LatLong.distance(this.getPosition(), visibility.getPosition());
		return distance < visibility.getRatio() && this.level <= visibility.getLevel();
	}
	
	public final double getLat(){
		return position.getLat();
	}
	
	public final double getLon(){
		return position.getLon();
	}
	
	public final LatLong getPosition(){
		return position;
	}
	
	public final double getRatio(){
		return this.ratio;
	}
	
	public final int getLevel(){
		return this.level;
	}
	
	public void setPosition(LatLong position) {
		this.position = position;
		
	}

}
