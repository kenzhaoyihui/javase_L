package yzhao.spring.io.InnerBeans;

public class TextEditor {
    private String messages;
    private SpellChecker spellChecker;
    // a setter method to inject the dependency.

    public TextEditor(){}

    public TextEditor(String messages, SpellChecker spellChecker){
        this.messages = messages;
        this.spellChecker = spellChecker;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        System.out.println("Message: " + messages);
        return messages;
    }

    public TextEditor(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setSpellChecker." );
        this.spellChecker = spellChecker;
    }
    // a getter method to return spellChecker
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
