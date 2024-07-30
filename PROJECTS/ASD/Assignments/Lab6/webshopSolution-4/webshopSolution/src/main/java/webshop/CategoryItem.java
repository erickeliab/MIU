package webshop;

public abstract class CategoryItem {
	private String name;
	
	

	public CategoryItem(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected abstract void print();
	protected abstract String getType();
	
}
