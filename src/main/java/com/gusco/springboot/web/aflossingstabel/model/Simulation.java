package com.gusco.springboot.web.aflossingstabel.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Simulation {
	
	private int id;
	private String user;
	private double pmt;
	
	@NotNull
	@Min(value=0, message="Je moet een getal typen groter dan 0.")
	private double kapitaal;
	
	@NotNull
	@Min(value=0, message="Vul een looptijd in in maanden.")
	private int loopTijd;
	
	@NotNull
	@Min(value=0, message="Vul een rente in in maanden.")
	private double jaarRente;
	
	public Simulation () {}

	public Simulation(int id, String user, double kapitaal, int loopTijd, double jaarRente, double pmt) {
		this.id = id;
		this.user = user;
		this.kapitaal = kapitaal;
		this.loopTijd = loopTijd;
		this.jaarRente = jaarRente;
		this.pmt = pmt;
	}
	
	public double getPmt() {
		return pmt;
	}

	public void setPmt(double pmt) {
		this.pmt = pmt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public double getKapitaal() {
		return kapitaal;
	}

	public void setKapitaal(double kapitaal) {
		this.kapitaal = kapitaal;
	}

	public int getLoopTijd() {
		return loopTijd;
	}

	public void setLoopTijd(int loopTijd) {
		this.loopTijd = loopTijd;
	}

	public double getJaarRente() {
		return jaarRente;
	}

	public void setJaarRente(double jaarRente) {
		this.jaarRente = jaarRente;
	}

	@Override
	public String toString() {
		return String.format("Simulation [kapitaal=%s, loopTijd=%s, jaarRente=%s]", kapitaal, loopTijd, jaarRente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Simulation other = (Simulation) obj;
		return Double.doubleToLongBits(jaarRente) == Double.doubleToLongBits(other.jaarRente)
				&& kapitaal == other.kapitaal && loopTijd == other.loopTijd;
	}

}
