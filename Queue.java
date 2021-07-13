package com.datastructures;

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

public class Queue 
{
	static Node head;
	static Node tail;
	
	public static void push(int key)
	{
		Node node = new Node(key);
		
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			tail.next = node;
			tail = tail.next;
		}
	}
	
	public static void pop()
	{
		if(head == null)
			return;
		
		else
		{
			Node temp = head;
			head = head.next;
			temp.next = null;
		}
	}
	
	public static void printList()
	{
		if(head == null)
		{
			System.out.println("Queue is Empty");
		}
			
		else
		{
			Node current = head;
			
			while(current != null)
			{
				System.out.print(current.val + "->");
				current = current.next;
			}
			System.out.println("NULL");
		}
	}
	
	public static void main(String args[])
	{
		int keys[] = {1,2,3,4,5};
		
		for(int key: keys)
		{
			push(key);
		}
		
		printList();
		
		push(6);
		printList();
		
		pop();
		printList();
	}
}
