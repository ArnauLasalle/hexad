package com.persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class AvaliablePackets {
	
	private List<Packet> avaliablePackets = new ArrayList<>();
	
	public AvaliablePackets() {
		super();

		this.addAvaliablePacket(new Packet(new VegemiteScroll(),3, 6.99f));
		this.addAvaliablePacket(new Packet(new VegemiteScroll(),5, 8.99f));
		this.addAvaliablePacket(new Packet(new BlueberryMuffin(),2, 9.95f));
		this.addAvaliablePacket(new Packet(new BlueberryMuffin(),5, 16.95f));
		this.addAvaliablePacket(new Packet(new BlueberryMuffin(),8, 24.95f));
		this.addAvaliablePacket(new Packet(new Croissant(),3, 5.95f));
		this.addAvaliablePacket(new Packet(new Croissant(),5, 9.95f));
		this.addAvaliablePacket(new Packet(new Croissant(),9, 16.99f));
	}

	public List<Packet> getAvaliablePackets() {
		return avaliablePackets;
	}

	public void setAvaliablePackets(List<Packet> avaliablePackets) {
		this.avaliablePackets = avaliablePackets;
	}
	
	public void addAvaliablePacket(Packet packet){
		
		this.avaliablePackets.add(packet);
	}
	
//	public List<Packet> getAvaliablePacketsByProductCode(String Code){
	//	return this.avaliablePackets->filter
//	}
	
	
	
	
}
