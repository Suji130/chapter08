package chapter08;

class PrimeNumber03 implements Runnable{
	int num;
	int count=0;
	
	PrimeNumber03(int num){//������
		this.num=num;
	}
	public void run(){
		
		System.out.println(Thread.currentThread().getName());//������ �̸� ���
		//�Ҽ� ���ϴ� �˰���
		for(int i=1; i<=num; i++) {
			if (i==1) continue;
			else
				for(int j=1;j<i;j++) //�Ҽ��� �ڱ�� 1�� �����ϰ� ������ 0�� �Ǵ� ���� ����
					if (i%j==0) count++;	
				if(count==1) {
					System.out.print(i+"  ");//�Ҽ� ���
				}
			count=0;//0���� �ʱ�ȭ
		}	
	}
}
public class ex06 {
	
	public static void main(String[] args) {
		new Thread(new PrimeNumber03(25), "�Ҽ� ����� ������").start();
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
//		System.out.println(getName());//������ �̸� ���
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
//		PrimeNumber02 pn = new PrimeNumber02(20,"�Ҽ� ����� ������");
//		pn.start();
//	
//	}
//}
