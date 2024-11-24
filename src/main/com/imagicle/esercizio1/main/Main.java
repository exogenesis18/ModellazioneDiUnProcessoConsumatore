package main.com.imagicle.esercizio1.main;

import main.com.imagicle.esercizio1.enumerations.Priority;

import main.com.imagicle.esercizio1.classes.Queue;
import main.com.imagicle.esercizio1.classes.Request;

public class Main {
	public static void main(String[] args) {

		int processesToCreate = 20;
		int createdProcesses = 0;

		Queue queue = new Queue();

		/*
		 * In questa simulazione ad ogni iterazione vengono creati
		 * e pushati nella Queue 2 processi (uno a priorità bassa
		 * ed uno a priorità alta), successivamente viene eseguita un'operazione
		 * di pop(). In questo modo è possibile vedere il comportamento
		 * dell'algoritmo in caso di congestione con priorità diverse
		 * 
		 */
		while (createdProcesses < processesToCreate || !queue.getRequests().isEmpty()) {

			try {
				if(createdProcesses < processesToCreate) {
					queue.push(new Request(Priority.Low));
					Thread.sleep(1000);	
					queue.push(new Request(Priority.High));	
					Thread.sleep(1000);	
					
					createdProcesses+=2;
				}
				
				queue.pop();
				Thread.sleep(1000);
											
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}
}
