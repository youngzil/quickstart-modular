package org.quickstart.modular.jarslink.redis;

import org.quickstart.modular.jarslink.api.ActionRequest;
import org.quickstart.modular.jarslink.api.DefaultCacheImpl;

import com.alipay.jarslink.api.Action;

public class RedisAction extends DefaultCacheImpl implements Action<ActionRequest, String>{

	private static final long serialVersionUID = 9219245460794102632L;

	public String execute(ActionRequest actionRequest) {
		return "redis:"+super.execute(actionRequest);
	}


	public String getActionName() {
		return "demoCache";
	}

}
