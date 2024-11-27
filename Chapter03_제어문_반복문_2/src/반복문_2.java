/*
 *    2*1=2 3*1=3 4*1=4...9*1=9
 *    ..
 *    ..
 *    ..
 *    ..
 *    2*9=18 3*9=27  ... 9*9=81 
 *    
 *    가로 1~9 => 
 *    세로 2~9 => 8
 */
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++)
		{
			for(int j=2;j<=9;j++)
			{
				System.out.printf("%2d * %2d = %2d\t",j,i,j*i);
			}
			System.out.println();
		}
	}

}
