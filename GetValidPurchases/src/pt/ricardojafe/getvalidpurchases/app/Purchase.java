package pt.ricardojafe.getvalidpurchases.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "purchaseWs", urlPatterns = {"/Purchase"})
public class Purchase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger _log = Logger.getLogger("Sage");
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			System.out.println(params.nextElement());
		}
		String textResponse = "HI!";

		PrintWriter out = response.getWriter();
		out.println(textResponse);
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
		return "Short description";
	}// </editor-fold>

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "xml=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3Cmapi%3E%3Cmapiversion%3E1.0%3C%2Fmapiversion%3E%3Cmd5content%3Ef6d09b545bfeb4111552fbf007608674%3C%2Fmd5content%3E%3Cresult%3E%3Coperation%3Eauthorization%3C%2Foperation%3E%3Cstatus%3Enok%3C%2Fstatus%3E%3Cdate%3E2016-06-07%3C%2Fdate%3E%3Ctime%3E11%3A16%3A56+UTC%2B0000%3C%2Ftime%3E%3CorigAmount%3E106.25%3C%2ForigAmount%3E%3CorigCurrency%3EEUR%3C%2ForigCurrency%3E%3CidForMerchant%3E495738%3C%2FidForMerchant%3E%3CemailClient%3Emarketing%40gfi.pt%3C%2FemailClient%3E%3CidClient%3E495454%3C%2FidClient%3E%3CmerchantDatas%3E++++%3C_aKey_id_client%3E2000%3C%2F_aKey_id_client%3E++++%3C_aKey_name%3Emy+client+name%3C%2F_aKey_name%3E++%3C%2FmerchantDatas%3E%3CcardCountry%3EFR%3C%2FcardCountry%3E%3CipCountry%3EPT%3C%2FipCountry%3E%3Ctransid%3E5756AD2162467200%3C%2Ftransid%3E%3Cis3ds%3ENo%3C%2Fis3ds%3E%3CpaymentMethod%3ECB%3C%2FpaymentMethod%3E%3CrefProduct0%3E29403%3C%2FrefProduct0%3E%3CcustomerCountry%3EPT%3C%2FcustomerCountry%3E%3C%2Fresult%3E%3C%2Fmapi%3E%0A";
		s = URLDecoder.decode(s,"UTF-8");
		if(s.startsWith("xml="))
			s = s.substring(4);
		System.out.println(URLDecoder.decode(s, "UTF-8"));
	}
	
}
