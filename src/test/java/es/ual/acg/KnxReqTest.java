package es.ual.acg;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class KnxReqTest {

    @Test
    public void TestDiscoverServerPrint() {
        KnxReq knxReq = new KnxReq();
        knxReq.discoverServerPrint();
    }

    @Test
    public void TestDiscoverServer() {
        KnxReq knxReq = new KnxReq();
        assertNotEquals(null, knxReq.discoverServer());
    }

    @Test
    public void TestGroupDiscoverer(){

        KnxProcessListener pl = new KnxProcessListener();
        pl.monitorGroups("192.168.1.149");
    }

}