package com.splaytree;

public class Main
{
	public static void main(String[] args)
	{
		SplayBST<Integer, Integer> st = new SplayBST<Integer, Integer>();
		st.put(5, 5);
		st.put(9, 9);
		st.put(13, 13);
		st.put(11, 11);
		st.put(1, 1);

		System.out.println(st.get(1));
		st.remove(13);
		System.out.println(st.get(13));
	}
}
