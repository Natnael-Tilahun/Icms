package com.example.icms;

public class PassRequirementmModel {
    public String requirement_title, requirement_description;
    public boolean expandable;

    public PassRequirementmModel(String requirement_title, String requirement_description) {
        this.requirement_title = requirement_title;
        this.requirement_description = requirement_description;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getRequirement_title() {
        return requirement_title;
    }

    public void setRequirement_title(String requirement_title) {
        this.requirement_title = requirement_title;
    }

    public String getRequirement_description() {
        return requirement_description;
    }

    public void setRequirement_description(String requirement_description) {
        this.requirement_description = requirement_description;
    }

    @Override
    public String toString() {
        return "PassRequirementmModel{" +
                "requirement_title='" + requirement_title + '\'' +
                ", requirement_description='" + requirement_description + '\'' +
                ", expandable=" + expandable +
                '}';
    }
}
