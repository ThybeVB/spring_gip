package com.gusco.springboot.web.wicova.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gusco.springboot.web.wicova.model.Aflossing;
import com.gusco.springboot.web.wicova.model.Airplane;

@Service
public class AflossingService {
	
	private static List<Aflossing> rows = new ArrayList<Aflossing>();
	private static int rowCount = 0;
	
	private double huidigSaldo = 0;
	
	public void addRow(double payment, double intrestPart, double capitalPart, double debtSaldo) {
		rows.add(new Aflossing(++rowCount, payment, intrestPart, capitalPart, debtSaldo));
	}
	
	public List<Aflossing> getAflossingen(Airplane plane) {
		this.huidigSaldo = plane.getPrice();
		for (int i = 0; i < plane.getLoopTijd(); i++) {
			double intrestGedeelte = getInterestgedeelte(plane.getJaarRente());
			double kapitaalGedeelte = getKapitaalDeel(plane.getPmt(), intrestGedeelte);
			double newSaldo = this.getNewSaldo(kapitaalGedeelte);
			this.addRow(plane.getPmt(), intrestGedeelte, kapitaalGedeelte, newSaldo);
		}
		
		return rows;
	}
	
	private double getKapitaalDeel (double pmt, double intrestGedeelte) {
		return this.round(pmt - intrestGedeelte, 2);
	}
	
	private double getNewSaldo(double kapitaalDeel) {
		double a = huidigSaldo -= kapitaalDeel;

		return round(a, 3);
	}
	
	private double getInterestgedeelte(double renteJaar) {
		return this.round(huidigSaldo * this.getMaandRente(renteJaar), 2);
	}
	
	public double getMaandRente(double renteJaar) {
		double rentevoetSamengesteld = (double) (1+(renteJaar/100));
		double maandRente = (double) Math.pow(rentevoetSamengesteld, (double)1/12) - 1;
		return maandRente;
	}
	
	public void flush() {
		rowCount = 0;
		rows.removeAll(rows);
	}
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
