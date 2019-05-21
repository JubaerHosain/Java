package CH23.SharedBuffer;

// Buffer interface specifies method called by Producer and Consumer
public interface Buffer {
	// place into value into Buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
