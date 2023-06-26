package org.example;

public class Contact {
    private String title;
    private String name;
    private String adress;
    private String realAdress;
    private String departement;
    private String country;
    private String tel;
    private String email;

    public Contact(String title, String name, String address, String realAddress, String department, String country, String tel, String email) {
        this.title = title;
        this.name = name;
        this.adress = address;
        this.realAdress = realAddress;
        this.departement = department;
        this.country = country;
        this.tel = tel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact [title=" + title + ", name=" + name + ", address=" + adress + ", realAddress=" + realAdress
                + ", department=" + departement + ", country=" + country + ", tel=" + tel + ", email=" + email + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRealAdress() {
        return realAdress;
    }

    public void setRealAdress(String realAddress) {
        this.realAdress = realAddress;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
