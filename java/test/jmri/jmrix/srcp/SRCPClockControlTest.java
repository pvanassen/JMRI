package jmri.jmrix.srcp;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SRCPClockControlTest.java
 *
 * Description:	tests for the jmri.jmrix.srcp.SRCPClockControl class
 *
 * @author	Bob Jacobsen
 * @version $Revision$
 */
public class SRCPClockControlTest extends TestCase {

    public void testCtor() {
        SRCPBusConnectionMemo sm = new SRCPBusConnectionMemo(new SRCPTrafficController() {
            @Override
            public void sendSRCPMessage(SRCPMessage m, SRCPListener reply) {
            }
        }, "A", 1);
        SRCPClockControl m = new SRCPClockControl(sm);
        Assert.assertNotNull(m);
    }

    // from here down is testing infrastructure
    public SRCPClockControlTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {"-noloading", SRCPClockControlTest.class.getName()};
        junit.swingui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(SRCPClockControlTest.class);
        return suite;
    }

    // The minimal setup for log4J
    @Override
    protected void setUp() {
        apps.tests.Log4JFixture.setUp();
    }

    @Override
    protected void tearDown() {
        apps.tests.Log4JFixture.tearDown();
    }
    private final static Logger log = LoggerFactory.getLogger(SRCPClockControlTest.class.getName());
}
