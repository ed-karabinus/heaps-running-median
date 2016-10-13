**Heaps: Find the Running Median**
(adapted from https://www.hackerrank.com/challenges/ctci-find-the-running-median)

The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your dataset of integers in non-decreasing order, then:

* If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted dataset {1, 2, 3}, 2 is the median.
* If your dataset contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted dataset {1, 2, 3, 4}, (2 + 3) / 2 = 2.5 is the median.

Given an input stream of  integers, you must perform the following task for each  integer:

1. Add the ith integer to a running list of integers.
2. Find the median of the updated list (i.e., for the first element through the ith element).
3. Print the list's updated median on a new line. The printed value must be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).

*Input Format*

The first line contains a single integer, n, denoting the number of integers in the data stream. 
Each line i of then subsequent lines contains an integer, a_i, to be added to your list.

**Constraints**

* 1 <= n <= 10^5

* 0 <= a_i <= 10^5

*Output Format*

After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).

Two sample inputs, input1.txt and input2.txt, as well as two corresponding sample outputs, output1.txt and output2.txt, are included in this repository.