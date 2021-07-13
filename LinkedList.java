package com.datastructures.linkedlists;

class Node
{
	int val;
	Node next;
	
	public Node(int val)
	{
		this.val = val;
		this.next = null;
	}
}

public class LinkedList 
{
	static Node head = null;
	
	public static void insertAtEnd(int key)
	{
		if(head == null)
		{
			head = new Node(key);
		}
		
		else
		{
			Node current = head;
			
			while(current.next != null)
			{
				current = current.next;
			}
			
			current.next = new Node(key);
		}
		
	}
	
	public static void insertAtFront(int key)
	{
		if(head == null)
		{
			head = new Node(key);
		}
		
		else
		{
			Node newNode = new Node(key);
			newNode.next = head;
			head = newNode;
		}
	}
	
	public static boolean search(int key)
	{
		if(head == null)
			return false;
		
		else
		{
			Node current = head;
			
			while(current != null)
			{
				if(current.val == key)
				{
					return true;
				}
				current = current.next;
			}
		}
		
		return false;
	}
	
	public static void delete(int key)
	{
		if(search(key))
		{
			if(head == null)
				return;
			
			Node current = head;
			
			while(current != null)
			{
				if(current.val == key)
				{
					current.val = current.next.val;
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
		}
		
		else
		{
			System.out.println("Element is not in the list!");
		}

	}
	
	public static void reverse()
	{
		if(head == null)
			return;
		
		Node prev = null;
		Node current = head;
		
		while(current != null)
		{
			Node next = current.next;
			
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	public static void printList()
	{
		Node current = head;
		
		if(current == null)
			return;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) 
	{
				
		int keys[] = {11, 2, 3, 4, 5};
		
		for(int key: keys)
		{
			insertAtEnd(key);
		}

		System.out.println("List After Normal Inserts");
		printList();
		
		insertAtFront(-1);
		System.out.println("List After Inserting at Front");
		printList();
		
		
		delete(1);
		
		
		System.out.println("List After Deleting a Node");
		printList();
		
		reverse();
		System.out.println("List after reversing");
		printList();
		
		delete(5);
		System.out.println("After deleting");
		printList();

	}

}
