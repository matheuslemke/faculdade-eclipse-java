package floydwarshall;

import java.util.ArrayList;

public class Constants
{
	public static boolean debug = false;
	public static boolean debug2 = false;

	public int ç = 100000000; // Integer.MAX_VALUE não funciona por causa
								// do estouro de memoria na hora da soma

	// public int[][] matrix =
	// {
	// { 0, 8, ç, 7, ç, ç },
	// { 8, 0, 3, 5, 8, ç },
	// { ç, 3, 0, ç, 4, 2 },
	// { 7, 5, ç, 0, 1, ç },
	// { ç, 8, 4, 1, 0, 7 },
	// { ç, ç, 2, ç, 7, 0 } };

	Link one_zero = new Link(new ArrayList<Integer>() {{add(0); }}, new ArrayList<Integer>() {{add(1);}}, 9);
	Link two_zero = new Link(new ArrayList<Integer>() {{add(0); }}, new ArrayList<Integer>() {{add(2);}}, 2);
	Link two_one = new Link(new ArrayList<Integer>() {{add(1); }}, new ArrayList<Integer>() {{add(2);}}, 3);
	Link thr_zero = new Link(new ArrayList<Integer>() {{add(0); }}, new ArrayList<Integer>() {{add(3);}}, ç);
	Link thr_one = new Link(new ArrayList<Integer>() {{add(1); }}, new ArrayList<Integer>() {{add(3);}}, 4);
	Link thr_two = new Link(new ArrayList<Integer>() {{add(2); }}, new ArrayList<Integer>() {{add(3);}}, ç);
	Link four_zero = new Link(new ArrayList<Integer>() {{add(0); }}, new ArrayList<Integer>() {{add(4);}}, ç);
	Link four_one = new Link(new ArrayList<Integer>() {{add(1); }}, new ArrayList<Integer>() {{add(4);}}, ç);
	Link four_two = new Link(new ArrayList<Integer>() {{add(2); }}, new ArrayList<Integer>() {{add(4);}}, 1);
	Link four_thr = new Link(new ArrayList<Integer>() {{add(3); }}, new ArrayList<Integer>() {{add(4);}}, 9);
	
	public Link[][] matrix =
	{
	{ null, null, null, null, null },
	{ one_zero, null, null, null, null },
	{ two_zero, two_one , null, null, null },
	{ thr_zero, thr_one, thr_two, null, null },
	{ four_zero, four_one, four_two, four_thr, null } };

}
