/*
 *   ** 프로그램은 데이터 관리 
 *              ---------
 *               상태 관리 : Vue , React (Front) 
 *   데이터 저장하는 방법 
 *   ----------------
 *    변수 : 데이터 한개 저장 => 데이터를 변경할 수 있다 
 *          읽기 (메모리에서 데이터를 가지고 온다)
 *          쓰기 (메모리 저장)
 *          수정 (값 수정)
 *          => 데이터형 변수명=값;
 *    상수 : 데이터 한개 저장 => 데이터 변경이 불가능 
 *          읽기 (메모리에서 데이터를 가지고 온다)
 *          쓰기 (메모리 저장)
 *             final 데이터형 변수명=값;
 *             => 변수는 소문자로 시작 
 *             => 상수는 전체 대문자
 *    ------------ 변수와 상수가 많은 경우에는 제어 
 *    배열 : 변수여러개를 한개이름으로 제어 (관리가 쉽다)
 *          => 고정적 
 *          => 같은 데이터형만 모아서 관리 
 *    클래스 => 여러개의 데이터를 저장할 수 있다 
 *             => 고정적이 아니다 (원하는 갯수만큼 저장이 가능)
 *         => 
 *            1) 데이터를 모아준다 => 한개의 대한 정보 
 *               사람 => 사람 1명에 대한 변수 
 *               학생 => 학생 1명에 대한 정보 저장 
 *               영화 => 영화정보 1개만 설계 
 *               ----------------------------
 *               저장하는 공간을 따라 만든 생성 
 *            => 데이터형 클래스 
 *            => 액션 ==> 변수/메소드 
 *    1) 예
 *         학생 
 *         ----
 *         class 학생  => 20명 => 20개를 저장하는 공간을 만든다
 *         {
 *            이름 
 *            학번
 *            학점
 *            주소
 *            전화
 *            나이
 *            ...
 *         }
 *         
 *         ==> new 
 *         ==> 다른 데이터형을 모을 수 있다 
 *    --------------- 메모리에 저장 
 *    파일 
 *    데이터베이스 
 *    --------------- 영구적인 저장 장치 
 */
/*
 *    java => 한개의 파일안에 여러개 클래스를 생성 
 *    ** public class => 한번만 사용이 가능 
 *    
 *    A.java
 *    public class A
 *    {
 *    }
 *    public class B
 *    {
 *    }
 *    ------------------- 오류 코드 
 *    A.java
 *    public class A ==> 저장명 
 *    {
 *    }
 *    class B
 *    {
 *    }
 *    
 *    A.java / B.java
 *    class A
 *    {
 *    }
 *    class B
 *    {
 *    }
 *    
 *    권장 
 *     = 클래스는 가급적인 파일을 따로 만든다 
 *     
 *     
 *     int[] kor=new int[3]
 *     int[] kor=new int[3]
 *     int[] kor=new int[3]
 *     int[] kor=new int[3]
 *     int[] kor=new int[3]
 *     int[] kor=new int[3]
 *    
 *    class Student
 *    {
 *       int kor,eng,math,total;
 *       char score;
 *       double avg;
 *    }
 */
class Student
{
	int hakbun;
	String name;
	int age;
	// 변수의 종류 
	public void aaa()
	{
		int a=10;
	}
}
public class 클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student hong=new Student();
        hong.hakbun=1;
        hong.name="홍길동";
        hong.age=20;
        //System.out.println(hong);
        /*
         *    hong => Student@4aa8f0b4
         *    ---------
         *       1 ==> hakbun
         *    ---------
         *      홍길동 ==> name
         *    ---------
         *      20    ==> age
         *    ---------
         */
        System.out.println("학번:"+hong.hakbun);
        System.out.println("이름:"+hong.name);
        System.out.println("나이:"+hong.age);
        Student shim=new Student();
        
	}

}