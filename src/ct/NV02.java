package ct;

class NV02 {
    public String solution(String sentence, String keyword, int[] skips) {
        String answer = "";
        String sent = sentence;
        String key = keyword;
        int[] skps = skips;

        int skpsIdx = 0;
        int keyIdx = 0;

        for (int i = 0; i < sent.length(); i++) {
            if (skpsIdx < skps.length) {
                if (skps[skpsIdx] == 0) { // 할당된 만큼 건너뛴 후 keyword 입력
                    answer += key.charAt(keyIdx);
                    keyIdx = (keyIdx + 1) % key.length();
                    skpsIdx++;
                    i--;
                    continue;

                } else if (sent.charAt(i) == key.charAt(keyIdx)) { // 할당된 만큼 건너뛰기 전 같은 keyword와 같은문자일 경우
                    answer += sent.charAt(i);
                    answer += key.charAt(keyIdx);
                    keyIdx = (keyIdx + 1) % key.length();
                    skpsIdx++;
                    //System.out.println(skpsIdx);
                    continue;

                } else { // skps를 1씩 낮춘다.
                    skps[skpsIdx]--;
                }
            }

            answer += sent.charAt(i);
        }

        // sentence를 모두 입력한 후 남은 skps가 0인경우 나머지 keyword 입력
        while (skpsIdx < skps.length && skps[skpsIdx] == 0) {
            answer += key.charAt(keyIdx);
            keyIdx = (keyIdx + 1) % key.length();
            skpsIdx++;
        }

        return answer;
    }
}