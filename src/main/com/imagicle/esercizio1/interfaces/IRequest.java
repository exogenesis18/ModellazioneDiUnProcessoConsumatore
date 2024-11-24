package main.com.imagicle.esercizio1.interfaces;

import main.com.imagicle.esercizio1.enumerations.Priority;

public interface IRequest {
	
	Priority getPriority();

	void process();
}