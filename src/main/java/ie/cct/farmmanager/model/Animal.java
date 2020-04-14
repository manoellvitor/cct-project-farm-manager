package ie.cct.farmmanager.model;

/*
 * @author: Manoel Vitor Nascimento Lopes
 * @college: CCT College Dublin
 * @studentID: 2019286
 * */


public class Animal {

	protected String type;
	protected Double weight;

	public Animal() {
		
	}
	
	//	Constructor which will receive Animal Type and Animal Weight
	public Animal(String type, Double weight) {
		this.type = type;
		this.weight = weight;
	}
	

	//	Getters and Setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}


}
