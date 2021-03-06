package pt.ricardojafe.getvalidpurchases.persistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;

/**
 * The DummySQLInstance serves two purposes:
 * -> To allow tests without need of an actual DB or embeded DB;
 * -> To allow development of the Purchase microservice in a decoupled way from the Database team
 * @author ricardo.jafe
 *
 */
public class DummySqlInstance implements IPurchaseDS {

	//init of dummy purchase data
	private Purchase [] purchases = { 
			new Purchase(1,"CoolType",getDate(1)),
			new Purchase(2,"HotType", getDate(30)),
			new Purchase(3,"WarmType",   getDate(7)),
			new Purchase(4,"ExpiredType",getDate(-7)),
	};
	//init of dummy purchase detail data
	private PurchaseDetail [] purchaseDetails={
			new PurchaseDetail(101, "Banana", 10, 5),
			new PurchaseDetail(102, "Morango", 7, 5),
			new PurchaseDetail(103, "Tablet PC", 1, 300),
			new PurchaseDetail(104, "Lampadas", 12, 25),
			new PurchaseDetail(105, "Pen 6Gb", 3, 11),
			new PurchaseDetail(106, "Resmas Papel", 23, 98),
			new PurchaseDetail(107, "Disketes", 123, 200),
	};

	//the constructor just sets the purchase details to the purchases.
	public DummySqlInstance() {
		purchases[0].setPurchaseDetails(Arrays.asList(purchaseDetails[0],purchaseDetails[1]));
		purchases[1].setPurchaseDetails(Arrays.asList(purchaseDetails[2],purchaseDetails[3]));
		purchases[2].setPurchaseDetails(Arrays.asList(purchaseDetails[4],purchaseDetails[5]));
		purchases[3].setPurchaseDetails(Arrays.asList(purchaseDetails[6]));
	}

	private Date getDate(int i) {
		Calendar c=new GregorianCalendar();
		c.add(Calendar.DATE, i);
		return c.getTime();
	}

	/**
	 * Valid purchases are purchases that expire after the passed date
	 * @param date
	 * @return
	 */
	public List<Purchase> getValidPurchases(Date date) {
		try{
			return Arrays.asList(purchases).stream().filter(o -> o.getExpires().after(date)).collect(Collectors.toList());
		}catch(NoSuchElementException e){
			return null;
		}
	}

	@Override
	public Purchase getPurchaseById(long purchaseId) {
		try{
			return Arrays.asList(purchases).stream().filter(o -> o.getId() == purchaseId).findFirst().get();
		}catch(NoSuchElementException e){
			return null;
		}
	}

	@Override
	public List<Purchase> getPurchasesByIds(long[] ids) {
		List<Purchase> resultSet = new ArrayList<Purchase>();
		Stream<Purchase> stream = Arrays.asList(purchases).stream(); 
		for(long id : ids){
			try{
				resultSet.add(stream.filter(o -> o.getId() == id).findFirst().get());
			}catch(NoSuchElementException e){
				continue;
			}
		}
		return resultSet;
	}

	@Override
	public PurchaseDetail getPurchaseDetailById(long purchaseId) {
		try{
			return Arrays.asList(purchaseDetails).stream().filter(o -> o.getId() == purchaseId).findFirst().get();
		}catch(NoSuchElementException e){
			return null;
		}
	}

	@Override
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(long purchaseId) {
		Purchase p = getPurchaseById(purchaseId);
		return p.getPurchaseDetails();
	}

	@Override
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseIds(long[] ids) {
		List<PurchaseDetail> purchaseDetails = new ArrayList<>();
		for(long id : ids){
			PurchaseDetail pd = getPurchaseDetailById(id);
			if(pd != null){
				purchaseDetails.add(pd);
			}
		}
		return purchaseDetails;
	}

	/**
	 * Gets paginated results, simulates the use of SEEK method in SQL instead of OFFSET.
	 * Performance with SEEK is much better if an index on ID exists on the DB.
	 * 
	 */
	@Override
	public List<Purchase> getAllPurchasesPaginatedOrderedById(long startId, long endId) {
		List<Purchase> pAsList = Arrays.asList(purchases);
		Collections.sort(pAsList, new Comparator<Purchase>() {
			@Override
			public int compare(Purchase p1, Purchase p2)
			{
				return  p1.getId() < p2.getId() ? -1 :
					p1.getId() > p2.getId() ? 1 : 0;
			}
		});
		List<Purchase> resultSet = new ArrayList<>();
		for(int i = 0 ; i < endId ; i++){
			if(pAsList.get(i).getId() > startId){
				if(pAsList.get(i).getId() > endId){
					break;
				}
				resultSet.add(pAsList.get(i));
			}
		}
		return resultSet;
	}

	/**
	 * Gets paginated results, simulates the use of SEEK method in SQL instead of OFFSET.
	 * Performance with SEEK is much better if an index on ID exists on the DB.
	 * 
	 */
	@Override
	public List<PurchaseDetail> getAllPurchaseDetailsPaginatedOrderedById(long startId, long endId) {
		List<PurchaseDetail> pAsList = Arrays.asList(purchaseDetails);
		Collections.sort(pAsList, new Comparator<PurchaseDetail>() {
			@Override
			public int compare(PurchaseDetail p1, PurchaseDetail p2)
			{
				return  p1.getId() < p2.getId() ? -1 :
					p1.getId() > p2.getId() ? 1 : 0;
			}
		});
		List<PurchaseDetail> resultSet = new ArrayList<>();
		for(int i = 0 ; i < endId ; i++){
			if(pAsList.get(i).getId() > startId){
				if(pAsList.get(i).getId() > endId){
					break;
				}
				resultSet.add(pAsList.get(i));
			}
		}
		return resultSet;
	}

	@Override
	public boolean createOrUpdatePurchase(Purchase purchase) {
		Purchase p = getPurchaseById(purchase.getId());
		if(p == null){
			List<Purchase> aux = Arrays.asList(purchases);
			purchases = aux.toArray(new Purchase[purchases.length+1]);
			purchases[purchases.length-1] = purchase;
		}else{
			updatePurchase(p, purchase);
		}
		return true;
	}


	@Override
	public boolean createOrUpdatePurchaseDetail(PurchaseDetail purchaseDetail) {
		PurchaseDetail pd = getPurchaseDetailById(purchaseDetail.getId());
		if(pd == null){
			List<PurchaseDetail> aux = Arrays.asList(purchaseDetails);
			purchaseDetails = aux.toArray(new PurchaseDetail[purchaseDetails.length+1]);
			purchaseDetails[purchaseDetails.length-1] = purchaseDetail;
		}else{
			updatePurchaseDetail(pd, purchaseDetail);
		}
		return true;
	}

	/**
	 * Checks if Purchase with same id exists. If no, creates one.
	 * If it does, updates its details and the purchase details.
	 * @param p
	 * @param purchase
	 */
	private void updatePurchase(Purchase p, Purchase purchase) {
		p.setProductType(purchase.getProductType());
		p.setExpires(purchase.getExpires());
		p.setPurchaseDetails(purchase.getPurchaseDetails());

		//find removed Details and gather them for removal
		List<PurchaseDetail> toRemove = new ArrayList<PurchaseDetail>();
		for(PurchaseDetail oldPd : p.getPurchaseDetails()){
			if(!purchase.getPurchaseDetails().stream().filter(o -> o.getId() == oldPd.getId()).findAny().isPresent()){
				toRemove.add(oldPd);
			}
		}
		p.getPurchaseDetails().removeAll(toRemove);
		//update remaining or new Details
		for(PurchaseDetail pd : p.getPurchaseDetails()){
			createOrUpdatePurchaseDetail(pd);
		}
	}

	private void updatePurchaseDetail(PurchaseDetail pd, PurchaseDetail purchaseDetail) {
		pd.setDescription(purchaseDetail.getDescription());
		pd.setQuantity(purchaseDetail.getQuantity());
		pd.setValue(purchaseDetail.getValue());
	}

	//no real function in dummy class
	@Override
	public boolean connect() {
		return true;
	}
	
	//yep, no real function either.
	@Override
	public boolean disconnect() {
		return true;
	}

	@Override
	public int getPurchaseCount() {
		return purchases.length;
	}

	@Override
	public int getPurchaseDetailCount() {
		return purchaseDetails.length; 
	}
}
