package prWordCounterSimpleCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class SignificantWordsCounter extends WordCounter {

    private Collection<String> noSignificant;

    public SignificantWordsCounter (Collection<String> wordsNS){
        super();
        noSignificant = new TreeSet<String>();
        for (String w : wordsNS) {
            this.noSignificant.add(w.toUpperCase());
        
        }
        
    }

    public SignificantWordsCounter(String noSignificantFile, String sep){
        super();
        noSignificant = new TreeSet<String>();
        readNoSignificantFromFile(noSignificantFile, sep);
    }



    public void readNoSignificantFromFile(String filename, String del){
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)) {
            readNoSignificantWords(sc, del);
        } catch (FileNotFoundException e){
            e.getMessage();
        }


    }
    private void readNoSignificantWords(Scanner sc, String sep){
        while(sc.hasNextLine())
            addAllNS(sc.nextLine(),sep);
        sc.close();
    }


    public void add(String word){
        if (!this.noSignificant.contains(word.toUpperCase()))
            super.add(word);
    }

    public void addNoSiginificant(String word){
        if (!this.noSignificant.contains(word))
        	this.noSignificant.add(word);
    }

    public void addAllNS(String line, String del){

        Scanner sc = new Scanner(line);
        sc.useDelimiter(del);
        while (sc.hasNext())
        	addNoSiginificant(sc.next());
        sc.close();
    }



   
    
}
