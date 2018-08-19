package com.example.jiraiya.e_bill;

//Getter and Setter for the MyOrderAdapter

public class GetSetMyOrder {

    private String dateTime;
    private String idNo;
    private String typeOfWork;
    private String status;
    private String money;
    private String name;
    private String imgUrl;

    public GetSetMyOrder() {
    }

    public GetSetMyOrder(String dateTime, String idNo, String typeOfWork, String status, String money, String name, String imgUrl) {
        this.dateTime = dateTime;
        this.idNo = idNo;
        this.typeOfWork = typeOfWork;
        this.status = status;
        this.money = money;
        this.name = name;
        this.imgUrl = imgUrl;

    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
