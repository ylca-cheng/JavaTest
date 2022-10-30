package com.wps.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author niecheng
 * @Description 类描述
 * @date 2021/6/10 9:59
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {
    /**
     * 一行一行读取excel内容
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData data, AnalysisContext analysisContext) {
        System.out.println("****"+data);
    }

    /**
     * 读取表头内容
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }

    /**
     * 读取完成之后
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }
}
