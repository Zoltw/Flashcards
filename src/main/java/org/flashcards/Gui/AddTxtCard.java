package org.flashcards.Gui;

import org.flashcards.src.GuiApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddTxtCard extends JPanel {
    private final Initializer initializer;

    public AddTxtCard(Initializer initializer) {
        this.initializer = initializer;
        setPreferredSize(new Dimension(960, 560));
        setBackground(new java.awt.Color(41, 41, 41));
        setLayout(null);
        addFlashCard();
        getSaveButton();
    }

    private void addFlashCard() {
        JButton addTextButton = new JButton("Next");
        JTextField answer = new JTextField("Enter an answer");
        JTextField question = new JTextField("Enter a question");
        addTextButton.setFont(new Font("Arbutus", Font.PLAIN, 16));
        addTextButton.setBounds(618, 239, 210, 65);

        addTextButton.addActionListener(e -> {
            GuiApp.getInstance().getApp().addTxtCard();
            initializer.update(GUInitializer.Panel.AddTxtCard);
            answer.setText("");
            question.setText("");
        });
        add(addTextButton);

        answer.setFont(new Font("Arbutus", Font.PLAIN, 16));
        answer.setHorizontalAlignment(JTextField.CENTER);
        answer.setBounds(375, 239, 210, 65);
        answer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                GuiApp.getInstance().getApp().txtCard.setAnswer(answer.getText());
            }
        });
        add(answer);

        question.setFont(new Font("Arbutus", Font.PLAIN, 16));
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setBounds(132, 239, 210, 65);
        question.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                GuiApp.getInstance().getApp().txtCard.setTextQuestion(question.getText());
            }
        });
        add(question);
    }
    private void getSaveButton() {
        JButton addTextButton = new JButton("Save");
        addTextButton.setFont(new Font("Arbutus", Font.PLAIN, 16));
        addTextButton.setBounds(375, 340, 210, 65);
        addTextButton.addActionListener(e -> {
            initializer.update(GUInitializer.Panel.Edit);
        });
        add(addTextButton);
    }
}