package com.persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<PacketCombination> cart = new ArrayList<>();

	public List<PacketCombination> getCart() {
		return cart;
	}

	public void setCart(List<PacketCombination> cart) {
		this.cart = cart;
	}

	public void addPacketCombination(PacketCombination combination){
		
		this.cart.add(combination);
	}
}
