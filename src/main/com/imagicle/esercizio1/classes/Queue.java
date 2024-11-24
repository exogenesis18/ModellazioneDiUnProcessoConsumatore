package main.com.imagicle.esercizio1.classes;

import java.util.LinkedList;
import java.util.List;

import main.com.imagicle.esercizio1.enumerations.Priority;
import main.com.imagicle.esercizio1.interfaces.IQueue;
import main.com.imagicle.esercizio1.interfaces.IRequest;

public class Queue implements IQueue {

	private List<Request> requests = new LinkedList<>();

	private static int counterElaboratedHighPriorityRequestsCombo = 0;

	@Override
	public void push(IRequest request) {

		//controllo tipo istanza
		if (request instanceof Request)
			requests.add((Request) request);

		sortByPriority();

	}

	@Override
	public IRequest pop() {

		if (!requests.isEmpty()) {

			//estrae sempre l'ultima request nella lista
			Request request = requests.get(requests.size() - 1);

			request.process();
			requests.remove(request);

			//caso processi ad alta priorità
			if (request.getPriority().equals(Priority.High)) {
				counterElaboratedHighPriorityRequestsCombo++;
				if (counterElaboratedHighPriorityRequestsCombo == 4)
					System.out.println("------Inversione priorità per impedire starvation------");

			//caso processi a bassa priorità
			} else {
				if (counterElaboratedHighPriorityRequestsCombo >= 4) {
					System.out.println("------Ripristino priorità------");
				}
				counterElaboratedHighPriorityRequestsCombo = 0;
			}

			sortByPriority();

			return request;

		} else {
			return null;
		}
	}

	@Override
	public void sortByPriority() {

		/*
		 * Ordinamento prima per priorità e poi per timestamp
		 * Nel caso siano state eseguite 4 richieste con alta priorità di fila
		 * la priorità viene invertita
		 */
		requests.sort((a, b) -> {
			if (a.getPriority().equals(Priority.High) && b.getPriority().equals(Priority.Low))
				return 1 * (counterElaboratedHighPriorityRequestsCombo < 4 ? 1 : -1);
			else if (a.getPriority().equals(Priority.Low) && b.getPriority().equals(Priority.High))
				return -1 * (counterElaboratedHighPriorityRequestsCombo < 4 ? 1 : -1);
			else {
				return b.getRequestDateTime().compareTo(a.getRequestDateTime());
			}
		});

	}

	public List<Request> getRequests() {
		return requests;
	}

}
