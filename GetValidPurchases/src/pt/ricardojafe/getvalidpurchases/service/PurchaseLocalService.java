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
	private long numberOfRequests = 0;
	private long totalDurationOfRequests = 0;
	private long averageTimePerRequest = 0;
	private long maxRequestDuration = 0;
	
	public PurchaseLocalService(AbstractDatasourceFactory adf) {
		datasource = adf.getDSInstance();
	}
	
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
	
	public String getMetrics(){
		averageTimePerRequest = totalDurationOfRequests / numberOfRequests;
		
		return "Average time per Request : "	+ averageTimePerRequest + "ms"+"\n"+
				"Maximum Request Duration : "	+ maxRequestDuration 	+ "ms"+"\n"+
				"Total Requests : "				+ numberOfRequests 		+ "ms"+"\n";
	}

}
