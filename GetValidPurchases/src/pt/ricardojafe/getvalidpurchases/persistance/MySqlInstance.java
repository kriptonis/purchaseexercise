package pt.ricardojafe.getvalidpurchases.persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;

public class MySqlInstance implements IPurchaseDS {

	@Override
	public List<Purchase> getValidPurchases(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Purchase getPurchaseById(long purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchasesByIds(long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDetail getPurchaseDetailById(long purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(long purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseDetail> getPurchaseDetailsByPurchaseIds(long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getAllPurchasesPaginatedOrderedById(long startId, long endId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseDetail> getAllPurchaseDetailsPaginatedOrderedById(long startId, long endId) {
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
