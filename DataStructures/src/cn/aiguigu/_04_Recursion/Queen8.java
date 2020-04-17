package cn.aiguigu._04_Recursion;

public class Queen8 {
    public int MAX_DIMENSION = 8;
    public int[] array = new int[MAX_DIMENSION];
    public static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }

    /**
     * 写一个方法输出皇后的位置
     */
    private void render() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 检测放下的皇后是否和现有的皇后冲突
     * @param index 第index个皇后，index实际上是数组array的下标
     * @return
     */
    private boolean isValidPosition(int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == array[index] || Math.abs(index - i) == Math.abs(array[index] - array[i])) {
                //array[i] == array[index]：
                //表示是否在同一列
                //Math.abs(index - i) == Math.abs(array[index] - array[i])：
                //行差等于列差，即落在了45°角位置，落在了同一斜线
                return false;
            }
        }
        return true;
    }
    private void check(int index) {
        //index用于控制纵向
        if (index == MAX_DIMENSION) {
            this.render();
            count++;
            return;
        }
        for (int i = 0; i < MAX_DIMENSION; i++) {   //i用于判断横向
            //先把当前这个皇后放到该行的第一列
            array[index] = i;
            if (this.isValidPosition(index)) {
                this.check(index + 1);
            }
        }
    }
}
