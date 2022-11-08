package banking;

public class MenuSelectException extends Exception {
	
	public MenuSelectException() {
		super("잘못 입력하셨습니다. 1~7 사이의 정수를 입력하세요.");
	}
}
