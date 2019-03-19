import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int k = (int)( (float)(data.length) * 0.0001) + 2;
    mergesort(data, 0, data.length - 1, k);
  }

  private static void mergesort(int[]data, int lo, int hi, int k){
    if(hi - lo + 1 <= k){
      insertionsort(data, lo, hi);
    }
    else{
      int middle = (lo + hi) / 2;
      mergesort(data, lo, middle, k);
      mergesort(data, middle + 1, hi, k);
      merge(data, lo, hi, middle);
    }
  }
  private static int[] makeList(int[] data, int lo, int hi){
    int[] newData = new int[hi - lo + 1];
    int j = 0;
    for(int i = lo; i < hi + 1 && j < newData.length; i++){
      newData[j] = data[i];
      j++;
    }
    return newData;
  }
  private static void merge(int[] data, int lo, int hi, int middle){
    int[] left = makeList(data, lo, middle);
    int[] right = makeList(data, middle + 1, hi);
    int r = 0;
    int l = 0;
    for(int i = lo; i < hi + 1; i++){
      if(l >= left.length){
        if(r < right.length){
          data[i] = right[r];
          r++;
        }
      }else if(r >= right.length){
        if(l < left.length){
          data[i] = left[l];
          l++;
        }
      }else if(l < left.length && r < right.length){
        if(left[l] < right[r]){
          data[i] = left[l];
          l++;
        }else{
          data[i] = right[r];
          r++;
        }
      }
    }
  }
  private static void insertionsort(int[] data, int lo, int hi){
    for (int i = lo; i < hi + 1; ++i) {
      int original = data[i];
      int c = i - 1;
      while (c >= lo && data[c] > original) {
        data[c + 1] = data[c];
        c--;
      }
      data[c + 1] = original;
    }
  }

  public static void main(String[] args) {

    int[] ary = { 1, 9, -10, 55, 55, 500, 0, 5, 22, 55, 59,100 };
    int[] aryCopy = ary;
    mergesort(ary);
    Arrays.sort(aryCopy);
    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(aryCopy));
    System.out.println(Arrays.equals(aryCopy, ary));
  }
}
