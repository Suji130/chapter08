package chapter08;
import java.util.Date;

class PrintTime implements Runnable{
	int num;//횟수
	
	PrintTime(int num){//생성자
		this.num=num;
	}
	public void run() {//스레드 기능 구현
		Date now = new Date();
		
		for(int i=1;i<=num;i++) {//i<num일 때까지 반복문 실행
			System.out.print("순위: "+Thread.currentThread().getPriority()+" ");//우선순위 출력
			System.out.print(now+" ");//현재 시간
			System.out.println(Thread.currentThread().getName());//스레드 이름 출력
		}
	}	
}
public class ex07 {

	public static void main(String[] args) {
		PrintTime p1 = new PrintTime(3);//객체 생성
		Thread th1 = new Thread(p1, "안녕하세요!");//인터페이스 객체, 스레드 이름
		th1.setPriority(Thread.MAX_PRIORITY-1);//
		th1.start();//스레드 시작
		
		PrintTime p2 = new PrintTime(6);
		Thread th2 = new Thread(p2, "반갑습니다.");//인터페이스 객체, 스레드 이름
		th2.setPriority(Thread.NORM_PRIORITY-1);//5-1
		th2.start();//스레드 시작
	}
}
