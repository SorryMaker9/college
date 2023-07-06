package com.xqing.core.filter;

import com.xqing.core.enums.Constants;
import org.apache.dubbo.rpc.RpcContext;

import java.util.List;
import java.util.Optional;

public class RequestContext {
	private static final ThreadLocal<String> USER_ID = new ThreadLocal<String>();
	private static final ThreadLocal<List<String>> USER_PERMISSION = new ThreadLocal<>();

	public static void setUserId(String userId) {
		RpcContext.getContext().setAttachment(Constants.USER_ID_KEY, userId);
		USER_ID.set(userId);
	}

	public static String getUserId() {
		return Optional.ofNullable(RpcContext.getContext().getAttachment(Constants.USER_ID_KEY)).orElse(USER_ID.get());
	}

	public static void clear() {
		RpcContext.getContext().removeAttachment(Constants.USER_ID_KEY);
		USER_ID.remove();
		USER_PERMISSION.remove();
	}
}
