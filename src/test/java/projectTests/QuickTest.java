package projectTests;

import org.testng.annotations.Test;

public class QuickTest extends TestBase{

    @Test(groups = {"web","rest"})
    public void quickTest(){
        System.out.println("Im Quick test");
        logger.info("Test passed");
    }
}