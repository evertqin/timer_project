package com.timer.common;

import java.util.ArrayList;
import java.util.List;

public class ProtocolComposite implements Protocol {
	public final long id; 
	public final String name;
	boolean isFavorited = false; 
	int weight = 0; // used to identify recently used protocols
	
	private List<Protocol> childProtocols= new ArrayList<Protocol>(); // this is to be populated from database
	
	public ProtocolComposite(final long id, final String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(id + ": " + name + " " + childProtocols.size());
		for(Protocol protocol : childProtocols) {
			protocol.print();
		}
	}
}
