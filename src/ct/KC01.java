package ct;

import java.util.Arrays;

public class KC01 {
   public static int solution(int[] gift_cards, int[] wants) {
        int[] cards = gift_cards;
        int[] needs = wants;
        int answer = 0;
        
        // 상품권 교환이 가능하므로 자연수 비교를 위해 정렬 (1 ~ 100000)
        Arrays.sort(cards);
        Arrays.sort(needs);
        
        int length = cards.length;
        int cardsIdx = 0;
        int needsIdx = 0;
        
        while(true) {
           
           if (cards[cardsIdx] == needs[needsIdx]) { // 상품번호와 원하는 상품번호 일치할 경우 다음 인덱스(둘다 ++)끼리 비교
              cardsIdx++;
              needsIdx++;
           } else if (cards[cardsIdx] > needs[needsIdx]) { // 상품번호가 원하는 상품번호보다 클 경우 다음
              needsIdx++;
              answer++;
           } else if (cards[cardsIdx] < needs[needsIdx]) { // 상품번호가 원하는 상품번호보다 작을경우 
              cardsIdx++;
           } // 두 배열이 다 정렬이 되어있기 때문에 이미 지나간 값은 비교하지 않아도 된다.
           
           // 인덱스가 범위를 넘어가면 break
           if (cardsIdx == length || needsIdx == length) {
              // 원하는 상품번호가 남아있으면 남아있는만큼 answer++
              if (needsIdx < length) {
                 answer += length - needsIdx;
              }
              break;
           }
        }
        
        return answer;
    }

   public static void main(String args[]) {
      int[] gift_cards = {2,1}; 
      int[] wants = {1,1};
      int solution = solution(gift_cards, wants);

      System.out.println(solution);
      
   }

}