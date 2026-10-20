package com.openatom.recruit.task03;

public class ScoreEvaluator {

    /**
     * 完成成绩判定
     * 方式一：if-else 区间判断，适合表示"范围"。
     */
    public String gradeByIfElse(int score) {
        if (score < 0 || score > 100) {
            return "分数不合法";
        }
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "E";
        }
    }

    /**
     * 方式二：switch 无法直接判断区间，这里借助整数除法 score / 10 取整，
     * 把 0-100 的分数压缩成 0-10 的档位，再用 case 匹配。
     */
    public String gradeBySwitch(int score) {
        if (score < 0 || score > 100) {
            return "分数不合法";
        }
        switch (score / 10) {
            case 10:    // 100 分
            case 9:     // 90-99 分
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
            default:    // 0-59 分（swictch语句中default是兜底，所有case都不匹配时执行）
                return "E";
        }
    }
}
