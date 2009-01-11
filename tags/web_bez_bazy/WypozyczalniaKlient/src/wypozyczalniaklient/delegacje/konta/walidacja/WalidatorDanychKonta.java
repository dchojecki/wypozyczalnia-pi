/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalniaklient.delegacje.konta.walidacja;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author marcin
 */
public class WalidatorDanychKonta implements IWalidatorDanychKonta {

    private boolean pusteOK;

    private WalidatorDanychKonta(boolean puste) {
        this.pusteOK = puste;
    }

    public static WalidatorDanychKonta pobierzWalidator(boolean puste) {
        return new WalidatorDanychKonta(puste);
    }

    public void zwalidujImie(String imie) throws WalidatorDanychKontaWyjatek {
        if (!pusteOK && (imie == null || imie.length() == 0)) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w imieniu", imie);
        }
        if (pusteOK && (imie == null || imie.length() == 0)) {
            return;
        }
        Pattern p = Pattern.compile("[A-Z][a-Å¼Ä‡Å›Å„Ã³ÅºÄ…Ä™]+");
        Matcher m = p.matcher(imie);
        if (!m.matches()) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w imieniu", imie);
        }
    }

    public void zwalidujNazwisko(String nazwisko) throws WalidatorDanychKontaWyjatek {
        if (!pusteOK && (nazwisko == null || nazwisko.length() == 0)) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w nazwisku", nazwisko);
        }
        if (pusteOK && (nazwisko == null || nazwisko.length() == 0)) {
            return;
        }


        Pattern p = Pattern.compile("[A-Z][a-Å¼Ä‡Å›Å„Ã³ÅºÄ…Ä™]+");
        Matcher m = p.matcher(nazwisko);
        if (!m.matches()) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w nazwisku", nazwisko);
        }

    }

    public void zwalidujMail(String mail) throws WalidatorDanychKontaWyjatek {
        if (!pusteOK && (mail == null || mail.length() == 0)) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w mailu", mail);
        }
        if (pusteOK && (mail == null || mail.length() == 0)) {
            return;
        }

        Pattern p = Pattern.compile("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        Matcher m = p.matcher(mail);
        if (!m.matches()) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w adresie mail", mail);
        }

    }

    public void zwalidujPESEL(String pesel) throws WalidatorDanychKontaWyjatek {
        if (!pusteOK && (pesel == null || pesel.length() == 0)) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w nr pesel", pesel);
        }
        if (pusteOK && (pesel == null || pesel.length() == 0)) {
            return;
        }
        Pattern p = Pattern.compile("[0-9]{11}");
        Matcher m = p.matcher(pesel);

        if (m.matches() == false) {
            throw new WalidatorDanychKontaWyjatek("Pesel musi sk³adaæ siê z 11 cyfr", pesel);
        } else {            
                char[] peselNr = pesel.toCharArray();
                int suma = 0;
                int[] mlt = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
                for (int i = 0; i < 10; i++) {
                    suma += (peselNr[i] - 48) * mlt[i];
                }
                suma %= 10;
                suma = 10 - suma;
                if (suma == peselNr[10] - 48) {
                    ;
                } else {
                    throw new WalidatorDanychKontaWyjatek("B³¹d w sumie kontrolnej peselu", pesel);
                }
                
            try {
                DateFormat formatter = new SimpleDateFormat("yyMMdd");
                String tmp  = pesel.substring(0, 6);
                Date date = (Date) formatter.parse(tmp);
                if (!formatter.format(date).equals(tmp)) {
                throw new WalidatorDanychKontaWyjatek("nieprawidlowa data", pesel);
                }
            } catch (ParseException ex) {
                throw new WalidatorDanychKontaWyjatek("B³¹d w peselu", pesel);
            }
        }
    }

    public void zwalidujDateUrodzenia(String dataurodzenia) throws WalidatorDanychKontaWyjatek {
        if (!pusteOK && (dataurodzenia == null || dataurodzenia.length() == 0)) {
            throw new WalidatorDanychKontaWyjatek("B³¹d w dacie urodzenia", dataurodzenia);
        }
        if (pusteOK && (dataurodzenia == null || dataurodzenia.length() == 0)) {
            return;
        }

        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) formatter.parse(dataurodzenia);
            if (!formatter.format(date).equals(dataurodzenia)) {
                throw new WalidatorDanychKontaWyjatek("nieprawidlowa data", dataurodzenia);
            }
        } catch (ParseException ex) {
            throw new WalidatorDanychKontaWyjatek("nieprawidlowa data", dataurodzenia);
        }
    }

    public void zwalidujDateUrodzeniaZPeselem(String dataUrodzenia, String pesel)
            throws WalidatorDanychKontaWyjatek {
        zwalidujDateUrodzenia(dataUrodzenia);
        zwalidujPESEL(pesel);

        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatter2 = new SimpleDateFormat("yyMMdd");
        pesel = pesel.substring(0, 6);

        try {
            Date date1 = (Date) formatter1.parse(dataUrodzenia);
            Date date2 = (Date) formatter2.parse(pesel);

            if (!date1.equals(date2)) {
                throw new WalidatorDanychKontaWyjatek("nieprawidlowa data lub pesel", dataUrodzenia);
            }
        } catch (Exception e) {
            throw new WalidatorDanychKontaWyjatek("nieprawidlowa data lub pesel", dataUrodzenia);

        }
    }
}
