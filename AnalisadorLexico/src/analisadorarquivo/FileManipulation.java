package analisadorarquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileManipulation
{
	public List<String> readSpecialFile(String type)
	{
		List<String> list = new LinkedList<>();
		try
		{
			BufferedReader readFile = new BufferedReader(new FileReader(type));
			String line = readFile.readLine();
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++)
				list.add(words[i]);
			readFile.close();
			return list;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public BufferedReader readSourceCodeFile(String filename)
	{
		try
		{
			return new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
