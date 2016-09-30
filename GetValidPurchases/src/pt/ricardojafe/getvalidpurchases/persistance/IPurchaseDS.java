package pt.ricardojafe.getvalidpurchases.persistance;

import java.util.ArrayList;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;

public interface IPurchaseDS {
	
	public Purchase getPurchaseById(String purchaseId);
	
	public ArrayList<Purchase> getPurchasesByIds(String [] ids);
	
	public PurchaseDetail getPurchaseDetailById(String purchaseId);
	
	public PurchaseDetail getPurchaseDetailsByPurchaseId(String purchaseId);
	
	public ArrayList<PurchaseDetail> getPurchaseDetailsByPurchaseIds(String [] ids);
	
	public ArrayList<Purchase> getAllPurchasesPaginatedOrderedById(String startId, String endId);
	
	public ArrayList<PurchaseDetail> getAllPurchaseDetailsPaginatedOrderedById(String startId, String endId);
	
	public boolean createOrUpdatePurchase(Purchase purchase);
	
	public boolean createOrUpdatePurchaseDetail(PurchaseDetail purchase);
	
	public boolean connect();
	
	public boolean disconnect();

}
