package com.constants;

public interface Graph
{
	public void addEdge(int vertex1, int vertex2, double w);
	
	public double getEdge(int vertex1, int vertex2);
	
	public int getN();
}
