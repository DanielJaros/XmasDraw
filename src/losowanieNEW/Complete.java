package losowanieNEW;

import java.util.Random;

public class Complete {

    public Complete()
    {

    }

    public void completeMethod(){

        Random rand = new Random();

        if (DrawClear.membersListModel.size() > 0)
        {
            int randomIndex = rand.nextInt(DrawClear.membersListModel.size());
            String drawedElement = (String) DrawClear.membersListModel.getElementAt(randomIndex);

            LosowanieNEW.whoDrawLabel.setText(drawedElement);
        }

        LosowanieNEW.completeFlag = 1;
    }
}
