public class Linea {
	
	String mArticulo;
	double mPrecio;

	public Linea(String a, double p) {
		mArticulo=a;
		mPrecio=p;
	}

	public void show() {
		System.out.println("\t" + mArticulo + " ..... " + mPrecio + " pts");
	}
}