package zadatak1;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book bookOne = new Book();
		Book bookTwo = new Book("Dan Brown", "Digital Fortress", 445 , 900.00);
		
		bookOne.setName("Inferno");
		bookOne.setAuthor("Dan Brown");
		bookOne.setNumberOfPages(445);
		bookOne.setPrice(950.00);
		
        System.out.println(bookOne.calculateDiscountPrice(15));
        
        double firstPrice = bookOne.calculateDiscountPrice(15);
        double secondPrice= bookTwo.calculateDiscountPrice(20);
        
        if(firstPrice<secondPrice)
        {
        	System.out.println("Druga knjiga je jeftinija od prve");
        }
        else
        {
        	System.out.println("Prva knjiga je jeftinija od druge");
        }

	}

}
