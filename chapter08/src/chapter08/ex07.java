package chapter08;
import java.util.Date;

class PrintTime implements Runnable{
	int num;//Ƚ��
	
	PrintTime(int num){//������
		this.num=num;
	}
	public void run() {//������ ��� ����
		Date now = new Date();
		
		for(int i=1;i<=num;i++) {//i<num�� ������ �ݺ��� ����
			System.out.print("����: "+Thread.currentThread().getPriority()+" ");//�켱���� ���
			System.out.print(now+" ");//���� �ð�
			System.out.println(Thread.currentThread().getName());//������ �̸� ���
		}
	}	
}
public class ex07 {

	public static void main(String[] args) {
		PrintTime p1 = new PrintTime(3);//��ü ����
		Thread th1 = new Thread(p1, "�ȳ��ϼ���!");//�������̽� ��ü, ������ �̸�
		th1.setPriority(Thread.MAX_PRIORITY-1);//
		th1.start();//������ ����
		
		PrintTime p2 = new PrintTime(6);
		Thread th2 = new Thread(p2, "�ݰ����ϴ�.");//�������̽� ��ü, ������ �̸�
		th2.setPriority(Thread.NORM_PRIORITY-1);//5-1
		th2.start();//������ ����
	}
}
