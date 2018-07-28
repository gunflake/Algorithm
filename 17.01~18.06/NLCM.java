package september;

/*
 *  n개의 숫자가 입력되었을 때, 최소공배수를 반환해 주세요. 예를들어 [2,6,8,14] 가 입력된다면 168을 반환해 주면 됩니다.
 */

public class NLCM {
	 public long nlcm(int[] num) {
	        long answer = 0;
	        long l = num[0];

	        for(int i=0;i<num.length-1;i++){
	            l = lcm(l,num[i+1]);
	        }
	        answer = l;

	        return answer;
	    }

	    public long lcm(long a,long b){
	        long lcm = a*b;
	        long tmp;

	        while(b%a != 0){
	            tmp = b;
	            b = a;
	            a = tmp%a;

	        }

	        return lcm/a;
	    }

	public static void main(String[] args) {
		NLCM c = new NLCM();
		int[] ex = {6, 2};
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.nlcm(ex));
	}
}
