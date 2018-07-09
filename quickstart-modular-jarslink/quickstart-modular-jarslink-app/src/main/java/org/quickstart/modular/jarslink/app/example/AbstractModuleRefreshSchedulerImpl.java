package org.quickstart.modular.jarslink.app.example;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;

import java.util.List;

/**
 * @author yuanchunsen@jd.com
 * 2018/4/23.
 */
public class AbstractModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

    private List<ModuleConfig> moduleConfigs;

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return moduleConfigs;
    }

    public void setModuleConfigs(List<ModuleConfig> moduleConfigs) {
        this.moduleConfigs = moduleConfigs;
    }

}