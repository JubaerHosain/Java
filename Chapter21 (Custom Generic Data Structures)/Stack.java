package Chapter21.LinkList;

import java.util.NoSuchElementException;

public class Stack<E> {
private List<E> stackList;
	
	// constructor
	public Stack() {stackList = new List<E>("stack");}
	
	// add object to stack
	public void push(E object) {stackList.insertAtFront(object);}
	
	// remove object from stack
	public E pop() throws NoSuchElementException{
		return stackList.removeFromFront();
	}
	
	// determine if stack is empty
	public boolean isEmpty() {return stackList.isEmpty();}
	
	// output stack contents
	public void print() {stackList.print();}
}
