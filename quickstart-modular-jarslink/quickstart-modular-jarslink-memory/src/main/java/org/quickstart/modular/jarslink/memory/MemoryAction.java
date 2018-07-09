package org.quickstart.modular.jarslink.memory;

import org.quickstart.modular.jarslink.api.ActionRequest;
import org.quickstart.modular.jarslink.api.DefaultCacheImpl;

import com.alipay.jarslink.api.Action;


public class MemoryAction extends DefaultCacheImpl implements Action<ActionRequest, String>{

	private static final long serialVersionUID = -63052827434556767L;

	public String execute(ActionRequest actionRequest) {
		return "memory:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "demoCache";
	}

 

}
