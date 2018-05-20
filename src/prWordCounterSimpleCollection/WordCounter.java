package prWordCounterSimpleCollection;

import java.io.*;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCounter {

    private Collection<WordInText> words;

    public WordCounter(){
        this.words = new TreeSet<WordInText>();
    }

   
    //NEW
    protected void add(String word){
    	boolean flag = true;
    	for (WordInText w : this.words)
            if (w != null) {
                String wordToCompare = w.toString();
                if (wordToCompare.split(":")[0].equals(word.toUpperCase())) {
                    w.increase();
                    flag = false;
                }
                
            }
        
    	if (flag) {
    		WordInText newWord = new WordInText(word);
    		this.words.add(newWord);
    	}
    	
    }
    
  //NEW
    public void addAll(String line, String del){

        Scanner sc = new Scanner(line);
        sc.useDelimiter(del);
        while (sc.hasNext())
            add(sc.next());
        sc.close();
    }

  //NEW
    public void addAll(String[] text, String del){
        for (String textLine : text)
            addAll(textLine,del);
    }

  //NEW
    public void addAllFile(String filename, String del){
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)) {
            readFile(sc, del);
        } catch (FileNotFoundException e){
        	System.out.println("File not found");
        }


    }


    //NEW
    public WordInText find (String word){
    	for (WordInText w : this.words)
            if (w != null) {
                String wordToCompare = w.toString();
                if (wordToCompare.split(":")[0].equals(word.toUpperCase()))
                    return w;
            }
        
    	throw new NoSuchElementException(word + " not found");
    	
    }
    	
    	
  //NEW
    public void printWords(String outputFile){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
        for (WordInText word : this.words)
            if (word!=null) {
                writer.write(word.toString() + "\n");
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Problem with output file");
        }
    }

  //NEW
    public void printWords(PrintWriter pw){
        for (WordInText word : this.words)
            if (word!=null)
            pw.println(word.toString());
    }

  //NEW
    @Override
    public String toString(){
        StringBuilder stringToReturn = new StringBuilder("[");
        for (WordInText word : this.words){
                stringToReturn.append(word.toString() + ", ");
            }
        stringToReturn.append("]");
        return stringToReturn.toString();
    }




    

    private void readFile(Scanner sc, String del){
        while(sc.hasNextLine())
            addAll(sc.nextLine(),del);
        sc.close();
    }
}
