public class CountOfDigit {
    public static void main(String[] args) {
        int n = 12345, cnt = 0;
        System.out.println("Count : "+count(n, cnt));

    }

    public static int count(int num, int cnt){
        if(num > 0){
            cnt++;
            return count(num /= 10, cnt);
        } else {
            return cnt;
        }
    }
}
