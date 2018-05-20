import prWordCounterSimpleCollection.WordInText;


public class WordInTextTest {

    public static void main(String[] args){

        WordInText word1 = new WordInText("Dog");
        WordInText word2 = new WordInText("Cat");
        WordInText word3 = new WordInText("HORSE");
        WordInText word4 = new WordInText("horse");

        word1.increase();
        word1.increase();
        word2.increase();
        word3.increase();
        word3.increase();
        word4.increase();


        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);
        System.out.println(word4);

        
        int comparator = word1.compareTo(word2);
        switch (comparator) {
        	case 0: 
        		 System.out.println(word1.toString() + " and " + word2.toString() + " are equal");
        		 break;
        	case 1:
        		System.out.println(word1.toString() + " is bigger than " + word2.toString());
       		 	break;
        	case -1:
        		System.out.println(word1.toString() + " is lower than " + word2.toString());
       		 	break;
       		default:
       			System.out.println("Wrong comparator");
       			break;
        }
        
        comparator = word3.compareTo(word4);
        switch (comparator) {
        case 0: 
   		 System.out.println(word3.toString() + " and " + word4.toString() + " are equal");
   		 break;
        case 1:
   		System.out.println(word3.toString() + " is bigger than " + word4.toString());
  		 	break;
        case -1:
   		System.out.println(word3.toString() + " is lower than " + word4.toString());
  		 	break;
   		default:
   			System.out.println("Wrong comparator");
   			break;
        }


       
    }
}
