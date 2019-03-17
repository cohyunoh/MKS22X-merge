import java.util.Arrays;
import java.util.Random;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length - 1);
  }

  private static void mergesort(int[]data, int lo, int hi){
    if(lo >= hi){
      return ;
    }
    int middle = (lo + hi) / 2;
    mergesort(data, lo, middle);
    mergesort(data, middle + 1, hi);
    merge(data, lo , hi, middle);
  }

  private static void merge(int[] data, int lo, int hi, int middle){
    int i = lo;
    int j = middle + 1;
    int[] newData = new int[data.length];
    for(int c = 0; c < newData.length; c++){
      if(i > middle && j < hi + 1){
        newData[c] = data[j];
        j ++;
      }else if(j > hi && i < middle + 1){
        newData[c] = data[i];
        i ++;
      }else if(j > hi && i > middle){
        data = newData;
      }else{
        if(data[j] > data[i]){
          newData[c] = data[i];
          i++;
        }else{
          newData[c] = data[j];
          j++;
        }
      }
    }
    data = newData;
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
