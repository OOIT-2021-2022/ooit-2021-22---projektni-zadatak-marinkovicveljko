package zadatak1;

public class Book {

	private String name;
	private String author;
	private int numberOfPages;
	private double price;

	public Book() {

	}

	public Book(String name, String author, int numberOfPages) {
		this.name = name;
		this.author = author;
		this.numberOfPages = numberOfPages;
	}

	public Book(String name, String author, int numberOfPages, double price) {
		this(name, author, numberOfPages);
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		if (this.numberOfPages > 0) {
			this.numberOfPages=numberOfPages;
		}
		else
			System.out.println("Nije moguce uneti negativan broj strana!");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (this.price > 0) {
			this.price = price; 
		}
		else
			System.out.println("Cena ne sme biti manja od 0!!!");
		
	}

	private double calculateDiscount(int discount) {
		return price*discount/100.00;
	}

	public double calculateDiscountPrice(int discount) {
		return this.price - this.calculateDiscount(discount);
	}

}
