package with.composite;

public class File extends FileSystemComponent {
	private int sizeInBytes;

	public File(String name, int sizeInBytes) {
		super(name);
		this.sizeInBytes = sizeInBytes;
	}

	public int getSizeInBytes() {
		return sizeInBytes;
	}

	public void print() {
		System.out.println("--- file " + name + " size=" + getSizeInBytes() + " bytes");
	}
}
