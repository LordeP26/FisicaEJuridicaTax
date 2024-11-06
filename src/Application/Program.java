package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.JuridicPerson;
import Entities.Person;
import Entities.PhysicalPerson;

public class Program {
	
	/*
	 * Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
     * renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
     * destes gastos são abatidos no imposto.
     * 
     * Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
     * fica: (50000 * 25%) - (2000 * 50%) = 11500.00
     * 
     * 
     * Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
     * funcionários, ela paga 14% de imposto.
     * 
     * Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
     * 400000 * 14% = 56000.00
	 */

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person>list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new PhysicalPerson(name, anualIncome,healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberEmployees = sc.nextInt();
				list.add(new JuridicPerson(name, anualIncome,numberEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for (Person p : list) {
			System.out.println(p);
		}
		double sum = 0;
		for (Person p : list) {
			double tax = p.tax();
			sum += tax;
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f%n", sum);
		
		sc.close();
	}

}
