import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class IUClave extends JFrame {

	private JPanel jContentPane = null;
	private JLabel titulo = null;
	private JLabel nnom = null;
	private JTextField elnom = null;
	private JLabel ccon = null;
	private JPasswordField lacon = null;
	private JButton llis = null;
	private JTextField rres = null;
	private TClave laclave;

	private JTextField getElnom() {
		if (elnom == null) {
			elnom = new JTextField();
			elnom.setBounds(new java.awt.Rectangle(120,45,127,20));
		}
		return elnom;
	}

	private JPasswordField getLacon() {
		if (lacon == null) {
			lacon = new JPasswordField();
			lacon.setBounds(new java.awt.Rectangle(137,75,108,20));
		}
		return lacon;
	}

	private JButton getLlis() {
		if (llis == null) {
			llis = new JButton();
			llis.setBounds(new java.awt.Rectangle(90,105,81,17));
			llis.setText("LISTO");
			llis.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					generated Event stub actionPerformed()
					identificalo();
				}
			});
		}
		return llis;
	}

	private JTextField getRres() {
		if (rres == null) {
			rres = new JTextField();
			rres.setBounds(new java.awt.Rectangle(22,137,238,20));
		}
		return rres;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUClave application = new IUClave();
		application.show();
	}

	public IUClave() {
		super();
		initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Application");
		laclave= new TClave();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			ccon = new JLabel();
			ccon.setBounds(new java.awt.Rectangle(35,75,91,16));
			ccon.setText("Contraseña:");
			nnom = new JLabel();
			nnom.setBounds(new java.awt.Rectangle(35,44,67,16));
			nnom.setText("Nombre:");
			titulo = new JLabel();
			titulo.setBounds(new java.awt.Rectangle(15,9,263,16));
			titulo.setText("Por favor escriba su nombre y su contraseña");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(titulo, null);
			jContentPane.add(nnom, null);
			jContentPane.add(getElnom(), null);
			jContentPane.add(ccon, null);
			jContentPane.add(getLacon(), null);
			jContentPane.add(getLlis(), null);
			jContentPane.add(getRres(), null);
		}
		return jContentPane;
	}

	private void identificalo() {
		//aqui llamamos a laclave para identificar al usuario
		int qres;
		String n=elnom.getText();
		String c=lacon.getText();
		System.out.println("leido:"+n+", y:"+c+"!");
		qres=laclave.identif(n,c);
		if (qres==1){
			rres.setText("El usuario "+n+" ha sido reconocido.");
			System.out.println("Permisos: "+laclave.damePermisos());
		}
		else{
			switch (qres) {
				case -1: rres.setText("Usuario "+n+", Contraseña errónea"); break;
				case -2: rres.setText("Usuario "+n+" no existe");break;
				case -3: rres.setText("Problema en conexión");break;
			}
		}
	}
}