/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.anajianu.agendatelefonica.start;

import java.io.File;
import java.util.Date;
import java.util.TimerTask;
import ro.anajianu.agendatelefonica.controller.CarteDeTelefonController;

/**
 *
 * @author ana
 */
public class ThreadSalvareBazaDate extends TimerTask {

    private final CarteDeTelefonController controller;
    private final File fisierDeSalvat;
    public ThreadSalvareBazaDate(CarteDeTelefonController aThis, File fisierDeSalvat) {
        controller = aThis;
        this.fisierDeSalvat = fisierDeSalvat;
    }

    @Override
    public void run() {
        System.out.println("Pornire salvare baza de date:" + new Date());
        controller.salveazaFisier(fisierDeSalvat);
        System.out.println("Terminare salvare baza de date:" + new Date());

    }

}
