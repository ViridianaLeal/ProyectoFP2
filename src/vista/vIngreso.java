package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vIngreso extends JFrame {

	private JPanel contentPane;
	private JRadioButton rbdConsulta;
	private JRadioButton rdbProfesor;
	private JRadioButton rdbAlumno;
	ButtonGroup grupo = new ButtonGroup();
	//vPrincipalA principalA = new vPrincipalA();
	//vPrincipalC principalC = new vPrincipalC();
	//vPrincipalP principalP = new vPrincipalP();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vIngreso frame = new vIngreso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public vIngreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 232);
		contentPane = new JPanel();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 0, 353, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rbdConsulta = new JRadioButton("Consulta");
		rbdConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//principalC.setVisible(true);
			}
		});
		rbdConsulta.setBounds(123, 65, 109, 23);
		panel.add(rbdConsulta);
		
		rdbAlumno = new JRadioButton("Alumno");
		rdbAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//principalA.setVisible(true);
			}
		});
		rdbAlumno.setBounds(123, 106, 109, 23);
		panel.add(rdbAlumno);
		
		rdbProfesor = new JRadioButton("Profesor");
		rdbProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//principalP.setVisible(true);
			}
		});
		rdbProfesor.setBounds(123, 145, 109, 23);
		panel.add(rdbProfesor);
		
		JLabel lblNewLabel = new JLabel("Ingresar como:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 11, 114, 47);
		panel.add(lblNewLabel);
		
		grupo.add(rbdConsulta);
		grupo.add(rdbAlumno);
		grupo.add(rdbProfesor);
		
	}
}
