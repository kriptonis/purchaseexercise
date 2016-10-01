package pt.ricardojafe.getvalidpurchases.persistance;

/**
 * The Abstract Datasource factory provides the datasource to the Purchase Microservice,
 * allowing the service to be completely database-agnostic.
 * 
 * @author ricardo.jafe
 *
 */
public class AbstractDatasourceFactory {

	
	private IPurchaseDS instance = null;
	private MySqlInstance mySqlInstance = null;
	private DummySqlInstance dummySqlInstance = null;
	
	public AbstractDatasourceFactory(IPurchaseDS instance) {
		this.instance = instance;
		if(instance instanceof MySqlInstance){
			mySqlInstance = (MySqlInstance) instance;
		}
		if(instance instanceof DummySqlInstance){
			dummySqlInstance = (DummySqlInstance) instance;
		}
	}
	
	public IPurchaseDS getDSInstance(){
		return instance;
	}
	public MySqlInstance getMySqlInstanceIfAvailable(){
		return mySqlInstance;
	}
	public DummySqlInstance getDummySqlInstanceIfAvailable(){
		return dummySqlInstance;
	}
	
}
