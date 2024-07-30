package webshop;

import java.util.ArrayList;
import java.util.List;

public class Category extends CategoryItem{
	List<CategoryItem> items = new ArrayList<CategoryItem>();
	
	public Category(String name) {
		super(name);
	}
	
	public void addItem(CategoryItem item) {
		items.add(item);
	}

	@Override
	protected void print() {
		System.out.println("Category [name=" + getName() + "]");
		for (CategoryItem item: items) {
			item.print();
		}		
	}
	
	public String getType() {
		return "Category";
	}

	
	public Category findCategoryWithName(String name) {
		Category result = null;
		if (name.equals(getName())) {
			return this;
		}
		else {
			for(CategoryItem subitem: items) {
				if (subitem.getType().equals("Category")) {
					result = ((Category)subitem).findCategoryWithName(name);
					if (result != null)
						return result;
				}				
			}
		}
		return result;
	}
	
}
