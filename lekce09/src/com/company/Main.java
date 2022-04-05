package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    public static final int POCET_FILOZOFU = 10;

    public static void main(String[] args) {
        Lock[] vidlicky = new ReentrantLock[POCET_FILOZOFU];


        for (int i = 0; i < POCET_FILOZOFU; i++) {
            vidlicky[i] = new ReentrantLock();

        }

//Vytvořím filozofy a pustím je na vlastních vláknech
        VecericiFilozofove[] filozofove = new VecericiFilozofove[POCET_FILOZOFU];

        for (int i = 0; i < filozofove.length; i++) {
            int filozofId = i + 1;
            Lock pravaVidlicka = vidlicky[(i + 1) % vidlicky.length];
            Lock levaVidlicka = vidlicky[i];


// zamezení Deadlock
            if (i == filozofove.length - 1) {
                filozofove[i] = new VecericiFilozofove(filozofId, pravaVidlicka, levaVidlicka);
            } else {
                filozofove[i] = new VecericiFilozofove(filozofId, levaVidlicka, pravaVidlicka);
            }
//Spouštění vlákna
            Thread vlakno = new Thread(filozofove[i], "Filozof : " + filozofId);
            vlakno.start();
        }
    }
}