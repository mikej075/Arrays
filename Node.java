import java.awt.Graphics;

public class Node 
{
	private int data;
	private Node next;
	 
	
	public Node()
	{
		data = 10;
		next = null;
	}
	public Node(int d, Node t)
	{
		data = d;
		next = t;
	}
	public void setData(int v) 
	{
		data = v;
	}
	public void setNext(Node n)
	{
		next = n;
	}
	 public void draw(Graphics g, int x, int y, int width) {

 
         g.drawString(data + "", x + 10, y + 30);
         g.drawString("-->", x + width, y + 30);

   }
	public int getData() { return data;}
	public Node getNext() {return next;}
}

