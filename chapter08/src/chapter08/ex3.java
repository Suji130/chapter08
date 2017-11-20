package chapter08;

class InvalidWithdraw extends Exception {//���� Ŭ���� ����
    private static final long serialVersionUID = 1L;
    public InvalidWithdraw(String msg) {
        super(msg);
    }
}
class BankAccount {
	int money=0;
	int min;
	
    private static final long serialVersionUID = 1L;
    public BankAccount(int min){//���� �ܱ� �ݾ�
    	this.min=min;
    }
    public void deposit(int money) {//�Ա� �޼ҵ�
        System.out.print("���� �Ա�ó��: �Աݱݾ�="+money);
        this.money+=money;
        System.out.println(", �ܱ�="+money);
    }
    public void withdraw(int money) throws InvalidWithdraw {//��� �޼ҵ� ����ó��
      	if(this.money-money>=min&&money>=0) {//��� ����
      		System.out.print("���� ���ó��: ��ݱݾ�="+money);
      		this.money-=money;
      		System.out.println(", �ܱ�="+this.money);
      }
        else throw new InvalidWithdraw("�ʰ� ��� �䱸 ����");//���� ���
    }
}

public class ex3 extends BankAccount{
	public ex3(int min) {
		super(min);
	}
	public static void main(String[] args) throws InvalidWithdraw  {
		BankAccount ba=new BankAccount(-100000);
		ba.deposit(100000);//�Ա�
	    ba.withdraw(100000);//���
	    ba.withdraw(200000);  //���
	}
}
