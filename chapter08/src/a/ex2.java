package a;

class InvalidWithdraw extends Exception {//사용자 정의 예외 클래스 생성
    private static final long serialVersionUID = 1L;
    public InvalidWithdraw(String msg) {//인자 생성자
        super(msg);
    }
}
class BankAccount {
	int money;
    
    public BankAccount(int money){//최저 잔금 저장 생성자
    	this.money=money;
    }
    public void deposit(int money) {//입금 메소드
        this.money+=money;
    }
    public void withdraw(int money) throws InvalidWithdraw {//출금 메소드
      	if(this.money-money>-100000&&money>=0)//출금 조건
      		this.money-=money;
        else throw new InvalidWithdraw("입력 금액 오류 또는 잔고 부족");//if조건을 만족하지 못하면 오류 출력
    }
}
public class ex2 extends BankAccount{

	public ex2(int money) {
		super(money);//생성자 오버라이딩
	}

	public static void main(String[] args){
		BankAccount ba=new BankAccount(-100000);
		try{//예외처리
			ba.withdraw(5000000);
		}catch(InvalidWithdraw e){//InvalidWithdraw 관련 요류 발생시 에러 내용 출력
			System.out.println("예외발생: "+e.getMessage());
		}
	 
	}
}
