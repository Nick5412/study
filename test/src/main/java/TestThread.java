import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Classname TestThread
 * @Date 7/14 014 16:09
 * @Created by Nick
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		boolean flag = true;
		int num = 0;
		TimeCountThread timeCountThread = new TimeCountThread();
		// 线程并未启动,等待cpu调度
		timeCountThread.start();
		while (flag) {
			Thread.sleep(1000);
			System.out.println(++num);
		}
	}

}

class TimeCountThread extends Thread {
	boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = format.format(date);
			System.out.println(time);
		}

	}
}