package textprocessor;

public class Cliente
{

	public static void main(String[] args)
	{
		TextProcessor tp = new TextProcessor("Padrão COMMAND");
		Command bold = new CommandBold(tp);
		Command italic = new CommandItalic(tp);
		Command underline = new CommandUnderline(tp);

		Macro macro = new Macro();
		macro.addCommand(bold);
		macro.addCommand(italic);
		macro.addCommand(underline);

		macro.executeAll();

	}
}
