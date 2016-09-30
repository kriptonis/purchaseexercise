package pt.ricardojafe.getvalidpurchases.model;

import java.util.Date;
import java.util.List;

/**
 *
 * Purchase(id:Long, productType:String, expires:DateTime, purchaseDetails:Details)
 * @author ricardo.jafe
 *
 */
public class Purchase {

	long id;
	String productType;
	Date expires;
	List<PurchaseDetail> purchaseDetails;
	
	public Purchase() {

	}
	
	public Purchase(long id, String productType, Date expires) {
		super();
		this.id = id;
		this.productType = productType;
		this.expires = expires;
	}
	
	public Purchase(long id, String productType, Date expires, List<PurchaseDetail> purchaseDetails) {
		super();
		this.id = id;
		this.productType = productType;
		this.expires = expires;
		this.purchaseDetails = purchaseDetails;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expires == null) ? 0 : expires.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((purchaseDetails == null) ? 0 : purchaseDetails.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (expires == null) {
			if (other.expires != null)
				return false;
		} else if (!expires.equals(other.expires))
			return false;
		if (id != other.id)
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (purchaseDetails == null) {
			if (other.purchaseDetails != null)
				return false;
		} else if (!purchaseDetails.equals(other.purchaseDetails))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", productType=" + productType + ", expires=" + expires + ", purchaseDetails="
				+ purchaseDetails + "]";
	}

	
	
}
