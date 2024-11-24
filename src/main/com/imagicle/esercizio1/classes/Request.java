package main.com.imagicle.esercizio1.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import main.com.imagicle.esercizio1.enumerations.Priority;
import main.com.imagicle.esercizio1.interfaces.IRequest;

public class Request implements IRequest{
	
	private Priority priority;
	private LocalDateTime requestDateTime;
	
	public Request(Priority priority) {
		
		this.priority = priority;	
		this.requestDateTime = LocalDateTime.now();
		
		System.out.println("CREAZIONE del " + this.toString());
		
	}

	@Override
	public Priority getPriority() {
		
		return priority;
	}

	
	public LocalDateTime getRequestDateTime() {
		return this.requestDateTime;
	}

	@Override
	public void process() {
		System.out.println("ESECUZIONE del " + this.toString());
	}
	
	@Override
	public String toString() {
		
		return "processo al "
				+ this.requestDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"))
				+ " con priorità "
				+ (this.getPriority().equals(Priority.High) ? "ALTA" : "BASSA");
	}
	

}
