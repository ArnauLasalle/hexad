package com.persistence.entities;

import java.util.List;

public class PacketCombination {
	
	private List<PacketUnits> packetCombination;
	private String code;
	private Float totalPrice;
	
	public PacketCombination(List<PacketUnits> packetCombination) {
		super();
		this.packetCombination = packetCombination;
	}

	public List<PacketUnits> getPacketCombination() {
		return packetCombination;
	}

	public void setPacketCombination(List<PacketUnits> packetCombination) {
		this.packetCombination = packetCombination;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void calculateTotalPrice(){
		
		Float total =0.0f;
		for(PacketUnits units : this.packetCombination){
			total += units.getPacket().getPrice()*units.getUnits();
		}
		this.totalPrice = total;
	}
	
	
	
}
