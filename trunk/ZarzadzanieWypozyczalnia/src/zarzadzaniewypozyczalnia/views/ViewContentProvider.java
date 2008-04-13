/**
 * 
 */
package zarzadzaniewypozyczalnia.views;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import zarzadzaniewypozyczalnia.views.ListaUzytkownikowWidok.TreeObject;
import zarzadzaniewypozyczalnia.views.ListaUzytkownikowWidok.TreeParent;

class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		/**
		 * 
		 */
		private final ListaUzytkownikowWidok listaUzytkownikowWidok;

		/**
		 * @param listaUzytkownikowWidok
		 */
		ViewContentProvider(ListaUzytkownikowWidok listaUzytkownikowWidok) {
			this.listaUzytkownikowWidok = listaUzytkownikowWidok;
		}
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(this.listaUzytkownikowWidok.getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
/*
 * We will set up a dummy model to initialize tree heararchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		private void initialize() {
			TreeObject to1 = this.listaUzytkownikowWidok.new TreeObject("Leaf 1");
			TreeObject to2 = this.listaUzytkownikowWidok.new TreeObject("Leaf 2");
			TreeObject to3 = this.listaUzytkownikowWidok.new TreeObject("Leaf 3");
			TreeParent p1 = this.listaUzytkownikowWidok.new TreeParent("Parent 1");
			p1.addChild(to1);
			p1.addChild(to2);
			p1.addChild(to3);
			
			TreeObject to4 = this.listaUzytkownikowWidok.new TreeObject("Leaf 4");
			TreeParent p2 = this.listaUzytkownikowWidok.new TreeParent("Parent 2");
			p2.addChild(to4);
			
			TreeParent root = this.listaUzytkownikowWidok.new TreeParent("Root");
			root.addChild(p1);
			root.addChild(p2);
			
			invisibleRoot = this.listaUzytkownikowWidok.new TreeParent("");
			invisibleRoot.addChild(root);
		}
	}