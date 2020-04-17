package cn.aiguigu._04_Recursion;

import org.jetbrains.annotations.NotNull;

/**
 * 小球迷宫问题
 */
public class Maze {
    public static int MAZE_HEIGHT = 8;  //迷宫高度
    public static int MAZE_WIDTH = 7;   //迷宫宽度

    public static int HAVENT_TRY = 0;   //还没尝试过的路
    public static int WALL = 1;         //墙
    public static int CAN_MOVE = 2;     //尝试过的可以走的路
    public static int CAN_NOT_MOVE = 3; //尝试过的不能走的路

    public static int START_HEIGHT = 1; //起点纵坐标
    public static int START_WIDTH = 1;  //起点横坐标
    public static int END_HEIGHT = 6;   //终点纵坐标
    public static int END_WIDTH = 5;    //终点横坐标

    public static void main(String[] args) {
        int[][] maze = initMaze();
        addBarrier(maze);
        render(maze);
        setWay(maze, START_HEIGHT, START_WIDTH);
        render(maze);
    }

    /**
     * 添加墙，自行设置
     *
     * @param maze
     */
    public static void addBarrier(int[][] maze) {
        maze[3][1] = 1;
        maze[3][2] = 1;
        //我自己添加的：
//        maze[2][4] = 1;
//        maze[3][4] = 1;
//        maze[4][4] = 1;
//        maze[5][4] = 1;
//        maze[6][4] = 1;
    }

    /**
     * 渲染迷宫
     *
     * @param maze
     */
    public static void render(int[][] maze) {
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 初始化迷宫墙壁，如果需要障碍，可以自行设置
     *
     * @return 四周有围墙的迷宫
     */
    public static int[][] initMaze() {
        int[][] maze = new int[MAZE_HEIGHT][MAZE_WIDTH];
        for (int height = 0; height < MAZE_HEIGHT; height++) {
            for (int width = 0; width < MAZE_WIDTH; width++) {
                if (height == 0 || height == MAZE_HEIGHT - 1) {
                    maze[height][width] = 1;
                    continue;
                }
                maze[height][0] = 1;
                maze[height][MAZE_WIDTH - 1] = 1;
                width = MAZE_WIDTH - 1;
            }
        }
        return maze;
    }

    /**
     * public static int HAVENT_TRY = 0;   //还没尝试过的路
     * public static int WALL = 1;         //墙
     * public static int CAN_MOVE = 2;     //尝试过的可以走的路
     * public static int CAN_NOT_MOVE = 3; //尝试过的不能走的路
     *
     * @param maze 表示迷宫
     * @param i    从哪个位置开始找（纵向坐标）
     * @param j    从哪个位置开始找（横向坐标）
     * @return 找到返回true，找不到返回false
     */
    public static boolean setWay(@NotNull int[][] maze, int i, int j) {
        if (maze[END_HEIGHT][END_WIDTH] == CAN_MOVE) {
            return true;
        }
        //走完第一个if后，这里可能等于1，2，3
        //为啥2也要false：这里是2说明这一步已经尝试过了，就没必要再尝试了
        if (maze[i][j] != HAVENT_TRY) {
            return false;
        }
        //现在剩下的就是没尝试过的：0
        //按照策略走：下右上左
        maze[i][j] = CAN_MOVE;  //假定可以走通
        if (setWay(maze, i + 1, j)) {
            return true;
        }
        if (setWay(maze, i, j + 1)) {
            return true;
        }
        if (setWay(maze, i - 1, j)) {
            return true;
        }
        if (setWay(maze, i, j - 1)) {
            return true;
        }
        maze[i][j] = CAN_NOT_MOVE;
        return false;
    }
}
