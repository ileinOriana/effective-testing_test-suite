package virtualecu.input;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.output.FuelInjector;

public class TestFuelInjector {
	private FuelInjector injector; 
	
	@Before
	public void setUp() {
		boolean voltageOn = true;
		injector = new FuelInjector(voltageOn);
	}
	
	@Test
	public void testInjectNormalState() {
		injector.interruptVoltage();
		injector.inject(2.4f);
        assertThat(injector.getState(), is("injecting fuel"));	
	}
	
	@Test
	public void testInjectFullState() {
		injector.interruptVoltage();
		injector.inject(2.7f);
        assertThat(injector.getState(), is("injecting fuel, full capacity"));	
	}
	
	@Test
	public void testInjectClosedState() {
		injector.inject(2.7f);
        assertThat(injector.getState(), is("fuel injector closed"));	
	}	

}
