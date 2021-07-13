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


public class Stack 
{
	static Node head;
	
	public static boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public static void push(int key)
	{
		Node node = new Node(key);
		
		if(head == null)
		{
			head = node;
			return;
		}
		
		else
		{
			node.next = head;
			head = node;
		}
	}
	
	public static int peek()
	{
		if(head == null)
			return -1;
		
		else
		{
			return head.val;
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
	
	public static void main(String args[])
	{
		int keys[] = {1,2,3,4,5};
		
		for(int key: keys)
		{
			push(key);
		}
		
		push(6);
		System.out.println("Top element is: "+peek());
		
		pop();
		System.out.println("Now the top element is: "+peek());
		
	}

}
