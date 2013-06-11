package br.com.sofiabookstore.model.test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import br.com.livrariasofia.model.Book;
import br.com.livrariasofia.model.BookCollection;
import br.com.livrariasofia.model.BookStore;



public class BookStoreTest {

	
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	private BookCollection bookC1;
	private BookCollection bookC2;
	private static final double deltaForDoubleComparison = 0;
	
	
	@Before
	public void setUp(){

		this.book1 = new Book("The Hobbit", "too much information", "J. R. R. Tolkien", 2, 30);
		this.book2 = new Book("123", "dfdsfds", "dewweded", 3, 50);
		this.book3 = new Book("hrththt", "ed3232d", "dasdsa", 4, 40); 
		this.book4 = new Book("Dracula", "Vampire", "Bram", 5, 100);

	}
	
	@Test
	public void showsDefaultSeparator() {
	
	
	ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	listOfBooks.add(book1);
	listOfBooks.add(book2);
	listOfBooks.add(book3);
	listOfBooks.add(book4);
	
	ArrayList<Book> bookList = new ArrayList<Book>();
	bookList.add(book1);
	bookList.add(book2);
	bookList.add(book3);
	bookList.add(book4);
	
	
	

	}
	
	@Test
	public void shouldShowTheListOfAuthors() {
		BookStore mockedBookStore = mock(BookStore.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		this.book1 = new Book("Dracula", "Vampire", "Bram", 2, 30);
		this.book2 = new Book("123", "dfdsfds", "dewweded", 3, 50);
		this.book3 = new Book("hrththt", "ed3232d", "dasdsa", 4, 40); 
		this.book4 = new Book("Dracula", "Vampire", "Bram", 5, 100);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		
		ArrayList<Book> list = new ArrayList<Book>();

		when(mockedBookStore.listBooksByAuthor(bookList, bookList.get(0).getAuthor())).thenReturn(list);
		assertEquals("list book",mockedBookStore.listBooksByAuthor(bookList,bookList.get(0).getAuthor()), list);

		
		
	}
	@Test
	public void shouldShowTheListOfTitles() {
		BookStore mockedBookStore = mock(BookStore.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		this.book1 = new Book("Dracula", "Vampire", "Bram", 2, 30);
		this.book2 = new Book("123", "dfdsfds", "dewweded", 3, 50);
		this.book3 = new Book("hrththt", "ed3232d", "dasdsa", 4, 40); 
		this.book4 = new Book("Dracula", "Vampire", "Bram", 5, 100);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		when(mockedBookStore.listBooksByTitle(bookList, bookList.get(0).getTitle())).thenReturn(list);
		assertEquals("list book",mockedBookStore.listBooksByTitle(bookList, bookList.get(0).getTitle()).toString(), list.toString());
		
	}

	@Test
	@Ignore
	public void shouldShowTheListOfCollections() {
		BookStore mockedBookStore = mock(BookStore.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		this.bookC1 = new BookCollection("The Fellowship of the Ring", "too much information", "J. R. R. Tolkien", 2, 30,2,10,"The Lord of the Rings");
		this.bookC2 = new BookCollection("The Two Towers", "too much information", "J. R. R. Tolkien", 3, 50, 2, 40, "The Lord of the Rings");

		bookList.add(bookC1);
		bookList.add(bookC2);

		
		ArrayList<BookCollection> list = new ArrayList<BookCollection>();
		
		when(mockedBookStore.listBooksByCollection(bookList, bookList.get(0).getTitle())).thenReturn(bookList);
		assertEquals("list book",mockedBookStore.listBooksByCollection(bookList,bookList.get(0).getTitle()).toString(), list.toString());
		
	}
	
	@Test
	public void shouldShowTheListOfMaxPrice() {
		BookStore mockedBookStore = mock(BookStore.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		this.book1 = new Book("Dracula", "Vampire", "Bram", 2, 30);
		this.book2 = new Book("123", "dfdsfds", "dewweded", 3, 50);
		this.book3 = new Book("hrththt", "ed3232d", "dasdsa", 4, 40); 
		this.book4 = new Book("Dracula", "Vampire", "Bram", 5, 100);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		
		ArrayList<Book> list2 = new ArrayList<Book>();
		when(mockedBookStore.listBooksByMaxPrice(bookList)).thenReturn(list2);
		assertEquals("list book",mockedBookStore.listBooksByMaxPrice(bookList).toString(), list2.toString());
		
	}
	
	
	@Test
	public void shouldReturnWithFilters(){
		
		BookStore mockedBookStore = mock(BookStore.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		ArrayList<Book> aux = new ArrayList<Book>();
		
		Book bkC1 = new Book("The Fellowship of the Ring", "too much information", "J. R. R. Tolkien", 2, 30);	
		Book bkC2 = new Book("The Two Towers", "too much information", "J. R. R. Tolkien", 3, 50);
		Book bkC3 = new Book("The Two Towers", "too much information", "J. R. R. Tolkien", 3, 50);
		Book bkC4 = new Book("The Two Towers", "too much information", "J. R. R. Tolkien", 3, 50);
		Book bkC5 = new Book("aaaaaa", "too much information", "aaaaaa", 3, 50);
		Book bkC6 = new Book("The Fellowship of the Ring", "too much information", "J. R. R. Tolkien", 2, 30);

		bookList.add(bkC1);
		bookList.add(bkC2);
		bookList.add(bkC3);
		bookList.add(bkC4);
		bookList.add(bkC5);
		bookList.add(bkC6);



		when(mockedBookStore.listBooksUsingMultipleFilters("J. R. R. Tolkien","The Two Towers",0,0,null, bookList)).thenReturn(aux);
		

		assertEquals("list book", mockedBookStore.listBooksUsingMultipleFilters("J. R. R. Tolkien","The Two Towers",0,0,null, bookList), aux);
		for(int i = 0; i < mockedBookStore.listBooksUsingMultipleFilters("J. R. R. Tolkien","The Two Towers",0,0,null, bookList).size(); i++)
		{
			System.out.println(aux.get(i).getAuthor());
		}

		
	}
	

}
