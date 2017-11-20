package chapter08;

class InvalidWithdraw extends Exception {//예외 클래스 생성
    private static final long serialVersionUID = 1L;
    public InvalidWithdraw(String msg) {
        super(msg);
    }
}
class BankAccount {
	int money=0;
	int min;
	
    private static final long serialVersionUID = 1L;
    public BankAccount(int min){//최저 잔금 금액
    	this.min=min;
    }
    public void deposit(int money) {//입금 메소드
        System.out.print("정상 입금처리: 입금금액="+money);
        this.money+=money;
        System.out.println(", 잔금="+money);
    }
    public void withdraw(int money) throws InvalidWithdraw {//출금 메소드 예외처리
      	if(this.money-money>=min&&money>=0) {//출금 조건
      		System.out.print("정상 출금처리: 출금금액="+money);
      		this.money-=money;
      		System.out.println(", 잔금="+this.money);
      }
        else throw new InvalidWithdraw("초과 출금 요구 예외");//예외 출력
    }
}

public class ex3 extends BankAccount{
	public ex3(int min) {
		super(min);
	}
	public static void main(String[] args) throws InvalidWithdraw  {
		BankAccount ba=new BankAccount(-100000);
		ba.deposit(100000);//입금
	    ba.withdraw(100000);//출금
	    ba.withdraw(200000);  //출금
	}
}
