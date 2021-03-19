import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Marcus Deans
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		int y = start;
		for (int x = 0; x<size; x++){
			myWords[x] = source[y];
			y += 1;
		}
//		myWords = source;
		myToString = null;
		myHash = 0;
		// TODO: initialize myWords
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return integer value of length of object's myWords
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o object to be compared
	 * @return whether object o same as existing, or false if NOT
	 */
	@Override
	public boolean equals(Object o) {
		boolean coor = true;
		if (!(o instanceof WordGram) || o == null){
			coor = false;
		}
		if(o instanceof WordGram){
			WordGram wg = (WordGram) o;
//			if ((hashCode(this.myToString))==(hashCode(wg))){
//				coor = true;
//			}
//			else{
//				coor = false;
//			}
			if(this.myWords.length != wg.myWords.length){
				return false;
			}
			for (int x =0; x<wg.myWords.length; x++){
				if((wg.myWords[x]).equals(this.myWords[x])){
					coor = true;
				}
				else{
					coor = false;
					break;
				}
			}
		}
		return coor;
//		WordGram wg = (WordGram)o;
//		if(Arrays.equals(wg.myWords, this.myWords)){
//			return true;
//		}
//		else{
//			return false;
//		}
		// TODO: Complete this method
	}

	/**
	 * Return hashcode for WordGram
	 * @return hashcode for current Wordgram
	 */
	@Override
	public int hashCode(){
		// TODO: complete this method
		if (this.myHash == 0){
			this.myHash = this.toString().hashCode();
		}
		return this.myHash;
//		int phan = this.toString().hashCode();
//		if (myHash==phan){
//			return myHash;
//		}
//		else{
//			myHash = phan;
//			return myHash;
//		}
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return new WordGram with String added
	 */
	public WordGram shiftAdd(String last) {
		String[] newWords = new String[myWords.length];
		WordGram wg = new WordGram(myWords,1,myWords.length-1);
		for (int x = 0; x<wg.myWords.length; x++){
			newWords[x] = wg.myWords[x];
		}
		newWords[myWords.length-1] = last;
		wg.myWords = newWords;
		// TODO: Complete this method
		return wg;
	}

	/**
	 * Create new toString method to join myWords into one string
	 * @return singular String consisting of joined myWords of WordGram
	 */
	@Override
	public String toString(){
		// TODO: Complete this method
		if(this.myToString==null) {
			this.myToString = String.join(" ",myWords);
		}
		return this.myToString;
	}
}
