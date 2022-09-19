import javax.swing.JOptionPane;

public class linkedlist 
{
	private Node head;
	private Node tail;
	private int size;
	private int low;
	private int high;
	
	public linkedlist()
	{
		head = null;
		tail = null;
		size = 0;
		low = 0;
		high = 100;
	}
	public linkedlist(Node h, Node t, int s, int l, int hi)
	{
		head = h;
		tail = t;
		size = s;
		low = l;
		high = hi;
	}
	public void createList()
	{
		String input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
				"Size of Linked List",JOptionPane.QUESTION_MESSAGE);
	    size=Integer.parseInt(input);
	    System.out.println("Size = "+size);
	    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
				"Lowest Value in the Linked List",JOptionPane.QUESTION_MESSAGE);
	    low = Integer.parseInt(input);
	    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
				"Highest Value in the Linked List",JOptionPane.QUESTION_MESSAGE);
	    high = Integer.parseInt(input);
	    
	  // Create the linked list by adding the new nodes to the end of the list
	    int s = size;
	    size = 0;
	    for (int i=0; i<s; i++)
	    {
	    	int k = low + (int)((high-low+1)*Math.random());
	    	addEnd(k);
	    }
	    System.out.println("returning from create list"+getHead());
	    
	}
	public void addBegining(int v)
	{
		Node t = new Node();
		t.setData(v);
		t.setNext(null);
		if (head == null)
		{
			head = t;
			tail = t;
		}
		else
		{
			
			t.setNext(head);
			head = t;
			
		}
	
		size++;
	}
	public void addAfterN(int v, int n)
	{
		Node t = head;;
		
		if (n ==0) {
			t = new Node();
			v = t.getData();
			t.setNext(null);
			
			if (head == null) {
				if( n != 0) {
					return;
					
				}else
					head = t;
				
			}
		}	
		if (head != null &&  n == 0) {
			head = t.getNext();
			t = head;
			return;
		}
		Node current = head;
		Node previos = null;
		
		int i = 0;
		while (i < n) {
			previos = current;
			current = current.getNext();
			
			if (current == null) {
				break;
			}
			i++;
			}
		current = t.getNext();
		t = previos.getNext();
		
			}
	
	public void addEnd(int v)
	{
		Node t = new Node();
		t.setData(v);
		t.setNext(null);
		if (head == null)
		{
			head = t;
			tail = t;
		}
		else
		{
			
			t.setNext(head);
			head = t;
			
		}
	
		size++;
	}
	public int removeFront(){
        if(head == null){
          
            return 0;
        }else{
            int temp = head.getData();
            head = head.getNext();  
            return temp;
        }

    }

	public int getMinimum()
	{
		int min = head.getData();
		Node t = head;
		while (t != null)
		{
			if (min > t.getData())
				min = t.getData();
			t = t.getNext();
		}
		return min;
	}
	public int getMaximum()
	{
		int max = head.getData();
		Node t = head;
		while (t != null)
		{
			if (max < t.getData())
				max = t.getData();
			t = t.getNext();
		}
		return max;
	}
	
	public double getAverage()
	{
		int sum = head.getData();
		Node t = head;
		while (t != null)
		{

		sum += t.getData();
			t = t.getNext();
		}
		return sum / size;
	}
	public boolean search(int key)
	{
		Node t = head;
		while(t != null) {
			if(t.getData() == key)
			{
				return true;
			}
		else
		{
			t = t.getNext();
		}
		}
			return false;
		}
		
	public String toString() {
		String data = "[";
		Node t = head;
		while (t != null) {
			data += t.getData();
			t = t.getNext();
			if (t != null) {
				data += ",";
			}
						
			}
			data += "]";
			return data;
		}
	
		
		

	public Node getHead() { return head;}
	public Node getTail() {return tail;}
	public int getSize()  { return size;}
	public int getLow()   { return low;}
	public int getHigh()  { return high;}
}