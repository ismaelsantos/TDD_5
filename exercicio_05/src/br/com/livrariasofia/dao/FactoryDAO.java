package br.com.livrariasofia.dao;

import java.util.ArrayList;

import br.com.livrariasofia.model.Book;

public interface FactoryDAO {

	/**
	 * @param args
	 */

	  public void add (Book book);    
	  public void delete (Book book);    
	  public ArrayList<Book> listaLivro ();    
	  public Book find (String livro);  


	

}
