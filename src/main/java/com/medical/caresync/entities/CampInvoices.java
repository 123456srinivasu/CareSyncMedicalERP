package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_warehouse_invoices")
public class CampInvoices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_WAREHOUSE_INVOICE_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DT")
    private Date invoiceDt;

    @Column(name = "INVOICE_NO")
    private String invoiceNo;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "DISPATCH_THROUGH")
    private String dispatchThrough;

    @Column(name = "MODE_TERMS_PAYMENT")
    private String modeTermsPayment;

    @Column(name = "GROSS_AMOUNT_BEFORE_TAX")
    private Double grossAmountBeforeTax;

    @Column(name = "NET_AMOUNT")
    private Double netAmount;

    @OneToMany(mappedBy = "campInvoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CampInvoiceDetail> campInvoiceDetails;

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

    public List<CampInvoiceDetail> getCampInvoiceDetails() {
        return campInvoiceDetails;
    }

    public void setCampInvoiceDetails(List<CampInvoiceDetail> campInvoiceDetails) {
        this.campInvoiceDetails = campInvoiceDetails;
    }
}
