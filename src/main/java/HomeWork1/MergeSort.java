package HomeWork1;

public class MergeSort {

    public static void sort(Entry[] entries) {
        if (entries == null || entries.length <= 1) {
            return;
        }
        mergeSort(entries, 0, entries.length - 1);
    }

    private static void mergeSort(Entry[] entries, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(entries, left, mid);
            mergeSort(entries, mid + 1, right);
            merge(entries, left, mid, right);
        }
    }

    private static void merge(Entry[] entries, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Entry[] leftArray = new Entry[n1];
        Entry[] rightArray = new Entry[n2];

        System.arraycopy(entries, left, leftArray, 0, n1);
        System.arraycopy(entries, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                entries[k] = leftArray[i];
                i++;
            } else {
                entries[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            entries[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            entries[k] = rightArray[j];
            j++;
            k++;
        }
    }
}