package with.composite;

public abstract class FileSystemComponent {
	protected String name;

	public FileSystemComponent(String name) {
		this.name = name;
	}

	public abstract void print();

	public abstract int getSizeInBytes();
}
