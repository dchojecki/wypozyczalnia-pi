/*package wypozyczalnia.ejb.timer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

@Stateless
public class ZamowienieTimerBean implements ZamowienieTimer {

	@Resource
	TimerService timerService;
	
	public void start() {
		timerService.createTimer(10000, null);

	}
	
	@Timeout
	public void zdarzenieCzasowe(javax.ejb.Timer timer) {
		@SuppressWarnings("unused")
		Integer idZamowienia = (Integer) timer.getInfo();
		System.out.println("asdf");
	}

	public void zalegle() {
		// TODO Auto-generated method stub
		
	}

}
*/