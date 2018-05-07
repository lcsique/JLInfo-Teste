package com.jlinfo.modelviewcontroller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import com.jlinfo.modeldominio.ProdutoBean;
import com.jlinfo.modelpersistencia.ProdutoDAO;


public class ProdutoInclui{
	public static void inclui(final JFrame frame) {

        final JPanel jpProdIncluir = new JPanel();
		jpProdIncluir.setLayout(new BoxLayout(jpProdIncluir, BoxLayout.Y_AXIS));
		jpProdIncluir.setPreferredSize(new Dimension(300, 350));
		JLabel jlTitle = new JLabel("Incluir Produto");
		jlTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jpProdIncluir.add(jlTitle);

		JLabel jlId = new JLabel("ID: ");
		jpProdIncluir.add(jlId);

		final JTextField jtfId = new JTextField();
		jtfId.setMaximumSize(new Dimension(450, 24));
		jpProdIncluir.add(jtfId);

		JLabel jlDescricao = new JLabel("Descrição: ");
		jpProdIncluir.add(jlDescricao);

		final JTextField jtfDescricao = new JTextField();
		jtfDescricao.setMaximumSize(new Dimension(450, 24));
		jpProdIncluir.add(jtfDescricao);

		JLabel jlQuantidade_minima = new JLabel("Quantidade Minima: ");
		jpProdIncluir.add(jlQuantidade_minima);

		final JTextField jtfQuantidade_minima = new JTextField();
		jtfQuantidade_minima.setMaximumSize(new Dimension(450, 24));
		jpProdIncluir.add(jtfQuantidade_minima);

		JLabel jlValor = new JLabel("Valor: ");
		jpProdIncluir.add(jlValor);

		final JTextField jtfValor = new JTextField();
		jtfValor.setMaximumSize(new Dimension(450, 24));
		jpProdIncluir.add(jtfValor);

		JButton confirm = new JButton("Confirmar");
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ProdutoBean ProdutoBean = new ProdutoBean();
				if (jtfId.getText().equals("") || jtfDescricao.getText().equals("") || jtfQuantidade_minima.getText().equals("") || 
						jtfValor.getText().equals(""))
					JOptionPane.showMessageDialog(jpProdIncluir,
							"Existem campos em branco.");
				else {
					ProdutoBean.setId(Long.valueOf(jtfId.getText()));
					ProdutoBean.setDescricao(jtfDescricao.getText());
					ProdutoBean.setQuantidade_minima(Integer.valueOf(jtfQuantidade_minima.getText()));
					ProdutoBean.getData_cadastro();
					ProdutoBean.setValor(Double.valueOf(jtfValor.getText()));
					ProdutoDAO ProdutoDAO = new ProdutoDAO();
					ProdutoDAO.inserir(ProdutoBean);
					JOptionPane.showMessageDialog(frame,"Produto cadastrado com sucesso!");
					jtfId.setText(null);
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
		jpProdIncluir.add(confirm);
		jpProdIncluir.add(cancel);
		frame.setContentPane(jpProdIncluir);
		frame.pack();
	}
}