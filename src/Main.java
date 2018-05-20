
import java.io.*;
import java.util.*;
import prWordCounterSimpleCollection.*;



public class Main {
	public static void main(String [] args) {
		String [] data = {	
				"The animal I really dig,",
				"Above all others is the pig.",
				"Pigs are noble. Pigs are clever,",
				"Pigs are courteous. However,",
				"Now and then, to break this rule,",
				"One meets a pig who is a fool."};		

		String delimiters = "[ .,:;\\-\\!\\�\\�\\?]+";    // Using Scanner 
		
		System.out.println("A word counter is created");
		WordCounter counter = new WordCounter();

		counter.addAll(data, delimiters);
		System.out.println(counter + "\n");
		
		try 
		{
			System.out.println(counter.find("pig"));
			System.out.println(counter.find("big"));
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println(e.getMessage()+"\n");
		}
		
		//The program runs again using I/O operations
		System.out.println("This time the program works with files");
		counter = new WordCounter();
		// Each word in data.txt is added
		try
		{
			
			counter.addAllFile("pig.txt", delimiters);
			System.out.println(counter + "\n");
			
		    //Words are printed on screen
			System.out.println("Screen output: ");
			PrintWriter pw = new PrintWriter(System.out, true);
			counter.printWords(pw);
			
			//Words are written to a file
			System.out.println("\nOutput file: output.txt\n");
			counter.printWords("output.txt");
			                                          
		}
		catch (Exception e)
		{
			System.out.println("ERROR:"+ e.getMessage());
		}
		
		
		// A SignificantWordsCounter now is created .................................
		
		String [] noSignificant = {"THE", "AND", "THEN", "TO", "THIS", "A"};
		Collection<String> nsWords = new HashSet<String>();
		for (String w : noSignificant){ nsWords.add(w); }
		
		System.out.println("A SignificantWordsCounter is created: ");
		SignificantWordsCounter significantWordsCounter = new SignificantWordsCounter(nsWords);
		significantWordsCounter.addAll(data, delimiters);
		System.out.println(significantWordsCounter + "\n");
		
		//The program runs again using files ................
		System.out.println("We create another SignificantWordsCounter word counter using data from a file");
				
		// Each word in data.txt is added.	
		
			significantWordsCounter = new SignificantWordsCounter("NoSignificantWordsFile.txt", delimiters);
			significantWordsCounter.addAllFile("pig.txt", delimiters);
			System.out.println(significantWordsCounter + "\n");
					
			
			System.out.println("Screen output:");
			PrintWriter pw = new PrintWriter(System.out, true);
			significantWordsCounter.printWords(pw);
					
			
			System.out.println("\nOutput file: NoSignificantWords.txt");
			significantWordsCounter.printWords("NoSignificantWords.txt");
					                                          
			
	}
}
