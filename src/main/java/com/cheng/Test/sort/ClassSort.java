package com.cheng.Test.sort;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/8/7 13:46
 * @Version 1.0
 */
public class ClassSort {
    // 升序
    private static String ASC_SORT = "+";
    // 降序
    private static String DESC_SORT = "-";
    // 是否允许null
    private static boolean NULL_ALLOW = true;

    /**
     * @作者: yangjizhou
     * @时间: 2015-8-6 下午2:46:27
     * @描述:
     *      根据sortFields对传入的sourceList进行排序。例如Test类有id,name,age属性，要根据id升序，name降序排序
     *      。则参数里的T用Test,sortFields配置为"id+","name-"
     *      <b>不对传入的集合进行做排序，使用时请使用返回后的集合做业务处理</b>
     * @param sourceList
     * @param sortFields
     * @return
     * @备注:
     */
    public static <T> List<T> classSort(List<T> sourceList,
                                        String... sortFields) {
        List<T> result = new ArrayList<T>();
        result.addAll(sourceList);
        if (CollectionUtils.isEmpty(sourceList) || sourceList.contains(null)) {
            return null;
        }
        if (sortFields == null || sortFields.length == 0) {
            return result;
        }
        ArrayList<BeanComparator> cmps = new ArrayList<BeanComparator>();
        for (int i = 0; i < sortFields.length; i++) {
            if (StringUtils.isEmpty(sortFields[i])) {
                continue;
            }
            String str = sortFields[i].trim();
            String sortType = null;
            if (!str.endsWith(ASC_SORT) && !str.endsWith(DESC_SORT)) {
                continue;
            } else if (str.endsWith(ASC_SORT)) {
                sortType = ASC_SORT;
            } else if (str.endsWith(DESC_SORT)) {
                sortType = DESC_SORT;
            }
            int index = str.indexOf(sortType);
            String sortField = str.substring(0, index);
            BeanComparator cmp = getBeanComparator(sortField, sortType);
            if (cmp != null) {
                cmps.add(cmp);
            }
        }
        // 创建一个排序链
        ComparatorChain multiSort = new ComparatorChain(cmps);
        try {
            Collections.sort(result, multiSort);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private static BeanComparator getBeanComparator(String sortField,
                                                    String sortType) {
        if (StringUtils.isEmpty(sortField) || sortType == null) {
            return null;
        }
        // 创建一个排序规则
        Comparator comparator = ComparableComparator.getInstance();
        if (sortType.equals(DESC_SORT)) {
            comparator = ComparatorUtils.reversedComparator(comparator); // 逆序
        }
        if (NULL_ALLOW) {
            comparator = ComparatorUtils.nullLowComparator(comparator); // 允许null
        }
        return new BeanComparator(sortField, comparator);
    }

}
