package com.example.memo.controller.view;

/**
 * メモ画面処理表示用クラス
 */
public class ProcessType {

    private int code;
    private String processName;
    private String actionName;
    public static final int INDEX_CODE = 1;
    public static final int CREATE_CODE = 2;
    public static final int UPDATE_CODE = 3;
    public static final int DELETE_CODE = 4;
    public static final String INDEX_NAME = "一覧";
    public static final String CREATE_NAME = "登録";
    public static final String UPDATE_NAME = "更新";
    public static final String DELETE_NAME = "削除";
    public static final String INDEX_ACTION_NAME = "表示";
    public static final String CREATE_ACTION_NAME = "作成";
    public static final String UPDATE_ACTION_NAME = "編集";
    public static final String DELETE_ACTION_NAME = "削除";

    public ProcessType(int code, String processName, String actionName) {
        this.code = code;
        this.processName = processName;
        this.actionName = actionName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public static ProcessType createProcessType(int code) {
        return new ProcessType(code, getProcessName(code), getActionName(code));
    }

    public static String getProcessName(int code) {
        return switch (code) {
            case INDEX_CODE -> INDEX_NAME;
            case CREATE_CODE -> CREATE_NAME;
            case UPDATE_CODE -> UPDATE_NAME;
            case DELETE_CODE -> DELETE_NAME;
            default -> throw new IllegalStateException("Unexpected value: " + code);
        };
    }

    public static String getActionName(int code) {
        return switch (code) {
            case INDEX_CODE -> INDEX_ACTION_NAME;
            case CREATE_CODE -> CREATE_ACTION_NAME;
            case UPDATE_CODE -> UPDATE_ACTION_NAME;
            case DELETE_CODE -> DELETE_ACTION_NAME;
            default -> throw new IllegalStateException("Unexpected value: " + code);
        };
    }

}
