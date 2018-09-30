package analisadorarquivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LexicalAnalyser
{
	private List<String> keywordsFromLanguage;
	private List<String> symbolsFromLanguage;

	private List<String> keywords = new LinkedList<>();
	private List<String> symbols = new LinkedList<>();
	private List<String> numbers = new LinkedList<>();
	private List<String> identifiers = new LinkedList<>();
	private List<String> strings = new LinkedList<>();
	private List<String> errors = new LinkedList<>();

	private BufferedReader sourceCodeRead;

	public LexicalAnalyser(String sourceCodeFilename, String keywordsFilename, String symbolsFilename)
	{
		FileManipulation fm = new FileManipulation();
		this.keywordsFromLanguage = fm.readSpecialFile(keywordsFilename);
		this.symbolsFromLanguage = fm.readSpecialFile(symbolsFilename);
		this.sourceCodeRead = fm.readSourceCodeFile(sourceCodeFilename);
	}

	public void run()
	{
		try
		{
			String line = sourceCodeRead.readLine();
			String[] words;
			while (line != null)
			{
				words = line.split(" ");

				for (int i = 0; i < words.length; i++)
				{
					if (keywordsFromLanguage.contains(words[i]))
					{
						if (!keywords.contains(words[i]))
							keywords.add(words[i]);
					} else if (symbolsFromLanguage.contains(words[i]))
					{
						if (!symbols.contains(words[i]))
							symbols.add(words[i]);
					} else if (words[i].matches("\\d+"))
						numbers.add(words[i]);
					else if (words[i].matches("\".*\""))
						strings.add(words[i]);
					else if (words[i].matches("[a-zA-Z].*"))
					{
						// if (!symbolsFromLanguage.contains(words[i]))
						int n = 0;
						for (String identifier : identifiers)
							if (!identifier.equals(words[i]))
								n++;
						if (n == identifiers.size())
							identifiers.add(words[i]);
					} else
						errors.add(words[i]);
				}
				line = sourceCodeRead.readLine();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void showResults()
	{
		System.out.println("Keywords");
		System.out.println(keywords.toString());
		System.out.println("Symbols");
		System.out.println(symbols.toString());
		System.out.println("Numbers");
		System.out.println(numbers.toString());
		System.out.println("Strings");
		System.out.println(strings.toString());
		System.out.println("Identifiers");
		System.out.println(identifiers.toString());
		System.out.println("Errors");
		System.out.println(errors.toString());
	}
}
