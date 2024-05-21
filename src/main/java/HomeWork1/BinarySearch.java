package HomeWork1;

public class BinarySearch {

    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int startIndex = -1;
        int endIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (entries[mid].getName().compareTo(searchableName) >= 0) {
                if (entries[mid].getName().equals(searchableName)) {
                    startIndex = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (startIndex == -1) {
            return new int[0];
        }

        left = startIndex;
        right = entries.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (entries[mid].getName().compareTo(searchableName) <= 0) {
                if (entries[mid].getName().equals(searchableName)) {
                    endIndex = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[] { startIndex, endIndex };
    }
}