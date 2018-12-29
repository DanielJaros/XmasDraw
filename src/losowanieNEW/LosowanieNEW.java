package losowanieNEW;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LosowanieNEW extends JFrame
{
    public LosowanieNEW()
    {
        iniComponents();
    }

    public void iniComponents() {
        this.setTitle("Świąteczne Losowanie");
        this.setBounds(300, 300, 600, 100);

        panel.add(panelAdd, BorderLayout.PAGE_START);

        panelAdd.add(writeNameTextField);
        panelAdd.add(add);
        panelAdd.add(complete);


        panel.add(label, BorderLayout.CENTER);
        panel.add(whoDrawLabel, BorderLayout.CENTER);
        panel.add(buttonDraw, BorderLayout.CENTER);
        panel.add(clear, BorderLayout.CENTER);
        panel.add(resultLabel, BorderLayout.NORTH);


        panelMembersList.add(membersList);
        panelMembersList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY) , "Lista uczestników", TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
        panelMembersList.setPreferredSize(new Dimension((this.getWidth())/5, this.getHeight()));


        buttonDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                drawClear.draw();

            resultLabel.setText(drawClear.result);
            }
        });


        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
            drawClear.clear();

            whoDrawLabel.setText(drawClear.whoDraw);
            resultLabel.setText(drawClear.result);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMembers.addMembers();


            }
        });

        complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comp.completeMethod();
            }
        });

        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(scrollMembersList, BorderLayout.EAST);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        }

        protected static DefaultListModel allMembersListModel = new DefaultListModel();


        JPanel panel = new JPanel();
        JPanel panelAdd = new JPanel(new GridLayout(2,1));
        JPanel panelMembersList = new JPanel(new FlowLayout());

        JList membersList = new JList(allMembersListModel);
        JList drawedList = new JList();
        JScrollPane scrollMembersList = new JScrollPane(panelMembersList);

        JLabel label = new JLabel("Losuje: ");
        protected static JLabel whoDrawLabel = new JLabel("                                   ");
        protected static JLabel resultLabel = new JLabel("                                   ");
        JLabel endOfDraw = new JLabel("Losowanie zakończone");




        JButton buttonDraw = new JButton("Losowanie");
        JButton clear = new JButton("Czyszczenie");
        JButton add = new JButton("Dodaj");
        JButton complete = new JButton("Zakończ dodawanie");

        protected static JTextField writeNameTextField = new JTextField("wpisz imię");


        DrawClear drawClear = new DrawClear();
        AddMembers addMembers = new AddMembers();
        Complete comp = new Complete();

        protected static int completeFlag = 0;





    public static void main(String[] args)

        {
        new LosowanieNEW().setVisible(true);

        }

        }
