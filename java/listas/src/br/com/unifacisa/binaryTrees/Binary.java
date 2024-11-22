package br.com.unifacisa.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Binary {

	private Node root = null;
	private List<Node> nodes = new ArrayList<>(); // Lista para armazenar os nós e facilitar a criação da tabela

	public Node getRoot() {
		return root;
	}

	public void showRoot() {
		if (root != null) {
			System.out.println("Raiz: " + root.getValue());
		} else {
			System.out.println("A árvore está vazia.");
		}
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
			nodes.add(node); // Adiciona o nó à lista de nós
		} else if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
				nodes.add(node.getLeft()); // Adiciona o nó esquerdo à lista
			} else {
				insert(node.getLeft(), value);
			}
		} else if (value > node.getValue()) {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
				nodes.add(node.getRight()); // Adiciona o nó direito à lista
			} else {
				insert(node.getRight(), value);
			}
		}
		return node;
	}

	public void remove(int value) {
		root = remove(root, value);
	}

	private Node remove(Node node, int value) {
		if (node == null) {
			System.out.println("O valor não foi encontrado na árvore.");
			return null;
		}

		System.out.println("  Percorrendo Nó " + node.getValue());

		if (value < node.getValue()) {
			node.setLeft(remove(node.getLeft(), value));
		} else if (value > node.getValue()) {
			node.setRight(remove(node.getRight(), value));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}

			node.setValue(findMin(node.getRight()).getValue());
			node.setRight(remove(node.getRight(), node.getValue()));
		}
		return node;
	}

	private Node findMin(Node node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getValue() + " ");
			inOrder(node.getRight());
		}
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}

	public void displayTable() {
		System.out.printf("%-10s %-10s %-10s %-10s%n", "Índice", "Valor", "Esquerda", "Direita");
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			int leftIndex = nodes.indexOf(node.getLeft()); // Índice do filho esquerdo ou -1 se não existir
			int rightIndex = nodes.indexOf(node.getRight()); // Índice do filho direito ou -1 se não existir
			System.out.printf("%-10d %-10d %-10d %-10d%n", i, node.getValue(), leftIndex, rightIndex);
		}
	}
}
