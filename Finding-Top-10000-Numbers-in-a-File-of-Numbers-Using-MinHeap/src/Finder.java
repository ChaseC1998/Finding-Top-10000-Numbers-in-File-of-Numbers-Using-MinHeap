//Chase Christiansen

/*DESCRIPTION:
 This class performs all the min-heap functions on the array, with the purposes of constructing the data into a min-heap form, sorting the 10,000
 elements in the min-heap, and inserting elements from the file input stream into the heap. 
*/

public class Finder {
	
	private void minHeapify(int A[], int n, int i) 
    { 
        int smallest = i;  							//the variable smallest is initialized equal to the root.
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 
  
        if (left < n && A[left] < A[smallest]) {	//if the left child is smaller than the root, the root is the left child.
            smallest = left; 						//also ensure left is less than the heap size (so it is in range).
        }
        if (right < n && A[right] < A[smallest]) {	//if the right child is smaller than the root, the root is the right child.
            smallest = right; 						//also ensure right is less than the heap size (so it is in range).
        }
        if (smallest != i) { 						//if the smallest is not the root, set int temp equal to the value in the
            int temp = A[i]; 						//root index. Set the value of the root index to the smallest index, and
            A[i] = A[smallest]; 					//set smallest equal to temp.
            A[smallest] = temp; 
  
            minHeapify(A, n, smallest); 			//call minHeapify with the A array parameter, heap size n, and smallest as
        } 											//the root node.
    }  
	
    void heapSort(int A[], int n) { 
        for (int i = n / 2 - 1; i >= 0; i--) {		//building the heap.
            minHeapify(A, n, i); 
        }
        for (int i = n - 1; i >= 0; i--) {          //extracting an element from the heap one at a time.    
            int temp = A[0]; 
            A[0] = A[i]; 							//moving the current root to the end of the heap.
            A[i] = temp; 
            minHeapify(A, i, 0); 					//call minHeaify on the heap with the parameters for the array A, the heap size i,
            										//and the root node at the index 0.
        } 
    }  
    
    void insert(int A[], int element) { 
    	if(element <= A[A.length - 1]) {			//if the element from the stream is less than the last index in the array
    		return;									//(i.e the smallest in the array) then return to the while loop that called
    	}											//this method and do the next value in the stream.
        A[A.length - 1] = element; 
        heapSort(A, A.length);						//if the element is greater than the lowest value in the array, set the last index
    }												//equal to the element and call the heapSort function to put it in the right place.
}
