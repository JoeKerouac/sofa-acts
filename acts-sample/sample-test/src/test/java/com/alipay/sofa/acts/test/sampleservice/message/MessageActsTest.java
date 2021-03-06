/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.acts.test.sampleservice.message;

import com.alipay.sample.servicetest.base.ApplicationTestRun;
import com.alipay.sofa.isle.sample.SampleService;
import com.alipay.test.acts.runtime.ActsRuntimeContext;
import org.testng.annotations.Test;

import com.alipay.test.acts.annotation.TestBean;
import com.alipay.test.acts.model.PrepareData;
import com.alipay.test.acts.template.ActsTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

/**
 *
 * @author $author
 * @version $Id: MessageActsTest.java,v 0.1 2019-03-07 上午 11:43:16 $author Exp $
 */
@SpringBootTest(classes = ApplicationTestRun.class)
public class MessageActsTest extends ActsTestBase{

    @TestBean
    @Autowired
    protected SampleService sampleService;

    /**
     * 说明：runTest(caseId, desc, prepareData)脚本中的process方法中的clear,prepare,execute,check四个方法如果无法满足脚本
     * 需求可以进行重写。forExample:
     * public void prepare(ActsRuntimeContext actsRuntimeContext) throws ActsTestException {
     *      userDifined();//自定义数据准备;
     *      super.prepare(actsRuntimeContext);//继承父类数据准备方法
     * }
     *
     * {@link com.alipay.sofa.isle.sample.SampleService#message()}
     */
    @Test(dataProvider = "ActsDataProvider")
    public void message
                (String caseId, String desc, PrepareData prepareData) {
        runTest(caseId, prepareData);
    }

    @Override
    public void beforeActsTest(ActsRuntimeContext actsRuntimeContext) {

        Method method =null;
        try {
            method = SampleService.class.getDeclaredMethod ("message", int.class);
        } catch (NoSuchMethodException e) {
            log.error(e);
        }
        actsRuntimeContext.setTestedMethod(method);
    }

    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }


}
