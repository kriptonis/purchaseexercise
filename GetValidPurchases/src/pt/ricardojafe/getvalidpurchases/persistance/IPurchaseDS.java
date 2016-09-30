package pt.ricardojafe.getvalidpurchases.persistance;

import java.util.Date;
import java.util.List;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;

public interface IPurchaseDS {
	
	public List<Purchase> getValidPurchases(Date date);
	
	public Purchase getPurchaseById(long purchaseId);
	
	public List<Purchase> getPurchasesByIds(long [] ids);
	
	public PurchaseDetail getPurchaseDetailById(long purchaseId);
	
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(long purchaseId);
	
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseIds(long [] ids);
	
	public List<Purchase> getAllPurchasesPaginatedOrderedById(long startId, long endId);
	
	public List<PurchaseDetail> getAllPurchaseDetailsPaginatedOrderedById(long startId, long endId);
	
	public boolean createOrUpdatePurchase(Purchase purchase);
	
	public boolean createOrUpdatePurchaseDetail(PurchaseDetail purchase);
	
	public boolean connect();
	
	public boolean disconnect();

}
