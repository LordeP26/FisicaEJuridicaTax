package Entities;

public class PhysicalPerson extends Person{
	
	private Double healthExpenditures;
	
	public PhysicalPerson() {
		
	}

	public PhysicalPerson(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	double tax = 0;
	@Override
	public double tax() {
		if (anualIncome < 20000.00 && healthExpenditures > 0) {
			 tax = (anualIncome * 0.15) - (healthExpenditures * 0.5) ;
		} else if(anualIncome > 20000.00 && healthExpenditures > 0) {
			tax = (anualIncome * 0.25) - (healthExpenditures * 0.5);
		} else if (anualIncome > 20000.00 && healthExpenditures <= 0) {
			tax = (anualIncome * 0.25);
		}else if(anualIncome < 20000.00 && healthExpenditures <= 0) {
			tax = (anualIncome * 0.15);
		}
		return tax;
	}
	
	@Override
	public String toString() {
		return super.getName() + ": $ " + String.format("%.2f",tax());
	}
	
}
