
public class 변수_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
//		System.out.println(a);
		
		a=200;
//		System.out.println(a);
		
		a=1000;
//		System.out.println(a);
		// 같은 블럭안에서는 같은 변수명을 사용할 수 없다
		/*
		 * 	학생 1명
		 * 	국어점수 : 90
		 * 	수학점수 : 90
		 * 	영어점수 : 90
		 * 	총점 : 270
		 * 	평균 : 90.0
		 * 	학점 : A
		 * 	등수 : 2
		 */
		
		int kor = 90, eng = 90, math = 90;
		int score = kor + eng + math;
		double avg = score/3.0;
		char grade = 'A';
		int rank = 2;
		
		System.out.println("======== 결과값 ========");
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("총점:"+score);
		System.out.println("평균:"+avg);
		System.out.println("학점:"+grade);
		System.out.println("등수:"+rank);
	}

}
