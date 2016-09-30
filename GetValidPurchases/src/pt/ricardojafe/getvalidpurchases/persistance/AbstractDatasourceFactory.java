package pt.ricardojafe.getvalidpurchases.persistance;

public class AbstractDatasourceFactory {

	
	private IPurchaseDS instance;
	private MySqlInstance mySqlInstance;
	
	public IPurchaseDS getDSInstance(){
		return instance;
	}
	public MySqlInstance getMySqlInstanceIfAvailable(){
		return mySqlInstance;
	}
	
}
