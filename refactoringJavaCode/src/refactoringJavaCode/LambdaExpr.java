package refactoringJavaCode;

import java.util.function.Predicate;

public class LambdaExpr {
	
	public static void main(String[] args) {
		
		Predicate<Person> olderThan16 = p -> p.getAge() > 16;	
		
		boolean b1 = olderThan16.test(new Person("Peter", 20));
		boolean b2 = olderThan16.test(new Person("Lucy", 14));
		
		System.out.println(b1 + " " + b2);
		
	}

}
