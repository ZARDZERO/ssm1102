package com.service;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.InputStream;
import java.util.List;

public interface ActivitiService {
    //新增流程部署
    public int add(InputStream in,String name);
    //查询部署信息
    public List<Deployment> getdeplist();
    //查询流程定义
    public List<ProcessDefinition> getprolist();
}
