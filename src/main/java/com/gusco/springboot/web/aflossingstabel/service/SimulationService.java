package com.gusco.springboot.web.aflossingstabel.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gusco.springboot.web.aflossingstabel.model.Simulation;

@Service
public class SimulationService {
	private static List<Simulation> sims = new ArrayList<Simulation>();
	private static int simCount = 3;
	
	static {
		sims.add(new Simulation(1, "Gebruiker", 3500.00, 12, 5.90, 0));
		sims.add(new Simulation(2, "Gebruiker", 4500.00, 24, 4.50, 0));
		sims.add(new Simulation(3, "Gebruiker", 7000.00, 36, 6.20, 0));
	}
	
	public List<Simulation> retrieveSims(String user) {
		List<Simulation> filteredSims = new ArrayList<>();
		for (Simulation sim : sims) {
			if (sim.getUser().equalsIgnoreCase(user)) {
				filteredSims.add(sim);
			}
		}
		
		return filteredSims;
	}
	
	public Simulation retrieveSim(int id) {
		for (Simulation sim : sims) {
			if (sim.getId() == id) {
				return sim;
			}
		}
		
		return null;
	}
	
	public void updateSim(Simulation sim) {
		sims.remove(sim);
		sims.add(sim);
	}
	
	public void addSimulation(String name, double kapitaal, int loopTijd, double jaarRente) {
		sims.add(new Simulation(++simCount, name, kapitaal, loopTijd, jaarRente, 0));
	}
	
	public void deleteSim(int id) {
		Iterator<Simulation> iterator = sims.iterator();
		while (iterator.hasNext()) {
			Simulation sim = iterator.next();
			if (sim.getId() == id) {
				iterator.remove();
			}
		}
	}
}
