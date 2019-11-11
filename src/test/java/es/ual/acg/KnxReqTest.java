package es.ual.acg;

import es.ual.acg.utils.KnxUtils;

public class KnxReqTest {

    

    KnxUtils ku = new KnxUtils();
    String address = ku.discoverServer().getHostAddress();
    //KnxReq kr = new KnxReq();
    /*   
    @Test
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

    }

    @Test
    public void TestGetStatus() {
        
        try {
            System.out.println("The address is " +address+ " and the status is " + kr.getStatus("192.168.1.22",address, "2/0/1", "1.001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void TestSetStatus() {

             
        try {
            kr.setStatus(address, "2/0/0", "1.001","off");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    */
}