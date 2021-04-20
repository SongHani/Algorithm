import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401_이항_계수_3 { // 210420 _ 페르마의 소정리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int P = 1000000007;
		
		System.out.println(nCr(N,R,P));
		
	}

	private static long nCr(int n, int r, int p) {
		if(r == 0)
			return 1L;
		
		long[] factorial = new long[n+1];
		factorial[0] = 1;
		
		for(int i = 1; i <= n; i++)
			factorial[i] = factorial[i-1] * i % p;
		
		return (factorial[n] *
				power(factorial[r], p-2, p) % p *
				power(factorial[n-r], p-2, p) % p)
				% p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x %= p;
		
		while(y > 0) {
			if (y % 2 != 0)
				res = (res * x) % p;
			
			y = y >> 1;
			x = (x * x) % p;
		}
		
		return res;
	}
}