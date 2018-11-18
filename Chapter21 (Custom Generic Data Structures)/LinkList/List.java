package Chapter21.LinkList;

import java.util.NoSuchElementException;

// Class to represent one node in a list
class ListNode<E>{
	// Package access members; List can access these directly
	E data; // Data for this node
	ListNode<E> nextNode; // reference to the next node in the list
	
	// Constructor creates a ListNode that refers to object
	ListNode(E object){this(object, null);}
	
	// Concstructor creates ListNode that refers to the specified object 
	// and to the next ListNode
	ListNode(E object, ListNode<E> node){
		data = object;
		nextNode = node;
	}
	
	// Return reference to data in node
	E getData() {return data;}
	
	// Return referernce to next node in list
	ListNode<E> getNext() {return nextNode;}
}

// Class List definition
public class List<E> {
	private ListNode<E> firstNode;
	private ListNode<E> lastNode;
	private String name; // String line "list" used in printing
	
	// Consturctor creates empty List with "list" as the name
	public List() {this("list");}
	
	// Constructor creats an empty List with a name
	public List(String listName) {
		name = listName; 
		firstNode = lastNode = null;
	}
	
	// Insert item at front of List
	public void insertAtFront(E insertItem) {
		if(isEmpty()) { // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<E>(insertItem);
		}
		else { // firstNode refers to new node
			firstNode = new ListNode<E>(insertItem, firstNode);
		}
	}
	
	// Insert item at end of List
	public void insertAtBack(E insertItem) {
		if(isEmpty()) { // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<E>(insertItem);
		}
		else { // lastNode's nextNode refers to new node
			lastNode = lastNode.nextNode = new ListNode<E>(insertItem);
		}
	}
	
	// Remove first node from List
	public E removeFromFront() throws NoSuchElementException {
		if(isEmpty()) {  // throw exception if List is empty
			throw new NoSuchElementException(name + " is empty");
		}
		
		E removedItem = firstNode.data; // retrieve data being removed
		
		// Update references firstNode and lastNode
		if(firstNode == lastNode) {
			firstNode = lastNode = null;
		}
		else {
			firstNode = firstNode.nextNode;
		}
		
		return removedItem; // Retrun removed node data
	}
	
	// Determine whether list is empty: returns true if so
	public boolean isEmpty() { 
		return firstNode == null;
	}
	
	// output list contents
	public void print() {
		if(isEmpty()) {
			System.out.printf("Empty %s%n", name);
			return ;
		}
		
		System.out.printf("The %s is: ", name);
		ListNode<E> current = firstNode;
		
		// While not at end of list, output current node's data
		while(current != null) {
			System.out.printf("%S ", current.data);
			current = current.nextNode;
		}
		
		System.out.println();
	}
}
