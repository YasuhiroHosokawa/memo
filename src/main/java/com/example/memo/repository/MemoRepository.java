package com.example.memo.repository;

import com.example.memo.repository.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * メモリポジトリインターフェース
 */
@Transactional
@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, String> {

    /**
     * メモ取得（全抽出）メソッド
     *
     * @return メモデータリスト
     */
    @Query(value = "SELECT * FROM memo ORDER BY update_timestamp DESC", nativeQuery = true)
    List<MemoEntity> selectMemo();

    /**
     * メモ取得（id指定）メソッド
     *
     * @param id メモID
     * @return メモデータ
     */
    @Query(value = "SELECT * FROM memo WHERE id = ?1", nativeQuery = true)
    MemoEntity selectMemoById(Integer id);

    /**
     * メモ作成メソッド
     *
     * @param content メモ内容
     */
    @Modifying
    @Query(value = "INSERT INTO memo (content) VALUES (?1)", nativeQuery = true)
    void insertMemo(String content);

    /**
     * メモ更新メソッド
     *
     * @param content メモ内容
     * @param id メモID
     */
    @Modifying
    @Query(value = "UPDATE memo SET content = ?1, update_timestamp = CURRENT_TIMESTAMP WHERE id = ?2", nativeQuery = true)
    void updateMemo(String content, Integer id);

    /**
     * メモ削除メソッド
     *
     * @param id メモID
     */
    @Modifying
    @Query(value = "DELETE FROM memo WHERE id = ?1", nativeQuery = true)
    void deleteMemo(Integer id);

}
