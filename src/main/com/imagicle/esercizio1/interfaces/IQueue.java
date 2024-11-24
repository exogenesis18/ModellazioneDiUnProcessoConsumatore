package main.com.imagicle.esercizio1.interfaces;

/// Represents a FIFO queue
public interface IQueue {

/// Pushes the given request into the queue
	void push(IRequest request);

/// Pops the first request from the queue
	IRequest pop();

/// Sorts the requests contained in the queue by priority ascending.
/// That is, low priority requests first, then high priority ones.
	void sortByPriority();
}
