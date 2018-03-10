import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Rebecca
 */
public class Cliente
{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			InterfaceCalculoRemoto objCalculoRemoto = (InterfaceCalculoRemoto) Naming
					.lookup("rmi://localhost/calc");

			int val1 = Integer.parseInt(JOptionPane
					.showInputDialog("Entre com o primeiro valor"));

			String opcao[] = { "+", "-", "*", "/" };

			int operacao = JOptionPane.showOptionDialog(null,
					"Escolha uma das operacoes", "Tipo de operacao", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);

			int val2 = Integer.parseInt(JOptionPane
					.showInputDialog("Entre com o segundo valor"));

			double resultado = objCalculoRemoto.metodoCalcular(val1, val2,
					operacao);
			System.out.println("resposta � : " + resultado);
			objCalculoRemoto.mensagemServidor("Recebi a Resposta");

		}
		catch (MalformedURLException | RemoteException | NotBoundException e)
		{
			System.out.println("Erro:" + e.toString());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Entrada inv�lida",
					e.getMessage(), JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}
}