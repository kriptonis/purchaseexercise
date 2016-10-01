package pt.ricardojafe.getvalidpurchases.service;

import java.util.Date;
import java.util.List;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;
import pt.ricardojafe.getvalidpurchases.persistance.AbstractDatasourceFactory;
import pt.ricardojafe.getvalidpurchases.persistance.IPurchaseDS;

public class PurchaseLocalService {

	/*TODO: Do the metrics for each service (by priority order): 
	*										Times called, 
	*										Average time per method,
	*										Median per method,
	*										Max calls per minute,
	*										Max waiting time
	*/
	
	private IPurchaseDS datasource;
	
	public PurchaseLocalService(AbstractDatasourceFactory adf) {
		datasource = adf.getDSInstance();
	}
	
	public List<Purchase> getValidPurchases(){
		return datasource.getValidPurchases(new Date());
	}
	
	public boolean updateOrCreatePurchase(Purchase purchase){
		return datasource.createOrUpdatePurchase(purchase);
	}
	
	public boolean updateOrCreatePurchaseDetail(PurchaseDetail purchaseDetail){
		return datasource.createOrUpdatePurchaseDetail(purchaseDetail);
	}
	
	public Purchase getPurchaseById(long purchaseId){
		return datasource.getPurchaseById(purchaseId);
	}
	
	public PurchaseDetail getPurchaseDetailById(long purchaseDetailId){
		return datasource.getPurchaseDetailById(purchaseDetailId);
	}
	
	public int countPurchases(){
		return datasource.getPurchaseCount();
	}
	
	public int countPurchaseDetails(){
		return datasource.getPurchaseDetailCount();
	}

}
