package com.iqmsoft.camel.spark;

import java.io.Serializable;

public class Company implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(debt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(eqratio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(equity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (Double.doubleToLongBits(debt) != Double.doubleToLongBits(other.debt))
			return false;
		if (Double.doubleToLongBits(eqratio) != Double.doubleToLongBits(other.eqratio))
			return false;
		if (Double.doubleToLongBits(equity) != Double.doubleToLongBits(other.equity))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private static final long serialVersionUID = 241887222461182257L;

	private int id;
	private String name;
	private double debt;
	private double equity;
	private double eqratio;

	public Company() {
	}

	public Company(int id, String name, double debt, double equity) {
		super();
		this.id = id;
		this.name = name;
		this.debt = debt;
		this.equity = equity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public double getEquity() {
		return equity;
	}

	public void setEquity(double equity) {
		this.equity = equity;
	}

	public double getEQRatio() {
		eqratio = 0;
		if (equity > 0)
			eqratio = debt / equity;
		return eqratio;
	}
}
