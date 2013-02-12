package org.pasut.games.guerra.domain;

public interface Placeable {
	double getLat();
	double getLon();
	LatLong getPosition();
	void setPosition(LatLong position);
}
