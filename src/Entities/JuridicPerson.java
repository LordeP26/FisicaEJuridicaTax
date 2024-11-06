package Entities;

public class JuridicPerson extends Person{
	
	private Integer employeeNumber;
	
	public JuridicPerson() {
		
	}

	public JuridicPerson(String name, Double anualIncome, Integer employeeNumber) {
		super(name, anualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	double tax = 0;
	
	@Override
	public double tax() {
		if(employeeNumber > 10) {
			tax = anualIncome * 0.14;
		}else {
			tax = anualIncome * 0.16;
		}
		return tax;
	}

	@Override
	public String toString() {
		return super.getName() + ": $ " + String.format("%.2f",tax());
	}
	
	
	
	

}
