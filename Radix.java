public class Radix{
  public static int nth(int n, int col){
    return Math.abs((int) (n % Math.pow(10, (col+1)) / Math.pow(10, col)));
  }

  public static int length(int n){
    String integer = "" + n;
    int len = integer.length();
    if(integer.charAt(0) == '-'){
      return len - 1;
    }
    return len;
  }

  public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int maxPlace = 1;
    for(int i = 0; i < data.size(); i++){
      int x = data.remove(0);
      if(length(x) > maxPlace){
        maxPlace = length(x);
      }
      data.add(x);
    }
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int j = 0; j < 10; j++){
      buckets[j] = new SortableLinkedList();
    }
    for(int places = 0; places < maxPlace; places++){
      while(0 < data.size()){
        int x = data.remove(0);
        buckets[nth(x,places)].add(x);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    int maxPlace = 1;
    for(int i = 0; i < data.size(); i++){
      int x = data.remove(0);
      if(length(x) > maxPlace){
        maxPlace = length(x);
      }
      data.add(x);
    }
    SortableLinkedList[] posBuckets = new SortableLinkedList[10];
    SortableLinkedList [] negBuckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      posBuckets[i] = new SortableLinkedList();
    }
    for(int j = 0; j < 10; j++){
      negBuckets[j] = new SortableLinkedList();
    }
    for(int places = 0; places < maxPlace; places++){
      while(0 < data.size()){
        int x = data.remove(0);
        if(x >= 0){
          posBuckets[nth(x,places)].add(x);
        }
        else{
          negBuckets[9 - nth(x,places)].add(x);
        }
      }
      merge(data, negBuckets);
      merge(data, posBuckets);
    }
  }

}
