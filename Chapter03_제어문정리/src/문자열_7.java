/*
 * 	변경
 * 	= toUpperCase() : 대문자 변환
 * 	= toLowerCase() : 소문자 변환
 * 	= replace() : 지정된 데이터 변경
 * 	= repalceAll() : 전체를 변경 =====> 정규식
 * 	  맛있+
 * 	  [가-힣] => 한글 전체
 * 	  [0-9] => 숫자 전체
 * 	  [A-Za-z] => 영어 전체
 *  + : 한글자 이상
 *  * : 0글자 이상
 *  | : 선택
 *  . : 임의의 문자 한개
 *  ? : 존재여부확인
 * 	= valueOf() : 모든 데이터형을 문자열로 변환
 * 	  valueOf(10) => "10"
 * 	  => 브라우저 / 윈도우창 => TextField
 * 		 <input type="text">
 */
import javax.swing.JFrame;
import javax.swing.JTextField;

public class 문자열_7 extends JFrame{
	public 문자열_7()
	{
		JTextField tf =new JTextField();
		tf.setText(String.valueOf(100));
		add("North",tf);
		setSize(600, 480);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 문자열_7();
	}

}
