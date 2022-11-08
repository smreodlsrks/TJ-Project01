package game;

import java.util.Scanner;

public class Game3by3 {
	
	char temp = '0';
	
	char[][] game = {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', 'X', '8'}
		};	
	
	Scanner scan = new Scanner(System.in);
	
//	public void setting() {
//		
//		boolean Setting = false;
//		int random = (int)(Math.random()*7)%4;
//		
//		String move = null;						
//	
//		for(int k=0 ; k<100 ; k++) {
//			switch(random) {
//			case 0:
//				move = "W";
//				break;
//			case 1:
//				move = "A";
//				break;
//			case 2:
//				move = "S";
//				break;
//			case 3:
//				move = "D";
//			}
//			System.out.println(move);
//		}
//		if(move.equals("W")) {
	//////////////////
//			for(int i=1 ; i<game.length ; i++) {
//				for(int j=0 ; j<game[i].length ; j++) {
//					if(game[i-1][j]=='X') {
//						temp = game[i-1][j];
//						game[i-1][j] = game[i][j];
//						game[i][j] = temp;
//						M = true;							
//					}						
//				}
//				if(M == true) break;
//			}
//			if(M == true) {					
//				continue;
//			}
//			else if(M == false) {
//				k--;
//				continue;
//			}
//		}
//		else if(move.equals("A")) {
//			for(int i=0 ; i<game.length ; i++) {
//				for(int j=1 ; j<game[i].length ; j++) {
//					if(game[i][j-1]=='X') {
//						temp = game[i][j-1];
//						game[i][j-1] = game[i][j];
//						game[i][j] = temp;
//						M = true;
//						break;
//					}							
//				}
//				if(M == true) break;
//			}
//			if(M == true) {					
//				continue;
//			}
//			else if(M == false) {
//				k--;
//				continue;
//			}
//		}	
//	}
	
	public void play() {		
		
		while(true) {
			
			boolean M = false;
		
			for(int i=0 ; i<game.length ; i++) {
				for(int j=0 ; j<game[i].length ; j++) {
					System.out.print(game[i][j] +" ");
				}
				System.out.println();
			}
		
			if(game[0][0]=='1' && game[0][1]=='2' && game[0][2]=='3' && game[1][0]=='4' && game[1][1]=='5' && 
					game[1][2]=='6' && game[2][0]=='7' && game[2][1]=='8' && game[2][2]=='X') {
				System.out.println("축하합니다! 게임을 클리어하셨습니다!");
				System.out.println();
				return;
			}				
			
			System.out.print("이동하려는 방향을 입력하세요(WASD) : ");
			String WASD = scan.nextLine();
			
			if(WASD.equalsIgnoreCase("W")) {				
				for(int i=1 ; i<game.length ; i++) {
					for(int j=0 ; j<game[i].length ; j++) {
						if(game[i-1][j]=='X') {
							temp = game[i-1][j];
							game[i-1][j] = game[i][j];
							game[i][j] = temp;
							M = true;							
						}						
					}
					if(M == true) break;
				}
				if(M == true) {
					System.out.printf("위로 1칸 이동하였습니다.\n");
					continue;
				}
				else if(M == false) {
					System.err.printf("위로는 이동할 수 없습니다.\n");
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("A")) {
				for(int i=0 ; i<game.length ; i++) {
					for(int j=1 ; j<game[i].length ; j++) {
						if(game[i][j-1]=='X') {
							temp = game[i][j-1];
							game[i][j-1] = game[i][j];
							game[i][j] = temp;
							M = true;
							break;
						}							
					}
					if(M == true) break;
				}
				if(M == true) {
					System.out.printf("왼쪽으로 1칸 이동하였습니다.\n");
					continue;
				}
				else if(M == false) {
					System.err.printf("왼쪽으로는 이동할 수 없습니다.\n");
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("S")) {
				for(int i=0 ; i<game.length-1 ; i++) {
					for(int j=0 ; j<game[i].length ; j++) {
						if(game[i+1][j]=='X') {
							temp = game[i+1][j];
							game[i+1][j] = game[i][j];
							game[i][j] = temp;
							M = true;
							break;
						}							
					}
					if(M == true) break;
				}
				if(M == true) {
					System.out.printf("아래로 1칸 이동하였습니다.\n");					
					continue;
				}
				else if(M == false) {
					System.err.printf("아래로는 이동할 수 없습니다.\n");				
					continue;
				}
			}
			else if(WASD.equalsIgnoreCase("D")) {
				for(int i=0 ; i<game.length ; i++) {
					for(int j=0 ; j<game[i].length-1 ; j++) {
						if(game[i][j+1]=='X') {
							temp = game[i][j+1];
							game[i][j+1] = game[i][j];
							game[i][j] = temp;
							M = true;
							break;
						}							
					}
					if(M == true) break;
				}
				if(M == true) {
					System.out.printf("오른쪽으로 1칸 이동하였습니다.\n");					
					continue;
				}
				else if(M == false) {
					System.err.printf("오른쪽으로는 이동할 수 없습니다.\n");					
					continue;
				}				
			}
			else if(WASD.equalsIgnoreCase("EXIT")) {
				System.out.println("게임을 종료합니다.");
				System.out.println();
				return;
			}			
			else {
				System.err.printf("잘못 입력하셨습니다 다시 입력하세요.\n");				
				continue;
			}			
		}			
	}
}