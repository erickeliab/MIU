import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;


public class RectCommand implements ICommand{
	Graphics g;
    int k,l,m,n;
    HistoryList historyList;
    private Collection<ICommand> commandlist = new ArrayList();
    
	public RectCommand(Graphics g,int k,int l,int m,int n, HistoryList historyList) {
		this.g=g;
		this.k=k;
		this.l=l;
		this.m=m;
		this.n=n;
		this.historyList=historyList;
		commandlist = historyList.getCommandlist();
	}
	
	public void execute() {
		g.fillRect(k, l, m, n);
		
	}

	public void unExecute() {
		for(ICommand command:commandlist){
			command.execute();			
		}
		
	}

}