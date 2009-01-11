/**
 * 
 */
package wypozyczalnia.to.zarzadzaniekontami;

import java.io.Serializable;
import java.util.Date;

import wypozyczalnia.dao.StanKonta;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class KontoTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KontoTO() {
    }
    
    
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private int nrKonta = 0;
    private String nrPeselKlienta = "";
    private Date dataOstatniegoLogowania = new Date();
    private Date dataOstatniejZmianyHasla = new Date();

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrKonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getNrKonta() {
        // begin-user-code
        return nrKonta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrKonta the nrKonta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrKonta(Integer theNrKonta) {
        // begin-user-code
        nrKonta = theNrKonta;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private StanKonta stanKonta = StanKonta.NIEAKTYWNE;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the stanKonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public StanKonta getStanKonta() {
        // begin-user-code
        return stanKonta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theStanKonta the stanKonta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setStanKonta(StanKonta theStanKonta) {
        // begin-user-code
        stanKonta = theStanKonta;
    // end-user-code
    }


    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrPeselKlienta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getNrPeselKlienta() {
        // begin-user-code
        return nrPeselKlienta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrPeselKlienta the nrPeselKlienta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrPeselKlienta(String theNrPeselKlienta) {
        // begin-user-code
        nrPeselKlienta = theNrPeselKlienta;
    // end-user-code
    }

    public Date getDataOstatniegoLogowania() {
        return dataOstatniegoLogowania;
    }

    public void setDataOstatniegoLogowania(Date dataOstatniegoLogowania) {
        this.dataOstatniegoLogowania = dataOstatniegoLogowania;
    }

    public Date getDataOstatniejZmianyHasla() {
        return dataOstatniejZmianyHasla;
    }

    public void setDataOstatniejZmianyHasla(Date dataOstatniejZmianyHasla) {
        this.dataOstatniejZmianyHasla = dataOstatniejZmianyHasla;
    }
}
