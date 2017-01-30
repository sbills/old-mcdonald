
	import java.text.DecimalFormat;
	import java.util.ArrayList;
	import java.util.Random;

	// Enum type for food
	enum FoodType { BONE, SALMON, GRASS }

public class Billideau {
	
	public static class Animal {
		Animal(){}
		protected	int	numberOfFeedings;
		private	int	numberOfRequiredFeedings;
		
		
		public Animal(int	feedingsRequired){
			numberOfFeedings = 0;
			numberOfRequiredFeedings = feedingsRequired;
		}
		
		public	void	feed(FoodType	ft){
			System.err.println();
		}
		
		public	String	speak(){
			System.err.println();
			return null;	
		}
		
		public	boolean	isStillHungry(){
			if(numberOfFeedings < numberOfRequiredFeedings)
			{
				return true;
			}
			else
			{
				return false;
			}
		}	
	} // end animal
	
	public static class Dog extends Animal{
		
			Dog(){}
			
			
			Dog(int	feedingsRequired){
				super(feedingsRequired);
				
			}
			
			public	void	feed(FoodType	ft){
				if(ft == FoodType.BONE)
				{
					numberOfFeedings++;
				}
				else
				{
					
				}
			}
			
			public	String	speak()	{
				return "Woof";
			}
			
			
	} //end dog
	
	public static class Cat extends Animal{
		Cat(){}

		Cat(int	feedingsRequired){
			super(feedingsRequired);
		}
		
		
		public	void	feed(FoodType	ft){
			if(ft == FoodType.SALMON)
			{numberOfFeedings++;
			
			}
			else
			{
				
			}
		}
		
		
		public	String	speak()	{
			return "Meow";
		}
		
	} //end cat
	
	public static class Cow extends Animal{
		Cow(){}
		Cow(int	feedingsRequired){
			super(feedingsRequired);
		}
		public	void feed(FoodType	ft){
			if (ft == FoodType.GRASS ) 
			{
			numberOfFeedings++;
			}
			else
			{
				
			}
		}
		public	String	speak()	{
			return "Moo";
		}	
	} //end cow
	
	public static class CS225_Project3_OldMcD_Client
	{
		// Constants for food costs
		final static double grassCost = 1.0;
		final static double boneCost = 3.0;
		final static double salmonCost = 5.0;
		
		public static void main(String[] args)
		{
			// Your program should always output your name and the project number.
			// DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
			System.out.println("Sean Billideau");
			System.out.println("Project 3");
			System.out.println("");

			// Decimal format class for printing out any prices
			DecimalFormat df = new DecimalFormat("$0.00");		
			
			// Use this test case to reproduce the output in the Project writeup
			//ArrayList<Animal> stalls = generateDogCatCow5ServingArrangement();
			 
			int numAnimals = 6;
			// Use this test case (comment out line above) to generate random test cases
			ArrayList<Animal> stalls = generateRandomStallArrangement(numAnimals);
			
			
			// TODO: Insert your code here which causes Old MacDonald (this client code) to
			// visit each of the stalls. Old MacDonald should speak to each animal to determine
			// what type of food to feed it. All along the way, he keeps track of what types 
			// of animals and how much of each type of food he is using. See the project
			// PDF for specific output expectations.
			double dogFeedings = 0;
			double	catFeedings = 0;
			double cowFeedings = 0;
			double numDogs = 0;
			double numCats = 0;
			double numCows = 0;
			
			for(int i = 0; i<stalls.size(); i++)
			{
				if(stalls.get(i).speak().equals("Moo"))
				{				
					while(stalls.get(i).isStillHungry()){
						stalls.get(i).feed(FoodType.GRASS);
					}					
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a cow who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * grassCost));
					cowFeedings += stalls.get(i).numberOfFeedings;
					numCows++;
				}
				else if (stalls.get(i).speak().equals("Meow"))
				{
					while(stalls.get(i).isStillHungry()){
						stalls.get(i).feed(FoodType.SALMON);
					}
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a cat who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * salmonCost));
					catFeedings += stalls.get(i).numberOfFeedings;
					numCats++;
				}
				else if (stalls.get(i).speak().equals("Woof"))
				{
					while(stalls.get(i).isStillHungry()){
						stalls.get(i).feed(FoodType.BONE);
					}
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a dog who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * boneCost));
					dogFeedings += stalls.get(i).numberOfFeedings;
					numDogs++;
				}
			}
//			System.out.println("Old MacDonald's total expenses:");
//			System.out.println(df.format(stalls.get(i).numberOfFeedings * boneCost) + " spent feeding " + numAnimals + "dog(s) " + stalls.get(i).numberOfFeedings + " total feedings."); 
//			System.out.println(df.format(stalls.get(i).numberOfFeedings * salmonCost) + " spent feeding " + numAnimals + "cat(s) " + stalls.get(i).numberOfFeedings + " total feedings."); 
//			System.out.println(df.format(stalls.get(i).numberOfFeedings * grassCost) + " spent feeding " + numAnimals + "cow(s) " + stalls.get(i).numberOfFeedings + " total feedings."); 
//			System.out.println("Total Cost: " + df.format(boneCost + salmonCost + grassCost));
//			
			System.out.println("");
			System.out.println("");
			System.out.println("Old MacDonald's total expenses:");
			System.out.println(df.format(dogFeedings * boneCost)+ " spent feeding " + (int)numDogs + " dog(s) " + (int)dogFeedings + " total feedings"  );
			System.out.println(df.format(catFeedings * salmonCost)+ " spent feeding " + (int)numCats + " cat(s) " + (int)catFeedings + " total feedings"  );
			System.out.println(df.format(cowFeedings * grassCost)+ " spent feeding " + (int)numCows + " cow(s) " + (int)cowFeedings + " total feedings"  );
			System.out.println("      Total Cost: " + df.format((dogFeedings * boneCost + catFeedings * salmonCost + cowFeedings *grassCost)));
				/////////////////////////////////////////////////////////////////////////////
			// Exiting program
			System.out.println("");
			System.out.println("E-I-E-I-O!");		
		
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		// DO NOT EDIT
		// This method generates a stall with numAnimals which are generated randomly.
		// In addition, the number of feedings required per animal are set randomly as
		// a number between 1 and 10.
		/////////////////////////////////////////////////////////////////////////////////
		private static ArrayList<Animal> generateRandomStallArrangement(int numAnimals)
		{
			// Create new stall (ArrayList) of animals
			ArrayList<Animal> newStallArrangement = new ArrayList<Animal>();
			 
			// Generate random animal  numbers of feedings required
			// AND random number of feedings required per animal
			Random r = new Random();
			
			// Generate numAnimals new animals
			for (int i = 0; i < numAnimals; i++)
			{
				int randAnimal = r.nextInt(3); // (Dog = 0, Cat = 1, Dog = 2)
				int numFeedings = r.nextInt(10)+1; // 1-10 feedings required per animal
				
				if (randAnimal == 0)
					newStallArrangement.add(new Dog(numFeedings));
				else if (randAnimal == 1)
					newStallArrangement.add(new Cat(numFeedings));
				else
					newStallArrangement.add(new Cow(numFeedings));
			}
			
			return newStallArrangement;
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		// DO NOT EDIT
		// This method generates a stall with a dog, cat and cow, which each need five
		// servings of food.
		/////////////////////////////////////////////////////////////////////////////////
		private static ArrayList<Animal> generateDogCatCow5ServingArrangement()
		{
			// Create new stall (ArrayList) of animals containing a Dog, Cat & Cow, each with a requirement of 5 servings
			ArrayList<Animal> newStallArrangement = new ArrayList<Animal>();
			newStallArrangement.add(new Dog(5));
			newStallArrangement.add(new Cat(5));
			newStallArrangement.add(new Cow(5));
			return newStallArrangement;
		}
	}

	
} //end main class




 

