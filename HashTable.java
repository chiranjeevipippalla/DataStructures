package com.datastructures.hashtables;

class ListNode
{
	String key;
	int value;
	ListNode next;
	
	public ListNode(String key, int value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}
}


public class HashTable 
{
	private int TABLE_SIZE;
	private int size;
	private ListNode[] table;
	
	public HashTable(int ts)
	{
		this.size = 0;
		TABLE_SIZE = ts;
		table = new ListNode[TABLE_SIZE];
		
		for(int i=0; i<TABLE_SIZE; i++)
		{
			table[i] = null;
		}
	}
	
	//calculate the hash value of the key
	public int hash(String x)
	{
		int hashVal = x.hashCode();
		hashVal = hashVal%TABLE_SIZE;
		
		if(hashVal < 0)
			hashVal = hashVal + TABLE_SIZE;
		
		return hashVal;
	}
	
	//Size of the hash table so far
	public int getSize()
	{
		return size;
	}
	
	//Clear the hash table
	public void makeEmpty()
	{
		for(int i=0; i<TABLE_SIZE; i++)
		{
			table[i] = null;
		}
	}
	
	//get
	public int get(String key)
	{
		int hash = hash(key)%TABLE_SIZE;
		
		if(table[hash] == null)
			return -1;
		
		else
		{
			ListNode current = table[hash];
			
			while(current != null && !current.key.equals(key))
			{
				current = current.next;
			}
			
			if(current == null)
				return -1;
			
			else
				return current.value;
		}
	}
	
	//put
	public void put(String key, int value)
	{
		int hash = hash(key)%TABLE_SIZE;
		
		if(table[hash] == null)
			table[hash] = new ListNode(key, value);
		
		else
		{
			ListNode current = table[hash];
			
			while(current.next != null && !current.key.equals(key))
			{
				current = current.next;
			}
			
			if(current.key.equals(key))
			{
				current.value = value;
			}
			else
			{
				current.next = new ListNode(key, value);
			}
		}
		size++;
	}
	
	//remove
	public void remove(String key)
	{
		int hash = hash(key)%TABLE_SIZE;
		
		if(table[hash] == null)
			return;
		
		else
		{
			ListNode temp = null;
			ListNode current = table[hash];
			
			while(current != null && !current.key.equals(key))
			{
				current = current.next;
			}
			
			if(current.key.equals(key))
			{
				if (temp == null)
                    table[hash] = current.next;
                else
                    temp.next = current.next;
                size--;
			}
		}
		
	}
	
	public void printHashTable()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            ListNode entry = table[i];
            while (entry != null)
            {
                System.out.print(entry.value +" ");
                entry = entry.next;
            }            
        }
    }
	
}

class HTDemo
{
	public static void main(String args[])
	{
		HashTable hashtable = new HashTable(5);
		
		hashtable.put("water", 100);
		hashtable.put("chocolate", 50);
		hashtable.put("apple", 5);
		hashtable.put("mango", 24);
		hashtable.put("guava", 13);
		hashtable.put("pineapple", 17);
		hashtable.put("strawberry", 37);
		
		hashtable.printHashTable();
		
		hashtable.remove("apple");
		
		System.out.println(" ");
		
		hashtable.printHashTable();
	}
}
