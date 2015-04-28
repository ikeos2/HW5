package edu.iastate.cs228.hw5;


/**
 * 
 * @author Alex Orman
 *
 */
public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplayTreeSet<Integer> main = new SplayTreeSet<Integer>();
		
		main.add(16);
		main.add(15);
		main.add(13);
		main.add(17);
		main.add(21);
		main.add(14);
		
		System.out.println(main.toString()+"\n\n");
		
		main.remove(17);
		main.remove(21);
		
		System.out.println(main.toString());
	}

}
