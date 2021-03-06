import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

import java.text.Format;
import java.text.SimpleDateFormat;

public class Sender extends Verticle {

    private Format format = new SimpleDateFormat("HH:mm:ss.SSS");

    public void start() {
	// Publish some news on the feed every second
	
	vertx.setPeriodic(1000, new Handler<Long>() {
		@Override
		    public void handle(Long timerID) {
		    String str = format.format(new java.util.Date());
		    System.out.println("Publishing @ " + str);
		    vertx.eventBus().publish("news-feed", "News from Java @ " + str);
		}
	    });
    }
}
