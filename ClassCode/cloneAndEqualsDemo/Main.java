package cloneAndEqualsDemo;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		IntegerVector v1 = new IntegerVector(3);
		v1.set(0, 10);
		v1.set(1, 20);
		v1.set(2, 30);
		
		System.out.println("v1: " + v1);
		
		IntegerVector v2 = v1;
//		System.out.println("v2: " + v2);
//		System.out.println(v1 == v2);
		
		
//		v2 = v1.clone();
//		System.out.println("v2: " + v2);
//		System.out.println(v1 == v2);
//		System.out.println(v1.equals(v2));
		
	}

}
