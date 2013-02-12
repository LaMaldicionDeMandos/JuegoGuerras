package org.pasut.games.guerra.domain.unit.visibility;

public enum VisibilityType {
	BASIC(0),
	ALLWAYS(1);
	
	private final int type;
	
	private VisibilityType(int type){
		this.type = type;
	}
	
	public int getType(){
		return this.type;
	}
	
	public static BasicVisibility build(BasicVisibility visibility){
		switch(visibility.getType()){
		case BASIC:
			return new BasicVisibility(visibility.getPosition(), visibility.getRatio(), visibility.getLevel());
		case ALLWAYS:
			return new AllwaysVisibleVisibility(visibility.getPosition());
		}
		return null;
	}
}
