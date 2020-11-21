package com.example.icms.servicefees_recyclerview;

public class ServiceFeeModel {
    public String servicefee_title, servicefee_description;
    public boolean expandable;

    public ServiceFeeModel(String servicefee_title, String servicefee_description) {
        this.servicefee_title = servicefee_title;
        this.servicefee_description = servicefee_description;
        this.expandable = false;
    }

    @Override
    public String toString() {
        return "ServiceFeeModel{" +
                "servicefee_title='" + servicefee_title + '\'' +
                ", servicefee_description='" + servicefee_description + '\'' +
                ", expandable=" + expandable +
                '}';
    }

    public String getServicefee_title() {
        return servicefee_title;
    }

    public void setServicefee_title(String servicefee_title) {
        this.servicefee_title = servicefee_title;
    }

    public String getServicefee_description() {
        return servicefee_description;
    }

    public void setServicefee_description(String servicefee_description) {
        this.servicefee_description = servicefee_description;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}
