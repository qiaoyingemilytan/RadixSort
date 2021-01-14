public class Radix{
  public static int nth(int n, int col){
    if(col > length(n)-1){
      return 0;
    }
    return (int) (n % Math.pow(10, (col+1)) / Math.pow(10, col));
  }

  public static int length(int n){
    int count = 0;
    while(n != 0){
      n = n/10;
      count ++;
    }
    return count;
  }

  public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int maxPlace = 1;
    for(int j = 0; j < data.size(); j++){
      if(length(data.get(j)) > maxPlace){
        maxPlace = length(data.get(j));
      }
    }
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }
    for(int places = 0; places < maxPlace; places++){
      SortableLinkedList pass = new SortableLinkedList();
      for(int index = 0; index < data.size(); index++){
        buckets[nth(data.get(index),places)].add(data.get(index));
      }
      merge(pass, buckets);
      data = pass;

    }
  }

  public static void radixSort(SortableLinkedList data){

  }

}
