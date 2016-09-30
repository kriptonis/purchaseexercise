package pt.ricardojafe.getvalidpurchases.persistance;

import java.util.ArrayList;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;

public class MySqlInstance implements IPurchaseDS {

	@Override
	public Purchase getPurchaseById(String purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchasesByIds(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDetail getPurchaseDetailById(String purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDetail getPurchaseDetailsByPurchaseId(String purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseDetail> getPurchaseDetailsByPurchaseIds(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getAllPurchasesPaginatedOrderedById(String startId, String endId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseDetail> getAllPurchaseDetailsPaginatedOrderedById(String startId, String endId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createOrUpdatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrUpdatePurchaseDetail(PurchaseDetail purchase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnect() {
		// TODO Auto-generated method stub
		return false;
	}

}
