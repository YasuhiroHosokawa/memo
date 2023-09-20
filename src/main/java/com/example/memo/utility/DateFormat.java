package com.example.memo.utility;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * 日時形式クラス
 */
public class DateFormat {
    private static final FastDateFormat yearToSecondFormat = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

    /**
     * 日付型を文字型"yyyy/MM/dd HH:mm:ss"に変換し、取得するメソッド
     *
     * @param timeStamp 日時
     * @return 文字型"yyyy/MM/dd HH:mm:ss"
     */
    public static String getYearToSecondDate(Date timeStamp) {
        try {
            return yearToSecondFormat.format(timeStamp);
        } catch (Exception e) {
            return "";
        }
    }

}
