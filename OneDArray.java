import java.util.Arrays;

import javax.swing.JOptionPane;

public class OneDArray 
{
	private int[] array;
	private int size;
	private int low;
	private int high;
	
	
public OneDArray(int s, int l, int h)
{
	array = new int[s];
	for (int i=0; i<s; i++)
    	array[i] = l + (int)((h-l+1)*Math.random());
}
public OneDArray()
{
	size = 100;
	low = 1;
	high = 100;
	array = new int[size];
	for (int i=0; i<size; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
	
}
public void createArray()
{
	String input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Size of One-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    size=Integer.parseInt(input);
    array = new int[size];
    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
			"Lowest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    low = Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Highest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    high = Integer.parseInt(input);
    for (int i=0; i<size; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
}
public int getMaximum()
{
	int max = array[0];
	for (int i=1; i<size; i++)
		if (max < array[i])
			max = array[i];
	return max;
}
public int getMinimum()
{
	int min = array[0];
	for (int i=1; i<size; i++)
		if (min > array[i])
			min = array[i];
	return min;
}
public double getAverage()
{
	int sum = array[0];
	
	for (int i=0; i<size -1; i++)	
		sum += array[i];
			
	return sum / size;
}


public boolean search(int key)
{
	for (int i : array) {
		if(key == i) {
			return true;
		}
	}
	return false;
	
	
	
	
}
public int[] Sort()
{
	int [] copy = array;

	Arrays.parallelSort(copy);
	return copy;
}

public int[] getArray() { return array;}
public int getSize() { return size;}
public int getLow() { return low;}
public int getHigh() { return high;}
}