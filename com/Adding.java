package week2_3_Objects;

public class Adding {
	public int addingMethod(int firstNumber, int secondNumber) {
		int result = firstNumber + secondNumber;
		return result;
	}
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = 6;
		int d = 21;

		Adding addingObject = new Adding();

		int aPlusb = addingObject.addingMethod(a,b);

		System.out.println(a + " + " + b + " = " + aPlusb);
		System.out.println(c + " + " + d + " = " + addingObject.addingMethod(c,d));
	}

}
