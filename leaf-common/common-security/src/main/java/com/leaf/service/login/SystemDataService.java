package com.leaf.service.login;

import com.leaf.entity.CustomData;
import com.leaf.entity.ResultDetails;
import com.leaf.exception.CustomizeException;

import java.util.List;

/**
 * @author Pu Zhiwei {@literal puzhiweipuzhiwei@foxmail.com}
 * create          2019-12-01 16:22
 */
public interface SystemDataService {
    List<CustomData> get();

    CustomData select(String id) throws CustomizeException;

    ResultDetails delete(String id, String authorities) throws CustomizeException;

    CustomData create(CustomData customData);
}
