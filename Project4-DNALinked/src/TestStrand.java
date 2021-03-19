import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Iterator;

/**
 * Class for running JUNit tests with different implementations of IDnaStrand.
 * To use a different implementation alter the method <code>getNewStrand</code>
 * since that method is called by all JUnit tests to create the IDnaStrand
 * objects being tested.
 * 
 * @author ola
 * @date January 2008, modified and commented in September 2008
 * @date January 2009, added splice testing
 * @date October 2015, added nodeList
 * @date October 2016, updated for iterator and no "" strings
 */

public class TestStrand {
	private static String[] strs = { "aggtccg", "aaagggtttcccaaagggtttccc", "a", "g",
			"aggtccgttccggttaaggagagagagagagttt" };

	/**
	 * Return a strand to test by other JUnit tests
	 * 
	 * @param s
	 *            is the string modeled by an IDnaStrand implementation
	 * @return an IDnaStrand object for testing in this JUnit testing class.
	 */
	public IDnaStrand getNewStrand(String s) {
		//return new StringStrand(s);
		return new LinkStrand(s);
//		return new StringBuilderStrand(s);
	}

	/**
	 * This test checks if .size() returns the correct value for basic cases"
	 */
	@Test
	public void testSize() {
		for (String s : strs) {
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand str = getNewStrand(s);
				return str;
			});
			assertEquals(s.length(), strand.size(),"This test checks if .size() returns the correct value"
					+ " for basic cases. The test case failed on was " + s);
		}
	}

	/**
	 * This test checks if toString works correctly for basic cases.
	 */
	@Test
	public void testToString() {
		for (String s : strs) {
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand str = getNewStrand(s);
				return str;
			});
			assertEquals(s, strand.toString(),"This test checks if toString works correctly for "
					+ "basic cases. The test case failed on was " + s);
			assertEquals(s.length(), strand.size(),"This test checks if toString works correctly for "
					+ "basic cases. The test case failed on was " + s);
		}
	}

	/** This test checks if initializeFrom works correctly for basic cases */
	@Test
	public void testInitialize() {
		for (String s : strs) {
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand str = getNewStrand("");
				str.initialize(s);
				return str;
			});
			assertEquals(s.length(), strand.size(),"This test checks if initializeFrom works correctly"
					+ " for basic cases. The test case failed on was " + s);
			assertEquals( s, strand.toString(),"This test checks if initializeFrom works correctly"
					+ " for basic cases. The test case failed on was " + s);
		}
	}

	/**
	 * This test checks if reverse works correctly for "simple cases"
	 */
	@Test
	public void testReverse() {
		for (String s : strs) {
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand str = getNewStrand(s);
				IDnaStrand rev = str.reverse();
				return rev;
			});
			String rs = new StringBuilder(s).reverse().toString();
			assertEquals(strand.toString(), rs,"This test checks if reverse works correctly for "
					+ "simple cases. The test case failed on was " + s);
		}
	}

	@Test
	/** This test checks if append works correctly for simple cases */
	public void testAppend() {
		String app = "gggcccaaatttgggcccaaattt";
		for (String s : strs) {
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand str = getNewStrand(s);
				str.append(app);
				return str;
			});
			assertEquals(s + app, strand.toString(),
					"This test checks if append works correctly for "
							+ "simple cases. The test case failed on was appending " + app + " to " + s
					);
			assertEquals(s.length() + app.length(), strand.size(),
					"This test checks if append works correctly for "
							+ "simple cases. The test case failed on was appending " + app + " to " + s
					);
		}
	}

	/**
	 * This test checks if cutAndSplice works correctly for simple cases
	 */
	@Test
	public void testSplice() {
		String r = "gat";
		String sp = "xxyyzz";
		String[] strands = { "ttgatcc", "tcgatgatgattc", 
				             "tcgatctgatttccgatcc", "gat",
				             "gatctgatctgat", "gtacc",
				             "gatgatgat" };
		String[] recombs = { "ttxxyyzzcc", "tcxxyyzzxxyyzzxxyyzztc", 
				             "tcxxyyzzctxxyyzzttccxxyyzzcc", "xxyyzz",
				             "xxyyzzctxxyyzzctxxyyzz", "","xxyyzzxxyyzzxxyyzz" };

		for (int k = 0; k < strands.length; k++) {
			IDnaStrand str = getNewStrand(strands[k]);
			String bef = str.toString();
			final IDnaStrand strand = assertTimeout(Duration.ofMillis(10000),()->{
				IDnaStrand rec = str.cutAndSplice(r, sp);
				return rec;
			});
			assertEquals(recombs[k], strand.toString(),
					"This test checks if cutAndSplice works correctly for "
							+ "simple cases. The test case failed on was splicing " + sp + " into " + strands[k]
					);
			assertEquals(bef, str.toString(),
					"This test checks if cutAndSplice works correctly for "
							+ "simple cases. The test case failed on was splicing " + sp + " into " + strands[k]
					);
		}
	}
	
	/**
	 *	Checks if iterator methods are implemented correctly
	 */
	@Test
	public void testIterator() {
		IDnaStrand test = getNewStrand(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			test.append(strs[i]);
		}
		String all = test.toString();
		Iterator<Character> itc = test.iterator();

		for (int i = 0; i < all.length(); i++) {
			final int index = i;
			Assertions.assertAll("iterator output",
			()->assertTrue(itc.hasNext(),"next at "+index+" of "+all.length()),
			()->assertTrue(all.charAt(index) == itc.next(),"chars equal at "+index));
		}
		
		assertFalse(itc.hasNext(),"no next when done");
	}
}
