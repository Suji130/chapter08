package chapter08;

class PrimeNumber03 implements Runnable{
	int num;
	int count=0;
	
	PrimeNumber03(int num){//생성자
		this.num=num;
	}
	public void run(){
		
		System.out.println(Thread.currentThread().getName());//스레드 이름 출력
		//소수 구하는 알고리즘
		for(int i=1; i<=num; i++) {
			if (i==1) continue;
			else
				for(int j=1;j<i;j++) //소수는 자기와 1을 제외하고 나눠서 0이 되는 수가 없음
					if (i%j==0) count++;	
				if(count==1) {
					System.out.print(i+"  ");//소수 출력
				}
			count=0;//0으로 초기화
		}	
	}
}
public class ex06 {
	
	public static void main(String[] args) {
		new Thread(new PrimeNumber03(25), "소수 만드는 스레드").start();
	}
}

//class PrimeNumber02 extends Thread{
//	int num;
//	int count=0;
//	
//	PrimeNumber02(int num, String name){
//		this.num=num;
//	    setName(name);
//	}
//	public void run(){
//		System.out.println(getName());//스레드 이름 출력
//		for(int i=1; i<=num; i++) {
//			if (i==1) continue;
//			else
//				for(int j=1;j<i;j++) 
//					if (i%j==0) count++;	
//				if(count==1) {
//					System.out.print(i+"  ");
//				}
//			count=0;
//		}
//	
//	}
//
//}
//public class ex06 {
//	
//	public static void main(String[] args) {
//		PrimeNumber02 pn = new PrimeNumber02(20,"소수 만드는 스레드");
//		pn.start();
//	
//	}
//}
