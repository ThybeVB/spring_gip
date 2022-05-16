package com.gusco.springboot.web.wicova.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gusco.springboot.web.wicova.model.Airplane;

@Service
public class PlaneService {
	private static List<Airplane> planes = new ArrayList<Airplane>();
	private static int planeCount = 6;
	
	static {
		planes.add(new Airplane(1, "A320", "Passagiersjet met twee motoren", "Airbus", 500000, 0, 0, 0));
		planes.add(new Airplane(2, "AN-225", "Grootste vliegtuig ooit bestaan", "Antonov", 5000000, 0, 0, 0));
		planes.add(new Airplane(3, "747-8", "Grootste passagiersjet met vier motoren", "Boeing", 2000000, 0, 0, 0));
		planes.add(new Airplane(4, "Citation", "Privéjet", "Cessna", 750000, 0, 0, 0));
		planes.add(new Airplane(5, "Typhoon", "NAVO Straaljager", "Eurofighter", 50000, 0, 0, 0));
		planes.add(new Airplane(6, "F-16 Fighting Falcon", "Meest verkochte aanval straaljager", "General Dynamics", 10000000, 0, 0, 0));
	}
	
	public List<Airplane> retrievePlanes() {
		List<Airplane> filteredSims = new ArrayList<>();
		for (Airplane plane : planes) {
			filteredSims.add(plane);
		}
		
		return filteredSims;
	}
	
	public Airplane retrievePlane(int id) {
		for (Airplane plane : planes) {
			if (plane.getId() == id) {
				return plane;
			}
		}
		
		return null;
	}
	
	public void updatePlane(Airplane plane) {
		planes.set(plane.getId() - 1, plane);
	}
	
	public void addPlane(String model, String description, String brand, double price) {
		planes.add(new Airplane(++planeCount, model, description, brand, price, 0, 0, 0));
	}
	
	public void deletePlane(int id) {
		Iterator<Airplane> iterator = planes.iterator();
		while (iterator.hasNext()) {
			Airplane plane = iterator.next();
			if (plane.getId() == id) {
				iterator.remove();
			}
		}
	}
}
