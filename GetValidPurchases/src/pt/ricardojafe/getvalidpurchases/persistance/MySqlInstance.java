package pt.ricardojafe.getvalidpurchases.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import pt.ricardojafe.getvalidpurchases.model.Purchase;
import pt.ricardojafe.getvalidpurchases.model.PurchaseDetail;


/**
 * Stubs for MySQL support
 * @author ricardo.jafe
 *
 */
public class MySqlInstance implements IPurchaseDS {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	Connection conn;



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
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return true;
	}

	public boolean createDatabase(String dbName){
		Statement stmt = null;
		try{
			//STEP 4: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE "+dbName;
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
		}
		return true;
	}

	@Override
	public boolean disconnect() {
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}//end finally try
		return true;
	}

	@Override
	public int getPurchaseCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPurchaseDetailCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		MySqlInstance m = new MySqlInstance();
		m.connect();
	}

}
