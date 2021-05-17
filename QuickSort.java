/**
 * <h1>It is assignment of quick sort implementation</h1>
 * <p>This is algorithm of code that was given in presentation </p>
 * @author student of Astana IT University(Y.K,SE-2014)
 * @since done 7:13  5/17/2021
 * *
 * */
public class QuickSort {

    static QuickSort quickSort = new QuickSort();//our method not static,because of this i create object of this class,in order to access non-static methods;

    /*This is given part of code
     * we create a return type void method that calls method of sort,
     * that takes parameters of whole array numbers,starting from 0's position and till the end
     * */
    public  void quickSort(int[] x){
        quickSort(x,0,x.length - 1);
    }

    public void quickSort(int[] x,int start,int end){
        if(start < end){
            int pi = partition(x,start,end);

            quickSort(x,start,pi - 1);
            quickSort(x,pi + 1,end);

        }
    }

    private  int partition(int[] x,int start,int end) {
        int pivot = x[end];

        int index = start - 1;

        for (int i = start; i <= end - 1; ++i) {
            if (x[i] < pivot) {
                index++;

                int temp = x[index];
                x[index] = x[i];
                x[i] = temp;
            }

        }

        int temp = x[index + 1];
        x[index + 1] = x[end];
        x[end] = temp;


        return index + 1;

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
        System.out.println("BEFORE QUICK SORT:\n");
        print(arr);
        quickSort.quickSort(arr);
        System.out.println();
        System.out.println("AFTER QUICK SORT:\n");
        print(arr);
    }
}
