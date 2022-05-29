package zadatak1;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book bookOne = new Book(); 
		Book bookTwo = new Book("Dan Brown", "Digital Fortress", 445, 900.00);
		
		bookOne.setName("Inferno");
		bookOne.setAuthor("Dan Brown");
		bookOne.setNumberOfPages(445);
		bookOne.setPrice(950.00);
		System.out.println(bookOne.calculateDiscountPrice(15));
		
		double priceOne = bookOne.calculateDiscountPrice(15);
		double priceTwo = bookTwo.calculateDiscountPrice(20);
		
		if(priceOne<priceTwo)
		{
			System.out.println(bookOne.getName() + " je jeftinija!");
		}
		else if(priceOne>priceTwo) {
			System.out.println(bookTwo.getName() + " je jeftinija");
		}
		else
		{
			System.out.println("Knjige " + bookOne.getName() + " i " + bookTwo.getName() + " su jednake cene");
		}
		
		
		
		

}
	
}