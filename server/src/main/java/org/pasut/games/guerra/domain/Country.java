package org.pasut.games.guerra.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pasut.persister.Entity;

@Entity("country")
public class Country {
	@JsonProperty("_id")
	private String id;
	
	private String code;
	private double lat;
	private double lon;
	private String name;
	private double pbi;
	private double reserve;
	private double estamitionPercent = .01f;
	private double estimation;
	private Stat[] historyStats;
	private GameDate date;
	private double fixedCost;
	private double dynamicCost;
	
	
	public Country(){}
	
	public Country(String code, String name, double pbi, double lat, double lon){
		this.code = code;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.pbi = pbi*.9;
		this.reserve = pbi*.1;
		this.estamitionPercent = .01;
		this.estimation = this.pbi*this.estamitionPercent;
		this.historyStats = new Stat[1];
		this.date = new GameDate();
		this.fixedCost = 0;
		this.dynamicCost = 0;
		this.historyStats[0] = new Stat(this.estimation,this.fixedCost, this.dynamicCost);
	}
	
	public void addDynamicCost(double cost){
		this.dynamicCost+= cost;
		this.historyStats[date.getDay()].addDynamicCost(cost);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPbi() {
		return pbi;
	}

	public void setPbi(double pbi) {
		this.pbi = pbi;
	}

	public double getReserve() {
		return reserve;
	}

	public void setReserve(double reserve) {
		this.reserve = reserve;
	}

	public double getEstamitionPercent() {
		return estamitionPercent;
	}

	public void setEstamitionPercent(double estamitionPercent) {
		this.estamitionPercent = estamitionPercent;
	}

	public double getEstimation() {
		return estimation;
	}

	public void setEstimation(double estimation) {
		this.estimation = estimation;
	}

	public Stat[] getHistoryStats() {
		return historyStats;
	}

	public void setHistoryStats(Stat[] historyStats) {
		this.historyStats = historyStats;
	}

	public GameDate getDate() {
		return date;
	}

	public void setDate(GameDate date) {
		this.date = date;
	}

	public double getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(double fixedCost) {
		this.fixedCost = fixedCost;
	}

	public double getDynamicCost() {
		return dynamicCost;
	}

	public void setDynamicCost(double dynamicCost) {
		this.dynamicCost = dynamicCost;
	}
}
