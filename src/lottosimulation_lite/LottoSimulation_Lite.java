/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottosimulation_lite;

import java.util.Scanner;

/**
 *
 * @author c.karadag
 */
public class LottoSimulation_Lite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        play_static_player_numbers(sc);
    }

    static void play_static_player_numbers(Scanner sc) throws Exception {
        int[] playerzahl = new int[6];
        playerzahl[0] = 15;
        playerzahl[1] = 10;
        playerzahl[2] = 25;
        playerzahl[3] = 27;
        playerzahl[4] = 34;
        playerzahl[5] = 49;
        //hier wird abgefragt wie oft man die richtigen haben will
        System.out.println("Wie oft soll es durchlaufen?");
        int az = sc.nextInt();
        //hier wird festgelegt wieviele richtig sein sollen 
        System.out.println("Wie viele richtige?");
        int richtige = sc.nextInt();
        System.out.println("das Ergebniss wird analysiert\n");

        int[] allezahlen = functions.vergleich(az, playerzahl, richtige);
        sc.close();
        //durchschnitt wird errechnet
        double durchschnitt = 0;
        for (int i = 0; i < allezahlen.length; i++) {
            durchschnitt = durchschnitt + allezahlen[i];
        }
        durchschnitt = durchschnitt / allezahlen.length;
        System.out.printf("Der Durchschnitt liegt bei: %f\n", durchschnitt);
        String d = String.format("Der Durchschnitt liegt bei: %f\n", durchschnitt);
        functions.schreibe(az,richtige,allezahlen,d);

    }

}
