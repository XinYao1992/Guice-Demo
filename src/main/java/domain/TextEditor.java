package domain;

import annotation.*;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import contract.Assertor;
import contract.DatabaseAccess;
import contract.SampleProvider;
import contract.SpellChecker;

import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;

import static annotation.Provider.JUnit;
import static annotation.Provider.JDBC;

public class TextEditor {
    private SpellChecker spellChecker;//如果这里加上inject，那就是字段注入
    private Assertor assertor;
    private Logger logger;

    @Inject
    public TextEditor(SpellChecker spellChecker,
                      @Named("TestNg") Assertor assertor1, // Named annotation
                      @AssertProvider(JUnit) Assertor assertor2, // Customized annotation
                      @Named("JDBC URL") String jdbc1,
                      @AssertProvider(JDBC) String jdbc2,
                      @Named("Context") Context context1,
                      @Named("Context") Context context2,// 和context1是同一个对象，都是单例的
                      SampleProvider sampleProvider1,
                      @DbAction SampleProvider sampleProvider2,
                      DatabaseAccess databaseAccess,// 默认会选择无参构造器
                      Logger logger,// built-in binding
                      SomeClass someClass // Untargetd binding

    ) {
        this.spellChecker = spellChecker;
//        this.assertor = assertor1;
//        System.out.println(jdbc1);
//        System.out.println(jdbc2);
//        System.out.println(context1.hashCode());
//        System.out.println(context2.hashCode());
//        sampleProvider1.someAction();
//        sampleProvider2.someAction();
//        databaseAccess.someAction();
//        this.logger = logger;
//        logger.warning("[Warning]: this is a warning message!");
//        logger.log(Level.INFO, "[Warning]: this is an info message!");
//        someClass.someAction();
    }

    @CallTracker // AOP, 拦截器。执行这个method前后会启动拦截器操作
    public void makeSpellChecker() {
        spellChecker.checkSpelling();
//        assertor.equal(1, 1);
    }

    @Inject
//    @Inject(optional = true) // 可选注入，当不提供绑定方式时，就使用默认值
    public void setContext(SpellChecker spellChecker) {// 方法注入
        this.spellChecker = spellChecker;
    }
}
