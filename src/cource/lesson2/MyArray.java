package cource.lesson2;

public class MyArray {

    private int[] arr;
    private int size;

    public MyArray(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public int getSize() {
        return size;
    }

    //2. Написать методы удаления, добавления, поиска элемента массива.
    public void delete(int value) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (arr[i] == value) break;
        }
        if (size - 1 - i >= 0) System.arraycopy(arr, i + 1, arr, i, size - 1 - i);
        size--;
    }

    public void insert(int value){
       int i;
        for(i = 0; i < size -1; i++) {
            if (this.arr[i]>value) {
                break;
            }
        }
        if (size - 1 - i >= 0) System.arraycopy(this.arr, i, this.arr, i + 1, size - 1 - i);
        this.arr[i] = value;
    }

    public boolean find(int value) {
        int low = 0;
        int high = size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == arr[mid]) {
                return true;
            } else {
                if (value < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public void sortBubble() {
        for (int j = arr.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void sortSelect() {
        int out, in, mark;
        for (out = 0; out < size; out++) {
            mark = out;
            for (in = out + 1; in < size; in++) {
                if (arr[in] < arr[mark]) {
                    mark = in;
                }
            }
            swap(out, mark);
        }
    }

    public void sortInsert() {
        int in, out;
        for (out = 1; out < size; out++) {
            in = out;
            while (in > 0 && arr[in - 1] >= arr[out]) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = arr[out];
        }
    }
}
