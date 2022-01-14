/**
 * Quick sort implementation featuring Insertion sort
 */
public class QuickSorterInsertion implements IntSorter {

    @Override
    public void sort(int[] a) {
        ArrayUtil.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    public void insertionSortPartition(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
                int x = a[j];
                a[j] = a[j - 1];
                a[j - 1] = x;
            }
        }
    }


    public void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if ((hi - lo + 1) < 15) {
            insertionSortPartition(a, lo, hi);
            return;
        } else {
            int p = lo;
            int i = lo;
            int j = hi + 1;
            int temp;
            while (i < j) {
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

