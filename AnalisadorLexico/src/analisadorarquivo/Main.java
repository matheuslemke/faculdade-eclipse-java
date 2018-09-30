package analisadorarquivo;

public class Main
{
	public static void main(String[] args)
	{
		LexicalAnalyser la = new LexicalAnalyser(
				"/home/matheus/Dropbox/Workspace/EclipseMars/AnalisadorLexico/src/analisadorarquivo/source",
				"/home/matheus/Dropbox/Workspace/EclipseMars/AnalisadorLexico/src/analisadorarquivo/keywords",
				"/home/matheus/Dropbox/Workspace/EclipseMars/AnalisadorLexico/src/analisadorarquivo/symbols");
		la.run();
		la.showResults();
	}
}
