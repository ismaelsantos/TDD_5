package br.com.livrariasofia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariasofia.model.BookStore;
import br.com.livrariasofia.model.Book;
import br.com.livrariasofia.model.BookCollection;

public class LivroController extends HttpServlet {
	private ArrayList<Book> listaLivro;

	private static final long serialVersionUID = -4924269687314937814L;

	public LivroController() {
		super();
		BookStore bookStore = new BookStore();
		this.listaLivro = bookStore.getBook();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);

		String descricao = request.getParameter("descricao");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");
		String volume;
		String qtdLivros;
		qtdLivros = request.getParameter("qtdLivros");
		volume = request.getParameter("volume");

		BookStore bookStore = new BookStore();

		if (request.getParameter("volume").equals("")) {
			Book book = new Book(descricao, autor, titulo, Integer.parseInt(id), 0);
			bookStore.add(book);

		} else {
			BookCollection bookCollection = new BookCollection(titulo, descricao,
					autor, Integer.parseInt(volume),
					Integer.parseInt(qtdLivros), Integer.parseInt(id),0);
			bookStore.add(bookCollection);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String descricao = request.getParameter("descricao");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		BookStore bookStore = new BookStore();
		Book book = new Book(titulo, descricao, autor, id, 0);

		if (action.equals("editar")) {
			Book livroParam = new Book(titulo, descricao, autor, id, 0);

		} else if (action.equals("apagar")) {
			bookStore.removeByIndex(book);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/livroExcluido.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * Funciona
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action == null) {
			
			// Cria um array de livros
			ArrayList<Book> listaLivro = new ArrayList<Book>();
			// Popula o array com os livros do model
			listaLivro = this.retornarLivros();

			RequestDispatcher rd = request.getRequestDispatcher("/listaLivros.jsp");
			// Seta o atributo arrayDeLivros com o array listaLivro
			request.setAttribute("arrayDeLivros", listaLivro);
			rd.forward(request, response);			

		} else {
				
			this.doGet(request, response);

		}
	}

	public ArrayList<Book> retornarLivros() {
		return this.listaLivro;
	}

}
