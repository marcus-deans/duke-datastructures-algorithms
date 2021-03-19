
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Spring 2020
 * Although this class has a history of several years,
 * it is starting from a blank-slate, new and clean implementation
 * as of Fall 2018.
 * <P>
 * Changes include relying solely on a tree for header information
 * and including debug and bits read/written information
 * 
 * @author Owen Astrachan
 */

public class HuffProcessor {

	public static final int BITS_PER_WORD = 8;
	public static final int BITS_PER_INT = 32;
	public static final int ALPH_SIZE = (1 << BITS_PER_WORD); 
	public static final int PSEUDO_EOF = ALPH_SIZE;
	public static final int HUFF_NUMBER = 0xface8200;
	public static final int HUFF_TREE  = HUFF_NUMBER | 1;

	private final int myDebugLevel;
	
	public static final int DEBUG_HIGH = 4;
	public static final int DEBUG_LOW = 1;
	
	public HuffProcessor() {
		this(0);
	}
	
	public HuffProcessor(int debug) {
		myDebugLevel = debug;
	}



//		Original Code
//		while (true){
//			int val = in.readBits(BITS_PER_WORD);
//			if (val == -1) break;
//			out.writeBits(BITS_PER_WORD, val);
//		}
//		out.close();

		// Our Code Below
	/**
	 * Compresses a file. Process must be reversible and loss-less.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be compressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void compress(BitInputStream in, BitOutputStream out){
		int[] count = readForCounts(in);
		HuffNode root = makeTreeFromCounts(count);
		//Our equivalent to makeCodingsFromTree because we have the methods already
		String[] codings = trails(root);

		out.writeBits(BITS_PER_INT, HUFF_TREE);
		writeHeader(root, out);

		in.reset();
		writeCompressedBits(codings,in,out);
		out.close();
	}

	/**
	 * Creates an integer array representing the frequency of the characters in the array, which
	 * are represented by 8 b its
	 * @param in is the buffered bit stream of the characters as bits
	 * @return integer array representing the frequency
	 */
	private int[] readForCounts(BitInputStream in){
		int[] reader = new int[ALPH_SIZE+1];
		while(true){
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) break;
			reader[val] += 1;
		}
		reader[PSEUDO_EOF] = 1;
		return reader;
	}

	/**
	 * This creates the header in the compressed file that contains the encoding tree
	 * this allows the decompressor to decompress the file
	 * @param root is the current node of the tree that is being converted
	 * @param out the BitOutputStream as the header
	 */
	private void writeHeader (HuffNode root, BitOutputStream out){
		if(((root.myLeft == null)&&(root.myRight == null))&&(root!=null)){
			out.writeBits(1,1);
			int val = root.myValue;
			out.writeBits(BITS_PER_WORD + 1, val);
		}
		else if(root != null){
			out.writeBits(1,0);
			writeHeader(root.myLeft, out);
			writeHeader(root.myRight, out);
		}
	}

	/**
	 * This creates the bits for the compressed data that is added to the input file
	 * based on the encoding of tree
	 * @param codings the encodings used to compress the file
	 * @param in input stream of data to be compressed
	 * @param out output stream of compressed data
	 */
	private void writeCompressedBits(String[] codings, BitInputStream in, BitOutputStream out){
//		for(int i = 0; i<codings.length-1; i++){
//			if(codings[i] != null){
//			String code = codings[i];
//			System.out.println(code);
//			out.writeBits(code.length(), Integer.parseInt(code, 2));
//		}}
		while(true){
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) break;
			String code = codings[val];
			out.writeBits(code.length(), Integer.parseInt(code, 2));
		}
		String code = codings[PSEUDO_EOF];
		out.writeBits(code.length(), Integer.parseInt(code, 2));
	}

	/**
	 * This creates the HuffmanTree used for the encodings
	 * @param freq integer array generated previously for the frequency
	 *             of the characters to be converted
	 * @return HuffmanTree of encodings
	 */
	private HuffNode makeTreeFromCounts(int[] freq){
		PriorityQueue<HuffNode> pq = new PriorityQueue<>();
		for(int i = 0; i<freq.length; i++){
			if(freq[i]>0){
				pq.add(new HuffNode(i, freq[i], null, null));
			}
		}
		while (pq.size() > 1){
			HuffNode left = pq.remove();
			HuffNode right = pq.remove();
			HuffNode t = new HuffNode(0, left.myWeight+right.myWeight, left, right);
			pq.add(t);
		}
		HuffNode root = pq.remove();
		return root;
	}

	/**
	 * Creates the codings from the tree by traversing it and generating a string of 0s and 1s
	 * @param tree is the HuffmanTree that will be represented in the binary string
	 * @return Binary string of encodings
	 */
	private String[] trails(HuffNode tree){
		String[] encodings = new String[ALPH_SIZE+1];
		findPaths(tree,"", encodings);
		return encodings;
	}

	/**
	 * Recursive method that creates the actual string of encodings
	 * @param t the current node of hte tree that is being traversed
	 * @param path the representative string of encodings being made
	 * @param encodings the frequency of the characters
	 */
	private void findPaths(HuffNode t, String path, String[] encodings){
		if(t == null){
			return;
		}
		if(t.myLeft == null && t.myRight == null){
			encodings[t.myValue] = path;
			return;
		}
		else {
			findPaths(t.myLeft, path + "0", encodings);
			findPaths(t.myRight, path + "1", encodings);
		}
	}

	//        myList = new TreeMap<>();
//        if (tree == null){
//            return null;
//        }
//        findPaths(tree, "");
////        Collections.sort(myList);
//        Set<Integer> keys = myList.keySet();
//        String[] fina = new String[myList.size()];
//        int count = 0;
//        for(int x: keys){
//            fina[count] = myList.get(x);
//            count ++;
//        }
//        return fina;
//Leaf Trails code starts here

//    private TreeMap<Integer, String> myList;


	/**
	 * Decompresses a file. Output file must be identical bit-by-bit to the
	 * original.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void decompress(BitInputStream in, BitOutputStream out){

		int magic = in.readBits(BITS_PER_INT);
		if (magic != HUFF_TREE) {
			throw new HuffException("invalid magic number "+magic);
		}
		HuffNode root = readTree(in);
		HuffNode current = root;
//		out.writeBits(BITS_PER_INT,magic);
		while (true){
//			int val = in.readBits(BITS_PER_WORD);
			int val = in.readBits(1);
			if (val == -1){
				throw new HuffException("bad input, no PSEUDO_EOF");
			}
			else{
				if(val == 0){
					current = current.myLeft;
				}
				else{
					current = current.myRight;
				}
				if(current.myLeft == null && current.myRight == null){
					if(current.myValue == PSEUDO_EOF) {
						break;
					}
					else{
						//write 8bits for current.value;
						out.writeBits(BITS_PER_WORD, current.myValue);
						current = root;
					}
				}
			}
//			out.writeBits(BITS_PER_WORD, val);
		}
		out.close();
	}

	/**
	 * Reads the string representation of the tree that is at the start of the encoded text
	 * and builds a HuffmanTree to use to decode it
	 * @param in the input stream of bits representing the compressed characters
	 * @return the representative node of the HuffmanTree
	 */
	private HuffNode readTree(BitInputStream in){
		int bit = in.readBits(1);
		if (bit == -1){
			throw new HuffException("invalid bit");
		}
		if (bit == 0){
			HuffNode left = readTree(in);
			HuffNode right = readTree(in);
			return new HuffNode(0,0,left,right);
		}
		else{
			int value = in.readBits(BITS_PER_WORD+1);
			return new HuffNode(value, 0, null, null);
		}
	}

}