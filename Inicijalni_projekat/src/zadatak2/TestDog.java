package zadatak2;

public class TestDog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog dogOne = new Dog("Bethoven", "St.Bernard", false);
		Dog dogTwo = new Dog("Boby", "Badger dog", true);

		dogOne.feed();
		System.out.println(dogOne.toString());
		System.out.println(dogTwo.toString());
        System.out.println(Dog.calculateHumanYears(3));

	}

}
