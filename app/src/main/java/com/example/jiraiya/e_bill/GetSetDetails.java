package com.example.jiraiya.e_bill;

public class GetSetDetails {

    String address,dateTime,discount,endTime,grandTotal,
            jobassign,paymentStatus,rate,serviceLocation,servicerequired,
            startTime,status,taxcgst,taxsgst,totalTime,typeOfWork;

    public GetSetDetails() {
    }

    public GetSetDetails(String address, String dateTime, String discount, String endTime, String grandTotal, String jobassign, String paymentStatus, String rate, String serviceLocation, String servicerequired, String startTime, String status, String taxcgst, String taxsgst, String totalTime, String typeOfWork) {
        this.address = address;
        this.dateTime = dateTime;
        this.discount = discount;
        this.endTime = endTime;
        this.grandTotal = grandTotal;
        this.jobassign = jobassign;
        this.paymentStatus = paymentStatus;
        this.rate = rate;
        this.serviceLocation = serviceLocation;
        this.servicerequired = servicerequired;
        this.startTime = startTime;
        this.status = status;
        this.taxcgst = taxcgst;
        this.taxsgst = taxsgst;
        this.totalTime = totalTime;
        this.typeOfWork = typeOfWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getJobassign() {
        return jobassign;
    }

    public void setJobassign(String jobassign) {
        this.jobassign = jobassign;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServicerequired() {
        return servicerequired;
    }

    public void setServicerequired(String servicerequired) {
        this.servicerequired = servicerequired;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaxcgst() {
        return taxcgst;
    }

    public void setTaxcgst(String taxcgst) {
        this.taxcgst = taxcgst;
    }

    public String getTaxsgst() {
        return taxsgst;
    }

    public void setTaxsgst(String taxsgst) {
        this.taxsgst = taxsgst;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }
}
