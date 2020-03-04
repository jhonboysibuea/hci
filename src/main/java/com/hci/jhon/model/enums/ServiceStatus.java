package com.hci.jhon.model.enums;


public enum ServiceStatus {

    //success
    SUCCESS("1000","General Success"),

    //failed
    NOT_FOUND("4000","Data Not Found"),
    UNAUTHORIZED("4001","Invalid Account"),
    INVALID_FILE("4002","Invalid file"),
    PARAM_ILLEGAL("4003","Param illegal"),
    USER_EXIST("4004","Username already taken"),
    ACCOUNT_NOT_FOUND("4005","Account not found"),
    DATA_DUPLICATE("4006","data duplicate"),
    INVALID_PHONE_NUMBER("4007","Invalid Phone Number"),
    LOGIN_FAIL("4999","Invalid Username or Password"),
    INTERNAL_SERVER_ERROR("5000","Internal Server Error"),

    //error
    NETWORK_AUTHENTICATION_REQUIRED("9111", "Network Authentication Required"),
    ACCESS_DENIED("403","Access Denied");



    private final String value;
    private final String reasonPhrase;
    private ServiceStatus(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public String getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

}

