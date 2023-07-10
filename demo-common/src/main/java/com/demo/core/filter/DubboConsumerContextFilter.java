package com.demo.core.filter;

import com.demo.core.enums.Constants;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;


/**
 * @className DubboConsumerContextFilter.java
 * @author yuanchao.ma
 * @date 2022/06/02
 */
@Activate(group = CommonConstants.CONSUMER)
public class DubboConsumerContextFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String userId = RpcContext.getContext().getAttachment(Constants.USER_ID_KEY);
		if (userId == null) {
			RpcContext.getContext().setAttachment(Constants.USER_ID_KEY, RequestContext.getUserId());
		}
		return invoker.invoke(invocation);
	}
}
