/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.logika.zarzadzanieKontami.walidacja;

/**
 *
 * @author marcin
 */
public interface IWalidatorDanychKonta {

    void zwalidujDateUrodzenia(String pesel) throws WalidatorDanychKontaWyjatek;

    void zwalidujImie(String imie) throws WalidatorDanychKontaWyjatek;

    void zwalidujMail(String mail) throws WalidatorDanychKontaWyjatek;

    void zwalidujNazwisko(String nazwisko) throws WalidatorDanychKontaWyjatek;

    void zwalidujPESEL(String pesel) throws WalidatorDanychKontaWyjatek;
    void zwalidujDateUrodzeniaZPeselem(String dataUrodzenia, String pesel)
            throws WalidatorDanychKontaWyjatek;
}
