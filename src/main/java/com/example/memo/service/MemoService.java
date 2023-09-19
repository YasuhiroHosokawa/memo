package com.example.memo.service;

import com.example.memo.repository.MemoRepository;
import com.example.memo.repository.entity.MemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * メモサービスクラス
 */
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /**
     * メモ取得（全抽出）メソッド
     *
     * @return メモデータリスト
     */
    public List<MemoEntity> getAllMemo() {
        return memoRepository.selectMemo();
    }


    /**
     * メモ取得（id指定）メソッド
     *
     * @param id メモID
     * @return メモデータ
     */
    public MemoEntity getMemo(int id) {
        return memoRepository.selectMemoById(id);
    }

    /**
     * メモ作成メソッド
     *
     * @param memoEntity メモデータ
     */
    public void createMemo(MemoEntity memoEntity) {
        memoRepository.insertMemo(memoEntity.getContent());
    }

    /**
     * メモ更新メソッド
     *
     * @param memoEntity メモデータ
     */
    public void updateMemo(MemoEntity memoEntity) {
        memoRepository.updateMemo(memoEntity.getContent(), memoEntity.getId());
    }

    /**
     * メモ削除メソッド
     *
     * @param id メモID
     */
    public void deleteMemo(int id) {
        memoRepository.deleteMemo(id);
    }

}
