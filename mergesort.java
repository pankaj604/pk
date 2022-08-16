package DSA1.sort;
  public class SortMerge {
      public static void conquer(int are[] , int si , int mid , int ei){
          int merger [] = new int [ ei +1 - si ];
          int idx1 = si;
          int idx2 = mid+1;
          int x = 0;
          while(idx1<= mid && idx2 <= ei ){
              if (are[idx1] <= are[idx2] ){
                  merger[x] = are[idx1];
                  x++; idx1++;
              }else {
                  merger[x++] = are[idx2++];
              }
          }
          while(idx1 <= mid) {
              merger[x++] = are[idx1++];
          }
          while (idx2 <= ei){
              merger[x++] = are[idx2++];
          }
          for (int i = 0, j = si; i< merger.length;i++ , j++){
              are[j] = merger[i];
          }
      }
      public static void divide(int are[] , int si , int ei) {
//         mid  = si + ei / 2;
          if (si>=ei){
              return;
          }
          int mid = si + (ei - si) / 2;
          divide(are , si , mid );
          divide(are , mid + 1  , ei);
          conquer(are , si , mid , ei);
    }
     public static void main(String[] args) {
        int are [] = {9,8,7,6,5,4,3,2,1,0};
        int n = are.length;
        divide(are , 0 , n-1);
         for (int i = 0; i < n; i++) {
             System.out.println(are[i]+" ");
         }
         System.out.println();
    }

}
