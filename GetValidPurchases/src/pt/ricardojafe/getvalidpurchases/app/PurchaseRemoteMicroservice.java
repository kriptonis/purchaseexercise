package pt.ricardojafe.getvalidpurchases.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.ricardojafe.getvalidpurchases.persistance.AbstractDatasourceFactory;
import pt.ricardojafe.getvalidpurchases.persistance.DummySqlInstance;
import pt.ricardojafe.getvalidpurchases.service.PurchaseLocalService;

@WebServlet(name = "purchaseWs", urlPatterns = {"/Purchase"})
public class PurchaseRemoteMicroservice extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger _log = Logger.getLogger("Purchase");
	//this would be injected or configured in external file. Using DummySqlInstance for brevity
	AbstractDatasourceFactory dataSourceFactory = new AbstractDatasourceFactory(new DummySqlInstance());
	PurchaseLocalService service = new PurchaseLocalService(dataSourceFactory);
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Enumeration<String> params = request.getParameterNames();
		String purchaseServiceResponse = null;
		while(params.hasMoreElements()){
			String paramName = params.nextElement();
			if(paramName.toLowerCase().equals("service")){
				String serviceName = request.getParameter(paramName);
				switch(serviceName){
					case "getValidPurchases":purchaseServiceResponse = getParametersAndCallGetValidPurchases(request);break;
					case "createOrUpdatePurchase":purchaseServiceResponse = getParametersAndCallCreateOrUpdatePurchase(request);break;
					case "createOrUpdatePurchaseDetail":purchaseServiceResponse = getParametersAndCallCreateOrUpdatePurchaseDetail(request);break;
				}
				_log.info("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
		}

		PrintWriter out = response.getWriter();
		out.println(purchaseServiceResponse);
	}
	
	private String getParametersAndCallCreateOrUpdatePurchaseDetail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getParametersAndCallCreateOrUpdatePurchase(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getParametersAndCallGetValidPurchases(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}
	
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	public String getServletInfo() {
		return "Purchase Service";
	}// </editor-fold>
	
}
