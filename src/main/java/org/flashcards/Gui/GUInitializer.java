package org.flashcards.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUInitializer extends JFrame implements Initializer {
    private final GetStarted getStarted;
    private final Menu menu;
    private final Add add;
    private final Edit edit;
    private final ChooseMode chooseMode;
    private final LearnMode learnMode;
    private final TestMode testMode;
    private final FlashCardsMode flashCardsMode;

    private final AddTxtRepoTitle addTxtRepoTitle;

    private final AddImgRepoTitle addImgRepoTitle;

    private final AddTxtCard addTxtCard;

    private final Menu2 menu2;


    public GUInitializer() {

        File icon = new File("src/main/resources/img/FlashCardsIcon.png");
        BufferedImage iconImage;
        try {
            String os = System.getProperty("os.name");
            iconImage = ImageIO.read(icon);
            if (os.contains("Mac OS X")) {
                final Taskbar taskbar = Taskbar.getTaskbar();
                taskbar.setIconImage(iconImage);
            }
            else {
                setIconImage(iconImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        changeFont("src/main/java/org/flashcards/Gui/fonts/Arbutus-Regular.ttf");

        getStarted = new GetStarted(this);
        menu = new Menu(this);
        add = new Add(this);
        edit = new Edit(this);
        chooseMode = new ChooseMode(this);
        learnMode = new LearnMode(this);
        testMode = new TestMode(this);
        flashCardsMode = new FlashCardsMode(this);
        addTxtRepoTitle = new AddTxtRepoTitle(this,edit);
        addImgRepoTitle = new AddImgRepoTitle(this,edit);
        addTxtCard = new AddTxtCard(this);
        menu2 = new Menu2(this);


        setTitle("Flashcards");
        add(getStarted);
        pack();
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void changePanel(Panel panel) {
        switch (panel) {
            case GetStarted -> {
                menu.setVisible(false);
                setContentPane(getStarted);
                pack();
                getStarted.setVisible(true);
            }
            case Menu -> {
                getStarted.setVisible(false);
                setContentPane(menu);
                pack();
                menu.setVisible(true);
            }
            case Add -> {
                menu.setVisible(false);
                setContentPane(add);
                pack();
                add.setVisible(true);
            }
            case Edit -> {
                add.setVisible(false);
                setContentPane(edit);
                pack();
                edit.setVisible(true);
            }
            case ChooseMode -> {
                edit.setVisible(false);
                setContentPane(chooseMode);
                pack();
                chooseMode.setVisible(true);
            }
            case LearnMode -> {
                chooseMode.setVisible(false);
                setContentPane(learnMode);
                pack();
                learnMode.setVisible(true);
            }
            case TestMode -> {
                chooseMode.setVisible(false);
                setContentPane(testMode);
                pack();
                testMode.setVisible(true);
            }
            case FlashCardsMode -> {
                chooseMode.setVisible(false);
                setContentPane(flashCardsMode);
                pack();
                flashCardsMode.setVisible(true);
            }
            case AddTxtRepoTitle -> {
                chooseMode.setVisible(false);
                setContentPane(addTxtRepoTitle);
                pack();
                addTxtRepoTitle.setVisible(true);
            }

            case AddImgRepoTitle -> {
                chooseMode.setVisible(false);
                setContentPane(addImgRepoTitle);
                pack();
                addImgRepoTitle.setVisible(true);
            }
            case AddTxtCard -> {
                chooseMode.setVisible(false);
                setContentPane(addTxtCard);
                pack();
                addTxtCard.setVisible(true);
            }

            case Menu2 -> {
                chooseMode.setVisible(false);
                setContentPane(menu2);
                pack();
                menu2.setVisible(true);
            }
        }
    }

    @Override
    public void update(Panel panel) {
        changePanel(panel);
    }

    public enum Panel {
        GetStarted,
        Menu,
        Add,
        Edit,
        ChooseMode,
        FlashCardsMode,
        LearnMode,
        TestMode,

        Result,

        AddTxtRepoTitle,
        AddImgRepoTitle,
        AddTxtCard,
        Menu2
    }

    public static void changeFont(String path) {
        try {
            GraphicsEnvironment font = GraphicsEnvironment.getLocalGraphicsEnvironment();
            font.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
        } catch (IOException | FontFormatException e) {
            System.out.println("Font not found");
            e.printStackTrace();
        }
    }
}
