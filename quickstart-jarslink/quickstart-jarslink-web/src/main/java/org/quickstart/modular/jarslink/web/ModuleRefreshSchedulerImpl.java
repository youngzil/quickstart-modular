package org.quickstart.modular.jarslink.web;

import java.net.URL;
import java.util.List;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;


public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
	
	public ModuleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager) {
		super.setModuleLoader(moduleLoader);
		super.setModuleManager(moduleManager);
	}
	
	@Override
	public List<ModuleConfig> queryModuleConfigs() {
		return ImmutableList.of(buildModuleConfig());
	}

	public static ModuleConfig buildModuleConfig() {
	    String path = "[INFO] Building jar: /Users/yangzl/git/quickstart-all/quickstart-modular/quickstart-modular-jarslink/";
	    String urlRedis = "quickstart-modular-jarslink-redis/target/quickstart-modular-jarslink-redis-0.0.1-SNAPSHOT.jar";
	    String urlMemory = "quickstart-modular-jarslink-memory/target/quickstart-modular-jarslink-memory-0.0.1-SNAPSHOT.jar";
	    String urlMysql = "quickstart-modular-jarslink-mysql/target/quickstart-modular-jarslink-mysql-0.0.1-SNAPSHOT.jar";
		URL demoModule = Thread.currentThread().getContextClassLoader().getResource(path + urlMemory);
		ModuleConfig moduleConfig = new ModuleConfig();
		moduleConfig.setName("demo-cache-service");
		moduleConfig.setEnabled(true);
		moduleConfig.setVersion(String.valueOf(System.currentTimeMillis()));
		moduleConfig.setProperties(ImmutableMap.of("author", "songjian"));
		moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
//		moduleConfig.addScanPackage("org.quickstart.modular.jarslink");
		return moduleConfig;
	}
	
	public static ModuleConfig buildModuleConfig(String module,String version) {
		URL demoModule = Thread.currentThread().getContextClassLoader().getResource(String.format("META-INF/%s-%s.jar", module, version));
		ModuleConfig moduleConfig = new ModuleConfig();
		moduleConfig.setName("demo-cache-service");
		moduleConfig.setEnabled(true);
		moduleConfig.setVersion(String.valueOf(System.currentTimeMillis()));
		moduleConfig.setProperties(ImmutableMap.of("author", "songjian", "desc", "runtime loading functions"));
		moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
//		moduleConfig.addScanPackage("org.quickstart.modular.jarslink");
		return moduleConfig;
	}

}