/**
 * <h1>It is assignment of merge sort implementation</h1>
 * <p>This is algorithm of code that was given in presentation </p>
* @author student of Astana IT University(Y.K,SE-2014)
* @since done 7:13  5/17/2021
 * *
* */
public class MergeSort {

    /*This is given part of code
     * we create a return type void method that calls method of sort,
     * that takes parameters of whole array numbers,starting from 0's position and till the end
     * */
    public static void sort(int[] x) {
        sort(x, 0, x.length - 1);
    }

    /*This method contain the some recursive call,that can help our method of merge to
     * merge numbers in correct order;
     */
    private static void sort(int[] x, int start, int end) {
        if (start < end) {

            int middle = start + (end - start) / 2; // there we find middle point of our array collection;

            sort(x, start, middle);//Recursively find first half

            sort(x, middle + 1, end);//Recursively find second half

            merge(x, start, end, middle);//In the end,we just merge sorted halves
        }
    }

    public static void merge(int[] x, int start, int end, int middle) {
        /*Giving sizes for two subArrays*/
        int size = end - middle;
        int size1 = middle - start + 1;

        // SubArrays
        int[] a = new int[size1];
        int[] b = new int[size];

        /*We just copy parts to temporary arrays*/
        if (size1 >= 0) System.arraycopy(x, start, a, 0, size1);
        for (int j = 0; j < size; ++j)
            b[j] = x[middle + 1 + j];

        int k = 0, m = 0;

        for (int i = start; i < end + 1; ++i) {
            if (k < a.length && m < b.length) {
                if (a[k] < b[m]) {
                    x[i] = a[k];
                    k++;
                } else {
                    x[i] = b[m];
                    m++;
                }
            } else if (k < a.length) {//Copy remaining of a[] elements
                x[i] = a[k];
                k++;
            } else if (m < b.length) {//Copy remaining of b[] elements
                x[i] = b[m];
                m++;
            }
        }
    }

    /*Method of print that give opportunity not only print my elements
     * but also give some teachable representation*/
    static void print(int[] array) {
        for (double i = 0; i < array.length * 6.3; ++i)
            System.out.print("-");

        System.out.println();

        for (int i : array) {

            System.out.printf("| %2s " + " ", i);

        }

        System.out.println("|");

        for (double i = 0; i < array.length * 6.3; ++i)
            System.out.print("-");

        System.out.println();

    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 5, 7, 8, 4, 5};
        System.out.println();
        System.out.println("BEFORE MERGE SORT:\n");
        print(arr);
        sort(arr);
        System.out.println();
        System.out.println("AFTER MERGE SORT:\n");
        print(arr);

    }
}
