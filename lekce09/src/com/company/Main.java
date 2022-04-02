package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int POCET_FILOZOFU_VIDLICEK = 10;

    public static void main(String[] args) {
        Lock[] vidlicky = new ReentrantLock[POCET_FILOZOFU_VIDLICEK];

        for (int i = 0; i < 10; ++i) {
            vidlicky[i] = new ReentrantLock();
        }

        VecericiFilozofove[] filozofove = new VecericiFilozofove[POCET_FILOZOFU_VIDLICEK];

        for (int i = 0; i < filozofove.length; ++i) {
            int filozofId = i + 1;
            Lock pravaVidlicka = vidlicky[(i + 1) % vidlicky.length];
            Lock levaVidlicka = vidlicky[i];
            if (i == filozofove.length - 1) {
                filozofove[i] = new VecericiFilozofove(filozofId, pravaVidlicka, levaVidlicka);
            } else {
                filozofove[i] = new VecericiFilozofove(filozofId, levaVidlicka, pravaVidlicka);
            }

            Thread vlakno = new Thread(filozofove[i], "Filozof : " + filozofId);
            vlakno.start();
        }

    }
}
