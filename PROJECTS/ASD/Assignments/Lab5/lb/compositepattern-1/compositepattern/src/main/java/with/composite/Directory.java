package with.composite;

import java.util.ArrayList;
import java.util.Collection;

public class Directory extends FileSystemComponent {
	protected Collection<FileSystemComponent> fileSystemComponents = new ArrayList<FileSystemComponent>();

	public Directory(String name) {
		super(name);
	}

	public void addComponent(FileSystemComponent component) {
		fileSystemComponents.add(component);
	}

	public int getSizeInBytes() {
		int sizeInBytes = 0;
		for (FileSystemComponent component : fileSystemComponents) {
			sizeInBytes += component.getSizeInBytes();
		}
		return sizeInBytes;
	}

	public void print() {
		System.out.println("-- dir " + name + " size=" + getSizeInBytes() + " bytes");
		for (FileSystemComponent component : fileSystemComponents) {
			component.print();
		}
	}
}
