package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Queens2 {
	
	public static HashMap<Integer,HashMap<Integer,Integer>> boardMap;
	static int can_attack(HashMap<Integer,HashMap<Integer,Integer>> boardMap,int x,int y) {
		HashMap<Integer,Integer> rowMap = boardMap.get(x);
		if(rowMap==null) {
			HashMap<Integer,Integer> colMap = new HashMap<Integer,Integer>();
			colMap.put(y,2);
			boardMap.put(x,colMap);
			return 1;
		}
		else {
			//HashMap<Integer,Integer> colMap = rowMap.get(y);
			if(rowMap.get(y)==null)
			{
				rowMap.put(y,2);
				boardMap.put(x,rowMap);
				return 1;
			}else if(rowMap.get(y)==0) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	//creating a hashmap for storing info
    	 boardMap = new HashMap<Integer,HashMap<Integer,Integer>>();
        //initializing the board
        /*int[][] board = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                board[i][j]=1;
        //marking the obstacles
        for(int i=0;i<k;i++)
            board[obstacles[i][0]][obstacles[i][1]]=0;
        board[r_q][c_q]=0;
        */
    	
    	for(int i=0;i<k;i++) {
    		int obs_x=obstacles[i][0], obs_y=obstacles[i][1];
    		HashMap<Integer,Integer> col = new HashMap<Integer,Integer>();
    		col.put(obs_y,0);
    		boardMap.put(obs_x,col);
    	}
    	
        int count=0;

        //checking left of queen
        int row=r_q, col=c_q-1;
        while(col>=1)
        {
        	//HashMap<Integer,Integer> rowMap=boardMap.get(row);
        	int can_attack_result = can_attack(boardMap, row, col);
            if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            col--;
        }

        //checking right of queen
        row=r_q; col=c_q+1;
        while(col<=n){
        	int can_attack_result = can_attack(boardMap, row, col);
            if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            col++;
        }
        
        //checking top of queen
        row=r_q-1; col=c_q;
        while(row>=1){
        	int can_attack_result = can_attack(boardMap, row, col);
            if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            row--;
        }

        //checking bottom of queen
        row=r_q+1; col=c_q;
        while(row<=n){
        	int can_attack_result = can_attack(boardMap, row, col);
            if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            row++;
        }
        //checking the left top diagnol
        int x=r_q-1,y=c_q-1;
        while(x>0 && x>=1 && y>0 && y>=1){
        	int can_attack_result = can_attack(boardMap, x, y);
        	if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            x-=1;
            y-=1;
        } 

        //checking right bottom diagnol
        x=r_q+1;y=c_q+1;
        while(x<=n && y<=n){
        	int can_attack_result = can_attack(boardMap, x, y);
        	if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            x+=1;
            y+=1;
        }

        //checking the lower left diagnol
        x=r_q+1;y=c_q-1;
        while(x<=n && y>0 && y>=1){
        	int can_attack_result = can_attack(boardMap, x, y);
        	if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            x+=1;
            y-=1;
        }

        //checking the upper right diagnol
        x=r_q-1;y=c_q+1;
        while(x>=1 && y<=n){
        	int can_attack_result = can_attack(boardMap, x, y);
        	if(can_attack_result==1){
                count++;
            }else if(can_attack_result==-1){
                break;
            }
            x-=1;
            y+=1;
        }
        //print_board(board,n);
        return count;
    }

    public static void print_board(int[][] board,int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.out"));
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
