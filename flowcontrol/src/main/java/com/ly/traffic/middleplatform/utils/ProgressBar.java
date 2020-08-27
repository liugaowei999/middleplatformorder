package com.ly.traffic.middleplatform.utils;

public class ProgressBar {
    // 进度条粒度
    private static final int PROGRESS_SIZE = 50;
    private static int BITE = 2;

    private static String getNChar(int num, char ch){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < num; i++){
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void printProgress(String name) throws InterruptedException {
        System.out.print("Progress:");
        int index = 0;
        String finish;
        String unFinish;

        finish = getNChar(index / BITE, '█');
        unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');
        String target = String.format("【%s】%3d%%[%s%s]", name, index, finish, unFinish);
        System.out.print(target);

        while (index <= 100){
            reset();
            finish = getNChar(index / BITE, '█');
            unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');

            target = String.format("【%s】%3d%%├%s%s┤", name, index, finish, unFinish);
//            System.out.print(getNChar(PROGRESS_SIZE + 6, '\b'));
            System.out.print(target);

            Thread.sleep(50);
            index++;
        }
    }

    /**
     * 光标移动到行首
     */
    private static void reset() {
        System.out.print('\r');
    }

    public <T> void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) throws InterruptedException {
        ProgressBar progressBar = new ProgressBar();
        ProgressBar.printProgress("同步进度");

        progressBar.show("sss");
    }
}
