package es.ual.acg;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class KnxReqTest {

    @Test
    public void TestDiscoverServerPrint() {
        KnxUtils ku= new KnxUtils();
        ku.discoverServersPrint();
    }

    @Test
    public void TestDiscoverServer() {
        KnxUtils ku= new KnxUtils();
        assertNotEquals(null, ku.discoverServer());
    }

    @Test
    public void TestGroupDiscoverer(){

        KnxUtils ku= new KnxUtils();
        String address = ku.discoverServer().getHostAddress();
        ku.monitorGroups(address);
        
    }

}