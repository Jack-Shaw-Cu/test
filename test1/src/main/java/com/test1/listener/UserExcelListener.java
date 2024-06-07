package com.test1.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.test1.bean.UserExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XT
 * @Title: UserExcelListemer
 * @Date: 2024/6/1 16:26
 * @description: userExcelListener
 */
@Slf4j
public class UserExcelListener extends AnalysisEventListener<UserExcel> {

    private List<UserExcel> data = new ArrayList<>();

    @Override
    public void invoke(UserExcel userExcel, AnalysisContext analysisContext) {
        data.add(userExcel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("解析完成！");
    }
}
