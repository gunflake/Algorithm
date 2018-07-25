package september;

import java.util.Arrays;
import java.util.Comparator;

/*
 *  1보다 큰 N개의 도시 중 한 곳에 공항을 지을 예정입니다. 
 *  사람들의 편의를 위해 공항으로부터 각 사람들까지의 도시간 이동 거리가 최소가 되는 도시에 짓기로 하였습니다. 
 *  편의상 도시는 일직선상에 놓여있다고 가정하며 좌표의 범위는 음수가 포함됩니다. 또한 좌표는 정렬되어 있지 않습니다. 
 *  직선상의 위치와 그 도시에 사는 사람들의 수가 주어질 때, 공항을 지을 도시의 위치를 반환해주는 함수 chooseCity 함수를 완성하세요. 
 *  거리가 같은 도시가 2개 이상일 경우 위치가 더 작은 쪽의 도시를 선택하면 됩니다. 예를 들어 다음과 같은 정보의 도시가 있다고 가정해 봅시다.
 *  ex : {{1,5},{2,2},{3,3}};
 *  이 살 경우, 각각의 도시에 공항을 지었을 때의 사람들의 이동 거리는 8, 8, 12 이므로 
 *  1번 또는 2번에 지을 수 있지만, 1의 위치가 더 작으므로 1을 반환해주면 됩니다.
 *  
 */

public class ChooseCity {

	public int chooseCity(int n, int[][] city) {

		Arrays.sort(city, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		int start = 0;
		int end = city.length - 1;
		double standard = 0;
		while (n > 1) {

			if (n % 2 == 1) {

				if (oddValue(start, (n / 2) - 1, city[n / 2][0], city) > oddValue((n / 2) + 1, end, city[n / 2][0],
						city)) {
					end = n / 2 - 1;
					n /= 2;
				} else if (oddValue(start, (n / 2) - 1, city[n / 2][0], city) < oddValue((n / 2) + 1, end,
						city[n / 2][0], city)) {
					start = n / 2 + 1;
					n /= 2;
				} else {
					return city[n / 2][0];
				}

			} else {
				standard = (city[n / 2][0] - city[n / 2 - 1][0]) / 2;

				if (evenValue(start, n / 2 - 1, standard, city) > evenValue(n / 2, end, standard, city)) {
					end = n / 2 - 1;
					n /= 2;

				} else if (evenValue(start, n / 2 - 1, standard, city) < evenValue(n / 2, end, standard, city)) {
					start = n / 2;
					n /= 2;

				} else {
					return city[n / 2 - 1][0];
				}
			}
		}
		return city[end][0];

	}

	public double evenValue(int start, int end, double standard, int[][] city) {
		double tmp = 0;

		for (int i = start; i <= end; i++) {
			tmp += Math.abs((city[i][0] - standard)) * city[i][1];
		}
		return tmp;
	}

	public int oddValue(int start, int end, int standard, int[][] city) {

		int tmp = 0;

		for (int i = start; i <= end; i++) {
			tmp += Math.abs((city[i][0] - standard)) * city[i][1];
		}
		return tmp;
	}

	// public int chooseCity(int n, int[][] city) {
	// int result = 0;
	// int tmp = 0;
	// int answer = 0;
	// for (int i = 0; i < city.length; i++) {
	// for (int j = 0; j < city.length; j++) {
	// if (i == j)
	// continue;
	// else {
	// tmp += Math.abs((city[j][0] - city[i][0])) * city[j][1];
	// }
	// }
	// if (result > tmp) {
	// result = tmp;
	// answer = city[i][0];
	// }
	// tmp = 0;
	//
	// }
	//
	// return answer;
	// }

	public static void main(String[] args) {
		ChooseCity test = new ChooseCity();
		int tn = 7;
		int[][] tcity = { { 1, 5 }, { 10, 99 }, { 13, 3 }, { 77, 2 }, { 2, 2 }, { 3, 3 }, { 5, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}

}
