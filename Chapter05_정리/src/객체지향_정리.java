/*
 *    1. 클래스 구조 
 *       클래스는 객체를 생성하기 위한 설계 
 *              --- 속성 / 동작 
 *                  (변수) (메소드)
 *       class ClassName
 *       {
 *          -----------------------
 *          변수
 *           = 멤버변수 (인스턴스) : 객체 생성시마다 메모리에 따로 저장 
 *           = 정적변수 (static) : 메모리 공간 1개 생성 
 *                               => 모든 객체가 공유해서 사용
 *           형식)
 *                멤버변수 
 *                [접근지정어] 데이터형 변수명;
 *                ---------- 데이터 보호 (정보은닉) => private
 *                정적변수 
 *                [접근지정어]static 데이터형 변수명;
 *                
 *          영화 프로그램 
 *          -----------
 *            ------- 인스턴스 ****** 관련된 데이터나 기능을 모아서 메모리에 저장후 사용
 *            영화명 
 *            장르 
 *            개봉일 
 *            출연 
 *            등급 
 *            감독 
 *            줄거리
 *            평점  
 *            ------
 *            로고 => 공통 => static => 오라클 (공유된 데이터)
 *            사이트 => 출력하는 모든 데이터는 오라클 
 *                    => 데이터 수집후에 처리 
 *                    => 사이트에서 파일입출력 : 다운로드/업로드 
 *             | 웹개발 : => 자바/오라클 => Back-End
 *                         ----------------------
 *                         => Front-End : 자바스크립트 
 *                                        | => 언어 
 *                         => 타입스크립트 => 자바스크립트 변환 
 *                            --------------------------
 *                            NodeJS : 서버측 사이드 
 *                            ------
 *          -----------------------
 *          생성자 : 멤버변수 설정 => 초기화 
 *                 ------- 기본값이 설정 (int=0,long=0L,double=0.0,String=null,boolean=false)
 *                  초기화 
 *                  1) 명시적 초기값 : 임의로 설정 
 *                     ----------- class 영역은 선언만 하는 영역
 *                  2) 구현후에 초기화 : 파일읽기 / 데이터베이스 
 *                     연산자 / 제어문 ... 구현 => 클래스 영역에서 설정이 불가능
 *                     = 생성자 : 인스턴스변수/static변수 설정이 가능
 *                               ------------------- 
 *                     = 인스턴스 블럭 : 인스턴스변수/static변수 설정이 가능
 *                                    -------------------
 *                     = static 블럭 : static변수 설정이 가능 
 *                        => static => 사용이 가능 (static만 가능)
 *                                     객체 생성후 사용 
 *                                     
 *                     => 특별한 경우가 아니면 => 생성자를 주로 이용한다 
 *                        --------
 *                        | static변수 => 목록(배열/클래스)
 *                        | mybatis => 데이터베이스 연동 
 *             생성자 특징 
 *               = 클래스명과 동일 
 *               = 오버로딩이 가능 
 *                 ------
 *                  => 메소드명이 동일 
 *                  => 리턴형은 관계없다 
 *                  => 매개변수가 다르다(데이터형,갯수)
 *                  => 접근지정어도 관련없다 
 *               = 리턴형이 없다 (void => 리턴형이다)
 *                 class A
 *                 {
 *                    void A(){} => 일반 메소드 
 *                    A(){}==> 생성자
 *                 } 
 *               = 다른 클래스 사용이 가능 => public 
 *               *** 생성자가 없는 경우에는 컴파일러에 의해 디폴트 생성자 추가 
 *               *** 디폴트 생성자는 매개변수가 없다 
 *                   A() ...
 *               class A
 *               {
 *                   A(int a){} // 추가가 안된다 
 *                   매개변수가 있는 것도 생성자 
 *               }     
 *               class A
 *               {
 *                 // 추가
 *               }  
 *          -----------------------
 *          메소드 : 동작 , 행위 => 기능처리 
 *                  => 데이터 결과값 전송 
 *                  => 다른 클래스와 연결 
 *          형식)
 *               [접근지정어] 리턴형 메소드명(매개변수...) => 선언부
 *                         ------
 *               ---------- public 
 *               {
 *                  => 구현부 
 *                  return 값
 *                         ---
 *                  *** void일때는 return 생략이 가능 
 *                      => 컴파일러에 의해 자동 추가
 *                      => return은 메소드가 종료
 *               }
 *          -----------------------
 *          메소드는 사용자 정의시에는 반드시 호출 
 *          인스턴스 
 *             객체명.메소드(값...)
 *             => 다른 클래스에 사용시에는 객체를 생성한 후에 접근
 *                Scanner scan=new Scanner()
 *             => scan.nextInt()
 *          static 
 *             클래스명.메소드(값...) => 자동 메모리 할당 
 *             => Math.random()
 *       }
 *    2. 멤버변수 
 *   ------------------------------------------
 *   멤버변수 : Heap영역 => 클래스 종료시까지 사용 
 *            => 클래스에 있는 모든 곳에서 사용 가능 
 *            => 다른 클래스 사용 가능 
 *            => 생성 : new를 이용해서 객체생성 
 *   ------------------------------------------
 *   정적변수 : MethodArea
 *            => 클래스 전체 영역에서 사용 
 *            => 다른 클래스에서 사용 가능 
 *            => 생성 : 컴파일시에 자동 생성 
 *   ------------------------------------------
 *   지역변수 : Stack => 메모리 자체 관리 => {} 자동으로 사라진다
 *   매개변수  => 메소드 호출시 생성 
 *           => 메소드안에서만 사용이 가능 
 *   ------------------------------------------
 *    5. 접근지정어 => 127page
 *       클래스,메소드,멤버변수만 사용이 가능 / 지역변수에서는 사용이 불가능 
 *                                      ------- final 
 *       private : 자신의 클래스에서만 사용이가능 
 *                 은닉화 => 모든 멤버변수는 private
 *       public : 모든 클래스에서 사용이 가능 
 *                => 클래스 , 메소드 , 생성자 
 *                
 *       protected : 같은 패키지안에서만 사용이 가능 
 *                   다른 패키지 => 상속받은 클래스 
 *                   => 사용빈도 거의 없다 
 *       default : 같은 패키지에서만 사용이 가능 
 *                 윈도우 => 버튼 , 편집기
 *       
 *       ** public : 클래스는 필요시 모든 클래스에서 사용이 가능
 *                   생성자 , 메소드 
 *       ** private : 멤버변수 => 은닉화 
 *       
 *       ** 접근 범위 
 *          private < default < protected < public 
 *          => 오버라이딩 
 *             => 접근지정어의 확장은 가능 / 축소는 할 수 없다 
 *       ===> 객체지향의 3대 특성 
 *            1) 캡슐화 : 개인 정보 보호 
 *               => 변수 : private 
 *               => 변수의 기능을 추가 => getter/setter
 *            ----------------------------------------
 *            2) 상속 / 포함 : 재사용 기법 / 중복코드를 제거
 *               is-a  has-a  
 *               => 소스를 볼 수 없다 => 가독성이 낮다 
 *               => 속도가 느려진다 
 *               => 변경이 어렵다 => 다른 클래스에 영향이 있다
 *               => 형변환 
 *               => 클래스는 크기를 잴 수 없다 
 *               class 개
 *               {
 *                  int a,b;
 *               }
 *               class 소
 *               {
 *                  int a,b,c,d
 *               }
 *               
 *               class 동물
 *               {
 *               }
 *               class 개 extends 동물 
 *               {
 *               }
 *               
 *               동물 > 개 ==> is-a
 *            3) 기능 변경 / 기능 추가 
 *               오버라이딩   오버로딩 ==> 다형성 
 *            ----------------------------------------
 *    6. 캡슐화 : 데이터 보호 => 데이터를 감춘다 : private 
 *              => 필요시에 사용 => 메소드를 이용해서 사용 
 *                 => 저장 : setter , 읽기 : getter
 *                    ---------------------------
 *                    | 152page
 *    7. 패키지 : 폴더개념 : 관련된 클래스를 모아서 검색이 쉽게..
 *               => 132page
 *              다른 패키지에서 사용 => import 
 *                                 --------
 *                                 1. 라이브러리 
 *                                 2. 사용자 정의 클래스
 *                                 3. 같은 패키지에서는 import를 사용하지 않는다
 *                  => 패키지명에 키워드는 사용이 불가능 
 *                     com.sist.int
 *                  => 소문자로 사용 (대문자(X))
 *                  => 공백이 있으면 안된다 
 *                  => 특수문자 사용 불가능 
 *                  => 클래스 분리 
 *                  => 네트워크 
 *                     client / server / commons 
 *                     웹 
 *                      admin / user
 *                  => com(org).회사명.종류
 *                                   ---- vo,dao,io
 *    8. static을 사용시에 주의점 => 178page
 *       static 메소드 안에서 
 *       -----------------
 *         1) static 변수 사용이 가능 
 *         2) static 메소드 호출이 가능 => 인스턴스는 반드시 객체 생성 
 *         3) this,this() 사용이 불가능 
 *            ----------- 인스턴스 메소드 / 생성자 
 *            this : 자신의 객체주소를 가지고 있다 
 *                   => 인스턴스변수 / 지역변수 구분시에 주로 사용
 *                   => 윈도우 => 현재 실행중인 원도우를 전송 
 *                              ---------------- this
 *            this()는 생성자 안에서만 사용이 가능 
 *                    생성자안에서 다른 생성자를 호출할때 사용 
 *                    => 생성자 첫번째 위치 
 *       static{}을 사용하는 방법 => 
 *            static변수로 배열/클래스=> 초기화시에 주로 사용
 *                           ----- 라이브러리 (MyBatis)
 *                       ---목록 
 *            => 블럭안에서는 static만 초기화가 가능 
 *            
 *       => 118page ~ 121page 
 *       => 122page => 객체 생성  => new 생성자()
 *       => 123page => 메모리 저장 
 *          class A
 *          {
 *             int a,b;
 *          }
 *          A aa=new A()
 *          Stack 
 *          --aa--
 *           0x100        Heap
 *          ------    0x100--------
 *                           0 => a
 *                         --------
 *                           0 => b
 *                         --------
 *          객체생성 => 클래스 객체명=new 생성자()
 *                    ----------------------
 *                    클래스 객체명;
 *                    객체명=new 생성자()
 *          객체 => 메모리 주소를 저장 
 *          참조 => 125page 
 *          class A
 *          
 *          A a=new A();
 *          A b=a;  =====> a와 b는 같은 메모리 제어 
 *                                ----------
 *                                Call By Reference 
 *          => 메소드의 매개변수 이용
 *          
 *    ----------------------
 *    6장 상속 / ***포함 / 클래스 종류 (7장 추상클래스 / ***인터페이스)
 *     | 오버라이딩 
 *    8장 : 예외처리 
 *    -------------------------- 자바 문법 
 *    9장 : java.lang / java.util (***Collection)
 *    10장 : **java.io / java.net / java.text
 *    11장 ~ 12장 => **java.sql 
 *                  --------- 오라클 연동 
 */
public class 객체지향_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // return;
	}

}