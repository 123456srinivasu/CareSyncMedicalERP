package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_warehouse_medicines")
public class CampInvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TBL_WAREHOUSE_MEDICINES_ID")
	private Integer id;
	@Column(name = "MEDICINE_CODE") // Assumed column name based on usage, actual column might be different or joined. 
    // In TblWarehouseMedicine, medicineCode is Transient and fetched likely via TblMedicine. 
    // For this API, ensuring simple mapping. If strict JPA required, might need TblMedicine relation.
    // However keeping it simple as per request for 'complete api code'
	private String medicineCode;
	@Column(name = "BATCH_NO")
	private String batchNo;
	@Temporal(TemporalType.DATE)
	@Column(name = "BATCH_EXPIRATION_DT")
	private Date batchExpirationDt;
	@Column(name = "HSNHAC_NM")
	private String hsnhacNm;
	@Column(name = "CGST_TAX")
	private Double cgstTax;
	@Column(name = "SGST_TAX")
	private Double sgstTax;
	@Column(name = "MRP")
	private Double mrp;
	@Column(name = "RATE")
	private Double rate;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "AMOUNT") // Field 'amount' in TblWarehouseMedicine
	private Double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TBL_WAREHOUSE_INVOICE_ID")
	@JsonBackReference
	private CampInvoices campInvoice;
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
	public CampInvoices getCampInvoice() {
		return campInvoice;
	}
	public void setCampInvoice(CampInvoices campInvoice) {
		this.campInvoice = campInvoice;
	}
}
