package bsu;

import java.util.ArrayList;

public class Median {

    static int a, b;

    // Utility function to swapping of element
    static ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        return arr;
    }

    // Returns the correct position of
    // pivot element
    static int Partition(ArrayList<Integer> arr, int l, int r)
    {
        int lst = arr.get(r), i = l, j = l;
        while (j < r)
        {
            if (arr.get(j) < lst)
            {
                arr = swap(arr, i, j);
                i++;
            }
            j++;
        }
        arr = swap(arr, i, r);
        return i;
    }

    // Picks a random pivot element between
    // l and r and partitions arr[l..r]
    // around the randomly picked element
    // using partition()
    static int randomPartition(ArrayList<Integer> arr, int l, int r)
    {
        int n = r - l + 1;
        int pivot = (int) (Math.random() % n);
        arr = swap(arr, l + pivot, r);
        return Partition(arr, l, r);
    }

    // Utility function to find median
    static int MedianUtil(ArrayList<Integer> arr, int l, int r, int k)
    {

        // if l < r
        if (l <= r)
        {

            // Find the partition index
            int partitionIndex = randomPartition(arr, l, r);

            // If partition index = k, then
            // we found the median of odd
            // number element in arr[]
            if (partitionIndex == k)
            {
                b = arr.get(partitionIndex);
                if (a != -1)
                    return Integer.MIN_VALUE;
            }

            // If index = k - 1, then we get
            // a & b as middle element of
            // arr[]
            else if (partitionIndex == k - 1)
            {
                a = arr.get(partitionIndex);
                if (b != -1)
                    return Integer.MIN_VALUE;
            }

            // If partitionIndex >= k then
            // find the index in first half
            // of the arr[]
            if (partitionIndex >= k)
                return MedianUtil(arr, l, partitionIndex - 1, k);

                // If partitionIndex <= k then
                // find the index in second half
                // of the arr[]
            else
                return MedianUtil(arr, partitionIndex + 1, r, k);
        }

        return Integer.MIN_VALUE;
    }

    // Function to find bsu.Median
    static int findMedian(ArrayList<Integer> arr, int n) {
        int ans;
        a = -1;
        b = -1;

        // If n is odd
        if (n % 2 == 1) {
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = b;
        }

        // If n is even
        else {
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = (a + b) / 2;
        }

        // Print the bsu.Median of arr[]
        System.out.print("Median = " + ans + "\n");
        return ans;
    }
}

