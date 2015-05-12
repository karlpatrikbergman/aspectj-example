package se.patrikbergman.java.aspectj.mixin;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MixinTest {

    Logger log = LoggerFactory.getLogger(MixinTest.class);

    @Test
    public void testAndReset() {
        Band band = new Band("Saxon");
        final boolean isDirty = ((ChangeMonitorAspect.Monitorable) band).testAndReset();

        log.info(Boolean.toString(isDirty));
    }

    @Test
    public void setDirty() {
        Band band = new Band("Saxon");
        ((ChangeMonitorAspect.Monitorable) band).setDirty();
        final boolean isDirty = ((ChangeMonitorAspect.Monitorable) band).testAndReset();

        log.info(Boolean.toString(isDirty));
    }
}
