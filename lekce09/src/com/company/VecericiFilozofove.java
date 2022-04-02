package com.company;


import java.util.Random;
import java.util.concurrent.locks.Lock;

public class VecericiFilozofove implements Runnable {
    Random nahodneCislo = new Random();
    private int filozofId;
    private Lock pravaVidlicka;
    private Lock levaVidlicka;

//Konstruktor

    public VecericiFilozofove(int filozofId, Lock pravaVidlicka, Lock levaVidlicka) {
        this.filozofId = filozofId;
        this.pravaVidlicka = pravaVidlicka;
        this.levaVidlicka = levaVidlicka;
    }

//Filozofové přemýšlí, zvednou levou vidličku, pravou vidličku, pojídá, položí vidličky
    @Override
    public void run() {
        try {
            while (true) {
                premysli();
                zvedneLevouVidlicku();
                zvednePravouVidlicku();
                pojida();
                poloziVidlicku();
            }
        } catch (InterruptedException e) {
            System.out.println("Vlákno filozofa " + filozofId + " bylo přerušeno.");
        }
    }

    public void premysli() throws InterruptedException {
        System.out.println("Filozof jménem: " + filozofId + " přemýšlí.");
        System.out.flush();//vyprázdnění obsahu vyrovnávací paměti do výstupního proudu
        Thread.sleep(nahodneCislo.nextInt(10));
    }

    public void zvedneLevouVidlicku() {
        levaVidlicka.lock();
        System.out.println("Filozof jménem: " + filozofId + " zvedne levou vidličku.");
        System.out.flush();
    }

    public void zvednePravouVidlicku() {
        pravaVidlicka.lock();
        System.out.println("Filozof jménem: " + filozofId + " zvedne pravou vidličku.");
        System.out.flush();
    }

    public void pojida() throws InterruptedException {
        System.out.println("Filozof jménem: " + filozofId + " pojídá.");
        System.out.flush();
        Thread.sleep(nahodneCislo.nextInt(10));
    }

    public void poloziVidlicku() {
        System.out.println("Filozof jménem: " + filozofId + " položí vidličku");
        System.out.flush();
        levaVidlicka.unlock();
        pravaVidlicka.unlock();
    }
}


