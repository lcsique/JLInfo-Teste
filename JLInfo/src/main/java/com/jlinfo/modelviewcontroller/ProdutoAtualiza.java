package com.jlinfo.modelviewcontroller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jlinfo.modeldominio.ProdutoBean;
import com.jlinfo.modelpersistencia.ProdutoDAO;

public class ProdutoAtualiza {
	public static void atualiza(final JFrame frame) {
		final JPanel jpProUpdate = new JPanel();
		jpProUpdate.setLayout(new BoxLayout(jpProUpdate, BoxLayout.Y_AXIS));
		jpProUpdate.setPreferredSize(new Dimension(300, 350));
		JLabel jlTitle = new JLabel("Atualizar Produto");
		jlTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jpProUpdate.add(jlTitle);
		
	    JLabel jlId = new JLabel("Código do produto a ser atualizado:");
		jpProUpdate.add(jlId);

		final JTextField jtfId = new JTextField();
		jtfId.setMaximumSize(new Dimension(450, 24));
		jpProUpdate.add(jtfId);

		JLabel jlDescricao = new JLabel("Nova Descrição: ");
		jpProUpdate.add(jlDescricao);

		final JTextField jtfDescricao = new JTextField();
		jtfDescricao.setMaximumSize(new Dimension(450, 24));
		jpProUpdate.add(jtfDescricao);

		JLabel jlQuantidade_minima = new JLabel("Nova Quantidade Minima: ");
		jpProUpdate.add(jlQuantidade_minima);

		final JTextField jtfQuantidade_minima = new JTextField();
		jtfQuantidade_minima.setMaximumSize(new Dimension(450, 24));
		jpProUpdate.add(jtfQuantidade_minima);

		JLabel jlValor = new JLabel("Novo Valor: ");
		jpProUpdate.add(jlValor);

		final JTextField jtfValor = new JTextField();
		jtfValor.setMaximumSize(new Dimension(450, 24));
		jpProUpdate.add(jtfValor);

		JButton confirm = new JButton("Confirmar");
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ProdutoBean pb = new ProdutoBean();
				if (jtfId.getText().equals("") || jtfDescricao.getText().equals("") || jtfQuantidade_minima.getText().equals("") || 
						jtfValor.getText().equals(""))
					JOptionPane.showMessageDialog(jpProUpdate,
							"Existem campos em branco.");
				else {
					pb.setId(Long.valueOf(jtfId.getText()));
					pb.setDescricao(jtfDescricao.getText());
					pb.setQuantidade_minima(Integer.valueOf(jtfQuantidade_minima.getText()));
					pb.getData_cadastro();
					pb.setValor(Double.valueOf(jtfValor.getText()));
					ProdutoDAO pd = new ProdutoDAO();
					pd.update(pb);
					JOptionPane.showMessageDialog(frame,
							"Produto atualizado com sucesso!");
					jtfDescricao.setText(null);
					jtfQuantidade_minima.setText(null);
					jtfValor.setText(null);
				}
				frame.dispose();
				new IniciaControleEstoque();
			}
		});
		
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new IniciaControleEstoque();
			}
		});
		jpProUpdate.add(confirm);
		jpProUpdate.add(cancel);
		frame.setContentPane(jpProUpdate);
		frame.pack();
	}
}