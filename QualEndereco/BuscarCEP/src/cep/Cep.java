package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.management.DynamicMBean;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Color;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JLabel lblValido;
	private JButton btnSobre;
	private JComboBox<?> cmbUf;
	private JLabel lblCepPesquisado;

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
		
		btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setForeground(SystemColor.control);
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/info.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(400, 34, 64, 64);
		contentPane.add(btnSobre);
		
		lblValido = new JLabel("");
		lblValido.setVisible(false);
		lblValido.setIcon(new ImageIcon(Cep.class.getResource("/img/check m.png")));
		lblValido.setToolTipText("CEP válido");
		lblValido.setBounds(230, 17, 20, 20);
		contentPane.add(lblValido);
		
		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 20, 35, 14);
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
		
		cmbUf = new JComboBox<Object>();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cmbUf.setBounds(291, 178, 64, 24);
		contentPane.add(cmbUf);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Prencha o campo CEP para realizar a busca");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnBuscar.setToolTipText("Buscar CEP");
		btnBuscar.setBounds(266, 15, 89, 24);
		contentPane.add(btnBuscar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setToolTipText("Limpar campos");
		btnLimpar.setBounds(153, 241, 89, 24);
		contentPane.add(btnLimpar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 228, 316, 2);
		contentPane.add(separator);
		
		txtCep = new JTextField();
		txtCep.setBounds(109, 15, 143, 24);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		RestrictedTextField restricao = new RestrictedTextField(txtCep, "0123456789");
		
		lblCepPesquisado = new JLabel("Último CEP pesquisado.");
		lblCepPesquisado.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCepPesquisado.setForeground(new Color(0, 191, 255));
		lblCepPesquisado.setToolTipText("Último CEP pesquisado.");
		lblCepPesquisado.setBounds(109, 48, 191, 14);
		contentPane.add(lblCepPesquisado);
		restricao.setLimit(8);
		
		this.setLocationRelativeTo(null);
	}
	
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";		
		String resultado = null;
		String cep = txtCep.getText();
		
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
	        Document documento = xml.read(url);
	        Element root = documento.getRootElement();
	        
	        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
	            Element element = it.next();
	            if (element.getQualifiedName().equals("cidade")) {
	            	txtCidade.setText(element.getText());
				}
	            if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
	            if (element.getQualifiedName().equals("uf")) {
					cmbUf.setSelectedItem(element.getText());
				}
	            if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
	            if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
	            if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblValido.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "CEP inválido, busque por outro CEP.");
						limparCampos();
					}
				}
	        }
	        
	        String endereco = tipoLogradouro + " " + logradouro;
	        txtEndereco.setText(endereco);
	        
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void limparCampos() {
		if (txtCep.getText().equals("")) {
			lblCepPesquisado.setText("Último CEP pesquisado.");			
		} else {
			lblCepPesquisado.setText(txtCep.getText());			
		}
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cmbUf.setSelectedIndex(0);
		
		txtCep.requestFocus();
		lblValido.setVisible(false);
	}
}
