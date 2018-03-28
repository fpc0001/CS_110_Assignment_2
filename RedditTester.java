import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class RedditTester {
	
	public static void main(String[] args) {
		
		
		Scanner user_input= new Scanner(System.in); //set-up new scanner
		
		//System.setOut(new PrintStream(new FileOutputStream("testingTestOneWord.txt")));
		
		String filePosts= "RedditPost.txt"; //user_input.nextLine();
		String fileAuthor= "RedditAuthors.txt"; //user_input.nextLine();
		String fileDate= "RedditDate.txt";  //user_input.nextLine();
		String fileNumComments= "RedditNumComments.txt";  //user_input.nextLine();
		String fileScore= "RedditScore.txt";   //user_input.nextLine();

		RedditReader file= new RedditReader();
		
		System.out.println("Welcome to the Reddit Keyword Data Compiler!");
		
		int x=1;
			
		while (x==1) {
			
			try {
				
		file.menu();
		String optionNum= user_input.nextLine();//"1"; 
		
		
		//System.setOut(new PrintStream(new FileOutputStream("testingBigTest.txt"))); //need to figure out how to switch back to console printing if I am going to do a loop.
		//Currently all actions above line 35 print to console, after all prints to txt file. 
		
		//System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); //getting back to console
		
		if (optionNum.equals("3")) {
			
			System.out.println("Enter the first word to search for: ");
			String keyword=  user_input.nextLine().toLowerCase(); 
			
			System.out.println("Enter the second word to search for: ");
			String keyword1= user_input.nextLine().toLowerCase();
			
			System.out.println("Enter the third word to search for: ");
			String keyword2= user_input.nextLine().toLowerCase();
			
			System.out.println("To conduct a search with results of posts containing either word or both words (logical OR) enter: OR");
			System.out.println("To conduct a search with results of posts containing both words (logical AND) enter: AND");
			String ANDOR= user_input.nextLine().toUpperCase();
			System.out.println("Enter the file name to print output to: ");
			String outputFile= user_input.nextLine();
			
			System.setOut(new PrintStream(new FileOutputStream(outputFile)));
			file.checkThreeKeywords(filePosts, fileAuthor, fileDate, fileNumComments, fileScore, keyword, keyword1, keyword2, ANDOR);
		
		
			}else if (optionNum.equals("2")) {
			
			System.out.println("Enter the first word to search for: ");
			String keyword=  user_input.nextLine().toLowerCase(); 
			
			System.out.println("Enter the second word to search for: ");
			String keyword1= user_input.nextLine().toLowerCase();
			
			System.out.println("To conduct a search with results of posts containing either word or both words (logical OR) enter: OR");
			System.out.println("To conduct a search with results of posts containing both words (logical AND) enter: AND");
			String ANDOR= user_input.nextLine().toUpperCase();
			System.out.println("Enter the file name to print output to: ");
			String outputFile= user_input.nextLine();
			
			System.setOut(new PrintStream(new FileOutputStream(outputFile)));
			file.checkTwoKeywords(filePosts, fileAuthor, fileDate, fileNumComments, fileScore, keyword, keyword1, ANDOR);
			
		}else if (optionNum.equals("1")) {
			
			System.out.println("Enter the first word to search for: ");
			String keyword=  user_input.nextLine(); 
			System.out.println("Enter the file name to print output to: ");
			String outputFile= user_input.nextLine();
			
			System.setOut(new PrintStream(new FileOutputStream(outputFile)));
			file.checkOneKeyword(filePosts, fileAuthor, fileDate, fileNumComments, fileScore, keyword);
			
		}else if (optionNum.equals("0")) {
			
			x=0;
			System.out.println("Thank you for using Reddit Keyword Data Compiler!");
			
		}else {
			
			System.out.println("Error: invalid option seleted.");
			
		}
			}
		catch (Exception e) {
			System.out.println("A fatal error occured. check all spelling, make sure file names were entered correctly, when selecting to do a logical search use AND or OR.");
		}
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}	
		user_input.close();
	}	
	}
//two word formatting
//make keywords go to all lowercase
//add three word OR/AND ???
//do like above, but instead of keyword search, add date search, score above x, score below x, number of comments above/below x???????