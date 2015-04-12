package org.pasut.games.guerra.domain.unit;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pasut.games.guerra.domain.LatLong;
import org.pasut.games.guerra.domain.unit.visibility.AllwaysVisibleVisibility;
import org.pasut.games.guerra.domain.unit.visibility.Visibility;
import org.pasut.persister.Entity;

@Entity("central_base_unit")
public class CentralBase extends FixedUnit {
	private final static String TYPE = "CentralBase";
	/**
	 * 
	 */
	private static final long serialVersionUID = -4303316438448743884L;

	private final static Map<Integer, Double> costByLevel = new HashMap<Integer, Double>();
	private final static Map<Integer, Double> maintananceCostByLevel = new HashMap<Integer, Double>();
	
	private static void loadCost(){
		costByLevel.put(1, 15000000.0);
		costByLevel.put(2, 20000000.0);
		costByLevel.put(3, 30000000.0);
		costByLevel.put(4, 50000000.0);
		costByLevel.put(5, 80000000.0);
		maintananceCostByLevel.put(1, 15000.0);
		maintananceCostByLevel.put(2, 20000.0);
		maintananceCostByLevel.put(3, 30000.0);
		maintananceCostByLevel.put(4, 50000.0);
		maintananceCostByLevel.put(5, 80000.0);
	}
	
	{
		loadCost();
	}
	
	@JsonProperty("_id")
	private String id;
	private int level;
	private AllwaysVisibleVisibility visibility;
	
	public CentralBase(String countryCode, String name, LatLong position, int level){
		super(countryCode, name, TYPE);
		this.state = UnitState.READY;
		this.speed = 0;
		this.visibility = new AllwaysVisibleVisibility(position);
		this.level = level;
	}
	
	@Override
	@JsonProperty("_id")
	String getId() {
		return id;
	}

	@Override
	public Visibility getVisibility() {
		return this.visibility;
	}

	@Override
	public double getCost() {
		if(costByLevel.get(getLevel())==null) loadCost();
		return costByLevel.get(getLevel());
	}

	@Override
	public double getMaintenance() {
		if(maintananceCostByLevel.get(getLevel())==null) loadCost();
		return maintananceCostByLevel.get(getLevel());
	}

	@Override
	public int getContructionTime() {
		return 0;
	}
	
	@Override
	public int getLevel(){
		return this.level;
	}

}
