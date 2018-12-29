package losowanieNEW;

import javax.swing.*;
import java.util.Random;

public class DrawClear
{

    public DrawClear()
    {
//        membersListModel.addElement(LosowanieNEW.momDad);
//        membersListModel.addElement(LosowanieNEW.annPablo);
//        membersListModel.addElement(LosowanieNEW.paulaDano);
//
//        drawListModel.addElement(LosowanieNEW.momDad);
//        drawListModel.addElement(LosowanieNEW.annPablo);
//        drawListModel.addElement(LosowanieNEW.paulaDano);


    }

        public void draw()
        {

            DefaultListModel tempListModel = new DefaultListModel();

            /**
             * Condition check if memebersListModel and drawListModel has only 2 elements and the same time membersListModel contein all elements
             * of drawListModel for this case it's have a special draw process, for don't let to draw by member himself.
             * When in whoDraw label is first element of drawListModel in result label will be set a second element of drawListModel
             * amd vice versa.
             */
            if (!drawListModel.isEmpty() && clearFlag == 1 && membersListModel.size() == 2 && drawListModel.size() == 2 && (membersListModel.contains(drawListModel.get(0))
                    || membersListModel.contains(drawListModel.get(1))) && infoFlag == 1)
            {
                System.out.println("ostatni losujący: " + lastWhoDraw);
                System.out.println("obecny losujący:  " + whoDraw);
                System.out.println("lastResult:  " + lastResult);

                if (lastWhoDraw.equals(drawListModel.get(0)) && whoDraw.equals(lastResult))
                {
                    designatedElement1 = (String)drawListModel.get(1);
                    result = designatedElement1;

                    System.out.println("IDZIE 1");
                }

                if (lastWhoDraw.equals(drawListModel.get(1)) && whoDraw.equals(lastResult))
                {
                    designatedElement0 = (String)drawListModel.get(0);
                    result = designatedElement0;
                    System.out.println("IDZIE 2");
                }

                if (lastWhoDraw.equals(drawListModel.get(0)) && !whoDraw.equals(lastResult))
                {
                    designatedElement0 = (String)drawListModel.get(0);
                    result = designatedElement0;

                    System.out.println("IDZIE 3");

                }

                if (lastWhoDraw.equals(drawListModel.get(1)) && !whoDraw.equals(lastResult))
                {
                    designatedElement1 = (String)drawListModel.get(1);
                    result = designatedElement1;

                    System.out.println("IDZIE 4");
                }

                if(result.equals(designatedElement0))
                    drawListModel.remove(0);

                if(result.equals(designatedElement1))
                    drawListModel.remove(1);
            }


            else if (!drawListModel.isEmpty() && clearFlag == 1)
            {


                if (drawListModel.size() == 3 && membersListModel.size() == 3 && membersListModel.contains(drawListModel.get(1))
                        && membersListModel.contains(drawListModel.get(0)) && membersListModel.contains(drawListModel.get(2)))
                {
                    infoFlag = 1;
                }
                /**
                 * There is code to normal drawing procedure when there are more than 2 members.
                 */

                for (int i = 0; i < drawListModel.size(); i++)
                {
                    if (LosowanieNEW.whoDrawLabel.getText().equals(drawListModel.getElementAt(i)))
                    {
                        for (int j = 0; j < drawListModel.size(); j++) {
                            tempListModel.addElement(drawListModel.getElementAt(j));
                        }

                        tempListModel.removeElement(drawListModel.getElementAt(i));
                    }
                }

                Random rand = new Random();

                if (tempListModel.size() > 0) {
                    int randomIndex = rand.nextInt(tempListModel.size());
                    String drawedElement = (String) tempListModel.getElementAt(randomIndex);

                    result = drawedElement;
                    lastResult = drawedElement;

                    drawListModel.removeElement(tempListModel.getElementAt(randomIndex));

                }

                else {
                    Random rand2 = new Random();

                    if (drawListModel.size() > 0) {
                        int randomIndex = rand2.nextInt(drawListModel.size());
                        String drawedElement2 = (String) drawListModel.getElementAt(randomIndex);

                        result = drawedElement2;
                        lastResult = drawedElement2;


                        drawListModel.removeElement(drawListModel.getElementAt(randomIndex));
                    }
                }
            }

            clearFlag = 0;
        }


        public void clear()
        {
            lastWhoDraw = LosowanieNEW.whoDrawLabel.getText();
            System.out.println("lastWhoDraw: "+ lastWhoDraw);

            if(!membersListModel.isEmpty() && clearFlag == 0)
            {
                for (int k = 0; k < membersListModel.size(); k++)
                {
                    if (LosowanieNEW.whoDrawLabel.getText().equals(membersListModel.getElementAt(k)))
                    {
                        membersListModel.removeElement(membersListModel.getElementAt(k));
                    }
                }
            }

            if (membersListModel.size() > 0 && clearFlag == 0)
            {

                Random rand2 = new Random();
                int randomIndex = rand2.nextInt(membersListModel.size());
                String membersElement2 = (String) membersListModel.get(randomIndex);

                whoDraw = membersElement2;
            }

            if (drawListModel.getSize() == 0)
                whoDraw = "            ";

            result = "";
            clearFlag = 1;
        }


    protected static DefaultListModel membersListModel = new DefaultListModel();
    protected static DefaultListModel drawListModel = new DefaultListModel();



    String designatedElement0 = "";
    String designatedElement1 = "";
    String lastWhoDraw = "";
    String lastResult = "";

    String result = "";
    String whoDraw = "";

    int clearFlag = 1;
    int infoFlag = 0;

}


