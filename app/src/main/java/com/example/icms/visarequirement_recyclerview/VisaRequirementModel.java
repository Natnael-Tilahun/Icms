package com.example.icms.visarequirement_recyclerview;

public class VisaRequirementModel {
    public String visarequir_title, visarequir_description;
    public boolean expandable;

    public VisaRequirementModel(String visarequir_title, String visarequir_description) {
        this.visarequir_title = visarequir_title;
        this.visarequir_description = visarequir_description;
        this.expandable = false;
    }

    public String getVisarequir_title() {
        return visarequir_title;
    }

    public void setVisarequir_title(String visarequir_title) {
        this.visarequir_title = visarequir_title;
    }

    public String getVisarequir_description() {
        return visarequir_description;
    }

    public void setVisarequir_description(String visarequir_description) {
        this.visarequir_description = visarequir_description;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    @Override
    public String toString() {
        return "VisaRequirementModel{" +
                "visarequir_title='" + visarequir_title + '\'' +
                ", visarequir_description='" + visarequir_description + '\'' +
                ", expandable=" + expandable +
                '}';
    }
}
