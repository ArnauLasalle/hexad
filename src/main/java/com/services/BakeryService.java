package com.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.persistence.entities.AvaliablePackets;
import com.persistence.entities.Cart;
import com.persistence.entities.Packet;
import com.persistence.entities.PacketCombination;
import com.persistence.entities.PacketUnits;
import com.services.input.BakeryInputData;
import com.services.input.BakeryOrderInputData;

@Service
public class BakeryService {

	private AvaliablePackets avaliablePackets = new AvaliablePackets();
	
	public Cart processOrder(BakeryInputData bakeryInputData){
		
		AvaliablePackets orderPackets = new AvaliablePackets();
		Cart cart = new Cart();
		
		for(BakeryOrderInputData bakeryOrderInputData : bakeryInputData.getBakeryOrder()){
			orderPackets.setAvaliablePackets(avaliablePackets.getAvaliablePackets().stream().filter(v -> {		
					return v.getProduct().getCode().equals(bakeryOrderInputData.getCode());	
			}).collect(Collectors.toList()));
			Collections.sort(orderPackets.getAvaliablePackets(), new SortService());
			cart.addPacketCombination(getOrderCart(bakeryOrderInputData, orderPackets));
			
			
		}
		return cart;
	}
	
	public PacketCombination getOrderCart(BakeryOrderInputData bakeryOrderInputData, AvaliablePackets orderPackets ){
		
		
		List<PacketUnits> packetUnits = new ArrayList<>();
		int units = 0;
		int total = bakeryOrderInputData.getUnits();
		int left = 0;
		int minleft = orderPackets.getAvaliablePackets().get(orderPackets.getAvaliablePackets().size()-1).getUnits();
		for(Packet packet : orderPackets.getAvaliablePackets()){
			units = total / packet.getUnits();
			left = total % packet.getUnits();
			if(units!=0 && (left>=minleft || left==0) && (left%minleft==0)){
				total=left;
				PacketUnits packetunit = new PacketUnits(packet, units);
				packetUnits.add(packetunit);
				units = 0;
			}
			if (total==0)
				break;
		}
		PacketCombination combination = new PacketCombination(packetUnits);
		combination.calculateTotalPrice();
		combination.setCode(orderPackets.getAvaliablePackets().get(0).getProduct().getCode());
		return combination;
	}
}
