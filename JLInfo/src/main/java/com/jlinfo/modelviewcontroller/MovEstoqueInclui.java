package com.jlinfo.modelviewcontroller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import com.jlinfo.modeldominio.MovEstoqueBean;
import com.jlinfo.modeldominio.ProdutoBean;
import com.jlinfo.modeldominio.Tipo_movimentacao;
import com.jlinfo.modelpersistencia.MovEstoqueDAO;
import com.jlinfo.modelpersistencia.ProdutoDAO;


public class MovEstoqueInclui {
	public static void inclui(final JFrame frame) {

        JPanel jpMovIncluir = new JPanel();
		jpMovIncluir.setLayout(new BoxLayout(jpMovIncluir, BoxLayout.Y_AXIS));
		jpMovIncluir.setPreferredSize(new Dimension(300, 255));
		JLabel jlTitle = new JLabel("Movimentacao de Estoque");
		jlTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jpMovIncluir.add(jlTitle);

		JLabel jlId = new JLabel("ID: ");
		jpMovIncluir.add(jlId);

		final JTextField jtfId = new JTextField();
		jtfId.setMaximumSize(new Dimension(450, 24));
		jpMovIncluir.add(jtfId);

		JLabel jlProduto_id = new JLabel("Produto: ");
		jpMovIncluir.add(jlProduto_id);
		
		final JComboBox<Object> cb = new JComboBox<Object>();
		jpMovIncluir.add(cb);
		cb.removeAllItems();
		ProdutoDAO pd = new ProdutoDAO();
		for(ProdutoBean p: pd.listar()) {	
			cb.addItem(p);
		}
		
		JLabel jlQuantidade = new JLabel("Quantidade: ");
		jpMovIncluir.add(jlQuantidade);

		final JTextField jtfQuantidade = new JTextField();
		jtfQuantidade.setMaximumSize(new Dimension(450, 24));
		jpMovIncluir.add(jtfQuantidade);

		JLabel jlTipo_movimentacao = new JLabel("Tipo Movimentação: ");
		jpMovIncluir.add(jlTipo_movimentacao);

		final JRadioButton jrb1 = new JRadioButton("Entrada");
		JRadioButton jrb2 = new JRadioButton("Saida");
		final ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jpMovIncluir.add(jrb1);
		jpMovIncluir.add(jrb2);

		JButton confirm = new JButton("Confirmar");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovEstoqueBean MovEstoqueBean = new MovEstoqueBean();
				ProdutoBean pb = new ProdutoBean();
				pb = (ProdutoBean) cb.getSelectedItem();
				MovEstoqueBean.setId(Long.valueOf(jtfId.getText()));
				MovEstoqueBean.setProduto(pb);
				MovEstoqueBean.getData_movimentacao();
				MovEstoqueBean.setQuantidade(Integer.valueOf(jtfQuantidade.getText()));
				if (jrb1.isSelected())
					MovEstoqueBean.setTm(Tipo_movimentacao.ENTRADA);
				else
					MovEstoqueBean.setTm(Tipo_movimentacao.SAIDA);
				MovEstoqueDAO MovEstoqueDAO = new MovEstoqueDAO();
				MovEstoqueDAO.inserir(MovEstoqueBean);
				JOptionPane.showMessageDialog(frame,"Movimentação de Estoque cadastrada com sucesso!");
				jtfId.setText(null);
				jtfQuantidade.setText(null);
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
		jpMovIncluir.add(confirm);
		jpMovIncluir.add(cancel);
		frame.setContentPane(jpMovIncluir);
		frame.pack();
	}
}