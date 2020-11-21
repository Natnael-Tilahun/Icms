package com.example.icms.faq_fragment;

public class FaqModel {
    private String info_title, info_description;
    private boolean expandable;

    public FaqModel(String info_title, String info_description) {
        this.info_title = info_title;
        this.info_description = info_description;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getInfo_title() {
        return info_title;
    }

    public void setInfo_title(String info_title) {
        this.info_title = info_title;
    }

    public String getInfo_description() {
        return info_description;
    }

    public void setInfo_description(String info_description) {
        this.info_description = info_description;
    }

    @Override
    public String toString() {
        return "FaqModel{" +
                "info_title='" + info_title + '\'' +
                ", info_description='" + info_description + '\'' +
                '}';
    }
}
