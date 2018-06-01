package com.bridgelabz.innerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextEditorMain {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/bridgelabz/innerBean/textEditiorBean.xml");
	TextEditor te = (TextEditor) context.getBean("texteditor");
	te.spellCheck();
}
}
