/**
 * 
 */
package wypozyczalniaklient.views.listawypozyczen;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTOZbior;


class TreeParent extends TreeObject {
	public TreeParent(String name) {
		super(name);
	}

	public void setZbior(ZamowienieTOZbior zbior) {
		this.zbior = zbior;
	}

	public ZamowienieTOZbior getZbior() {
		return zbior;
	}

	private ZamowienieTOZbior zbior;
}