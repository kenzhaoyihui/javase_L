package yzhao.spring.io.InnerBeans;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private String messages;

    @Autowired
    private SpellChecker spellChecker;
    // a setter method to inject the dependency.

    public TextEditor(){}

    public TextEditor(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }

    public TextEditor(String messages, SpellChecker spellChecker){
        this.messages = messages;
        this.spellChecker = spellChecker;
    }

    @Autowired(required = false)
    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        System.out.println("Message: " + messages);
        return messages;
    }


    @Autowired
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
