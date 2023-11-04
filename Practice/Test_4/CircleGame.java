package Practice.Test_4;

public class CircleGame {
    public static void main(String[] args) {
        CircleGame circleGame = new CircleGame();

        circleGame.play(110, -30);
    }

    private void play(int n, int x) {
        boolean visited[] = new boolean[n + 1];

        int count = 1, i = 1, m = n;
        while(m >= x) {

            while(count < x && !visited[i]) {
                count++; 
                i = (i %= n) + 1;
            }
            
            if(count == x && !visited[i]) {
                visited[i] = true;    
                count = 1;
                m--;
                System.out.print(i + " -> ");
            }
            i = (i %= n) + 1;
        }
    }
}
