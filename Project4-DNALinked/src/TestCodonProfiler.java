import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestCodonProfiler {

	private static IDnaStrand myTestStrand;
	private static CodonProfiler myProfiler;
	
	public static IDnaStrand getEmptyStrand() {
		return new StringStrand();
	}
	
	@BeforeAll
	public static void setUp() {
		String str = "cgacgacgatagtagtagtagcgacgacgacga";
		myTestStrand = getEmptyStrand();
		myTestStrand.initialize(str);
		myProfiler = new CodonProfiler();
	}
	
	@Test
	public void testNone() {
		String[] codons = {"aaa", "ttt", "gac", "gat"};
		int[] expected = {0,0,0,0};
		int[] counts = myProfiler.getCodonProfile(myTestStrand, codons);
		assertArrayEquals(expected,counts);
	}
	@Test
	public void testMulti() {
		String[] codons = {"cga", "gat","tag"};
		int[] expected = {7,0,4};
		int[] counts = myProfiler.getCodonProfile(myTestStrand, codons);
		assertArrayEquals(expected,counts);
	}

}
