import java.awt.*;
import java.awt.event.*;
import java.sql.Array;

import javax.swing.*;
import javax.swing.JOptionPane;


public class Project06 extends Frame implements ActionListener
{
	String command = "";
	int key;
	int v;
	boolean found;
	Font f = new Font("SansSerif",Font.BOLD,12);
	Font f1 = new Font("SansSerif",Font.BOLD,16);
	
	OneDArray originalArray;
	linkedlist list;
	int[] originalCopy;
	Node original;

	
	public static void main(String[] args)
	{
		Frame frame = new Project06();	
		frame.setResizable(true);
		frame.setSize(1000,800);
		frame.setVisible(true);
	}
	
	public Project06()
	{
		setTitle("CSC 229 - Project 6 - Lists");
		
		// Create Menu
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		Menu actionMenu = new Menu("One Dimensional Array");
		mb.add(actionMenu);
		
		MenuItem miCreate1D = new MenuItem("Create Array");
		miCreate1D.addActionListener(this);
		actionMenu.add(miCreate1D);
		
		Menu statsMenu1D = new Menu("Statistics");
		actionMenu.add(statsMenu1D);
		
		MenuItem miMinimum1D = new MenuItem("Array Minimum");
		miMinimum1D.addActionListener(this);
		statsMenu1D.add(miMinimum1D);
		
		MenuItem miMaximum1D = new MenuItem("Array Maximum");
		miMaximum1D.addActionListener(this);
		statsMenu1D.add(miMaximum1D);
		
		MenuItem miAverage1D = new MenuItem("Array Average");
		miAverage1D.addActionListener(this);
		statsMenu1D.add(miAverage1D);
		
		MenuItem miSort = new MenuItem("Sort Array");
		miSort.addActionListener(this);
		actionMenu.add(miSort);
		
		MenuItem miSearch1D = new MenuItem("Search Array");
		miSearch1D.addActionListener(this);
		actionMenu.add(miSearch1D);
		
		// Linked List
		
		Menu actionMenu1 = new Menu("Linked List");
		mb.add(actionMenu1);
		
		MenuItem miCreate2D = new MenuItem("Create List");
		miCreate2D.addActionListener(this);
		actionMenu1.add(miCreate2D);
		
		Menu addMenu = new Menu("Add");
		actionMenu1.add(addMenu);
		
		Menu DeleteMenu = new Menu("Delete");
		actionMenu1.add(DeleteMenu);
		
		MenuItem mifirstNode = new MenuItem("First node");
		mifirstNode.addActionListener(this);
		DeleteMenu.add(mifirstNode);
		
		MenuItem miLastNode = new MenuItem("Last node");
		miLastNode.addActionListener(this);
		DeleteMenu.add(miLastNode);
		
		MenuItem miBegining = new MenuItem("Begining");
		miBegining.addActionListener(this);
		addMenu.add(miBegining);
		
		MenuItem miEnd = new MenuItem("End");
		miEnd.addActionListener(this);
		addMenu.add(miEnd);
		
		Menu statsMenu2D = new Menu("List Statistics");
		actionMenu1.add(statsMenu2D);
		
		MenuItem miMinimum2D = new MenuItem("List Minimum");
		miMinimum2D.addActionListener(this);
		statsMenu2D.add(miMinimum2D);
		
		MenuItem miMaximum2D = new MenuItem("List Maximum");
		miMaximum2D.addActionListener(this);
		statsMenu2D.add(miMaximum2D);
		
		MenuItem miAverage2D = new MenuItem("List Average");
		miAverage2D.addActionListener(this);
		statsMenu2D.add(miAverage2D);
		
		MenuItem miSortList = new MenuItem("Sort List");
		miSortList.addActionListener(this);
		
		
		actionMenu1.add(miSortList);
		
		MenuItem miSearchList = new MenuItem("Search List");
		miSearchList.addActionListener(this);
		actionMenu1.add(miSearchList);
		
		
		// End program when window is closed
		
		WindowListener l = new WindowAdapter()
		{
						
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			int n;
			// take action accordingly
			if("About".equals(command))
			{
				repaint();
			}
			else
			if("Exit".equals(command))
			{
				System.exit(0);
			}
			else
			if("Create Array".equals(command))
			{
				originalArray = new OneDArray();
				originalArray.createArray();
				
				repaint();
			}
			
			else
			if("Array Minimum".equals(command)  || 
			   "Array Maximum".equals(command) ||
			   "Array Average".equals(command)  ||
			 
			   "List Minimum".equals(command)  || 
			   "List Maximum".equals(command) ||
			   "List Average".equals(command)  
			    )
				{
					
					repaint();
				}
			else
			if("Sort Array".equals(command))
			{
				originalCopy = originalArray.getArray();
				repaint();
			}
			else
			if("Search Array".equals(command))
			{
				
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
						"Search Key",JOptionPane.QUESTION_MESSAGE);
			    key = Integer.parseInt(input);
			    found = list.search(key);
				repaint();
			}
			else
			if("Create List".equals(command))
			{
				list = new linkedlist();
				list.createList();
					
				repaint();
				}
		
			else
			if("Begining".equals(command))
			{
				String input = JOptionPane.showInputDialog("Please Enter the Node Number to Add to begining");
				n = Integer.parseInt(input);
				repaint();
			}
			else
			if("End".equals(command))
		    {
				String input = JOptionPane.showInputDialog("Please Enter the Node Number to Add to end");
				n = Integer.parseInt(input);
				repaint();
			}
			else
		    if("First Node".equals(command))
		    {
		    	String input = JOptionPane.showInputDialog("Please Enter the Node Number to delete first node");
				n = Integer.parseInt(input);
				repaint();
			}
		    else
			if("Last Node".equals(command))
			{
				String input = JOptionPane.showInputDialog("Please Enter the Node Number to delete last node");
				n = Integer.parseInt(input);
				repaint();
			}
		
		
			else
				if ("After Nth Node".equals(command))
				{
					String input = JOptionPane.showInputDialog("Please Enter the Node Number to Add New Node After");
					n = Integer.parseInt(input);
					repaint();
				}
			else
				if ("Nth Node".equals(command))
				{
					String input = JOptionPane.showInputDialog("Please Enter the Node Number to Delete");
					n = Integer.parseInt(input);
					repaint();
				}
		
			
			else
			if("Search List".equals(command))
			{
						
				String input = JOptionPane.showInputDialog(null,"Please enter an integer Number to Search for:",
							"Search Key",JOptionPane.QUESTION_MESSAGE);
				key = Integer.parseInt(input);
				found = list.search(key);
				repaint();
				}
		
		
	// Linked List Operations
//********************** Add Linked list items
			
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			
			// Check Command issued, take action accordingly
			int ww = this.getWidth();
			
			g.setFont(f);
			if("Create Array".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY  = displayArray(g,t,x,y,ww,"Original Array");
			}
			
			else
			if("Array Minimum".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Minimum = "+Integer.toString(originalArray.getMinimum()), ww/2-50, currentY+25);
					
			}
			else
			if("Array Maximum".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Maximum = "+Integer.toString(originalArray.getMaximum()), ww/2-50, currentY+25);
					
			}
			else
			if("Array Average".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Average = "+(originalArray.getAverage()), ww/2-50, currentY+25);
			}
				
					
	
			else
			if("Sort Array".equals(command))
			{
				
				{
					int x=100;
					int y = 100;
					int[] t = originalCopy;
					int currentY = displayArray(g,t,x,y,ww,"Original Array");
				}
				
				int x=450;
				int y = 450;
				int[] t = originalArray.Sort();
				int currentY = displayArray(g,t,x,y,ww,"Sorted Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				
					
			}
	
			else
			if("Search Array".equals(command))
			{
				int x=100;
				int y = 100;
				int[] t = originalArray.getArray();
				int currentY = displayArray(g,t,x,y,ww,"Original Array");
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Search key ***** "+(originalArray.search(key)), ww/2-50, currentY+25);
					
			}
			else
			if("Create List".equals(command))
			{
				int x=100;
				int y = 100;
				Node t = list.getTail();
				int currentY = displayList(g,list,x,y,ww,"list");
				
			}
			else
				if("List Minimum".equals(command))
				{
					int x=100;
					int y = 100;
					
					int currentY = displayList(g,list,x,y,ww,"list");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Minimum = "+Integer.toString(list.getMinimum()), ww/2-50, currentY+15);
						
				}
				else
				if("List Maximum".equals(command))
				{
					int x=100;
					int y = 100;
					
					int currentY = displayList(g,list,x,y,ww,"list");
					displayList(g,list,x,y,ww,"Original list");
					g.setFont(f1);
					g.setColor(Color.RED);
					g.drawString("Maximum = "+Integer.toString(list.getMaximum()), ww/2-50,  currentY+15);
						
				}
				else
					if("List Average".equals(command))
					{
						int x=100;
						int y = 100;
						
						int currentY = displayList(g,list,x,y,ww,"list");
						displayList(g,list,x,y,ww,"Original list");
						g.setFont(f1);
						g.setColor(Color.RED);
						g.drawString("Average = "+Integer.toString((int) list.getAverage()), ww/2-50,  currentY+15);
							
					}
					else
						if("Search List".equals(command))
						{
							int x=100;
							int y = 100;
							
							int currentY = displayList(g,list,x,y,ww,"Original List");
							displayList(g,list,x,y,ww,"Original list");
							g.setFont(f1);
							g.setColor(Color.RED);
							g.drawString("Search key ***** "+(list.search(key)), ww/2-50, currentY+25);
								
						}
						
	// Linked List Operations ********** Add Code         **********************************
		
		}
		
		

	
		


		public int displayArray(Graphics g,int[] t, int x, int y, int ww, String title)
		{
			g.setFont(f1);;
			g.setColor(Color.RED);
			g.drawString(title, ww/2-50, y);
			g.setFont(f);
			g.setColor(Color.BLACK);
			y = y + 25;
			
			for (int i=0; i<t.length; i++)
			{
				g.drawString(Integer.toString(t[i]), x, y);
				x = x + 35;
				if (x>(ww-100))
				{
					x = 100;
					y = y + 15;
				}
			}
			return y;
		}
		public int displayList(Graphics g, linkedlist l, int x, int y, int width,String title )
{
			
			g.setFont(f1);;
			g.setColor(Color.RED);
			g.drawString(title, width/2-50, y);
			g.setFont(f);
			g.setColor(Color.BLACK);
			y = y + 25;
			int xy = x;
				
			
			Node t = l.getHead();
			while ( t != null)
			{
				System.out.print(t.getData() + " ");
				x = x + 40;
				g.drawString(t.getData() + "", x, y);
				t = t.getNext();
				x=x+40;
				if (x> width-40)
			{
				x = xy;
				y = y + 20;
			}
			}
		
		return y;
	}
			
}

