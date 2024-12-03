import java.util.*; // 두개 이상 사용 => Scanner, Calendar
public class 배열응용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();

		System.out.print("월 입력:");
		int month=scan.nextInt();
	
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		Calendar cal=Calendar.getInstance();
		// Calendar => 추상 크래스 => new를 사용하지 못한다.
		// 전년도까지 날 수
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); // 0부터
		cal.set(Calendar.DATE, day);
		
		char[] strWeek = {' ','일','월','화','수','목','금','토'};
		// week=0, week=1 => week=1번부터
		// 요일 구하기
		int week=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(year+"년도 "+
				+month+"월 "+day+"일은 "+strWeek[week]+"요일입니다");
		// 입력달의 마지막 날
		int lastday=cal.getActualMaximum(Calendar.DATE);
		System.out.println("마지막 날:"+lastday);
	}

}
