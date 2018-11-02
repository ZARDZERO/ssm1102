package com.service.impl;

import com.service.ActivitiService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@Service
public class ActivitiServiceImpl implements ActivitiService {

    @Autowired
    private RepositoryService repositoryService;


    @Override
    public int add(InputStream in, String name) {
        ZipInputStream zip=new ZipInputStream(in);
        repositoryService.createDeployment()
                .addZipInputStream(zip)
                .name(name)
                .deploy();

        return 1;
    }

    @Override
    public List<Deployment> getdeplist() {

      List list=  repositoryService.createDeploymentQuery().list();


        return list;
    }

    @Override
    public List<ProcessDefinition> getprolist() {
        List list=repositoryService.createProcessDefinitionQuery().list();
        return list;
    }
}
