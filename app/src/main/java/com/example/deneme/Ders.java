package com.example.deneme;

public class Ders {
    private String isim,not;
    public Ders(String isim,String not){
        this.isim=isim;
        this.not=not;
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

}
