import java.util.ArrayList;

public class LinkStrand implements IDnaStrand{
    /**
     * Constructor for Class Node to be used throughout LinkStrand Class
     */
    private class Node{
        String info;
        Node next;

        public Node(String q){
            info = q;
        }
        /**
         * Method to create new Node in LinkStrand
         * @param s string to be contained as information of new node
         * @param n the subsequent node to be placed correctly
         */
        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    /**
     * Create instance variables
     */
    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private int myLocalIndex;
    private Node myCurrent;

    /**
     * Initial call of LinkStrand with a blank string to create
     */
    public LinkStrand() {
        this("");
    }

    /**
     * Creates code to be used when LinkStrand is called
     * @param s string that will be used to initialize first node
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    //@Override
    //	public long size() {
    //		return myInfo.length();
    //	}

    /**
     * Method for size of LinkStrand information (charaters)
     * @return size of linkstrand information characters as long
     */
    @Override
    public long size() {
        return mySize;
    }
//	public void initialize(String source) {
//		myInfo = new StringBuilder(source);
//		myAppends = 0;
//	}

    /**
     * Method to initialize new LinkStrand
     * @param source is string that is used for information of the node (first) that is created
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        myAppends = 0;
        mySize = source.length();
        myIndex = 0;
        myLocalIndex = 0;
        myCurrent = myFirst;
    }

    /**
     * Overwriting initial method such to create LinkStrands
     * @param source is data from which object constructed
     * @return new LinkStrand with the string source
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }
    //	public IDnaStrand append(String dna) {
    //		myInfo.append(dna);
    //		myAppends++;
    //		return this;
    //	}

    /**
     * Method to add an additional node with information to linkedlist
     * @param dna is the string appended to this strand
     * @return linkstrand with new string as node appended
     */
    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, myLast.next);
        myLast = myLast.next;
//        myLast.info = dna;
        mySize += dna.length();
        myAppends++;
        return this;
    }
//		StringBuilder buf = new StringBuilder();
//		while (s.hasNextLine()) {
//			String line = s.nextLine().toLowerCase();
//			for (int k = 0; k < line.length(); k++) {
//				char ch = line.charAt(k);
//				if ("acgt".indexOf(ch) != -1) {
//					buf.append(ch);
//				}
//			}
//		}
//		return buf.toString();

    /**
     * Method to convert linkstrand to string
     * @return String representation of LinkStrand
     */
    @Override
    public String toString() {
        StringBuilder alf = new StringBuilder();
        Node counter = myFirst;
        while(counter != null){
            String cur = counter.info;
            alf.append(cur);
//            for (int p = 0; p < cur.length(); p++){
//                char ch = cur.charAt(p);
//                alf.append(ch);
//            }
            counter = counter.next;
        }
        return alf.toString();
    }
//    public String toString() {
//        return myInfo.toString();
//    }


//public IDnaStrand reverse() {
//		StringBuilder copy = new StringBuilder(myInfo);
//		StringBuilderStrand ss = new StringBuilderStrand("replace");
//		copy.reverse();
//		ss.myInfo = copy;
//		return ss;
//	}

    /**
     * Method to reverse order and node information of LinkStand, without mutating original
     * @return new reversed LinkStrand
     */
    @Override
    public IDnaStrand reverse() {
//        Node orgFirst = this.myFirst;
//        StringBuilder forgInfo = new StringBuilder(orgFirst.info);
//        forgInfo.reverse();
//        LinkStrand alter = new LinkStrand(forgInfo.toString());
//        Node newFirst = alter.myFirst;
//        orgFirst = orgFirst.next;
//        while(orgFirst != null){
//            StringBuilder orgInfo = new StringBuilder(orgFirst.info);
//            orgInfo.reverse();
//            Node newInfo = new Node(orgInfo.toString(),newFirst);
////            newInfo.next = newFirst;
//            newFirst = newInfo;
//            orgFirst = orgFirst.next;
//        }
//        return alter;
        Node iter=  this.myFirst;
        ArrayList<String> init = new ArrayList<String>();
        while(iter != null){
            StringBuilder meh = new StringBuilder(iter.info);
            meh.reverse();
            init.add(meh.toString());
            iter = iter.next;
        }
        int len = init.size();
        if(len<=0){
            return null;
        }
        LinkStrand ree = new LinkStrand(init.get(len-1));
        Node panz = ree.myFirst;
        for(int p = len-2; p >= 0; p-=1){
            Node alter = new Node(init.get(p));
            panz.next = alter;
            panz = panz.next;
        }
        ree.mySize = this.mySize;
        return ree;
//        Node panz = ree.myLast;
//        while(iter.next != myLast){
//            StringBuilder dual = new StringBuilder(this.toString());
//            dual.reverse();
//            Node alter = new Node(dual.toString(),panz);
//            alter.next = panz;
//            panz = alter;
//            alter.next = alter;
//            iter = iter.next;
//        }
//        return ree;
    }
//public IDnaStrand reverse() {
//		StringBuilder copy = new StringBuilder(myInfo);
//		copy.reverse();
//		StringStrand ss = new StringStrand(copy.toString());
//		return ss;
//	}

    /**
     * Method to return the number of strings appended
     * @return number of strings appended as integer
     */
    @Override
    public int getAppendCount() {
        return myAppends;
    }

    /**
     * Method to return char at specific index
     * @param index specifies which character will be returned
     * @return character present at the specified index
     */
    @Override
    public char charAt(int index) {
        int count = myIndex;
        int dex = myLocalIndex;
        Node list = myCurrent;
        if(index < myIndex){
            count = 0;
            dex = 0;
            list = myFirst;
        }
        int matx = 0;
        int chetk = 0;
        Node tept = myFirst;
//        while(tept.next != null){
//            matx ++;
//            chetk++;
//            if(chetk >= tept.info.length()){
//                chetk = 0;
//                tept = tept.next;
//            }
//        }
//        if((index>matx)||(index<0)){
//            throw new IndexOutOfBoundsException();
//        }
        if((index>=size())||(index<0)){
            throw new IndexOutOfBoundsException();
        }
        while (count != index){
            count++;
            dex++;
            if (dex >= list.info.length()){
                dex = 0;
                list = list.next;
            }
        }
        myIndex = count;
        myLocalIndex = dex;
        myCurrent = list;
        return list.info.charAt(dex);
    }

    //mark
}
