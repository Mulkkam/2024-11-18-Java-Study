/*
 * 	&&(AND)		||(OR)
 * 	
 * 	(조건) && (조건) ====> 범위, 기간 안에 있는 경우 ======> 직렬연산자
 * 
 * 
 * 	(조건) || (조건) ====> 범위 밖에 있는 경우 =====> 병렬연산자
 * 
 * 
 * 	int x=10;
 * 	int y=9;
 * 	
 * 	x<y	&& x==++y ==	false  ===> 앞에 조건 false
 * 		   ===== 연산 (x) => 효율적인 연산
 * 	|| 
 * 	
 * 	x>y || x==++y == true ====> 앞에 조건  true
 * 		   ====== 연산 (O)
 */
public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int $age=50;
		
		// && => 예약일, 체크인
		// || => 유효성 검사
		/*
		 * 	국어, 영어 수학 입렧 => 총점, 평균
		 * 	=> int kor = 입력
		 * 	=> int eng = 입력
		 * 	=> int math = 입력
		 * 
		 * 	int total = kor+eng+math;
		 * 	double avg = total/3.0;
		 * 
		 * 	문자열 입력
		 * 	=> ABKBA  5/2 2
		 * 	
		 * 
		 */
	}

}
