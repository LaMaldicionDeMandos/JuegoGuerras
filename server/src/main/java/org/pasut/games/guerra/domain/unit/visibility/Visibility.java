package org.pasut.games.guerra.domain.unit.visibility;

import org.pasut.games.guerra.domain.Placeable;

public interface Visibility extends Placeable{
	boolean isVisible(Visibility visibility);
	double getRatio();
	int getLevel();
}


