// 1~100 사이의 3의배수의 합, 5의 배수의 합, 7의 배수의 합
public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a3=0,a5=0,a7=0;
        for(int i=1;i<=100;i++)
        {
        	if(i%3==0) //3의 배수라면  i=15 
        		a3+=i;
        	if(i%5==0)
        		a5+=i;
        	if(i%7==0)
        		a7+=i;
        }
        System.out.println("1~100 사이의 3의 배수합:"+a3);
        System.out.println("1~100 사이의 5의 배수합:"+a5);
        System.out.println("1~100 사이의 7의 배수합:"+a7);
	}

}
