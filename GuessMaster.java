/* Program Description: A program that allows the user to 
 * 						guess the birthday of a famous person or object and if the
 * 						responds younger and older depending on the users guess. If the 
 * 						User guessign right it responds "Bingo" and gives another 
 * 						famous birthday to guess until the user types in "quit" or an 
 * 						invalid date. 
 * Author: Jonathan Stroz
 * NetID : 15jas11@queensu.caa
 * Student Number: 20005542
 * Last Changed: Febuary 6th, 2018.


*/ 
package PersonAndDate;

import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	// Initialize the number of entities used, and an array list of entities
	private static int numberOfCandidateEntities = 3;
	private static Entity[] entities;

	// Basic Constructor
	public GuessMaster() {
		entities = new Entity[numberOfCandidateEntities]; // There are 3 entities
		// Set number of candidates to 0 so new entities can be added to the array list
		numberOfCandidateEntities = 0;

	}

	// Adding a new entity using the number of canadidate entities and incrmemenitng
	// each time
	public void addEntity(Entity entity) {
		// adds new entity
		entities[numberOfCandidateEntities] = entity;
		numberOfCandidateEntities++;
	}

	// Function that scans input, returns the input form the user.
	public static String getInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter month, day, and year. in the formal mm/dd/yyyy");
		System.out.println("Do not use a comma.");
		String input = keyboard.nextLine();

		return input;

	}

	// Function that plays the game, this means that the function calls get input
	// and then checks whether the user input is
	// younger or older than the entities birth date, as well as checking whether or
	// not the input is "quit"
	public static void playGame(int entityInd) {
		// Given an entity, play the guessing game with regard to that entity
		// Use the precedes(date, otherDate) method
		// Start by printing question
		String name = entities[entityInd].getName();
		Date born = entities[entityInd].getBorn();

		System.out.println("When was " + name + " born? ");
		// Create new Date

		// Calling input
		String input = getInput();
		// checking if input equals to quit
		if (input.equals("quit")) {
			System.out.println("Quitting Program");
			// Exiting program
			System.exit(13);
		}
		// Creating a new date for the date entered by user
		Date guess = new Date(input);
        
		
		// Checking if the date is ok
		if (guess.dateOK(guess.getMonth(), guess.getDay(), guess.getYear())) {
			// If date is correct
			if (guess.equals(born)) {
				System.out.println("Bingo");

				// If date is older than birth day of entity
			} else if (guess.precedes(born)) {

				System.out.println("They are older!");
				playGame(entityInd);

				// If date is younger than birth day of entity
			} else if (guess.precedes(born) == false) {
				System.out.println("\nThey are younger!");
				playGame(entityInd);

			}

		} else {
			// If invalid date but correct format
			System.out.println("Please enter a valid date:");
			playGame(entityInd);
		}

	}

	// Start the game
	public void playGame(Entity entity) {
		// given an entity play the guessing game with entity passes as a parameter.
		playGame(numberOfCandidateEntities);
	}

	// Start Game by getting random number to select which entity to guess
	public static void playGame() {
		// generate random number
		// quits when player is done
		// gets user input
		while (true) {
			System.out.println("Welcome to the guessing Master!\n");
			int index = genRandomEntityInd();
			playGame(index);
		}
	}

	// Generating random number and return it, the max being the max number of
	// entities
	static int genRandomEntityInd() {
		Random rand = new Random();
		int random = rand.nextInt(numberOfCandidateEntities);

		return random;
	}

	public static void main(String[] args) {

		// Creating new Entities
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 14, 1776));

		// Creating new guess master
		GuessMaster gm = new GuessMaster();

		// adding entities defined above and adding them to the game master
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);

		// Starting the game
		playGame();
	}
}
