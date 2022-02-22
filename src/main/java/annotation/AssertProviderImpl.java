package annotation;

import com.google.inject.internal.Annotations;

import java.lang.annotation.Annotation;

public class AssertProviderImpl implements AssertProvider {
    private Provider value;

    public AssertProviderImpl(Provider value) {
        this.value = value;
    }

    // Adding this hashCode() can make this impl as a "值对象"
    // The "value" value must match the method name in your "AssertProvider" annotation class
    // 保证传进来一个值，会产生唯一的值。不管你传进来多少次，拿到都是一个对象。
    @Override
    public int hashCode() {
        return (127 * "value".hashCode()) ^ value.hashCode();// 必须这么写，需要看Java源码
    }

    public Provider value() {
        return this.value;
    }

    public Class<? extends Annotation> annotationType() {
        return AssertProvider.class;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AssertProvider)) {
            return false;
        }
        AssertProvider other = (AssertProvider) obj;
        return value.equals(other.value());
    }

    @Override
    public String toString() {
        return "@" + AssertProvider.class.getName() + "(" + Annotations.memberValueString("value", value) + ")";
    }
}
