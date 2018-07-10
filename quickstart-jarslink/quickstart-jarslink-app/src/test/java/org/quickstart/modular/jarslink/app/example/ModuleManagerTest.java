package org.quickstart.modular.jarslink.app.example;
import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanchunsen@jd.com
 * 2018/4/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class ModuleManagerTest {

    @Autowired
    private ModuleManager moduleManager;

    @Autowired
    private ModuleLoader moduleLoader;

    @Test
    public void shouldLoadModule() {
        //1:加载模块
        Module module = loadModule();
        Assert.assertNotNull(module);
        Assert.assertNotNull(module.getCreation());
        Assert.assertNotNull(module.getChildClassLoader());
        //卸载模块
        module.destroy();
        Assert.assertNotNull(module.getChildClassLoader());

    }

    @Test
    public void shouldRegisterModule() throws MalformedURLException {
        //2:注册模块
        Module module = loadModule();
        Module removedModule = moduleManager.register(module);
        Assert.assertNull(removedModule);

        //3:查找模块
        Module findModule = moduleManager.find(module.getName());
        Assert.assertNotNull(findModule);

        Assert.assertNotNull(moduleManager.getErrorModuleContext());
        Assert.assertEquals(1, moduleManager.getModules().size());

        Module remove = moduleManager.remove(module.getName());

        Assert.assertNull(moduleManager.find(remove.getName()));
        Assert.assertEquals(0, moduleManager.getModules().size());
    }

    @Test
    public void shouldDoAction() {
        Module findModule = loadModule();
        Module removedModule = moduleManager.register(findModule);
        //4.1:查找和执行Action

        String actionName = "helloworld";
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("h");
        moduleConfig.setEnabled(true);
        ModuleConfig result = findModule.doAction(actionName, moduleConfig);
        Assert.assertEquals(1, findModule.getActions().size());
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), moduleConfig.getName());
        Assert.assertEquals(result.getEnabled(), moduleConfig.getEnabled());

        //4.2:查找和执行Action
        Action<ModuleConfig, ModuleConfig> action = findModule.getAction(actionName);
        Assert.assertNotNull(action);
        result = action.execute(moduleConfig);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), moduleConfig.getName());
        Assert.assertEquals(result.getEnabled(), moduleConfig.getEnabled());

        //卸载模块
        moduleManager.remove(findModule.getName());
    }

    /**
     * 构建模块配置信息
     */
    public static ModuleConfig buildModuleConfig() {
        return buildModuleConfig(true);
    }

    public static ModuleConfig buildModuleConfig(boolean enabled) {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("jarslink-module-demo-1.0.0.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("demo");
        moduleConfig.setEnabled(enabled);
        moduleConfig.setOverridePackages(ImmutableList.of("com.alipay.jarslink.demo"));
        moduleConfig.setVersion("1.0.0.20170621");
        Map<String, Object> properties = new HashMap();
        properties.put("url", "127.0.0.1");
        moduleConfig.setProperties(properties);
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }

    private Module loadModule() {return moduleLoader.load(buildModuleConfig());}

}
