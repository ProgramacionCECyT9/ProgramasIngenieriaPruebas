import java.util.Vector;

public class Factura implements Euro {

	String mNumero, mFecha;
	Linea mLineas[];

	public Factura(String n, String f) {
		mNumero=n; mFecha=f;
		mLineas=new Linea[10];
	}

	public void add(Linea l) {
		int i=0;
		for (i=0; mLineas[i]!=null; i++) ;
		mLineas[i]=l;
		}
		public void quitar(int i) {
		mLineas[i].mArticulo=null;
		mLineas[i].mPrecio=0;
	}

	public void show() {
		double total=0;
		System.out.println(mNumero + "; " + mFecha);
		for (int i=0; mLineas[i]!=null; i++) {
		mLineas[i].show();
		total+=mLineas[i].mPrecio;
		}
		System.out.println("Total .... " + total + " pts. \n");
		System.out.println((total/kCambio) + " euros");
	}
}