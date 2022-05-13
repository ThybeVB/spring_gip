package com.gusco.springboot.web.aflossingstabel.model;

public class Aflossing {
	
	private int nrAflossing;
	private double payment;
	private double intrestPart;
	private double capitalPart;
	private double debtSaldo;
	
	public Aflossing() {}

	public Aflossing(int nrAflossing, double payment, double intrestPart, double capitalPart, double debtSaldo) {
		this.nrAflossing = nrAflossing;
		this.payment = payment;
		this.intrestPart = intrestPart;
		this.capitalPart = capitalPart;
		this.debtSaldo = debtSaldo;
	}

	public int getNrAflossing() {
		return nrAflossing;
	}

	public void setNrAflossing(int nrAflossing) {
		this.nrAflossing = nrAflossing;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getIntrestPart() {
		return intrestPart;
	}

	public void setIntrestPart(double intrestPart) {
		this.intrestPart = intrestPart;
	}

	public double getCapitalPart() {
		return capitalPart;
	}

	public void setCapitalPart(double capitalPart) {
		this.capitalPart = capitalPart;
	}

	public double getDebtSaldo() {
		return debtSaldo;
	}

	public void setDebtSaldo(double debtSaldo) {
		this.debtSaldo = debtSaldo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aflossing other = (Aflossing) obj;
		return Double.doubleToLongBits(capitalPart) == Double.doubleToLongBits(other.capitalPart)
				&& Double.doubleToLongBits(debtSaldo) == Double.doubleToLongBits(other.debtSaldo)
				&& Double.doubleToLongBits(intrestPart) == Double.doubleToLongBits(other.intrestPart)
				&& nrAflossing == other.nrAflossing
				&& Double.doubleToLongBits(payment) == Double.doubleToLongBits(other.payment);
	}

	@Override
	public String toString() {
		return String.format("Aflossing [nrAflossing=%s, payment=%s, intrestPart=%s, capitalPart=%s, debtSaldo=%s]",
				nrAflossing, payment, intrestPart, capitalPart, debtSaldo);
	}
}
