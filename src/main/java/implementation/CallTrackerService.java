package implementation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CallTrackerService implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // methodInvocation就是我们所拦截的方法，这里可以做很多操作，比如读取缓存
        // 比如：若想要的值在缓存中，就跳过拦截方法本身。
        System.out.println("Before: " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After: " + methodInvocation.getMethod().getName());
        return result;
    }
}
