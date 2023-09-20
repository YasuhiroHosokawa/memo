package com.example.memo.repository.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * メモエンティティクラス
 */
@Entity
@Table(name = "memo")
public class MemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Date createTimestamp;
    private Date updateTimestamp;

    public MemoEntity() {

    }

    public MemoEntity(Integer id, String content, Date createTimestamp, Date updateTimestamp) {
        this.id = id;
        this.content = content;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
