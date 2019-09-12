package es.ual.acg;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class KnxReqTest {

    /* @Test
    public void TestDiscoverServerPrint() {
        KnxUtils ku = new KnxUtils();
        ku.discoverServersPrint();
    }

    @Test
    public void TestDiscoverServer() {
        KnxUtils ku = new KnxUtils();
        assertNotEquals(null, ku.discoverServer());
    }

    @Test
    public void TestGroupDiscoverer() {

        KnxUtils ku = new KnxUtils();
        String address = ku.discoverServer().getHostAddress();
        ku.monitorGroups(address);

    } */

    @Test
    public void TestGetStatus() {

        KnxReq kr = new KnxReq();
        KnxUtils ku = new KnxUtils();
        String address = ku.discoverServer().getHostAddress();
        try {
            System.out.println(kr.getStatus(address, "2/0/1", "1.001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void TestSetStatus() {

        KnxReq kr = new KnxReq();
        KnxUtils ku = new KnxUtils();
        String address = ku.discoverServer().getHostAddress();
        try {
            kr.setStatus(address, "2/0/0", "1.001","off");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}