package br.com.livrariasofia.model;

public class BookCollection extends Book {

	private int volume;
	private int bookQuantity;
	private String titleCollection;
	
	public BookCollection(String titulo, String descricao, String autor, 
			int volume, int bookQuantity, int id, int installment,String titleCollection) {
		super(titulo, descricao, autor,id ,0);
		this.volume = volume;
		if(bookQuantity >= 2){
			this.bookQuantity = bookQuantity;  
		}
		this.setTitleCollection(titleCollection);
		
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTitleCollection() {
		return titleCollection;
	}

	public void setTitleCollection(String titleCollection) {
		this.titleCollection = titleCollection;
	}


}
