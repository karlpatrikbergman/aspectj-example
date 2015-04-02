package se.patrikbergman.java.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;

@Aspect
public class ChangeMonitorAspect {

	public interface Monitorable {
		public void setDirty();
		public boolean testAndReset();
	}

	@DeclareMixin("se.patrikbergman.java.aspectj.Band")
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

	

}
