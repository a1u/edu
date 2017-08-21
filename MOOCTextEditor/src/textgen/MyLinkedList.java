package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		checkElement(element);
		LLNode<E> add = new LLNode<E>(element);
		add.next = tail;
		add.prev = tail.prev;
		tail.prev.next = add;
		tail.prev = add;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		checkSizes(index);
		LLNode<E> get = head;
		for (int i = 0; i <= index; i++) {
			get = get.next;
		}
		E element = get.data;
		return element;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		checkElement(element);
		if (index != size) checkSizes(index);

		LLNode<E> add = new LLNode<E>(element);
		LLNode<E> target = head;
		for (int i = 0; i <= index; i++) {
			target = target.next;
		}
		LLNode<E> prev = target.prev;
		add.prev = prev;
		add.next = target;
		prev.next = add;
		target.prev = add;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		checkSizes(index);
		LLNode<E> remove = head;
		for (int i = 0; i <= index; i++) {
			remove = remove.next;
		}
		LLNode<E> prev = remove.prev;
		LLNode<E> next = remove.next;
		prev.next = next;
		next.prev = prev;
		size--;
		return remove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		checkElement(element);
		checkSizes(index);
		LLNode<E> set = head;
		for (int i = 0; i <= index; i++) {
			set = set.next;
		}
		set.data = element;
		return element;
	}

	private void checkSizes(int index) {
		if (index < 0 || index > size - 1 || index == 0 && size == 0) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
	}

	private void checkElement(E element) {
		if (element == null) {
			throw new NullPointerException("Element you are adding should not be null");
		}
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
