package com.reine.job;

import javafx.concurrent.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author reine
 * 2022/6/8 19:57
 */
public class MyTask extends Task<Number> {
    /**
     * 调用start方法时执行
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Number call() throws Exception {
        this.updateTitle("拷贝文件");
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\Users\\86158\\图片\\110300202_waifu2x_1x_3n_jpg (2).png"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\Users\\86158\\图片\\测试复制.png"));
        double max = fileInputStream.available();
        byte[] bytes = new byte[1024];
        int len = 0;
        double sum = 0;
        double progress = 0;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            if (isCancelled()) {
                break;
            }
            fileOutputStream.write(bytes, 0, len);
            sum += len;
            this.updateProgress(sum, max);
            progress = sum / max;
            if (progress < 0.5) {
                this.updateMessage("请耐心等待");
            } else if (progress < 0.8) {
                this.updateMessage("马上就好");
            } else if (progress < 1) {
                this.updateMessage("即将完成");
            } else {
                this.updateMessage("拷贝完成");
            }
            Thread.sleep(10);
        }
        fileInputStream.close();
        fileOutputStream.close();
        return 100;
    }

    @Override
    protected void updateProgress(long workDone, long max) {
        super.updateProgress(workDone, max);
    }

    @Override
    protected void updateProgress(double workDone, double max) {
        super.updateProgress(workDone, max);
    }

    @Override
    protected void updateMessage(String message) {
        super.updateMessage(message);
    }

    @Override
    protected void updateTitle(String title) {
        super.updateTitle(title);
    }

    @Override
    protected void updateValue(Number value) {
        super.updateValue(value);
        // 判断当前线程是否是fx线程
        // System.out.println(Platform.isFxApplicationThread());

    }
}
