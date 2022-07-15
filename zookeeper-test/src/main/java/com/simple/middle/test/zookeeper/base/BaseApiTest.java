package com.simple.middle.test.zookeeper.base;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 项目: pagination
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-07-15 10:16
 **/
public class BaseApiTest {

    /**
     * 连接地址
     */
    private static String connectString = "127.0.0.1:2181";

    /**
     * session过期时间
     */
    private static int sessionTimeout = 15000;

    /**
     * zk客户端
     */
    private ZooKeeper zkClient = null;


    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

                // 收到事件通知后的回调函数（用户的业务逻辑）
                System.out.println("回调函数:===> " + event.getType() + "--" + event.getPath());

                // 再次启动监听
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建子节点
     *
     * @throws Exception
     */
    @Test
    public void create() throws Exception {

        // 参数1：要创建的节点的路径； 参数2：节点数据 ； 参数3：节点权限 ；参数4：节点的类型
        String nodeCreated =
                zkClient.create("/ysq", "wcx".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取子节点
     *
     * @throws Exception
     */
    @Test
    public void getChildren() throws Exception {

        List<String> children = zkClient.getChildren("/", true);

        for (String child : children) {
            System.out.println(child);
        }

        // 延时阻塞
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void getPathValue() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte[] data = zkClient.getData("/zyy", false, stat);
        System.out.println("获取节点的值：===> " + new String(data));
    }

    @Test
    public void deleteTest() throws KeeperException, InterruptedException {
        zkClient.delete("/wcx", 0);
    }

    /**
     * 判断znode是否存在
     *
     * @throws Exception
     */
    @Test
    public void exist() throws Exception {

        Stat stat = zkClient.exists("/wcx", false);

        System.out.println(stat == null ? "not exist" : "exist");
    }
}
