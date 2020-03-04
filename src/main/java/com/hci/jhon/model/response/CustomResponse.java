package com.hci.jhon.model.response;


import com.hci.jhon.model.enums.ServiceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {

    private String message;
    private String status;
    private Object data;

    public CustomResponse() {
        super();
        this.data = null;
    }

    public CustomResponse(Object data) {
        super();
        this.data = data;
    }

    public CustomResponse(String message, String status) {

        super();
        this.message = message;
        this.status = status;
        this.data = null;
    }

    public CustomResponse(String message, String status, Object data) {

        super();
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public CustomResponse(ServiceStatus status) {
        super();
        this.message = status.getReasonPhrase();
        this.status = status.getValue();
    }

    public CustomResponse(ServiceStatus status, Object data) {
        super();
        this.message = status.getReasonPhrase();
        this.status = status.getValue();
        this.data = data;
    }

    public static CustomResponse buildSuccess() {
        return new CustomResponse(ServiceStatus.SUCCESS);
    }

    public static CustomResponse buildSuccess(Object data) {
        return new CustomResponse(ServiceStatus.SUCCESS, data);
    }

    public static CustomResponse buildNotFound() {
        return new CustomResponse(ServiceStatus.NOT_FOUND);

    }

    public static CustomResponse build(ServiceStatus status) {
        return new CustomResponse(status);
    }

    public static CustomResponse build(ServiceStatus status, Object data) {
        return new CustomResponse(status, data);
    }

}