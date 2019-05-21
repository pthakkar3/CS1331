public class Recitation3 {
	public static void main(String[] args) {
		/*
		Array indexing
		have to set length = fixed
		everything is the same type
		EDIT: it's not an object
		dynamic allocation
		*/
		String[] arr1 = {"hi", "hello", "hullo"};
		//String arr2[], my_str;
		//arr1.length;
		for (int i=arr1.length-1; i>=0 ; i--) {
			System.out.println(arr1[i]);
			//arr1[i] = "wassup";
		}
		for (String s : arr1) {
			System.out.println(s);
		}
		int var = -2;
		int[] scores = new int[-5 * var];
		
		//System.out.println(scores[-1]);

		//scores = new String[5];
		
		System.out.println(sum(1, 2, 3, 4, 5));

		int[][] matrix = new int[5][5];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = i * j;
				System.out.println(matrix[i][j]);
			}
		}
		
		// array that holds 5 int arrays
		// but each spot is null
		int[][] jagged = new int[5][];
		for (int i = 0; i<jagged.length; i++) {
			jagged[i] = new int[i+3];
		}
		for (int i=0; i<jagged.length; i++) {
			for (int j=0; j<jagged[i].length; j++) {
				jagged[i][j] = i * j;
				System.out.println(jagged[i][j]);
			}
		}

		String[] arr3 = {"a", "b", "c"};
		String[] arr4 = new String[arr3.length];
		//arr4 = arr3;
		for(int i=0; i<arr4.length; i++) {
			arr4[i] = new String(arr3[i]);
		}
	}
	
	public static int sum(int x, int ... numbers) {
		int result = x;
		for (int i : numbers) {
			result += i;
		}
		return result;
	}
}



