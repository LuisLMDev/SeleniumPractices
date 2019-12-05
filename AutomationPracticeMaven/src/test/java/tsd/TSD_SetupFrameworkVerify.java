package tsd;

import bsn.BSN_Registry;
import master.TestDriverAbs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TSD_SetupFrameworkVerify extends TestDriverAbs {

    @Test
    public void prueba_farmework() {
        System.out.println("Setup ok");
        BSN_Registry registry = new BSN_Registry(driver,baseUrl);
        registry.Run();
        Assert.assertTrue(registry.passed, registry.defect);
    }
}
