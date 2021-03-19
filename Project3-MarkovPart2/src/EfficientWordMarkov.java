import java.util.*;

/**
 *  * Program to more efficiently create a Markov Model based on a text of String
 *  * Compared to the BaseWordMarkov Method
 *  * This will use a Map to store values instead of naively reiterating through text
 *  * Marcus Deans (md374)
 */
public class EfficientWordMarkov extends BaseWordMarkov{
    /**
     * Constructor for EfficientWordMarkov used throughout program
     * @param order Size of Markov Model to base calculations on
     */
    public EfficientWordMarkov(int order){
        myOrder = order;
        myRandom = new Random(RANDOM_SEED);
    }
    private HashMap<WordGram,ArrayList<String>> myMap = new HashMap<>();
    /**
     * Call EfficientWordMarkov with Order 2 to initialize
     */
    public EfficientWordMarkov() {
        this(2);
    }

    /**
     * Method to populate map with markov model wordgrams and possibilites
     * @param text string of text that markov model is constructed from
     */
    @Override
    public void setTraining(String text) {
        super.setTraining(text); //takes String of text and splits into String[]
        myMap.clear();
//        int newinde = 0;
        for (int z = 0; z<myWords.length-myOrder+1; z++){
            WordGram ngram = new WordGram(myWords, z,myOrder);
            myMap.putIfAbsent(ngram, new ArrayList<String>());
            if(z == myWords.length-myOrder){
                myMap.get(ngram).add(PSEUDO_EOS);
            }
            else{
                String nword = myWords[z+myOrder];
                myMap.get(ngram).add(nword);
            }
//            ArrayList<String> temp = myMap.get(ngram);
//            temp.add(nword);
//            myMap.put(ngram, temp);
//            newinde +=1;
//            ngram = ngram.shiftAdd(nword);
        }
//        for (int p =0; p< text.length()-myOrder; p++){
//            String nsub = myText.substring(p, p+myOrder);
//            String nchar = myText.substring(p+myOrder, p+1+myOrder);
//            myMap.putIfAbsent(nsub, new ArrayList<String>());
//            ArrayList<String> temp = myMap.get(nsub);
//            temp.add(nchar);
//            myMap.put(nsub, temp);
//            newinde += 1;
//        }
//        ArrayList<String>panzer = new ArrayList<String>();
//        panzer.add(PSEUDO_EOS);
//        myMap.putIfAbsent(new WordGram(myWords, myWords.length, 1), panzer);
    }

    /**
     * Method to retrieve possible endings for the given WordGram
     * @param key is the WordGram for which additional strings should be found
     * @return value of key in the map, so the ArrayList of strings of possible endings
     */
    @Override
    public ArrayList<String> getFollows(WordGram key){
        if (myMap.get(key) == null){
            throw new NoSuchElementException(key + " not in map");
        }
        else{
            return myMap.get(key);
        }
    }
}
