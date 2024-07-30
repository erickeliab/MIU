package webshop;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {

	List<CategoryItem> catalog = new ArrayList<CategoryItem>();

	public void addCategory(String categoryName, String parentName) {
		Category category = new Category(categoryName);
		if (parentName == null) {
			catalog.add(category);
		} else {
			Category parentCategory = findCategory(parentName);
			if (parentCategory != null) {
				parentCategory.addItem(category);
			}
		}
	}

	public void addProduct(Product product, String categoryName) {
		Category parentCategory = findCategory(categoryName);
		if (parentCategory != null) {
			parentCategory.addItem(product);
		}
	}

	private Category findCategory(String parentName) {
		Category result = null;
		for (CategoryItem item : catalog) {
			if (item.getName().equals(parentName)) {
				return (Category) item;
			}
			if (item.getType().equals("Category")) {
				result = ((Category)item).findCategoryWithName(parentName);
				if (result!= null)
					return result;
			}			 
		}
		System.out.println("*****result = "+result);
		return result;
	}

	public void print() {
		for (CategoryItem item : catalog) {
			item.print();
		}		
	}

}
