package lottosimulation_lite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class functions {

    static int[] vergleich(int az, int[] playerzahl, int wievielerichtig) {
        //hier wird geprüft wieviele Zahlen richtig sind 
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
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

    static void schreibe(int durchlaeufe, int richtige, int[] allezahlen, String durchschnitt) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df;
        df = DateTimeFormatter.ISO_LOCAL_DATE;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        String dateiname = "erg_" + durchlaeufe + "_" + richtige + "_" + df.format(now) + "_uhr_" + sdf.format(cal.getTime()) + ".txt";

        File f = new File(dateiname);
        try {
            FileWriter w = new FileWriter(f, true);

            for (int i = 0; i < allezahlen.length; i++) {
                String zahl = Integer.toString(allezahlen[i]);
                w.write(zahl);
                w.write(System.getProperty("line.separator"));
                w.flush();
            }
            w.write("--------------------------------------------------------");
            w.write(System.getProperty("line.separator"));
            w.write(durchschnitt);
            w.write(System.getProperty("line.separator"));
            w.write("--------------------------------------------------------");
            w.flush();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
