package xmasDraw;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XmasDraw extends JFrame
{
    public XmasDraw()
    {
        iniComponents();
    }

    public void iniComponents() {
        this.setTitle("Xmas Draw");
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
        panelMembersList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY) , "Members list", TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
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

        JLabel label = new JLabel("Drawing: ");
        protected static JLabel whoDrawLabel = new JLabel("                                   ");
        protected static JLabel resultLabel = new JLabel("                                   ");
        JLabel endOfDraw = new JLabel("Draw over");




        JButton buttonDraw = new JButton("Draw");
        JButton clear = new JButton("Clear");
        JButton add = new JButton("Add");
        JButton complete = new JButton("Stop adding");

        protected static JTextField writeNameTextField = new JTextField("Name");


        DrawClear drawClear = new DrawClear();
        AddMembers addMembers = new AddMembers();
        Complete comp = new Complete();

        protected static int completeFlag = 0;





    public static void main(String[] args)

        {
        new XmasDraw().setVisible(true);

        }

        }
