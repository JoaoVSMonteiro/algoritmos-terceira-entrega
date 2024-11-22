package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

	private int numVertices;
	private List<List<Integer>> adjacencyList;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new ArrayList<>(numVertices);

		for (int i = 0; i < numVertices; i++) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		/*
		 * v = origem
		 * w = destino
		 */
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
	}

	// Implementação da Busca em Largura (BFS)
	public void bfs(int startVertex) {
		// Array para marcar os vértices visitados
		boolean[] visited = new boolean[numVertices];
		// Fila para a BFS
		Queue<Integer> queue = new LinkedList<>();

		// Marcar o vértice inicial como visitado e adicioná-lo à fila
		visited[startVertex] = true;
		queue.add(startVertex);

		System.out.println("Busca em Largura (BFS) a partir do vértice " + startVertex + ":");

		while (!queue.isEmpty()) {
			// Remover um vértice da fila
			int vertex = queue.poll();
			System.out.print(vertex + " ");

			// Obter todos os vértices adjacentes não visitados
			for (int neighbor : adjacencyList.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true; // Marcar como visitado
					queue.add(neighbor); // Adicionar à fila
				}
			}
		}
		System.out.println(); // Para nova linha após a BFS
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numVertices; i++) {
			sb.append("Vértice: ").append(i).append(":\n");
			for (Integer neighbor : adjacencyList.get(i)) {
				sb.append(" -> ").append(neighbor).append("\n");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		System.out.println(grafo.toString());

		// Executar a busca em largura a partir do vértice 0
		grafo.bfs(0);
	}
}
