public class MergeSorter implements IntSorter {


    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public void insertionSortPartition(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
                int x = a[j];
                a[j] = a[j - 1];
                a[j - 1] = x;
            }
        }
    }

    public void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi + lo) / 2;
        if ((mid - lo) <= 29) {
            insertionSortPartition(a, lo, hi);
            return;

        } else {
            mergeSort(a, lo, mid);
        }
        if ((hi - mid) <= 29) {
            insertionSortPartition(a, lo, hi);
            return;
        } else {
            mergeSort(a, mid + 1, hi);
        }
        merge(a, lo, mid, hi);
    }

    public void merge(int[] a, int lo, int mid, int hi) {
        int[] copyA = a;
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (k <= hi) {
            if (i > mid) {
                a[k] = a[j];
                j++;
            }
            if (j > hi) {
                a[k] = a[i];
                i++;
            } else {
                if (a[i] <= a[j]) {
                    a[k] = a[i];
                    i++;
                } else {
                    a[k] = a[j];
                    j++;
                }
            }
            k++;
        }
    }
}
