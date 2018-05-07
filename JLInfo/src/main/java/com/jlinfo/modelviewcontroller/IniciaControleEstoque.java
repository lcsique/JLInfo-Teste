package com.jlinfo.modelviewcontroller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class IniciaControleEstoque implements ActionListener {
	private JFrame jfrm;
	public IniciaControleEstoque(){
		jfrm = new JFrame("Controle de Estoque");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(300, 140);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jbtnProAdd = new JButton("Cadastrar Produto");
		JButton jbtnEdit = new JButton("Editar Produto");
		JButton jbtnMovAdd = new JButton("Adicionar Movimentação de Estoque");
		jbtnProAdd.addActionListener(this);
		jbtnEdit.addActionListener(this);
		jbtnMovAdd.addActionListener(this);
		jfrm.add(jbtnProAdd);
		jfrm.add(jbtnEdit);
		jfrm.add(jbtnMovAdd);
		JLabel jlab = new JLabel("Selecione uma opção.");
		jfrm.add(jlab);
		jfrm.setVisible(true);

	jbtnProAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			ProdutoInclui.inclui(jfrm);
		}
	});
	
	jbtnEdit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			ProdutoAtualiza.atualiza(jfrm);
		}
	});
	
	jbtnMovAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			MovEstoqueInclui.inclui(jfrm);
		}
	});
	
	}
	
	public void actionPerformed(ActionEvent e) {
		e.getActionCommand();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new IniciaControleEstoque();
			}
		});
	}
}
