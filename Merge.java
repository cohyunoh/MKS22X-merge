public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergeSort(data, 0, data.length - 1);
  }

  private static void mergesort(int[]data, int lo, int hi){
    if(lo >= hi){
      return ;
    }
    mergesort(data, lo, (lo + hi) / 2);
    mergesort(data, ((lo + hi) / 2) + 1, hi);
    merge(data, lo , hi);
  }

  private static void merge(int[] data, int lo, int hi){
    int[] left = new int[((lo + hi) / 2) - lo];
    int[] right = new int[hi - ((lo + hi) / 2) + 1];
    for(int i = lo; i < hi + 1; i++){
      if(i < (lo + hi) / 2){
        left[i] = data[i];
      }else{
        right[i - ((lo + hi) / 2)] = data[i];
      }
    }

    for(int i)
  }

}
