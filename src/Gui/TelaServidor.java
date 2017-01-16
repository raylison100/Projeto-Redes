package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import Servido.Servidor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaServidor extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Servidor servido = new Servidor();
	
	

	public TelaServidor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaServidor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 513, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProjetoDeRedes = new JLabel("Projeto de Redes");
		lblProjetoDeRedes.setBounds(32, 11, 412, 66);
		lblProjetoDeRedes.setFont(new Font("Tahoma", Font.ITALIC, 54));
		panel.add(lblProjetoDeRedes);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(10, 288, 55, 32);
		panel.add(lblStatus);
		
		JLabel lblDesconectado = new JLabel("Desconectado");
		lblDesconectado.setBounds(78, 291, 224, 32);
		panel.add(lblDesconectado);
		
		JLabel lblServidorJava = new JLabel("SERVIDOR JAVA");
		lblServidorJava.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblServidorJava.setBounds(162, 102, 159, 32);
		panel.add(lblServidorJava);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				servido.estabelecerConecao();
				lblDesconectado.setText("Servidor iniciado na porta: 3322");	
	
			}});
		btnConectar.setBounds(271, 296, 89, 23);
		panel.add(btnConectar);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblDesconectado.setText("Conexao encerrada");
				servido.encerraConexao();
			}
		});
		btnDesconectar.setBounds(370, 296, 103, 23);
		panel.add(btnDesconectar);
	}

}
