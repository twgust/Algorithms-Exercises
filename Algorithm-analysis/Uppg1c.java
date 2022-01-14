public class Uppg1c {
  public static int countpairs(int[] sortedarr){
        int N = sortedarr.length;
        int pairs = 0;
        int m = 1;
        for (int i = 0; i < N; i++) {
            if (N <= (i+1)){
                m = ((m - 1) * ((m -1 ) + 1));
                m = m /2;
                pairs += m;
            }
            else if(sortedarr[i] == sortedarr[i + 1]){
                m++;
            }
            else if (sortedarr[i] != sortedarr[i + 1]){
                m = ((m - 1) * ((m -1 ) + 1));
                m = m /2;
                pairs += m;
                m = 1;
            }
        }
        return pairs;
    }
}
