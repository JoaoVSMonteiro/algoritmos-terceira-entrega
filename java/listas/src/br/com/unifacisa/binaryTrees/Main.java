package br.com.unifacisa.binaryTrees;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int input = 20;
		String result;
		Binary tree = new Binary();

		while (input != 0) {
			result = showMenu();

			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
				result = showMenu();
			} else {
				input = Integer.parseInt(result);

				switch (input) {
					case 1:
						String item = JOptionPane.showInputDialog("Digite um número para inserir na árvore:");
						if (item != null && !item.equals("")) {
							tree.insert(Integer.parseInt(item));
						}
						break;
					case 2:
						String vl = JOptionPane.showInputDialog("Digite o valor que você deseja remover:");
						if (vl != null && !vl.equals("")) {
							tree.remove(Integer.parseInt(vl));
						}
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Valor da raiz exibido no console.");
						tree.showRoot();
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Ordem simétrica exibida no console.");
						tree.inOrder(tree.getRoot());
						System.out.println();
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Pré-ordem exibida no console.");
						tree.preOrder(tree.getRoot());
						System.out.println();
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Pós-ordem exibida no console.");
						tree.postOrder(tree.getRoot());
						System.out.println();
						break;
					case 7:
						JOptionPane.showMessageDialog(null, "Tabela de adjacência exibida no console.");
						tree.displayTable();
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "Saindo do programa.");
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
						break;
				}
			}
		}
	}

	public static String showMenu() {
		return JOptionPane.showInputDialog(
				"Digite:" +
						"\n 1: Para inserir" +
						"\n 2: Para remover" +
						"\n 3: Para exibir a raiz" +
						"\n 4: Para exibir ordem simétrica" +
						"\n 5: Para exibir pré-ordem" +
						"\n 6: Para exibir pós-ordem" +
						"\n 7: Para exibir a tabela de adjacência" +
						"\n 0: Para sair"
		);
	}
}
