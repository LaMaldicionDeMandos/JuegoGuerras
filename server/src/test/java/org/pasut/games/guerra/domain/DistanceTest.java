package org.pasut.games.guerra.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistanceTest {

	@Test
	public void test() {
		Double distance = LatLong.distance(-34, -58, -35, -58);
		assertTrue(distance<111000 && distance>110000);
	}

}
