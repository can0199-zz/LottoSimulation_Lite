/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottosimulation_lite;

/**
 *
 * @author c.karadag
 */
public class functions {
    static int[] prüfe(int az, int[] playerzahl, int wievielerichtig) {
        //hier wird geprüft wieviele Zahlen richtig sind 
        Lottosimulation_lite.lottozahlenziehe lottozahlen = new Lottosimulation_lite.lottozahlenziehe();
        int[] vec = new int[az];
        for (int i = 0; i < az; i++) {
            boolean srichtige = false;
            int durchgaenge = 0;
            int richtige = 0;
            while (srichtige == false) {
                richtige = 0;
                int[] lotto = lottozahlen.ziehe();
                for (int c = 0; c < 6; c++) {
                    for (int j = 0; j < 6; j++) {
                        if (playerzahl[c] == lotto[j]) {
                            richtige++;
                            break;
                        }
                    }
                }
                //in dieser if abfrage wird festgelegt wieviele zahlen richtig sein müssen!
                // die variable wievielerichtig ist das enscheidene
                if (richtige == wievielerichtig) {
                    srichtige = true;
                }
                durchgaenge++;
            }
            vec[i] = durchgaenge;
        }
        return vec;
    }
    
}
