package with.composite;

public class Application {

	public static void main(String[] args) {
		Directory cdir = new Directory("C");
	    Directory appdir = new Directory("applications");
	    Directory datadir = new Directory("my data");
	    Directory coursedir = new Directory("cs525");
	    File excelfile = new File("msexcel.exe", 2353256);
	    File wordfile = new File("msword.exe", 3363858);
	    File studentsfile = new File("students.doc", 34252);
	    cdir.addComponent(appdir);
	    cdir.addComponent(datadir);
	    datadir.addComponent(coursedir);
	    appdir.addComponent(excelfile);
	    appdir.addComponent(wordfile);
	    coursedir.addComponent(studentsfile);
	    cdir.print();
	  }

}
