package com.example.memo.controller.view;

import com.example.memo.repository.entity.MemoEntity;
import com.example.memo.utility.DateFormat;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * メモ画面表示用クラス
 */
public class MemoView {

    /**
     * メモ一覧画面 表示用メモデータ格納クラス
     *
     * @param id メモID
     * @param content メモ内容
     * @param createDateView 作成日時
     * @param updateDateView 更新日時
     */
    public record MemoIndexView(Integer id,
                                String content,
                                String createDateView,
                                String updateDateView) {
    }

    /**
     * メモ一覧画面 表示用メモデータリスト作成メソッド
     *
     * @param memoEntityList メモデータリスト
     * @return 表示用メモデータリスト
     */
    public static List<MemoIndexView> createMemoIndexViewList(List<MemoEntity> memoEntityList) {
        return memoEntityList.stream()
                .map(memoEntity -> {
                    String content = StringUtils.isEmpty(memoEntity.getContent()) ? "空のメモです。" : memoEntity.getContent();
                    String createDateView = DateFormat.getYearToSecondDate(memoEntity.getCreateTimestamp());
                    String updateDateView = DateFormat.getYearToSecondDate(memoEntity.getUpdateTimestamp());
                    return new MemoIndexView(memoEntity.getId(), content, createDateView, updateDateView);
                }).toList();
    }

}
