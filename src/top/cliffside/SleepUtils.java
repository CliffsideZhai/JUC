package top.cliffside;

import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2021-05-22 14:33
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
