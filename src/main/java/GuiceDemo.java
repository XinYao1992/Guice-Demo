import com.google.inject.Guice;
import com.google.inject.Injector;
import contract.SpellChecker;
import domain.TextEditor;
import implementation.SpellCheckerImpl;

public class GuiceDemo {
    public static void main(String[] args) {
        System.out.println("Hello Guice!");

        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor textEditor = injector.getInstance(TextEditor.class);

        // 即时注入，需要module里面定义bind规则
        // 作用不大
//        SpellChecker spellChecker = new SpellCheckerImpl();
//        injector.injectMembers(spellChecker);

        textEditor.makeSpellChecker();
    }
}
