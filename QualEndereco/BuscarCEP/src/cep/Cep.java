package cep;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JLabel lblValido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
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
	public Cep() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/home.png")));
		setResizable(false);
		setTitle("Busca de CEP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setForeground(SystemColor.control);
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/info.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(400, 34, 64, 64);
		contentPane.add(btnSobre);
		
		lblValido = new JLabel("");
		lblValido.setIcon(new ImageIcon(Cep.class.getResource("/img/check m.png")));
		lblValido.setToolTipText("CEP válido");
		lblValido.setBounds(230, 41, 20, 20);
		contentPane.add(lblValido);
		
		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 44, 35, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Cep.class.getResource("/img/home G.png")));
		lblNewLabel_1.setBounds(389, 61, 181, 219);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEndereco.setBounds(39, 84, 74, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblNewLabel_2 = new JLabel("Bairro");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setBounds(39, 132, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_3.setBounds(39, 183, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("UF");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_4.setBounds(262, 183, 30, 14);
		contentPane.add(lblNewLabel_4);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(109, 79, 246, 24);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(109, 127, 246, 24);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(109, 178, 143, 24);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JComboBox<?> cmbUf = new JComboBox<Object>();
		cmbUf.setBounds(291, 178, 64, 24);
		contentPane.add(cmbUf);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Buscar CEP");
		btnBuscar.setBounds(266, 39, 89, 24);
		contentPane.add(btnBuscar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Limpar campos");
		btnLimpar.setBounds(153, 241, 89, 24);
		contentPane.add(btnLimpar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 228, 316, 2);
		contentPane.add(separator);
		
		txtCep = new JTextField();
		txtCep.setBounds(109, 39, 143, 24);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
	}
}
