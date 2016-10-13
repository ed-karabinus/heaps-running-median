import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Heap {
    protected int[] heap;
    protected int size;
    protected int maxSize;
   
    protected int FRONT = 1;

    Heap(int maxSize) {
        maxSize = maxSize;
        size = 0;
        heap = new int[maxSize + 1];
    }

    public int front() {
        return heap[FRONT];
    }

    protected int parentNodePosition(int position) {
        return position / 2;
    }
    
    protected int rightChildPosition(int position) {
        return (2 * position) + 1;
    }
    
    protected int leftChildPosition(int position) {
        return 2 * position;
    }

    protected boolean isLeaf(int position) {
        return (position > (int) Math.floor(size / 2.0) && position <= size);
    }

    protected void transpose(int firstPosition, int secondPosition) {
        int temp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = temp;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.println("THE HEAP IS:");
        for (int i = 1; i <= (int) Math.floor(size / 2.0); i++ )
        {
            System.out.print(" PARENT : " + heap[i]);
            if (2 * i <= size) {
                System.out.print(" LEFT CHILD : " + heap[2*i]);
            }
            if (2 * i + 1 <= size) {
                  System.out.print(" RIGHT CHILD :" + heap[2 * i  + 1]);
            }
            System.out.println();
        }
    }
}

class MinHeap extends Heap {

    MinHeap(int maxSize) {
        super(maxSize);
        heap[0] = Integer.MIN_VALUE;
    }

    private void heapify(int position) {
        if (!isLeaf(position)) {
            if (heap[position] > heap[leftChildPosition(position)] ||
                heap[position] > heap[rightChildPosition(position)]) {
                if (heap[rightChildPosition(position)] > heap[leftChildPosition(position)]) {
                    transpose(position, leftChildPosition(position));
                    heapify(leftChildPosition(position));
                }
                else {
                    transpose(position, rightChildPosition(position));
                    heapify(rightChildPosition(position));
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;
        
        while(heap[current] < heap[parentNodePosition(current)]) {
            transpose(current, parentNodePosition(current));
            current = parentNodePosition(current);
        }
    }

    public int remove() {
        int removed = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);
        return removed;
    }
}

class MaxHeap extends Heap {
    MaxHeap(int maxSize) {
        super(maxSize);
        heap[0] = Integer.MAX_VALUE;
    }

    private void heapify(int position) {
        if (!isLeaf(position)) {
            if (heap[position] < heap[leftChildPosition(position)] ||
                heap[position] < heap[rightChildPosition(position)]) {
                if (heap[rightChildPosition(position)] < heap[leftChildPosition(position)]) {
                    transpose(position, leftChildPosition(position));
                    heapify(leftChildPosition(position));
                }
                else {
                    transpose(position, rightChildPosition(position));
                    heapify(rightChildPosition(position));
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;
        
        while(heap[current] > heap[parentNodePosition(current)]) {
            transpose(current, parentNodePosition(current));
            current = parentNodePosition(current);
        }
    }

    public int remove() {
        int removed = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);
        return removed;
    }
}

public class Solution {
    
    public static void printDoubleLn(double f) {
        System.out.printf("%.1f\n", f);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        MinHeap minHeap = new MinHeap(n);
        MaxHeap maxHeap = new MaxHeap(n);  
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if (a_i == 0) {
                printDoubleLn((double) a[0]);
            }
            else if (a_i == 1) {
                if (a[0] < a[1]) {
                    minHeap.insert(a[1]);
                    maxHeap.insert(a[0]);
                }
                else {
                    minHeap.insert(a[0]);
                    maxHeap.insert(a[1]);
                }

                // The following two lines print out each heap.
                // minHeap.print();
                // maxHeap.print();


                printDoubleLn((maxHeap.front() + minHeap.front()) / 2.0);
            }
            else {
                if (a[a_i] < maxHeap.front()) {
                    maxHeap.insert(a[a_i]);
                }
                else {
                    minHeap.insert(a[a_i]);
                }
                if (minHeap.size() - maxHeap.size() > 1) {
                    maxHeap.insert(minHeap.remove());
                }
                else if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.insert(maxHeap.remove());              
                }

                // The following four lines print out the heap after each round
                // of insertion and heap balancing.
                
                // System.out.print("MIN: ");
                // minHeap.print();
                // System.out.print("MAX: ");
                // maxHeap.print();

                if (maxHeap.size() == minHeap.size()) {
                    printDoubleLn((minHeap.front() + maxHeap.front()) / 2.0);
                }
                else if (maxHeap.size() > minHeap.size()) {
                    printDoubleLn((double) maxHeap.front());
                }
                else {
                    printDoubleLn((double) minHeap.front());
                }
            }
        }
   
        in.close();
    }
}