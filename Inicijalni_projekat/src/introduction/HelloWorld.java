package introduction;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");

		int firstNumber = 5;
		int secondNumber = 2;
		int result=firstNumber / secondNumber;
		System.out.println(result);
		
		System.out.println(Integer.parseInt("5") + result);
		
		int faktorijel=5;
		int rezultat=1;
		while(faktorijel!=0)
		{
			rezultat*=faktorijel;
			faktorijel--;
		}
		System.out.println(rezultat);
		

		int i;
		int x=10;
		for(i=0;i<x;i++)
		{
			if(i%2!=0)
				System.out.println(i);	
		}
		
	}

}
