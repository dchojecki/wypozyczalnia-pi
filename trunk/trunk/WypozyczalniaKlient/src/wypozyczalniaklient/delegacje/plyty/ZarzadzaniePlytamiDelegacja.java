package wypozyczalniaklient.delegacje.plyty;

import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytami;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

public class ZarzadzaniePlytamiDelegacja {

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated "UML to Java
		 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		private static ZarzadzaniePlytami zarzadzanieplytami;

		public static void setZarzadzanieKontami(ZarzadzaniePlytami zarza) {
			zarzadzanieplytami = zarza;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated "UML to Java
		 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated "UML to Java
		 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		private static final ZarzadzaniePlytamiDelegacja instance = new ZarzadzaniePlytamiDelegacja();

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated "UML to Java
		 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		private ZarzadzaniePlytamiDelegacja() {
			// begin-user-code
			// TODO: Implement constructor logic
			// end-user-code
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated "UML to Java
		 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public static ZarzadzaniePlytamiDelegacja getInstance() {
			// begin-user-code

			return instance;
			// end-user-code
		}

		public FilmTOZbior zwrocListeWszystkichFilmow() {
			FilmTOZbior z = zarzadzanieplytami.zwrocListeWszystkichFilmow();
			return z;
		}

		public PlytaTOZbior zwrocListeWszystkichPlyt(FilmTO film) {
			PlytaTOZbior z = zarzadzanieplytami.zwrocListeWszystkichPlyt(film);
			return z;
		}
		
		
		public void dodajFilm(FilmTO film) {
			zarzadzanieplytami.dodajFilm(film);
		}
		
		public void dodajPlyte(FilmTO film, PlytaTO plyta) {
			zarzadzanieplytami.dodajPlyte(film, plyta);
		}
	}

