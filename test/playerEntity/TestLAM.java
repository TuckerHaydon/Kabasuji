package playerEntity;

import static org.junit.Assert.*;
import java.util.Hashtable;
import setup.Setup;
import org.junit.Test;
import junit.framework.TestCase;
import playerEntity.LightningAchievementMonitor;

public class TestLAM extends TestCase{
	LightningAchievementMonitor LAM;
	
	protected void setUp() {
		Hashtable<String, Achievement> achievements = Setup.createNewAchievementsList();
		
	}
	
	protected void tearDown(){
		
	}
}
