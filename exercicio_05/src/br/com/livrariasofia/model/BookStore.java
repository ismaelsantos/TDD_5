package br.com.livrariasofia.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays.*;

public class BookStore{

	private ArrayList<Book> bookList;

	public BookStore() {
		this.bookList = new ArrayList<Book>();
	}

	public boolean add(Book book){
		return bookList.add(book);
	}

	public ArrayList<Book> getBook() {
		return bookList;
	}

	public void removeByIndex(Book book){
		for(Book l: bookList){
			if(l.getId() == book.getId()){
				bookList.remove(book);
			}
		}
	}


	public void changeBook(String title, String author, String description, int id) {
		for(Book l: bookList){	
			if(l.getId() == id){
				l.setAuthor(author);
				l.setDescription(description);
				l.setTitle(title);
			}
		}
	}

	// Valor minimo , maximo, autor, titulo, coleção

	public ArrayList<Book> listBooksByTitle(ArrayList<Book> bookList, String title) {
		ArrayList<Book> aux = new ArrayList<Book>();
		for(Book b: bookList){	
			if(title.equals(b.getTitle()))
			{
				aux.add(b);
			}
		}
		return aux;

	}

	// Valor minimo , maximo, autor, titulo, coleção

	public ArrayList<Book> listBooksByAuthor(ArrayList<Book> bookList, String author) {
		ArrayList<Book> aux = new ArrayList<Book>();

		for(Book b: bookList){
			if(author.equals(b.getAuthor()))
			{
				aux.add(b);
				System.out.println(b.getAuthor());
			}
		}

		return aux;
	}

	public ArrayList<Book> listBooksByCollection(ArrayList<Book> bookList, String title) {
		ArrayList<Book> aux = new ArrayList<Book>();
		for(Book b: bookList){
			if(b instanceof BookCollection){
				if(b.getTitle().equals(title)){
					aux.add(b);

				}
			}

		}

		return aux;
	}

	public ArrayList<Book> listBooksByMaxPrice(ArrayList<Book> bookList) {
		ArrayList<Book> aux = new ArrayList<Book>();
		double i = bookList.get(0).getPrice();
		Book b1 = null;
		for(Book b: bookList){	
			if(b.getPrice() > i)
			{
				i = b.getPrice();
				b1 = b;
			}
		}
		aux.add(b1);

		return aux;
	}

	public ArrayList<Book> listBooksUsingMultipleFilters(String author, String title, double maxValue, double minValue, String collection,ArrayList<Book> bookList) {

		ArrayList<Book> auxiliar = new ArrayList<Book>();
		if(author != null)
		{
			auxiliar = this.listBooksByAuthor(bookList, author);
		}
		if(title != null)
		{
			auxiliar = this.listBooksByTitle(bookList, title);
		}
		if(maxValue != 0)
		{
			auxiliar = this.listBooksByMaxPrice(bookList);
		}
		if(minValue != 0)
		{
			auxiliar = this.listBookByMinPrice(bookList);
		}
		if(collection != null)
		{
			auxiliar = this.listBooksByCollection(bookList, title);
		}
		
		return auxiliar;

	}

	private ArrayList<Book> listBookByMinPrice(ArrayList<Book> bookList2) {
		ArrayList<Book> aux = new ArrayList<Book>();
		double i = bookList2.get(0).getPrice();
		Book b1 = null;
		for(Book b: bookList){	
			if(b.getPrice() < i)
			{
				i = b.getPrice();
				b1 = b;
			}
		}
		aux.add(b1);

		return aux;

	}


}
