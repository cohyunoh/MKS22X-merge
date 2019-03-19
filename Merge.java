import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    //this value will dictate at what size length the mergesort will use insertion sort (mainly smaller ones);
    int k = (int)( (float)(data.length) * 0.00005) + 2;
    //performs a recursive mergesort from start to end
    mergesort(data, 0, data.length - 1, k);
  }

  private static void mergesort(int[]data, int lo, int hi, int k){
    //if the length is equal to the specified length then perform insertionsort
    if(hi - lo + 1 <= k){
      insertionsort(data, lo, hi);
    }
    else{
      //choose the middle of the array to split the array up into two groups (left and right)
      int middle = (lo + hi) / 2;
      //perform mergesort on the left half
      mergesort(data, lo, middle, k);
      //perform mergesort on the right half
      mergesort(data, middle + 1, hi, k);
      //then merge the two halfs
      //after merge is sort is performed on the two halves, the two halves should each be sorted
      merge(data, lo, hi, middle);
    }
  }

  //used to make the two arrays that represent the halves
  private static int[] makeList(int[] data, int lo, int hi){
    //make a new list at the length specified
    int[] newData = new int[hi - lo + 1];
    int j = 0;
    //copy over data
    for(int i = lo; i < hi + 1 && j < newData.length; i++){
      newData[j] = data[i];
      j++;
    }
    return newData;
  }

  private static void merge(int[] data, int lo, int hi, int middle){
    //will be decided to see what to do with equals
    Random rand = new Random();
    //make the two arrays: left and right
    int[] left = makeList(data, lo, middle);
    int[] right = makeList(data, middle + 1, hi);
    int r = 0;
    int l = 0;
    //basically compare the two values at r and l (r is on the right array and l is on the left array) and see which one is the
    //lesser one. Then add the lesser one to the right place on the orginial data array from lo to hi inclusive
    for(int i = lo; i < hi + 1; i++){
      //if l is past the length of left then just add the value from the right array
      if(l >= left.length){
        if(r < right.length){
          data[i] = right[r];
          r++;
        }
      //if r is past the length of right then just add the value from the left array
      }else if(r >= right.length){
        if(l < left.length){
          data[i] = left[l];
          l++;
        }
      }else if(l < left.length && r < right.length){
        //if the value on the left side is less then add it
        if(left[l] < right[r]){
          data[i] = left[l];
          l++;
        //if the values are equal then have a 50/50 chance on what is selected
        }else if(left[l] == right[r]){
          int choice = Math.abs(rand.nextInt()) % 2;
          if(choice == 0){
            data[i] = left[l];
            l++;
          }else{
            data[i] = right[r];
            r++;
          }
        //otherwise just add the value from the right array
        }else{
          data[i] = right[r];
          r++;
        }
      }
    }
  }
  private static void insertionsort(int[] data, int lo, int hi){
    //loop through the array from lo to hi inclusive
    for (int i = lo; i < hi + 1; ++i) {
      //this is the value we are inserting
      int original = data[i];
      //this is the value we are starting from to look backwards
      int c = i - 1;
      //loop backwards until we reach index lo or we find a value less than our original value
      while (c >= lo && data[c] > original) {
        data[c + 1] = data[c];
        c--;
      }
      //where ever we are just add the original value there
      data[c + 1] = original;
    }
  }
  /*
  public static void main(String[] args) {

    int[] ary = { 1, 9, -10, 55, 55, 500, 0, 5, 22, 55, 59,100 };
    int[] aryCopy = ary;
    mergesort(ary);
    Arrays.sort(aryCopy);
    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(aryCopy));
    System.out.println(Arrays.equals(aryCopy, ary));
  }
  */
}
