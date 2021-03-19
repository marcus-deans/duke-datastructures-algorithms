import java.util.*;

/**
 * Program to more efficiently creat a Markov Model based on a text of Strings
 * Compared to the BaseMarkov Method
 * This will use a Map to store values instead of naively reiterating through text
 * Marcus Deans (md374)
 */
public class EfficientMarkov extends BaseMarkov {
	/**
	 * Constructor for EfficientMarkov used throughout program
	 * @param order of k-gram for Markov model
	 */
	public EfficientMarkov(int order) {
		super(order);
		myOrder = order;
		myRandom = new Random(RANDOM_SEED);
	}
	private HashMap<String,ArrayList<String>> myMap = new HashMap<>();

	/**
	 * Calls EfficientMarkov with order of 3
	 */
	public EfficientMarkov() {
		this(3);
	}

	/**
	 * Method to populate map with markov model substrings and possibilites
	 * @param text string of text that is markov model is constructed from
	 */
	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
//		int newinde = 0;
		for (int p =0; p< text.length()-myOrder+1; p++){
			String nsub = myText.substring(p, p+myOrder);
			myMap.putIfAbsent(nsub, new ArrayList<String>());
			if(p == text.length() - myOrder){
				myMap.get(nsub).add(PSEUDO_EOS);
			}
			else{
				String nchar = String.valueOf(myText.charAt(p+myOrder));
				myMap.get(nsub).add(nchar);
			}
//			ArrayList<String> temp = myMap.get(nsub);
//			temp.add(nchar);
//			myMap.put(nsub, temp);
//			newinde += 1;
		}
//		ArrayList<String>panzer = new ArrayList<String>();
//		panzer.add(PSEUDO_EOS);
//		myMap.putIfAbsent(myText.substring(text.length()-myOrder, text.length()), panzer);
	}

	/**
	 * Method to retrieve possible endings for the given substring
	 * @param key is the substring for which additional characters should be found
	 * @return value of key in the map, so the ArrayList of possible endings
	 */
	@Override
	public ArrayList<String> getFollows(String key){
		if (myMap.get(key) == null){
			throw new NoSuchElementException(key + " not in map");
		}
		else{
			return myMap.get(key);
		}
	}
}

//			if(nchar.equals(" ")){
//				break;
//			}

//			if (myMap.get(nsub) == null){
//				ArrayList<String> tempb = new ArrayList<>();
//				tempb.add(nchar);
//				myMap.put(nsub, tempb);
//			}
//			else {
//				ArrayList<String> temp = myMap.get(nsub);
//				temp.add(nchar);
//				myMap.put(nsub, temp);
//			}
// make new substring with following letter/
// put into array list1
//			myMap.put(nsub, super.getFollows(nsub));

