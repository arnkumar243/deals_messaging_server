package com.messaging.pubsubservice.health.service;

import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class HealthService {

    public Map<String, Object> getHealth() {

        Map<String, Object> utilizationMap = new HashMap<String, Object>();

        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = bean.getHeapMemoryUsage();
        long used = usage.getUsed();
        long max = usage.getMax();
        double memory_utilization = ((double)used / max) * 100;
        utilizationMap.put("memory_utilization", memory_utilization);

        Path path = Paths.get("/");
        FileStore store;
        try {
            store = Files.getFileStore(path);
            long totalSpace = store.getTotalSpace();
            long usableSpace = store.getUsableSpace();
            double disk_utilization = ((double)(totalSpace - usableSpace) / totalSpace) * 100;

            utilizationMap.put("disk_utilization", disk_utilization);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return utilizationMap;
    }

}
