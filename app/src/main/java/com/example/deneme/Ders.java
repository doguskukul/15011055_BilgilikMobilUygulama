package com.example.deneme;

public class Ders {
    private String isim,not,ogretmen,kredi;
    public Ders(String isim,String not,String ogretmen,String kredi){
        this.isim=isim;
        this.not=not;
        this.ogretmen=ogretmen;
        this.kredi=kredi;
    }
    public String isimAl(){
        return isim;
    }
    public void isimDuzenle(String isim){
        this.isim=isim;
    }
    public String notAl(){
        return not;
    }
    public void notDuzenle(String not){
        this.not=not;
    }
    public String ogretmenAl () {return ogretmen;}
    public void ogretmenDuzenle (String ogretmen){this.ogretmen=ogretmen;}
    public String krediAl () {return kredi;}
    public void kredi (String ogretmen){this.kredi=kredi;}
}
