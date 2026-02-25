package exception;

public class Peaks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {10, 3, 12, 7, 15, 9, 2, 8, 1, 6};

        int peakCount = 0;

        System.out.println("Index\tValue\tPeak Type");

        for (int i = 1; i < values.length - 1; i++) {
            int prev = values[i - 1];
            int curr = values[i];
            int next = values[i + 1];

            if (curr >= prev + 5 && curr >= next + 5) {
                System.out.println(i + "\t" + curr + "\tTOP PEAK");
                peakCount++;
            } else if (curr <= prev - 5 && curr <= next - 5) {
                System.out.println(i + "\t" + curr + "\tBOTTOM PEAK");
                peakCount++;
            } else {
                System.out.println(i + "\t" + curr);
            }
        }

        System.out.println("\nTotal Peaks Detected: " + peakCount);

        // Visual Graph (Optional ASCII-style)
        System.out.println("\nPeak Graph:");
        for (int i = 0; i < values.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < values[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}

}
