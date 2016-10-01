package pt.ricardojafe.getvalidpurchases.service;

import java.util.Date;
import java.util.List;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;
import pt.ricardojafe.getvalidpurchases.persistance.AbstractDatasourceFactory;
import pt.ricardojafe.getvalidpurchases.persistance.IPurchaseDS;

public class PurchaseLocalService {

	/*TODO: Do the metrics for each service (by priority order): 
	*										Times called, CHECK
	*										Average time per method, CHECK
	*										Total all time calls, CHECK
	*										Median per method,
	*										Max calls per minute,
	*										Max waiting time
	*/
	
	private IPurchaseDS datasource;
	//metrics:
	private long numberOfRequests = 0;
	private long totalDurationOfRequests = 0;
	private long averageTimePerRequest = 0;
	private long maxRequestDuration = 0;
	
	public PurchaseLocalService(AbstractDatasourceFactory adf) {
		datasource = adf.getDSInstance();
	}
	
	/**
	 * Gets all valid purchases from the database.
	 * A purchase is considered valid if it's expiration date is in the future.
	 * @return
	 */
	public List<Purchase> getValidPurchases(){
		long startTime = System.nanoTime();
		numberOfRequests++;
		List<Purchase> result = datasource.getValidPurchases(new Date());
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * Tries to update the purchase with the same purchase id as the one passed in argument.
	 * If it does not exist, created a new purchase.
	 * @param purchase
	 * @return
	 */
	public boolean updateOrCreatePurchase(Purchase purchase){
		long startTime = System.nanoTime();
		numberOfRequests++;
		boolean result = datasource.createOrUpdatePurchase(purchase);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * Tries to update the purchase detail with the same purchase detail id as the one passed in argument.
	 * If it does not exist, created a new purchase detail.
	 * @param purchaseDetail
	 * @return
	 */
	public boolean updateOrCreatePurchaseDetail(PurchaseDetail purchaseDetail){
		long startTime = System.nanoTime();
		numberOfRequests++;
		boolean result = datasource.createOrUpdatePurchaseDetail(purchaseDetail);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * Get a purchase with the id passed or null if it does not exist.
	 * @param purchaseId
	 * @return
	 */
	public Purchase getPurchaseById(long purchaseId){
		long startTime = System.nanoTime();
		numberOfRequests++;
		Purchase result = datasource.getPurchaseById(purchaseId);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * Get a purchase detail with the id passed or null if it does not exist.
	 * @param purchaseDetailId
	 * @return
	 */
	public PurchaseDetail getPurchaseDetailById(long purchaseDetailId){
		long startTime = System.nanoTime();
		numberOfRequests++;
		PurchaseDetail result = datasource.getPurchaseDetailById(purchaseDetailId);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * returns total number of purchases in database.
	 * @return
	 */
	public int countPurchases(){
		long startTime = System.nanoTime();
		numberOfRequests++;
		int result = datasource.getPurchaseCount();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * returns total number of purchase details in database.
	 * @return
	 */
	public int countPurchaseDetails(){
		long startTime = System.nanoTime();
		numberOfRequests++;
		int result = datasource.getPurchaseDetailCount();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		totalDurationOfRequests += duration;
		maxRequestDuration = duration > maxRequestDuration ? duration : maxRequestDuration;
		return result;
	}
	
	/**
	 * Gets the service metrics. Uses lazy calculation of average to not impact performance until
	 * the result is actually needed (JIT).
	 * @return
	 */
	public String getMetrics(){
		averageTimePerRequest = totalDurationOfRequests / numberOfRequests / 1000000;
		
		return "Average time per Request : " + averageTimePerRequest 	    + "ms"+"\n"+
				"Maximum Request Duration : "+ maxRequestDuration / 1000000 + "ms"+"\n"+
				"Total Requests : "			 + numberOfRequests 		    +	   "\n";
	}

}
