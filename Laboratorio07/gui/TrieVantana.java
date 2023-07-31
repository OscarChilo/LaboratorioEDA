package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import ejercicio1.Trie;
import java.awt.Color;
import java.awt.Component;

public class TrieVentana extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField textInset;
	public JTextField textBus;
	private JTextField textRem;
	JButton btnInsert, btnBus, btnRem, btnBo;

	Trie trie = new Trie();
	private JPanel panel;

	public TrieVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("VENTANA BUSCAR");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void iniciarComponentes() {

		setBounds(100, 100, 552, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Insertar:");
		lblNewLabel.setBounds(36, 77, 87, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Buscar: ");
		lblNewLabel_1.setBounds(36, 113, 87, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Reemplazar: ");
		lblNewLabel_2.setBounds(36, 144, 87, 14);
		contentPane.add(lblNewLabel_2);

		textInset = new JTextField();
		textInset.setBounds(133, 74, 175, 20);
		contentPane.add(textInset);
		textInset.setColumns(10);

		textBus = new JTextField();
		textBus.setBounds(133, 110, 175, 20);
		contentPane.add(textBus);
		textBus.setColumns(10);

		textRem = new JTextField();
		textRem.setBounds(133, 141, 175, 20);
		contentPane.add(textRem);
		textRem.setColumns(10);

		btnInsert = new JButton("INSERTAR");
		btnInsert.setBounds(318, 73, 116, 23);
		btnInsert.addActionListener(this);
		contentPane.add(btnInsert);

		btnBus = new JButton("BUSCAR");
		btnBus.setBounds(318, 109, 116, 23);
		btnBus.addActionListener(this);
		contentPane.add(btnBus);

		btnRem = new JButton("REEMPLAZAR");
		btnRem.setBounds(318, 140, 116, 23);
		btnRem.addActionListener(this);
		contentPane.add(btnRem);

		btnBo = new JButton("BORRRAR");
		btnBo.setBounds(435, 259, 101, 23);
		btnBo.addActionListener(this);
		contentPane.add(btnBo);

		JLabel lblNewLabel_3 = new JLabel("TRIE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(242, 11, 46, 14);
		contentPane.add(lblNewLabel_3);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 225));
		panel.setBounds(36, 194, 399, 162);
		contentPane.add(panel);

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		String busString = textBus.getText();
		if (btnInsert == e.getSource()) {
			String inserString = textInset.getText();
			JOptionPane.showMessageDialog(null, "Insertar " + inserString);

			trie.insert(inserString);

			lista();
		}
		if (btnBus == e.getSource()) {

			if (trie.search(busString) == false) {
				JOptionPane.showMessageDialog(null, busString + " no se encontro");
			} else {
				JOptionPane.showMessageDialog(null, busString + " se encontro");

				Component[] components = panel.getComponents();
				for (Component component : components) {
					if (component instanceof JLabel) {
						JLabel label = (JLabel) component;
						if (label.getText().equals(busString)) {
							label.setOpaque(true);
							label.setBackground(Color.YELLOW);
						}
					}
				}

			}
		}
		if (btnRem == e.getSource()) {
			String remString = textRem.getText();
			JOptionPane.showMessageDialog(null, "Remplazar por " + remString);

			if (trie.search(busString) == false) {
				JOptionPane.showMessageDialog(null, busString + " no reemplazar");

			} else {
				trie.replace(busString, remString);
				lista();
				JOptionPane.showMessageDialog(null, busString + " se se remplazo con exito");

			}
			for (Component component : panel.getComponents()) {
				if (component instanceof JLabel) {
					JLabel label = (JLabel) component;
					// Hacer algo con el JLabel seleccionado aquí
				}
			}
		}
		if (btnBo == e.getSource()) {
			String boString = panel.getToolTipText();
			JOptionPane.showMessageDialog(null, "Borrar " + boString);

		}
	}

	public void lista() {
		panel.removeAll();
		for (String ele : trie.getWords()) {
			JLabel label = new JLabel(ele);
			panel.add(label);
		}
		panel.revalidate();
		// panel.repaint();
	}
}
