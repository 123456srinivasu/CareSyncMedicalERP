package com.medical.caresync.dto;

import java.util.Date;
import java.util.List;

public class CampInvoicesDTO {

	private Long id;
	private Date invoiceDt;
	private String invoiceNo;
	private String destination;
	private String dispatchThrough;
	private String modeTermsPayment;
	private Double grossAmountBeforeTax;
	private Double netAmount;
	private List<CampInvoiceDetailDTO> campInvoiceDetails;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInvoiceDt() {
		return invoiceDt;
	}
	public void setInvoiceDt(Date invoiceDt) {
		this.invoiceDt = invoiceDt;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDispatchThrough() {
		return dispatchThrough;
	}
	public void setDispatchThrough(String dispatchThrough) {
		this.dispatchThrough = dispatchThrough;
	}
	public String getModeTermsPayment() {
		return modeTermsPayment;
	}
	public void setModeTermsPayment(String modeTermsPayment) {
		this.modeTermsPayment = modeTermsPayment;
	}
	public Double getGrossAmountBeforeTax() {
		return grossAmountBeforeTax;
	}
	public void setGrossAmountBeforeTax(Double grossAmountBeforeTax) {
		this.grossAmountBeforeTax = grossAmountBeforeTax;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	public List<CampInvoiceDetailDTO> getCampInvoiceDetails() {
		return campInvoiceDetails;
	}
	public void setCampInvoiceDetails(List<CampInvoiceDetailDTO> campInvoiceDetails) {
		this.campInvoiceDetails = campInvoiceDetails;
	}
	
	public static class CampInvoiceDetailDTO {
		private Integer id;
		private String medicineCode;
		private String batchNo;
		private Date batchExpirationDt;
		private String hsnhacNm;
		private Double cgstTax;
		private Double sgstTax;
		private Double mrp;
		private Double rate;
		private Integer quantity;
		private Double amount;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getMedicineCode() {
			return medicineCode;
		}
		public void setMedicineCode(String medicineCode) {
			this.medicineCode = medicineCode;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
		public Date getBatchExpirationDt() {
			return batchExpirationDt;
		}
		public void setBatchExpirationDt(Date batchExpirationDt) {
			this.batchExpirationDt = batchExpirationDt;
		}
		public String getHsnhacNm() {
			return hsnhacNm;
		}
		public void setHsnhacNm(String hsnhacNm) {
			this.hsnhacNm = hsnhacNm;
		}
		public Double getCgstTax() {
			return cgstTax;
		}
		public void setCgstTax(Double cgstTax) {
			this.cgstTax = cgstTax;
		}
		public Double getSgstTax() {
			return sgstTax;
		}
		public void setSgstTax(Double sgstTax) {
			this.sgstTax = sgstTax;
		}
		public Double getMrp() {
			return mrp;
		}
		public void setMrp(Double mrp) {
			this.mrp = mrp;
		}
		public Double getRate() {
			return rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
	}
}
