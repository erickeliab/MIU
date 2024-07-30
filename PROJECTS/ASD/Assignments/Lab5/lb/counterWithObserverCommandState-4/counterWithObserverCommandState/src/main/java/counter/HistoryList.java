package counter;

import java.util.ArrayList;
import java.util.Collection;


public class HistoryList {

	private Collection<ICommand> commandlist = new ArrayList<ICommand>();
	private Collection<ICommand> undolist = new ArrayList<ICommand>();

	public void undo(){	
		if (commandlist.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<ICommand>)commandlist).get(commandlist.size()-1);
		((ArrayList<ICommand>)commandlist).remove(commandObject);
		commandObject.unExecute();
		undolist.add(commandObject);
		}
	}
    // this redo does not work correctly in all cases
	// this is not part of the exercise
	public void redo(){
		if (undolist.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<ICommand>)undolist).get(undolist.size()-1);
		commandObject.execute();
		((ArrayList<ICommand>)undolist).remove(commandObject);
		commandlist.add(commandObject);
		}
	}



	public void addCommand(ICommand commandObject){
		commandlist.add(commandObject);
	}

}
