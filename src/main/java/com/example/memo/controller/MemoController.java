package com.example.memo.controller;

import com.example.memo.controller.view.MemoView;
import com.example.memo.controller.view.ProcessType;
import com.example.memo.repository.entity.MemoEntity;
import com.example.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * メモコントローラクラス
 */
@Controller
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    /**
     * メモ一覧画面マッピングメソッド
     *
     * @param model モデル
     * @return "index"
     */
    @GetMapping("/")
    public String index(Model model) {
        var memoEntityList = memoService.getAllMemo();
        var memoList = MemoView.createMemoIndexViewList(memoEntityList);
        model.addAttribute("memoList", memoList);
        return "index";
    }

    /**
     * メモ作成画面マッピングメソッド
     *
     * @param model モデル
     * @return "edit"
     */
    @GetMapping("/edit")
    public String add(Model model) {
        var processType = ProcessType.createProcessType(ProcessType.CREATE_CODE);
        var memo = new MemoEntity();
        model.addAttribute("memo", memo);
        model.addAttribute("processType", processType);
        return "edit";
    }

    /**
     * メモ編集画面マッピングメソッド
     *
     * @param model モデル
     * @param id メモID
     * @return "edit"
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        var processType = ProcessType.createProcessType(ProcessType.UPDATE_CODE);
        var memo = memoService.getMemo(id);
        model.addAttribute("memo", memo);
        model.addAttribute("processType", processType);
        return "edit";
    }

    /**
     * メモ登録・更新マッピングメソッド
     *
     * @param memo メモデータ
     * @return "redirect:/"
     */
    @PostMapping("/post")
    public String post(MemoEntity memo) {
        // 新規登録の場合
        if (memo.getId() == null) {
            memoService.createMemo(memo);
        } else {
            memoService.updateMemo(memo);
        }
        return "redirect:/";
    }

    /**
     * メモ削除マッピングメソッド
     *
     * @param id メモID
     * @return "redirect:/"
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        memoService.deleteMemo(id);
        return "redirect:/";
    }

}
