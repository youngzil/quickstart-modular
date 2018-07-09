package org.quickstart.modular.jarslink.app.example;

/**
 * @author yuanchunsen@jd.com
 * 2018/4/23.
 */

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.ModuleConfig;

/**
 * 一个简单的Action实现
 *
 */
public class HelloWorldAction implements Action<ModuleConfig, ModuleConfig> {

    @Override
    public ModuleConfig execute(ModuleConfig actionRequest) {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName(actionRequest.getName());
        moduleConfig.setEnabled(actionRequest.getEnabled());
        moduleConfig.setVersion(actionRequest.getVersion());
        moduleConfig.setModuleUrl(actionRequest.getModuleUrl());
        moduleConfig.setProperties(actionRequest.getProperties());
        moduleConfig.setOverridePackages(actionRequest.getOverridePackages());
        return moduleConfig;
    }

    @Override
    public String getActionName() {
        return "helloworld";
    }

}