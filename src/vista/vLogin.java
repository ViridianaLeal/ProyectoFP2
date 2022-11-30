package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.daoUsuario;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class vLogin extends JFrame {

	private JPanel contentPane;
	private JButton btnEntrar;
	private JButton btnCancelar;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JLabel lblLogo;
	daoUsuario dao=new daoUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin frame = new vLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vLogin.class.getResource("/img/FP.png")));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 444);
		contentPane = new JPanel();
		//this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(29, 200, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 256, 86, 20);
		contentPane.add(lblPassword);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user=new Usuario();
				user.setUser(txtUser.getText());
				user.setPassword(String.valueOf(txtPassword.getPassword()));
				if(dao.loginUsuario(user)) {
					JOptionPane.showMessageDialog(null, "BIENVENIDO");
					vCargando cargando=new vCargando();
					setVisible(false);
					cargando.setVisible(true);
				}else {
				
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
			}
			}
		});
		btnEntrar.setBounds(71, 344, 89, 23);
		contentPane.add(btnEntrar);
		
		btnCancelar = new JButton("Cancel");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ADIOS");
				System.exit(0);
			}
		});
		btnCancelar.setBounds(186, 344, 89, 23);
		contentPane.add(btnCancelar);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPassword.getText().length()>10) {
					e.consume();
				}
			}
		});
		txtPassword.setText("");
		txtPassword.setBounds(29, 287, 301, 20);
		contentPane.add(txtPassword);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtUser.getText().length()>10) {
					e.consume();
			}
			}
		});
		txtUser.setBounds(29, 225, 301, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(vLogin.class.getResource("/img/DEOCLASS.png")));
		lblLogo.setBounds(87, 11, 167, 178);
		contentPane.add(lblLogo);
	}
}
