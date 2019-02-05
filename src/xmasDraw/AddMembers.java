package xmasDraw;

public class AddMembers
{
 public AddMembers()
 {

 }

 public void addMembers(){

  if(XmasDraw.completeFlag == 0) {

   XmasDraw.allMembersListModel.addElement(XmasDraw.writeNameTextField.getText());

   DrawClear.membersListModel.addElement(XmasDraw.writeNameTextField.getText());
   DrawClear.drawListModel.addElement(XmasDraw.writeNameTextField.getText());
  }
 }

}
