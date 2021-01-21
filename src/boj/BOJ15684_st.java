package boj;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ15684_st {
    static int n,m,h;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로선의 개수
        m = Integer.parseInt(st.nextToken()); // 가로선의 개수
        h = Integer.parseInt(st.nextToken()); // 세로선 마다 가로선을 놓을 수 있는 위치 개수
        // n과 h값 바꾸기
        n = 2*n-1;
        h = h+2;
        // 사다리를 표로 만들자
        // 세로 h+2(숫자표시) & 가로 n개+n-1칸들
        visited = new boolean[h][n];
        arr = new int[h][n];
        
        // 숫자 표시(출발 &도착) 첫 줄과 끝 줄 숫자 넣어주기
        for(int i=0,j=1;i<n;i+=2) {
            arr[0][i]=j;
            arr[h-1][i]=j++;
        }
        
        // 라인이 그려져야하는곳 -1로 채우기
        for(int i=0;i<h;i++) {
            for(int j=1;j<n;j+=2)
                arr[i][j] = -1;
        }
        
        // 주어지는 가로선 채우기 숫자 중간 중간이므로 홀수 배열로 찾아가도록
        // 1 3 5 7 9 11 ...
        int[] holsu = new int[31];
        for(int i=1,j=1;i<=30;i++,j+=2)
            holsu[i] = j;
        
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int pick = Integer.parseInt(st.nextToken());// 가로줄 번호
            int num = Integer.parseInt(st.nextToken()); // 세로줄 번호
            num = holsu[num];
            arr[pick][num] = 0;
            // 미리 그어저 있는 선의 양 옆은 건들지 못한다.
            // 범위를 벗어날 수도 있으니 try catch로 처리
            try {arr[pick][num+2] = -3;}catch (Exception e) {}
            try {arr[pick][num-2] = -3;}catch (Exception e) {}
        }
        // 답 최대 3개이므로 4로 설정
        result = 4;
        solve(1, 1, 0);
        // 그대로 4라면 불가능 한 것 
        if(result==4) result = -1;
        System.out.println(result);
    }
    
    static boolean flag;
    private static boolean check() {
        // i=0부터 시작 안하고 뒤에서 부터 시작 시키자
        // DFS를 통해 만들어지는 경우의 수가 앞에서부터 생성이 되므로, 뒤에서 부터 보면 안되는 경우를 빨리 쳐낼 수 있다.
        for(int i=n-1;i>=0;i-=2) {
            flag = false;
            visited[1][i] = true;
            dfs(1,i,i);
            visited[1][i] = false;
            if(!flag) return false;
        }
        return true;
    }
 
    // 사다리이므로 왼쪽 오른쪽 아래만 보면된다.(우 좌 하)
    static int[][] dir = {{0,1},{0,-1},{1,0}};
    static boolean[][] visited;
    private static void dfs(int x,int y,int num) {
        for(int i=0;i<3;i++) {
            int tx = x+dir[i][0];
            int ty = y+dir[i][1];
            if(ty<0 || ty>=n) continue;
            if(arr[tx][ty]<0) continue;
            if(visited[tx][ty]) continue;
            if(arr[tx][ty]>0) {
                if(ty==num) flag = true;
                return;
            }
            visited[tx][ty] = true;
            dfs(tx, ty,num);
            visited[tx][ty] = false;
            return;
        }
    }
    
    
    static int result;
    private static void solve(int x,int y,int cnt) {
        // 기존 값과 cnt를 비교해서 cnt가 작은 경우만 찾으면 되므로 다른 조건들은 return 시킨다.
        if(result<=cnt) return;
        
        // 3개 이하로 들어오면 계산
        if(cnt<=3) {
            if(check()) {
                result = Math.min(result, cnt);
                return;
            }
        }
        // 3개 이상이면 return
        if(cnt>=3) return;
 
        // 마지막 줄 아래로 이동 방지
        if(x>=h-1) return;
        
        // 해당 열을 넘으면 넘으면 다음 줄로 이동
        if(y>n-1) {
            solve(x+1, 1, cnt);
            return;
        }
 
        if(arr[x][y]==0) {
            // 이미 이어진 경우 패스하도록 +4.
            solve(x, y+4, cnt);
        }else if(arr[x][y]==-1) {
            // 바꿔도 되는 칸의 경우
            arr[x][y] = 0;
            solve(x,y+4,cnt+1);
            arr[x][y] = -1;
            // 연속된 가로선이 안되도록 2칸이동
            solve(x,y+2,cnt);
        }else if(arr[x][y]==-3) {
            // 건들면 안되는 칸의 경우
            solve(x,y+2,cnt);
        }
    }
    
    static class Pair{
        private int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}