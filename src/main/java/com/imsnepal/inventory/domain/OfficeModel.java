package com.imsnepal.inventory.domain;

public class OfficeModel {

    private String cityName;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Office translateModelToOffice() {
        Office office= new Office();
        office.setCityName(this.cityName);
        office.setPhoneNumber(this.phoneNumber);
        office.setAddressLine1(this.addressLine1);
        office.setAddressLine2(this.addressLine2);
        office.setState(this.state);
        office.setCountry(this.country);
        office.setPostalCode(this.postalCode);
        office.setTerritory(this.territory);
        return office;
    }

}
