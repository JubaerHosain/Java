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

---

### Insertion Sort:
Function:   
```java
// sort array using insertion sort
public static void insertionSort(int[] data) {
	// loop over data.length - 1 elements
	for(int next=1; next<data.length; next++) {
		int insert = data[next]; // value to insert
		int moveItem = next; // location to place element
		
		// search for place to put current element
		while(moveItem > 0 && data[moveItem -1] > insert) {
			// shift element right one slot
			data[moveItem] = data[moveItem -1];
			moveItem--;
		}
		
		// place inserted element
		data[moveItem] = insert; 
		// output pass of algorithm
		printPass(data, next, moveItem);
	}
}
```
Output:
```java
Unsorted array: [67, 34, 88, 58, 45, 35, 41, 49, 37, 32]

after pass  1: 34* 67 88 58 45 35 41 49 37 32 
               
after pass  2: 34 67 88* 58 45 35 41 49 37 32 
               
after pass  3: 34 58* 67 88 45 35 41 49 37 32 
               
after pass  4: 34 45* 58 67 88 35 41 49 37 32 
               
after pass  5: 34 35* 45 58 67 88 41 49 37 32 
               
after pass  6: 34 35 41* 45 58 67 88 49 37 32 
               
after pass  7: 34 35 41 45 49* 58 67 88 37 32 
               
after pass  8: 34 35 37* 41 45 49 58 67 88 32 
               
after pass  9: 32* 34 35 37 41 45 49 58 67 88 
               

Sorted array: [32, 34, 35, 37, 41, 45, 49, 58, 67, 88]
```

---

### Merge Sort:
Function:   
```java
// splits array, sorts subarrays and merges subarrays into sorted array
private static void sortArray(int[] data, int low, int high) {
	// test base case; size of array equals 1
	if(high - low >= 1) {
		// calculate middle of array
		int middle1 = (low + high) / 2;
		int middle2 = middle1 + 1;
		
		// output split step 
		System.out.printf("split:%n%s%n", subarrayString(data, low, high));
		System.out.printf("%s%n", subarrayString(data, low, middle1));
		System.out.printf("%s%n%n", subarrayString(data, middle2, high));
		
		// split array in half; sort each half (recursive calls)
		sortArray(data, low, middle1); // first half of array
		sortArray(data, middle2, high); // second half of array
		
		// merge two sorted arrays after split calls return 
		merge(data, low, middle1, middle2, high);
	}
}

// merge two sorted subarrays into one sorted subarray
private static void merge(int[] data, int left, int middle1, int middle2, int right) {
	int leftIndex = left;  // index into left subarray
	int rightIndex = middle2;  // index into right subarray
	int combinedIndex = left;  // index into temporary working array
	int[] combined = new int[data.length];  // working array
	
	// output two subarrays before merging
	System.out.printf("merge:%n%s%n", subarrayString(data, left, middle1));
	System.out.printf("%s%n", subarrayString(data, middle2, right));
	
	// merge arrays until reaching end of either
	while(leftIndex <= middle1 && rightIndex <= right) {
		// place smaller of two current elements into result and move to next space in arrays
		if(data[leftIndex] <= data[rightIndex]) {
			combined[combinedIndex++] = data[leftIndex++];
		}
		else {
			combined[combinedIndex++] = data[rightIndex++];
		}
	}
	
	// if left array is empty
	if(leftIndex == middle2) {
		// copy in rest of right array
		while(rightIndex <= right) {
			combined[combinedIndex++] = data[rightIndex++];
		}
	}
	// right array is empty
	else {
		// copy in rest of left array
		while(leftIndex <= middle1) {
			combined[combinedIndex++] = data[leftIndex++];
		}
	}
		
	// copy values back into original array
	for(int i=left; i<=right; i++) {
		data[i] = combined[i];
	}
	
	// output merged array
	System.out.printf("%s%n%n", subarrayString(data, left, right));
}
```
Output:
```java
Unsorted array: [59, 40, 35, 84, 80, 55, 82, 18, 69, 80]

split:
 59 40 35 84 80 55 82 18 69 80
 59 40 35 84 80
                55 82 18 69 80

split:
 59 40 35 84 80
 59 40 35
          84 80

split:
 59 40 35
 59 40
       35

split:
 59 40
 59
    40

merge:
 59
    40
 40 59

merge:
 40 59
       35
 35 40 59

split:
          84 80
          84
             80

merge:
          84
             80
          80 84

merge:
 35 40 59
          80 84
 35 40 59 80 84

split:
                55 82 18 69 80
                55 82 18
                         69 80

split:
                55 82 18
                55 82
                      18

split:
                55 82
                55
                   82

merge:
                55
                   82
                55 82

merge:
                55 82
                      18
                18 55 82

split:
                         69 80
                         69
                            80

merge:
                         69
                            80
                         69 80

merge:
                18 55 82
                         69 80
                18 55 69 80 82

merge:
 35 40 59 80 84
                18 55 69 80 82
 18 35 40 55 59 69 80 80 82 84

Sorted array: [18, 35, 40, 55, 59, 69, 80, 80, 82, 84]
```

---