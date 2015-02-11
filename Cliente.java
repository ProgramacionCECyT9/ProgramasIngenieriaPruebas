import java.util.Vector;

public class Cliente {
	String mNIF, mNombre;
	Vector mFacturas;

	public Cliente(String nif, String nombre) {
		mNIF=nif; mNombre=nombre; mFacturas=new Vector();
	}

	public void add(Factura f) {
		mFacturas.addElement(f);
	}

	public void show() {
		System.out.println("Facturas del cliente " + mNombre + ":");
		for (int i=0; i<mFacturas.size(); i++) {
			System.out.println("Factura " + (i+1));
			((Factura) mFacturas.elementAt(i)).show();
			System.out.println("-------------------\n\n");
		}
	}
}