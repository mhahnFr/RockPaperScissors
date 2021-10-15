package com.example.manuel.ssp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by manuel on 28.12.2015.
 */
public class Spiel
{
    private Random random;
    private ArrayList<Character> moeglich;
    private char mWahl;
    private char cWahl;
    private static int du = 0;
    private static int com = 0;

    public Spiel()
    {
        random = new Random();
        moeglich = new ArrayList<Character>();
        moeglich.add('s');
        moeglich.add('p');
        moeglich.add('r');
        du = 0;
        com = 0;
    }

    /**
     * Ermittelt den Sieger.
     *
     * @param mWahl des Users Wahl
     * @param iWin Der char, bei dem der Computer gewinnen würde
     * @param youWin Der char, bei dem der Spieler gewinnen würde
     * @return 1 - Computer gewinnt, 0 - Spieler gewinnt, 10 - Unentschieden
     */
    public int choosen(char mWahl, char iWin, char youWin)
    {
        this.mWahl = mWahl;
        cWahl = moeglich.get(random.nextInt(moeglich.size()));
        if(cWahl == iWin)
        {
            com++;
            return 1;
        }
        else if(cWahl == youWin)
        {
            du++;
            return 0;
        }
        return 10;
    }

    /**
     * Gibt zurück, was der Computer genommen hat.
     *  • 's' für Schere,
     *  • 'p' für Papier,
     *  • 'r' für Stein.
     *
     * @return was der Computer genommen hat
     */
    public char getComWahl()
    {
        return cWahl;
    }

    /**
     * Gibt zurück, wie oft der Spieler bereits gewonnen hat.
     *
     * @return wie oft der Spieler seit App-Start gewonnen hat
     */
    public static String getDu()
    {
        return String.valueOf(du);
    }

    /**
     * Gibt zurück, wie oft der Computer bereits gewonnen hat.
     *
     * @return wie oft der Computer seit App-Start gewonnen hat
     */
    public static String getCom()
    {
        return String.valueOf(com);
    }
}