import annotation.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import contract.Assertor;
import contract.SampleProvider;
import contract.SpellChecker;
import domain.Context;
import domain.SomeClass;
import domain.TextEditor;
import implementation.*;

import java.util.regex.Matcher;

import static annotation.Provider.*;

public class TextEditorModule extends AbstractModule {// 模块类
    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);
        bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);// 加上.in(Singleton.class)就每次都用同一个instance

        // Binding annotation
        bind(Assertor.class).annotatedWith(UseJUnit.class).to(JUnitAssertor.class);

        // Named annotation
        bind(Assertor.class).annotatedWith(Names.named("TestNg")).to(TestNgAssertor.class);

        // Customized annotation
        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(JUnit)).to(JUnitAssertor.class);
        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(TestNg)).to(TestNgAssertor.class);

        // Instance binding
        bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance("jdbc:mysql://localhost/pizza111");// solution 1
        bind(String.class).annotatedWith(AssertProviders.assertProvider(JDBC)).toInstance("jdbc:mysql://localhost/pizza222");// solution 2
        bindConstant().annotatedWith(Names.named("JDBC URL2")).to("jdbc:mysql://localhost/pizza333");// solution 3
        bind(Context.class).annotatedWith(Names.named("Context")).toInstance(new Context("text data")); // solution 4, bind your own class， singleton

        // Provides solution 2
        bind(SampleProvider.class).toProvider(SampleClassProvider.class);

        // Constructor binding
//        bind(DatabaseAccess.class).to(DatabaseAccessImpl.class);// 如果不在constructor上写inject，那么默认绑定到无参构造上
//        try {
//            bind(DatabaseAccess.class).toConstructor(DatabaseAccessImpl.class.getConstructor(String.class));// 意思是绑定到参数为string的构造器上，如果不带参数就代表为无参构造器。
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        // 关闭默认构造函数的绑定
//        binder().requireAtInjectOnConstructors();

        // 关闭使用自动注入 untargeted binding
//        binder().requireExplicitBindings();
//        bind(TextEditor.class);
//        bind(SomeClass.class);


        // AOP, bind一个拦截器
        bindInterceptor(
                Matchers.any(),
                Matchers.annotatedWith(CallTracker.class),
                new CallTrackerService()
        );

    }


    // Provides Solution 1
    @Provides @DbAction
    public SampleProvider provideSampleProvider (@Named("JDBC URL") String dbUrl) {
        String user = "user";
        SampleProvider sp = new SampleProviderImpl(dbUrl, user);
        return sp;
    }

}
