package com.reine.job;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.*;

/**
 * @author reine
 * 2022/6/14 17:23
 */
public class DataTask extends ScheduledService<List<Map<String, Integer>>> {

    private int series0 = 0;
    private int series1 = 0;

    @Override
    protected Task<List<Map<String, Integer>>> createTask() {
        return new Task<List<Map<String, Integer>>>() {
            @Override
            protected List<Map<String, Integer>> call() throws Exception {
                Random random = new Random();
                Map<String, Integer> map1 = new HashMap<>();
                Map<String, Integer> map2 = new HashMap<>();
                int value1 = random.nextInt(100);
                int value2 = random.nextInt(100);
                map1.put("seriesName", 0);
                map1.put("x", series0);
                map1.put("y", value1);
                map2.put("seriesName", 1);
                map2.put("x", series1);
                map2.put("y", value2);
                series0++;
                series1++;
                List<Map<String, Integer>> list = new ArrayList<>();
                list.add(map1);
                list.add(map2);
                return list;
            }
        };
    }

    @Override
    public void reset() {
        super.reset();
    }

    public void resetData() {
        series0 = 0;
        series1 = 1;
    }
}
