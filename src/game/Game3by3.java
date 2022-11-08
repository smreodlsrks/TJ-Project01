package game;

import java.util.Scanner;

public class Game3by3 {
	/*
	123   00 01 02
	45X   10 11 12
	786   20 21 22
	 */	
	public static void main(String[] args) {
		
		char temp = '0'; 		
		char[][] game = {
				{'1', '2', '3'},
				{'4', '5', '8'},
				{'7', 'X', '6'}
			};
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			for(int i=0 ; i<game.length ; i++) {
				for(int j=0 ; j<game[i].length ; j++) {
					System.out.print(game[i][j] +" ");
				}
				System.out.println();
			}
			
//			if(game[0][0]=='1' && game[0][1]=='2' && game[0][2]=='3' && game[1][0]=='4' && game[1][1]=='5' && 
//					game[1][2]=='6' && game[2][0]=='7' && game[2][1]=='8' && game[2][2]=='X') {
//				System.out.println("축하합니다! 게임을 클리어하셨습니다!");
//				return;
//			}				
			
			System.out.print("이동하려는 방향을 입력하세요(WASD) : ");
			String WASD = scan.nextLine();
			
			if(WASD.equalsIgnoreCase("W")) {
				boolean W = false;
				for(int i=1 ; i<game.length ; i++) {
					for(int j=0 ; j<game[i].length ; j++) {
						if(game[i-1][j]=='X') {
							temp = game[i-1][j];
							game[i-1][j] = game[i][j];
							game[i][j] = temp;
							W = true;
						}							
					}
				}
				if(W == true) {
					System.out.println("위로 1칸 이동하였습니다.");
					continue;
				}
				else if(W == false) {
					System.out.println("위로는 이동할 수 없습니다.");
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("A")) {
				boolean A = false;
				for(int i=0 ; i<game.length ; i++) {
					for(int j=1 ; j<game[i].length ; j++) {
						if(game[i][j-1]=='X') {
							temp = game[i][j-1];
							game[i][j-1] = game[i][j];
							game[i][j] = temp;
							A = true;
						}							
					}
				}
				if(A == true) {
					System.out.println("왼쪽으로 1칸 이동하였습니다.");
					continue;
				}
				else if(A == false) {
					System.out.println("왼쪽으로는 이동할 수 없습니다.");
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("S")) {
				boolean S = false;
				for(int i=0 ; i<game.length-1 ; i++) {
					for(int j=0 ; j<game[i].length ; j++) {
						if(game[i+1][j]=='X') {
							temp = game[i+1][j];
							game[i+1][j] = game[i][j];
							game[i][j] = temp;
							S = true;
						}							
					}
				}
				if(S == true) {
					System.out.println("아래로 1칸 이동하였습니다.");
					continue;
				}
				else if(S == false) {
					System.out.println("아래로는 이동할 수 없습니다.");
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("D")) {
				
			}
			else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
				continue;
			}
			
		}		
		
	}

}
