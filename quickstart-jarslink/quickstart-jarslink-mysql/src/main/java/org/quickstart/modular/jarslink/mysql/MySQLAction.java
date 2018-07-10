package org.quickstart.modular.jarslink.mysql;

import org.quickstart.modular.jarslink.api.ActionRequest;
import org.quickstart.modular.jarslink.api.DefaultCacheImpl;

import com.alipay.jarslink.api.Action;

public class MySQLAction extends DefaultCacheImpl implements Action<ActionRequest, String>{
	
	private static final long serialVersionUID = -4716239074103927075L;

	public String execute(ActionRequest actionRequest) {
		return "mysql:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "demoCache";
	}

}
