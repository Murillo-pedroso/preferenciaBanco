package com.uam.model;

public class Client {

    private Integer id;
    private Boolean status;

    public Client(Integer id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
