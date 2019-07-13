package com.mall.service;

import pojo.EasyUiTree;
import pojo.ResponseResult;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUiTree> findProductCategoryListByParentId(Short parentid);

    ResponseResult addCategory(Short parentid,String name);
}
