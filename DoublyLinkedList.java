package com.datastructures.linkedlists;

class ListNode
{
	int val;
	ListNode prev;
	ListNode next;
	
	public ListNode(int val)
	{
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}

public class DoublyLinkedList {
	
	static ListNode head = null;
	static ListNode tail = null;
	
	public static void printList()
	{
		ListNode current = head;
		
		System.out.print("NULL->");
		
		while(current != null)
		{
			System.out.print(current.val + "->");
			current = current.next;
		}
		
		System.out.print("NULL");
	}
	
	public static void insertAtEnd(int key)
	{
		ListNode node = new ListNode(key);
		
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
		
	}
	
	public static void insertAtFront(int key)
	{
		ListNode node = new ListNode(key);
		
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
	
	public static void insertAfterNode(int data, int key)
	{
		ListNode node = new ListNode(key);
		
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			ListNode current = head;
			
			while(current.val != data)
			{
				current = current.next;
			}
			
			ListNode temp = current.next;
			
			node.next = temp;
			temp.prev = node;
			
			current.next = node;
			node.prev = current;
		}
	}
	
	public static void insertBeforeNode(int data, int key)
	{
		ListNode node = new ListNode(key);
		
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			ListNode current = head;
			
			while(current.next.val != data)
			{
				current = current.next;
			}
			
			ListNode temp = current.next;
			
			temp.prev = node;
			node.next = temp;
			
			current.next = node;
			node.prev = current;
		}
	}
	
	public static void deleteNodeAtFront()
	{
		if(head == null)
			return;
		
		ListNode temp = head;
		
		head = head.next;
		head.prev = null;
		
		temp.next = null;					
	}
	
	public static void deleteNodeAtEnd()
	{
		if(tail == null)
			return;
		
		ListNode temp = tail;
		
		tail = tail.prev;
		
		tail.next = null;
		temp.prev = null;	
		
	}
	
	public static void deleteNode(int key)
	{
		if(head == null)
			return;
		
		else
		{
			ListNode current = head;
			
			while(current.next.val != key)
			{
				current = current.next;
			}
			
			ListNode temp = current.next.next;
			
			current.next = temp;
			temp.prev = current;
		}
	}
	
	public static void main(String[] args) 
	{
		int keys[] = {1,2,3,5,7};
		
		for(int key : keys)
		{
			insertAtEnd(key);
		}
		
		//Print Original List
		printList();
		System.out.println(" ");
		
		//Inserting new element at the front of the list
		insertAtFront(0);
		
		//Printing updated list
		printList();
		System.out.println(" ");
		
		//Insert node 4 after node 3
		insertAfterNode(3, 4);
		printList();
		System.out.println(" ");
		
		//Insert node 6 before node 7
		insertBeforeNode(7, 6);
		printList();
		System.out.println(" ");
		
		//Delete node 3
		deleteNode(3);
		printList();
		System.out.println(" ");
		
		//Deleting node at the front of the list
		deleteNodeAtFront();
		printList();
		System.out.println(" ");
		
		//Deleting node at the front of the list
		deleteNodeAtEnd();
		printList();
		System.out.println(" ");
				

	}

}
