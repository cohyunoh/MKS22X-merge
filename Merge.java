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
    int[] left = new int[middle - lo + 1];
    int[] right = new int[hi - middle];
    for(int i = lo; i < hi + 1; i++){
      if(i <= middle){
        left[i] = data[i];
      }else{
        right[i - middle - 1] = data[i];
      }
    }
    int i = 0;
    int j = 0;
    int[] newData = new int[data.length];
    for(int c = 0; c < newData.length; c++){
      if(left[i] < right[j]){
        newData[c] = left[i];
        if(i + 1 < left.length){
          i++;
        }
      }else{
        newData[c] = right[j];
        if(j + 1 < right.length){
          j++;
        }
      }
    }
    data = newData;
  }
}
