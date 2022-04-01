package login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLogin extends JFrame {

	public static final long serialVersionUID = 1L;
	private static PanelLogin frame;// sirve para que asigne la clase a la ventana, seria como un punto de enlace entre ventanas
	private static int ANCHO_LABEL = 100;// tamaño de ancho del JLabel
	private static int ALTO_LABEL = 20;// tamaño de alto del JLabel

	public void ventanaPrincipal() {

		JFrame ventana = new JFrame("AwelaHe");// El nombre con el que se llamara la ventana que sale
		ventana.setSize(800, 600);// asignas el tamaño con el que aparecera la ventana
		ventana.setResizable(false); // con esto no puedes cambiar el tamaño de la ventana
		ventana.setVisible(true);// para que la ventana se vea
		setDefaultCloseOperation(EXIT_ON_CLOSE);// PUEDE SER PARA QUE SI PULSAS LA X SE CIERRE

	}

	public JPanel datosVentanaPrincipal() {

		JPanel login = new JPanel();
		login.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		login.setLayout(null);
		JLabel usuario = new JLabel("Usuario: ");
		JLabel contraseña = new JLabel("Contraseña: ");
		usuario.setBounds(60, 150, ANCHO_LABEL, ALTO_LABEL);//
		contraseña.setBounds(60, 200, ANCHO_LABEL, ALTO_LABEL);//
		login.add(usuario);
		login.add(contraseña);

		JTextField nombre = new JTextField();
		JTextField pass = new JTextField();
		nombre.setBounds(200, 150, ANCHO_LABEL, ALTO_LABEL);
		pass.setBounds(200, 200, ANCHO_LABEL, ALTO_LABEL);
		login.add(nombre);
		login.add(pass);

		JLabel error = new JLabel();
		error.setBounds(70, 300, 400, ALTO_LABEL);// asignar en la ventana el lugar donde aparecera
		error.setForeground(Color.RED);// color del mensaje error error
		login.add(error);

		JButton boton = new JButton("Logueo");
		boton.setBounds(150, 250, ANCHO_LABEL, ALTO_LABEL);
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nombre.getText().equalsIgnoreCase("admin") && pass.getText().equals("ADMIN")) {
					frame.cambioPanel(2);
				}else {
					error.setText("Nombre de usuario o contraseña Incorrectos.");//setText es el nuevo SYSO
				}
			}
		});
		login.add(boton);
		return login;
	}

	public JPanel panelRegistrar() {//esta es la ventana que sale despues de dar al boton login y que sea correcto
		JPanel login = new JPanel();
		// asignar tamaño suponer 600 x 600
		login.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		// disposicion absoluta
		login.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblPass = new JLabel("Contraseña");
		// posicion label usuario
		lblUsuario.setBounds(60, 150, ANCHO_LABEL, ALTO_LABEL);
		lblPass.setBounds(60, 200, ANCHO_LABEL, ALTO_LABEL);
		login.add(lblUsuario);
		login.add(lblPass);

		JButton btnLogin = new JButton("login");
		btnLogin.setBounds(150, 250, ANCHO_LABEL, ALTO_LABEL);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambioPanel(1);

			}
		});
		login.add(btnLogin);
		return login;
	}

	protected void cambioPanel(int opcion) {
		
		switch (opcion) {
		case 1:
			frame.setContentPane(datosVentanaPrincipal());
			break;
		case 2: frame.setContentPane(panelRegistrar());
		}
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new PanelLogin();
				frame.setSize(800, 600);// asignas el tamaño con el que aparecera la ventana
				frame.setResizable(false);// con esto no puedes cambiar el tamaño de la ventana
				frame.setVisible(true);
				frame.cambioPanel(1);
			}
		});
	}
}
