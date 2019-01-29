# Recursion
### Factorial Calculator:
Factorial Inputs:   
```java
for(int counter = 0; counter <=21; counter ++) {
	System.out.printf("%d! = %d%n", counter, factorial(counter));
}
```
Facotorial Function:
```java
// recursive method factorial (assumes its parameter is >= 0)
public static long factorial(long number) {
	if(number <=1) {	// test for base case
		return 1;	// base case: 0! = 1 and 1! = 1
	}
	else	// recursion step
		return number * factorial(number-1);
}
```
Outputs:
```java
0! = 1
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720
7! = 5040
8! = 40320
9! = 362880
10! = 3628800
11! = 39916800
12! = 479001600		<-- cause overflow for int variables
13! = 6227020800
14! = 87178291200
15! = 1307674368000
16! = 20922789888000
17! = 355687428096000
18! = 6402373705728000
19! = 121645100408832000
20! = 2432902008176640000
21! = -4249290049419214848		<-- cause overflow for long variables
```

---

### Factorial Calculator with BigInteger:
Factorial Inputs:   
```java
for(int counter=0; counter<=50; counter++) {
	System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
}
```
Factorial Function: 
```java
// recursive method factorial (assumes its parameter is >= 0)
public static BigInteger factorial(BigInteger number) {
	if(number.compareTo(BigInteger.ONE) <= 0) {	// test for base case
		return BigInteger.ONE;	// base case: 0! = 1 and 1! = 1
	}
	else	// recursion step
		return number.multiply(factorial(number.subtract(BigInteger.ONE)));
}
```
Outputs:
```java
0! = 1
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720
7! = 5040
8! = 40320
9! = 362880
10! = 3628800
11! = 39916800
12! = 479001600
13! = 6227020800
14! = 87178291200
15! = 1307674368000
16! = 20922789888000
17! = 355687428096000
18! = 6402373705728000
19! = 121645100408832000
20! = 2432902008176640000
21! = 51090942171709440000
22! = 1124000727777607680000
.
.
.
48! = 12413915592536072670862289047373375038521486354677760000000000
49! = 608281864034267560872252163321295376887552831379210240000000000
50! = 30414093201713378043612608166064768844377641568960512000000000000
```

---

### Fibonacci Calculator
Fibonacci Input:
```java
public static BigInteger fibonacci(BigInteger number) {
	if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {	// base cases
		return number;
	}
	else 
		return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
}
```
Fibonacci Function:
```java
public static BigInteger fibonacci(BigInteger number) {
	if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {	// base cases
		return number;
	}
	else 
		return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
}
```
Output:
```java
Fibonacci of 0 is: 0
Fibonacci of 1 is: 1
Fibonacci of 2 is: 1
Fibonacci of 3 is: 2
Fibonacci of 4 is: 3
Fibonacci of 5 is: 5
Fibonacci of 6 is: 8
Fibonacci of 7 is: 13
Fibonacci of 8 is: 21
Fibonacci of 9 is: 34
Fibonacci of 10 is: 55
.
.
.
Fibonacci of 38 is: 39088169
Fibonacci of 39 is: 63245986
Fibonacci of 40 is: 102334155
```

---

### Factorial Calculator with Iterative Method
Factorial Inputs:  
```java
// calculate the factorials of 0 through 10
for(int counter=0; counter<=10; counter++) {
	System.out.printf("%d! = %d%n", counter, factorial(counter));
}
```
Factorial Function:
```java
// iterative declaration of method factorial 
public static long factorial(long number) {
	long result = 1;
	
	// iteratively calculate factorial
	for(long i=number; i>=1; i--) {
		result *= i;
	}
	
	return result;
}
```
Output: 
```java
0! = 1
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720
7! = 5040
8! = 40320
9! = 362880
10! = 3628800
```