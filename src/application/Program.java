package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Data;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String patch = "C:\\Users\\rapha\\Documents\\Workspace_eclipse\\Aula227\\in.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(patch))) 
		{
			String line = br.readLine();
			List<Data> list = new ArrayList<>();
			while (line != null)
			{
				String[] splitLine = line.split(",");
				String name = splitLine[0];
				String email = splitLine[1];
				double salary = Double.parseDouble(splitLine[2]);
				list.add(new Data(name, email, salary));
				line = br.readLine();
				
			}			
			for (Data d : list)
			{
			System.out.println(d);	
			}
			System.out.println("---------------------");
			List<String> emails = list.stream().filter(p -> p.getSalary()>2000.00).map(p -> p.getEmail()).sorted().collect(Collectors.toList());
			emails.forEach(System.out::println);
			System.out.println("---------------------");
			double sum = list.stream().filter(p -> p.getName().charAt(0)=='M').map(p -> p.getSalary()).reduce(0.0, (x,y) -> x + y);
			System.out.println(sum);
			System.out.println("---------------------");
			List<String> nameB = list.stream().filter(p -> p.getName().charAt(0)=='B').map(p -> p.getName()).collect(Collectors.toList());
			nameB.forEach(System.out::println);
			System.out.println("---------------------");
			List<Data> highSalary = list.stream().filter(p -> p.getSalary()>2000).collect(Collectors.toList());
			highSalary.forEach(System.out::println);
			System.out.println("---------------------");
			List<Data> lowSalary = list.stream().filter(p -> p.getSalary()<2000).collect(Collectors.toList());
			lowSalary.forEach(System.out::println);
			System.out.println("---------------------");
			List<Data> lessChar = list.stream().filter(p -> p.getName().length()>3).collect(Collectors.toList());
			lessChar.forEach(System.out::println);
		}
		catch (IOException e)
		{
			System.out.println("Error" + e.getMessage());
		}
		
	}

}
