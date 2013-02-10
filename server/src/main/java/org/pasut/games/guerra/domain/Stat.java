package org.pasut.games.guerra.domain;

public class Stat {
	private double amount;
	private double estimatedAmount;
	private double fixedCost;
	private double dynamicCost;
	
	public Stat(){}
	
	public Stat(double estimation, double fixedCost, double dynamicCost){
		this.amount = estimation;
		this.estimatedAmount = estimation;
		this.fixedCost = fixedCost;
		this.dynamicCost = dynamicCost;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
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
	public void setDynamicCost(double cost) {
		this.dynamicCost = cost;
	}
	public double getCost(){
		return this.fixedCost + this.dynamicCost;
	}
}
