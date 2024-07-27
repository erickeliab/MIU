package counter;

public class Counter {

	private int count=0;
	private TextFrame textframe ;
	private RectFrame rectframe ;
	private OvalFrame ovalframe ;

	public void increment(){
		count++;
		textframe.setCount(count);
		rectframe.setCount(count);
		ovalframe.setCount(count);
	}

	public void decrement(){
		count--;
		textframe.setCount(count);
		rectframe.setCount(count);
		ovalframe.setCount(count);
	}

	public void setTextframe(TextFrame textframe) {
		this.textframe = textframe;
	}

	public void setRectframe(RectFrame rectframe) {
		this.rectframe = rectframe;
	}

	public void setOvalframe(OvalFrame ovalframe) {
		this.ovalframe = ovalframe;
	}
}
