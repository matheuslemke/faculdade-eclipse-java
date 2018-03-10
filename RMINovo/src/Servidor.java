import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * @author Rebecca
 */
public class Servidor implements java.rmi.Remote
{

	/**
	 * 
	 * @throws RemoteException
	 */
	public Servidor() throws RemoteException
	{

		try
		{
			// LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/calc",
					new ImplementacaoCalculoRemoto());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException
	{
		new Servidor();
	}
}