import java.util.Random;

public class SimpleArray {
    private final int array[];
    private int writeIndex = 0;
    private final static Random generator = new Random();

    public SimpleArray(int size) {
        array = new int[size];
    }

    public void add(int value) {
        int pos = writeIndex;
        try {
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        array[pos] = value;
        System.out.printf("%s wrote %2d to element %d", Thread.currentThread().getName(), value, pos);

        ++writeIndex;
        System.out.println("Next Write index: " + writeIndex);
    }

    public String toString() {
        String arrayString = "\nContents of SimpleArray:\n";
        for(int i = 0; i < array.length; i++)
            arrayString += array[i] + " ";
        return arrayString;
    }
}
