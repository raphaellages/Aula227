package entities;

public class Data {
	private String name, email;
	private double salary;
	
	public Data() {
		super();
	}

	public Data(String name, String email, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "data [name=" + name + ", email=" + email + ", salary=" + String.format("%.2f", salary) + "]";
	}
	
	
}
