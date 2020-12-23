package com.example.icms.newpassport_process;

public class NewPassport_class {
    private String selectSite, selectCity, selectOffice, selectDeliverySite;
    private String legalId, completedForm, birthCertificate;

    public NewPassport_class() {
    }

    public NewPassport_class(String selectSite, String selectCity, String selectOffice, String selectDeliverySite, String legalId, String completedForm, String birthCertificate) {
        this.selectSite = selectSite;
        this.selectCity = selectCity;
        this.selectOffice = selectOffice;
        this.selectDeliverySite = selectDeliverySite;
        this.legalId = legalId;
        this.completedForm = completedForm;
        this.birthCertificate = birthCertificate;
    }

    public String getSelectSite() {
        return selectSite;
    }

    public void setSelectSite(String selectSite) {
        this.selectSite = selectSite;
    }

    public String getSelectCity() {
        return selectCity;
    }

    public void setSelectCity(String selectCity) {
        this.selectCity = selectCity;
    }

    public String getSelectOffice() {
        return selectOffice;
    }

    public void setSelectOffice(String selectOffice) {
        this.selectOffice = selectOffice;
    }

    public String getSelectDeliverySite() {
        return selectDeliverySite;
    }

    public void setSelectDeliverySite(String selectDeliverySite) {
        this.selectDeliverySite = selectDeliverySite;
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public String getCompletedForm() {
        return completedForm;
    }

    public void setCompletedForm(String completedForm) {
        this.completedForm = completedForm;
    }

    public String getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }
}
