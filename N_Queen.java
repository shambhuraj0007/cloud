import java.util.*;
public class N_Queen {
    static boolean found=false;
    public static boolean isSafe(char[][]board,int row,int col,int n,boolean[]col_check){
        if(col_check[col]){
            return false;
        }
        //upper left diagonal
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        //upper right diagonal
        i=row;
        j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public static void print(char[][]board,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solve(char[][]board,int row,int n,boolean[]col_check){
        if(row==n){
            found=true;
            print(board,n);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n,col_check)){
                board[row][col]='Q';
                col_check[col]=true;
                solve(board,row+1,n,col_check);
                board[row][col]='.';
                col_check[col]=false;
            }
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of board: ");
        int n=sc.nextInt();
        char[][] board=new char[n][n];
        boolean[]col_check=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(board,0,n,col_check);
        if(!found){
            System.out.println("No solution found for "+n+" queens.");
        }
    }
}   
