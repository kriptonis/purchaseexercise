package pt.ricardojafe.getvalidpurchases.app;

/**
 *
You need to develop an API for other backend services to fetch and store product purchases.
For now, the API only needs to serve operations through a HTTP server that connects to a database that provides the company’s purchases.
Another team will develop the database implementation only after your team creates the service.
You will implement the class that serves the requests and the method signatures for the database DAO, which the other team will respect.
Following is the schema for the data objects:

Purchase(id:Long, productType:String, expires:DateTime, purchaseDetails:Details)
Details(id:Long, description:String, quantity:Integer, value:Double)

The first operation retrieves purchase details related to valid company purchases.

    it fetches a collection of all existing purchases from the database;
    aggregates the results that are valid for the current time;
    subsequently calls the database with a collection of the aggregated purchase ids;
    the database yields all queried purchase details;
    it then transforms the data into a textual data format and returns to the calling entity. 

The second operation is responsible for storing - or handling updates - on the product purchases.
The database implementation is being developed by another team which stated that the expected SLA will be around 2 seconds.
The service should expose metrics to be collected by external services. Be free to expose all the metrics you think that has value to the server.

Feel free to add other relevant operations in the context of a microservice.
 * @author ricardo.jafe
 *
 */
public class StandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
