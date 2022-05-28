import java.util.List;

public class SprawdzanieThread extends Thread{
	
	private List<KoloThread> kolaThread;
	private long czasOdswiezania;
	
	public SprawdzanieThread(long czasOdswiezania, List<KoloThread> kolaThread) {
		this.czasOdswiezania = czasOdswiezania;
		this.kolaThread = kolaThread;
	}
	
	@Override
	public void run() {
		for(KoloThread koloThread1 : kolaThread) {
			for(KoloThread koloThread2 : kolaThread) {
				
			}
		}
	}
	
	private void sprawdzKola(Kolo kolo1, Kolo kolo2) {
		
	}

}
