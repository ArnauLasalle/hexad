package com.persistence.entities;

public class PacketUnits {
	
	private Packet packet;
	private int units;
	
	
	public PacketUnits(Packet packet, int units) {
		super();
		this.packet = packet;
		this.units = units;
	}
	public Packet getPacket() {
		return packet;
	}
	public void setPacket(Packet packet) {
		this.packet = packet;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
		
	
}
