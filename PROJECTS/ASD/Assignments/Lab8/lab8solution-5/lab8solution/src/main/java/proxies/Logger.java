package proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class Logger implements InvocationHandler {
	private Object o;

	public Logger(Object o) {
		this.o = o;
	}

	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		System.out.println("Logger: Invoking " + m.getName());
		return m.invoke(o, args);
	}
}