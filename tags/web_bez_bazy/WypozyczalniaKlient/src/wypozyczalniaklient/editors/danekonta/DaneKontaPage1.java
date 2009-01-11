package wypozyczalniaklient.editors.danekonta;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiWyjatek;
import wypozyczalniaklient.kontrolki.KontrolkaKalendarza;
import wypozyczalniaklient.wizards.zmianastanukonta.ZmianaStanuKonta;
import wypozyczalniaklient.wizards.zmianastanukonta.ZmianaStanuKontaPage;

public class DaneKontaPage1 extends FormPage {
	/**
	 * @param id
	 * @param title
	 */

	private KontoTO konto;
	private KlientTO klient;
	private AdresTO adres;

	public DaneKontaPage1(FormEditor editor) {
		super(editor, "first", "Konto"); //$NON-NLS-1$ //$NON-NLS-2$
		DaneKontaInput i = (DaneKontaInput) editor.getEditorInput();
		konto = i.getKonto();

		try {
			klient = ZarzadzanieKontamiDelegacja.getInstance()
					.zwrocDaneKlienta(konto.getNrPeselKlienta());
			adres = ZarzadzanieKontamiDelegacja.getInstance().zwrocDaneAdresu(
					konto.getNrPeselKlienta());
		} catch (ZarzadzanieKontamiWyjatek e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Edycja danych konta"); //$NON-NLS-1$
		TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);
		TableWrapData td;
		td = new TableWrapData();
		td.align = TableWrapData.LEFT;
		createKonto(form, toolkit);
		createKlient(form, toolkit);
		createAdres(form, toolkit);
	}

	private void createKonto(final ScrolledForm form, final FormToolkit toolkit) {
		final ExpandableComposite exp = toolkit.createExpandableComposite(form
				.getBody(), ExpandableComposite.TREE_NODE
		// ExpandableComposite.NONE
				);
		exp.setActiveToggleColor(toolkit.getHyperlinkGroup()
				.getActiveForeground());
		exp.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		Composite client = toolkit.createComposite(exp);
		exp.setClient(client);
		TableWrapLayout elayout = new TableWrapLayout();
		client.setLayout(elayout);
		elayout.leftMargin = elayout.rightMargin = 40;
		elayout.numColumns = 3;
		elayout.horizontalSpacing = 10;
		elayout.verticalSpacing = 10;
		exp.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		exp.setText("Konto"); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		// td.colspan = 2;
		// td.align = TableWrapData.LEFT;
		td.align = TableWrapData.FILL;

		toolkit.createLabel(client, "Numer identyfikacyjny konta:");
		toolkit.createLabel(client, konto.getNrKonta().toString());
		toolkit.createLabel(client, "");

		toolkit.createLabel(client, "Stan konta");
		toolkit.createLabel(client, konto.getStanKonta().toString());
		final Button button = toolkit.createButton(client, "Zmieñ", SWT.PUSH); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ZmianaStanuKonta wizard = new ZmianaStanuKonta();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), null);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.create();
				dialog.open();
			}
		});	
		toolkit.createLabel(client, "Data ostatniego logowania");
		toolkit.createLabel(client, konto.getDataOstatniegoLogowania()
				.toString());
		toolkit.createLabel(client, "");
		
		toolkit.createLabel(client, "Data ostatniej zmiany hasla:");
		toolkit.createLabel(client, konto.getDataOstatniejZmianyHasla()
				.toString());
		toolkit.createLabel(client, "");
		exp.setLayoutData(td);
	}

	private void createKlient(final ScrolledForm form, final FormToolkit toolkit) {
		final ExpandableComposite exp = toolkit.createExpandableComposite(form
				.getBody(), ExpandableComposite.TREE_NODE
		// ExpandableComposite.NONE
				);
		exp.setActiveToggleColor(toolkit.getHyperlinkGroup()
				.getActiveForeground());
		exp.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		Composite client = toolkit.createComposite(exp);
		exp.setClient(client);
		TableWrapLayout elayout = new TableWrapLayout();
		elayout.horizontalSpacing = 10;
		elayout.verticalSpacing = 10;
		client.setLayout(elayout);
		elayout.leftMargin = elayout.rightMargin = 40;
		elayout.numColumns = 3;
		exp.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		exp.setText("Klient"); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		// td.colspan = 2;
		td.align = TableWrapData.FILL;
		exp.setLayoutData(td);

		toolkit.createLabel(client, "Numer PESEL klienta:");
		toolkit.createLabel(client, klient.getNrPeselKlienta());
		toolkit.createLabel(client, "");

		toolkit.createLabel(client, "Nazwisko");
		Text t = toolkit.createText(client, klient.getNazwisko(), SWT.BORDER);
		toolkit.createLabel(client, "");
		
		toolkit.createLabel(client, "Imie");
		toolkit.createText(client, klient.getImie(), SWT.BORDER);
		toolkit.createLabel(client, "");

		toolkit.createLabel(client, "Data urodzenia:");
		toolkit.createLabel(client, klient.getDataUrodzenia().toString());
		final Button button = toolkit.createButton(client, "Kalendarz", SWT.PUSH); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				final Shell shell = DaneKontaPage1.this.getEditor().getSite().getShell();
				KontrolkaKalendarza cd = new KontrolkaKalendarza(shell);
				String dataString = (String) cd.open();
			}
		});		
		toolkit.createLabel(client, "Adres mailowy:");
		toolkit.createText(client, klient.getAdresMailowy(), SWT.BORDER);
		toolkit.createLabel(client, "");
	}

	private void createAdres(final ScrolledForm form, final FormToolkit toolkit) {
		final ExpandableComposite exp = toolkit.createExpandableComposite(form
				.getBody(), ExpandableComposite.TREE_NODE
		// ExpandableComposite.NONE
				);
		exp.setActiveToggleColor(toolkit.getHyperlinkGroup()
				.getActiveForeground());
		exp.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		Composite client = toolkit.createComposite(exp);
		exp.setClient(client);
		TableWrapLayout elayout = new TableWrapLayout();
		client.setLayout(elayout);
		elayout.leftMargin = elayout.rightMargin = 40;
		elayout.numColumns = 2;
		elayout.horizontalSpacing = 10;
		elayout.verticalSpacing = 10;
		exp.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		exp.setText("Adres"); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		// td.colspan = 2;
		// td.align = TableWrapData.LEFT;
		td.align = TableWrapData.FILL;
		exp.setLayoutData(td);

		toolkit.createLabel(client, "Miejscowoœæ");
		if (adres.getMiast() == null)
			toolkit.createText(client, "nie podano", SWT.BORDER);
		else
			toolkit.createText(client, adres.getMiast(), SWT.BORDER);

		toolkit.createLabel(client, "Ulica");
		if (adres.getUlica() == null)
			toolkit.createText(client, "nie podano", SWT.BORDER);
		else
			toolkit.createText(client, adres.getUlica(), SWT.BORDER);

		toolkit.createLabel(client, "Numer domu");
		if (adres.getNrDomu() == null)
			toolkit.createText(client, "nie podano", SWT.BORDER);
		else
			toolkit.createText(client, adres.getNrDomu().toString(), SWT.BORDER);

		toolkit.createLabel(client, "Numer mieszkania");
		if (adres.getNrMieszkania() == null)
			toolkit.createText(client, "nie podano", SWT.BORDER);
		else
			toolkit.createText(client, adres.getNrMieszkania().toString(), SWT.BORDER | SWT.FILL);

	}

}