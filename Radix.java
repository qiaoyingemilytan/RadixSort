public class Radix{
  public static int nth(int n, int col){
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
    int maxPlace = 0;
    for(int j = 0; j < data.size(); j++){
      if(length(data.get(j)) > maxPlace){
        maxPlace = length(data.get(j));
      }
    }
    for(int places = 0; places <= maxPlace; maxPlace++){
      SortableLinkedList[] buckets = new SortableLinkedList[10];
      SortableLinkedList pass = new SortableLinkedList();
      for(int i = 0; i < 10; i++){
        buckets[i] = new SortableLinkedList();
      }
      for(int key = 0; key < data.size(); key++){
        buckets[nth(data.get(key), places)].add(data.get(key));
      }
      merge(pass, buckets);
      data = pass;
    }
  }

}
