package com.sigmatrix.sc.page;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * 功能概要：
 * 
 * @author linbingwen
 * @since  2015年10月22日 
 */


public class PageBeanUtil {

    public static <T> PageBean<T> toPagedResult(List<T> datas) {
        PageBean<T> result = new PageBean<T>();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        }
        else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

}
