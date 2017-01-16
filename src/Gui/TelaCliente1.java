package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import Cliente.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class TelaCliente1 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRequisicaoGet;
	private JTextField textFieldIPDestino;
	private Cliente cliente = new Cliente();

	
	public TelaCliente1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente1.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 829, 477);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		textFieldRequisicaoGet = new JTextField();
		textFieldRequisicaoGet.setBounds(29, 424, 223, 20);
		panelPrincipal.add(textFieldRequisicaoGet);
		textFieldRequisicaoGet.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do arquivo Ex.:  GET /teste.htm  HTTP/1.0 ");
		lblDigiteONome.setBounds(29, 371, 522, 25);
		panelPrincipal.add(lblDigiteONome);
		lblDigiteONome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBounds(280, 423, 89, 23);
		panelPrincipal.add(btnConectar);
		
		JLabel lblRaylisonNunesE = new JLabel("Raylison nunes e  Pedro Carlos");
		lblRaylisonNunesE.setBounds(627, 452, 192, 14);
		panelPrincipal.add(lblRaylisonNunesE);
		
		JLabel lblIpDestino = new JLabel("IP Destino");
		lblIpDestino.setBounds(29, 289, 117, 25);
		panelPrincipal.add(lblIpDestino);
		lblIpDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldIPDestino = new JTextField();
		textFieldIPDestino.setBounds(29, 325, 157, 20);
		panelPrincipal.add(textFieldIPDestino);
		textFieldIPDestino.setColumns(10);
		
		JLabel lblProjetoDeRedes = new JLabel("Projeto de  Redes");
		lblProjetoDeRedes.setBounds(220, 64, 330, 46);
		panelPrincipal.add(lblProjetoDeRedes);
		lblProjetoDeRedes.setFont(new Font("Tahoma", Font.ITALIC, 37));
		btnConectar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				cliente.setNomeArquivo(textFieldRequisicaoGet.getText());
				cliente.setIpDestino(textFieldIPDestino.getText());
				cliente.estabelencendoConexao();                       
				JOptionPane.showMessageDialog(null,cliente.converterString(cliente.getRecebe()), Cliente.tituloDaPagina(cliente.getRecebe()), -1);
			
			}
		});
		
	}
	
	
}
