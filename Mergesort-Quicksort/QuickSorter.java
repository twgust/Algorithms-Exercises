import java.util.Random;

public class QuickSorter implements IntSorter {

    @Override
    public void sort(int[] a) {
        ArrayUtil.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        else {
            int p = lo;
            int i = lo;
            int j = hi+1;
            int temp;
            while(i < j) {
                i++;
                while (a[i] <= a[p] && i < hi) {
                    i++;
                }
                j--;
                while (a[j] > a[p]) {
                    j--;
                }
                if (i < j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            temp = a[j];
            a[j] = a[lo];
            a[lo] = temp;
            quickSort(a, lo, j - 1);
            quickSort(a, j + 1, hi);
        }
    }
}