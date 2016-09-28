package com.fengqiliu.test.zookeeper;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuFengqi on 2016/9/27.
 */
public class CuratorUtil {
    private CuratorFramework client;

    public CuratorUtil(String zkAddress) {
        client = CuratorFrameworkFactory.newClient(zkAddress, new ExponentialBackoffRetry(1000, 3));
        client.getCuratorListenable().addListener(new NodeEventListener());
        client.start();
    }


    /**
     * 创建node
     *
     * @param nodeName
     * @param value
     * @return
     */
    public boolean createNode(String nodeName, String value) {
        boolean suc = false;
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat == null) {
                String opResult = null;
                if (Strings.isNullOrEmpty(value)) {
                    opResult = getClient().create().creatingParentsIfNeeded().forPath(nodeName);
                } else {
                    opResult = getClient().create().creatingParentsIfNeeded()
                            .forPath(nodeName, value.getBytes(Charsets.UTF_8));
                }
                suc = Objects.equal(nodeName, opResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suc;
    }

    public void createNodeDirect(String nodeName, String value) throws Exception {
        String result = getClient().create().creatingParentsIfNeeded()
                .forPath(nodeName, value.getBytes(Charsets.UTF_8));
        System.out.println(result);
    }


    /**
     * 更新节点
     *
     * @param nodeName
     * @param value
     * @return
     */
    public boolean updateNode(String nodeName, String value) {
        boolean suc = false;
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {
                Stat opResult = getClient().setData().forPath(nodeName, value.getBytes(Charsets.UTF_8));
                suc = opResult != null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suc;
    }

    public void updateNodeDirect(String nodeName, String value) throws Exception {
        Stat result = getClient().setData().forPath(nodeName, value.getBytes(Charsets.UTF_8));
        System.out.println(result.getVersion());
    }

    /**
     * 删除节点
     *
     * @param nodeName
     */
    public void deleteNode(String nodeName) {
        try {
            getClient().delete().deletingChildrenIfNeeded().forPath(nodeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 找到指定节点下所有子节点的名称与值
     *
     * @param node
     * @return
     */
    public Map<String, String> listChildrenDetail(String node) {
        Map<String, String> map = Maps.newHashMap();
        try {
            GetChildrenBuilder childrenBuilder = getClient().getChildren();
            List<String> children = childrenBuilder.forPath(node);
            GetDataBuilder dataBuilder = getClient().getData();
            if (children != null) {
                for (String child : children) {
                    String propPath = ZKPaths.makePath(node, child);
                    map.put(child, new String(dataBuilder.forPath(propPath), Charsets.UTF_8));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 列出子节点的名称
     *
     * @param node
     * @return
     */
    public List<String> listChildren(String node) {
        List<String> children = Lists.newArrayList();
        try {
            GetChildrenBuilder childrenBuilder = getClient().getChildren();
            children = childrenBuilder.forPath(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return children;
    }


    /**
     * 增加监听
     *
     * @param node
     * @param isSelf true 为node本身增加监听 false 为node的子节点增加监听
     * @throws Exception
     */
    public void addWatch(String node, boolean isSelf) throws Exception {
        if (isSelf) {
            getClient().getData().watched().forPath(node);
        } else {
            getClient().getChildren().watched().forPath(node);
        }
    }


    /**
     * 增加监听
     *
     * @param node
     * @param isSelf  true 为node本身增加监听 false 为node的子节点增加监听
     * @param watcher
     * @throws Exception
     */
    public void addWatch(String node, boolean isSelf, Watcher watcher) throws Exception {
        if (isSelf) {
            getClient().getData().usingWatcher(watcher).forPath(node);
        } else {
            getClient().getChildren().usingWatcher(watcher).forPath(node);
        }
    }


    /**
     * 增加监听
     *
     * @param node
     * @param isSelf  true 为node本身增加监听 false 为node的子节点增加监听
     * @param watcher
     * @throws Exception
     */
    public void addWatch(String node, boolean isSelf, CuratorWatcher watcher) throws Exception {
        if (isSelf) {
            getClient().getData().usingWatcher(watcher).forPath(node);
        } else {
            getClient().getChildren().usingWatcher(watcher).forPath(node);
        }
    }


    /**
     * 销毁资源
     */
    public void destory() {
        if (client != null) {
            client.close();
        }
    }


    /**
     * 获取client
     *
     * @return
     */
    public CuratorFramework getClient() {
        return client;
    }

}


// 监听器
final class NodeEventListener implements CuratorListener {
    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
        System.out.println(event.toString() + ".......................");
        final WatchedEvent watchedEvent = event.getWatchedEvent();
        if (watchedEvent != null) {
            System.out.println(watchedEvent.getState() + "=======================" + watchedEvent.getType());
            if (watchedEvent.getState() == KeeperState.SyncConnected) {
                switch (watchedEvent.getType()) {
                    case NodeChildrenChanged:
                        // TODO
                        break;
                    case NodeDataChanged:
                        // TODO
                        break;
                    default:
                        break;
                }
            }
        }
    }


}