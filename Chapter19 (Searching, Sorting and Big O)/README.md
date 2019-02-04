# Searching, Sorting and Big O
### Linear Search:
Function:   
```java
// perform a linear search on the data
public static int linearSearch(int data[], int searchKey) {
	// loop through array sequentially
	for(int index=0; index<data.length; index++) {
		if(data[index] == searchKey) {
			return index;
		}
	}
	
	// integer was not found
	return -1;
}
```
Output:
```java
[76, 75, 15, 68, 55, 54, 96, 21, 39, 39]

Please enter an integer value (-1 to quit): 55
55 was found in position 4

Please enter an integer value (-1 to quit):39
39 was found in position 8

Please enter an integer value (-1 to quit):-1
```

---

### Binary Search:
Function:   
```java
// perform a binary search on the data
public static int binarySearch(int[] data, int key) {
	int low = 0; // low end of the search area
	int high = data.length -1; // high end of the search area
	int middle = (low + high + 1) / 2; // middle element
	int location = -1; // return value; -1 if not found
	System.out.println("middle: " + data[middle]);
	// loop to search for element
	do {
		// print remaining elements to array
		System.out.print(remainingElements(data, low, high));
		
		// output spaces for alignment
		for(int i=0; i<middle; i++) {
			System.out.print(" ");
		}
		
		// indicate curent middle
		System.out.println(" * "); 
		
		// if the element is found at the middle
		if(key == data[middle]) {
			// location is the current middle
			location = middle; 
		}
		// middle element is too high
		else if (key < data[middle]) {
			// eliminate the higher half
			high = middle - 1;
		}
		// middle element is too low
		else {
			// eliminate the lower half
			low = middle + 1;
		}
		
		// recalulate the middle 
		middle = (low + high + 1) / 2;
	}while((low <= high) && (location == -1));
	
	// return location of search key
	return location;
}

// method to output certain values in array
private static String remainingElements(int[] data, int low, int high) {
	StringBuilder temporary = new StringBuilder();
	
	// append spaces for alignment
	for(int i=0; i<low; i++) {
		temporary.append(" ");
	}
	
	// append elements left in array 
	for(int i=low; i<=high; i++) {
		temporary.append(data[i] + " ");
	}
	
	return String.format("%s%n", temporary);
}
```
Outputs:
```java
[12, 19, 33, 39, 40, 44, 44, 45, 56, 57, 64, 67, 86, 87, 89]

Please enter an integer value (-1 to quit):19
12 19 33 39 40 44 44 45 56 57 64 67 86 87 89 
        * 
12 19 33 39 40 44 44 
    * 
12 19 33 
  * 
19 was found in position 1

Please enter an integer value(-1 to quit):67
12 19 33 39 40 44 44 45 56 57 64 67 86 87 89 
        * 
        56 57 64 67 86 87 89 
            * 
67 was found in position 11

Please enter an integer value(-1 to quit):-1
```

---

### Selection Sort:
Function:   
```java
// sort array using selection sort
public static void selectionSort(int[] data) {
	// loop over data length - 1 elements
	for(int i=0; i<data.length;i++) {
		// first index of remaining array
		int smallest = i;
		
		// loop to find index of smallest element
		for(int index = i + 1; index < data.length; index++) {
			if(data[index] < data[smallest]) {
				smallest = index;
			}
		}
		
		// swap smallest element into position
		swap(data, i, smallest); 
		//output pass of algorithm
		printPass(data, i+1, smallest);
	}
}

// helper method to swap values in two elements
private static void swap(int[] data, int first, int second) {
	// store first in temporary
	int temporary = data[first];
	// replace first with second
	data[first] = data[second];
	// put temporary in second
	data[second] = temporary;
}
```
Outputs:
```java
Unsorted array: [31, 39, 33, 78, 73, 68, 38, 14, 42, 42]

after pass  1: 14 39 33 78 73 68 38 31* 42  42  
               -- 
after pass  2: 14 31 33 78 73 68 38 39* 42  42  
               -- -- 
after pass  3: 14 31 33* 78  73  68  38  39  42  42  
               -- -- -- 
after pass  4: 14 31 33 38 73 68 78* 39  42  42  
               -- -- -- -- 
after pass  5: 14 31 33 38 39 68 78 73* 42  42  
               -- -- -- -- -- 
after pass  6: 14 31 33 38 39 42 78 73 68* 42  
               -- -- -- -- -- -- 
after pass  7: 14 31 33 38 39 42 42 73 68 78* 
               -- -- -- -- -- -- -- 
after pass  8: 14 31 33 38 39 42 42 68 73* 78  
               -- -- -- -- -- -- -- -- 
after pass  9: 14 31 33 38 39 42 42 68 73* 78  
               -- -- -- -- -- -- -- -- -- 
after pass 10: 14 31 33 38 39 42 42 68 73 78* 
               -- -- -- -- -- -- -- -- -- -- 

Sorted array: [14, 31, 33, 38, 39, 42, 42, 68, 73, 78]
```