package se.patrikbergman.java.aspectj.mixin;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;

@Aspect
public class ChangeMonitorAspect {

	public interface Monitorable {
		void setDirty();
		boolean testAndReset();
	}

	@DeclareMixin("se.patrikbergman.java.aspectj.mixin.Band")
	public static Monitorable createMonitorable() {
		return new Monitorable() {
			private boolean dirty = false;

			@Override
			public void setDirty() {
				dirty = true;
			}

			@Override
			public boolean testAndReset() {
				boolean returnValue = dirty;
				dirty = false;
				return returnValue;
			}
		};
	}

	@After("execution (void se.patrikbergman.java.aspectj.logging.Band.play()) && this(band)")
	public void setDirtyFlag(Band band) {
		((Monitorable) band).setDirty();
	}

}
