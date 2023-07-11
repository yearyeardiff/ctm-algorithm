package utils;

public class Print {
    public static void array(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void array(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ",");
        }
    }

    public static void array(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " :");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(j + " " + arr[i][j] + ",");
            }
            System.out.println();
        }
    }
}
