package com.services;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.persistence.entities.Packet;

@Service
public class SortService implements Comparator<Packet> {

	@Override
	public int compare(Packet arg0, Packet arg1) {
		return arg1.getUnits()-arg0.getUnits();
	}
}
