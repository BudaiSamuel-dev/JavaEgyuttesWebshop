package program;

import classes.Hutomagnes;
import classes.Lemez;
import classes.Polo;
import classes.Termek;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class EgyuttesWebshopPrg {

    private static final File FILE_IN = new File("C:\\Dev\\FeladatForrasok\\BudaiS\\egyuttes-shop-kinalat.txt");

    static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        ArrayList<Termek> termekek = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(FILE_IN);

            while (fileScanner.hasNextLine()){
                String record = fileScanner.nextLine();

                if (!record.isEmpty()){
                    String[] data = record.split(";");

                    String cikkSzam = data[0].trim();
                    String megnevezes = data[1].trim();
                    int ar = Integer.parseInt(data[2].trim());
                    int keszlet = Integer.parseInt(data[3].trim());

                    switch (cikkSzam.substring(0,1)){
                        case "P" : termekek.add(new Polo(cikkSzam, megnevezes, ar, keszlet, data[4].charAt(0), data[5])); break;
                        case "L" : termekek.add(new Lemez(cikkSzam, megnevezes, ar, keszlet, Integer.parseInt(data[4]), data[5])); break;
                        case "H" : termekek.add(new Hutomagnes(cikkSzam, megnevezes, ar, keszlet, data[4])); break;
                    }
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("A fájl beolvasása során hiba lépett fel!");
            System.exit(0);
        }

        System.out.println("--------------------4.feladat--------------------");

        int teljesArukeszletErtek = 0;
        for(Termek termek : termekek){
            teljesArukeszletErtek += termek.getKeszlet() * termek.getAr();
        }
        System.out.printf("A teljes árukészlet értéke %d Ft\n", teljesArukeszletErtek);


        System.out.println("--------------------5.feladat--------------------");

        int poloKeszlet = 0;
        int lemezkeszlet = 0;
        int hutomagnesKeszlet = 0;

        int poloKeszletErtek = 0;
        int lemezKeszletErtek = 0;
        int hutomagnesKeszletErtek = 0;
        for(Termek termek : termekek){
            if (termek instanceof Polo){
                poloKeszlet += termek.getKeszlet();
                poloKeszletErtek += termek.getKeszlet() * termek.getAr();
            } else if (termek instanceof Lemez) {
                lemezkeszlet += termek.getKeszlet();
                lemezKeszletErtek += termek.getKeszlet() * termek.getAr();
            }else {
                hutomagnesKeszlet += termek.getKeszlet();
                hutomagnesKeszletErtek += termek.getKeszlet() * termek.getAr();
            }
        }
        double osszKeszlet = lemezkeszlet + poloKeszlet + hutomagnesKeszlet;

        System.out.printf(
                    "Pólok %d db - Értéke: %d Ft (Teljes készlet %.2f %%-a)\nLemezek %d db - Értéke: %d Ft (Teljes készlet %.2f %%-a)\nHűtőmágnesek %d db - Értéke: %d Ft (Teljes készlet %.2f %%-a)\n",
                    poloKeszlet, poloKeszletErtek, (poloKeszlet / osszKeszlet)*100d, lemezkeszlet, lemezKeszletErtek,(lemezkeszlet/osszKeszlet)*100d, hutomagnesKeszlet, hutomagnesKeszletErtek, (hutomagnesKeszlet/osszKeszlet)*100d
                );

        System.out.println("--------------------6.feladat--------------------");
        System.out.println("Az együttes lemezei: ");
        for (Termek termek : termekek){
            if (termek instanceof Lemez){
                System.out.println(((Lemez)termek).toString());
            }
        }


        System.out.println("--------------------7.feladat--------------------");
        Scanner input = new Scanner(System.in);
        boolean keresoMod = true;
        do {
            System.out.println("Adjon meg egy termékkódot: ");
            String userInput = input.next();

            if (userInput.equals("0")){
                System.out.println("Kilépés a keresésből...");
                input.close();
                keresoMod = false;
                break;
            }

            boolean vanTalaltTermek = true;

            for(Termek termek: termekek){
                if (userInput.equalsIgnoreCase(termek.getCikkSzam())){
                    System.out.println(termek.getInfo());
                    vanTalaltTermek = true;
                    return;
                }else{
                    vanTalaltTermek = false;
                }
            }

            if (!vanTalaltTermek){
                System.out.println("Nincs ilyen kódú termék!");
            }

        }while (keresoMod);
        //TODO a találat után újranyitni a keresést


        System.out.println("--------------------8.feladat--------------------");
        ArrayList<String> poloInfok = new ArrayList<>();
        ArrayList<String> lemezInfok = new ArrayList<>();
        ArrayList<String> hutomagnesInfok = new ArrayList<>();

        for(Termek termek : termekek){
            if (termek instanceof Polo){
               poloInfok.add(termek.getInfo());
            } else if (termek instanceof Lemez) {
                lemezInfok.add(termek.getInfo());
            }else {
                hutomagnesInfok.add(termek.getInfo());
            }
        }


        try {
            FileWriter fileWriter = new FileWriter(new File("C:\\Dev\\FeladatForrasok\\BudaiS\\EgyüttesWebshop\\pólók.txt"));

            for (String info : poloInfok){
                fileWriter.write(info + "\n\n");
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fileWriter = new FileWriter(new File("C:\\Dev\\FeladatForrasok\\BudaiS\\EgyüttesWebshop\\hűtőmágnesek.txt"));

            for (String info : hutomagnesInfok){
                fileWriter.write(info + "\n\n");
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter fileWriter = new FileWriter(new File("C:\\Dev\\FeladatForrasok\\BudaiS\\EgyüttesWebshop\\lemezek.txt"));

            for (String info : lemezInfok){
                fileWriter.write(info + "\n\n");
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
