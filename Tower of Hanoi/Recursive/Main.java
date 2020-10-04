public class Main {
    public static void main(String[] args) {
        int n = 4;
        solve(n,"A","C","B");
    }
    public static void solve(int n,String from,String to, String aux){
        if(n==1){System.out.println("Move disk 1 from rod "+ from +" to rod "+to); return;}
        solve(n-1,from,aux,to);
        System.out.println("Move disk "+n+" from rod " + from + " to rod "+to);
        solve(n-1,aux,to,from);
    }
}
