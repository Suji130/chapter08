package a;

class InvalidWithdraw extends Exception {//����� ���� ���� Ŭ���� ����
    private static final long serialVersionUID = 1L;
    public InvalidWithdraw(String msg) {//���� ������
        super(msg);
    }
}
class BankAccount {
	int money;
    
    public BankAccount(int money){//���� �ܱ� ���� ������
    	this.money=money;
    }
    public void deposit(int money) {//�Ա� �޼ҵ�
        this.money+=money;
    }
    public void withdraw(int money) throws InvalidWithdraw {//��� �޼ҵ�
      	if(this.money-money>-100000&&money>=0)//��� ����
      		this.money-=money;
        else throw new InvalidWithdraw("�Է� �ݾ� ���� �Ǵ� �ܰ� ����");//if������ �������� ���ϸ� ���� ���
    }
}
public class ex2 extends BankAccount{

	public ex2(int money) {
		super(money);//������ �������̵�
	}

	public static void main(String[] args){
		BankAccount ba=new BankAccount(-100000);
		try{//����ó��
			ba.withdraw(5000000);
		}catch(InvalidWithdraw e){//InvalidWithdraw ���� ��� �߻��� ���� ���� ���
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	 
	}
}
