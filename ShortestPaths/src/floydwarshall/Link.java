package floydwarshall;

import java.util.List;

public class Link
{
	private List<Integer> interSource;
	private List<Integer> interTarget;
	private int w;

	public Link(List<Integer> interSource, List<Integer> interTarget, int w)
	{
		this.interSource = interSource;
		this.interTarget = interTarget;
		this.w = w;
	}

	public List<Integer> getInterSource()
	{
		return interSource;
	}

	public void setInterSource(List<Integer> interSource)
	{
		this.interSource = interSource;
	}

	public List<Integer> getInterTarget()
	{
		return interTarget;
	}

	public void setInterTarget(List<Integer> interTarget)
	{
		this.interTarget = interTarget;
	}

	public int getW()
	{
		return w;
	}

	public void setW(int w)
	{
		this.w = w;
	}

}
