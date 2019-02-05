package xmasDraw;

public class AddMembers
{
 public AddMembers()
 {

 }

 public void addMembers(){

  if(LosowanieNEW.completeFlag == 0) {

   LosowanieNEW.allMembersListModel.addElement(LosowanieNEW.writeNameTextField.getText());

   DrawClear.membersListModel.addElement(LosowanieNEW.writeNameTextField.getText());
   DrawClear.drawListModel.addElement(LosowanieNEW.writeNameTextField.getText());
  }
 }

}
