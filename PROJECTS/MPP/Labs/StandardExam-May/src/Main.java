import java.time.LocalDate;

public class Main {
    //Expected output:
    //         [333-7806, 347-1111, 717-1235, 802-5716, 923-8756, 989-1256]
    public static void main(String[] args) {

        //uncomment when your code is ready

		CD[] cds = {
				new CD("101", "Happy", "Warner Bros",2),
				new CD("102", "Sad", "Warner Bros",2),
				new CD("103", "Jumpin", "Mills Bros",2),
				new CD("104", "Frowning", "Mills Bros",2),
				new CD("105", "Joy", "Warner Bros",3)
		};

		Book[] books = {
				new Book("1040A5", "Gone with the Wind", "Bob", "Gearhart",5),
				new Book("5241C3", "The Unhappy Indian", "Richard", "Steigert",7),
				new Book("9982D1", "The Unseen Rock", "Stephen", "King",1),
			new Book("1112E5", "Hunting", "Danielle", "Steele",5),
				new Book("8008T4", "Overdrive", "Cougar", "Fox",2)

		};

		setNumCopies(cds, books);

		CheckoutRecordEntry[] entries = {
				new CheckoutRecordEntry(books[0], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2016, 1, 15),LocalDate.of(2016, 3, 15), ItemType.BOOK),
				new CheckoutRecordEntry(books[2], LocalDate.of(2017, 2, 1),LocalDate.of(2017, 4, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[3], LocalDate.of(2017, 4, 1),LocalDate.of(2017, 6, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[4], LocalDate.of(2017, 1, 21),LocalDate.of(2017, 3, 21), ItemType.BOOK),
				new CheckoutRecordEntry(books[0], LocalDate.of(2016, 3, 1),LocalDate.of(2016, 5, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2016, 5, 1),LocalDate.of(2016, 7, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[2], LocalDate.of(2015, 10, 1),LocalDate.of(2015, 12, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[0], LocalDate.of(2015, 5, 1),LocalDate.of(2015, 7, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2014, 8, 1),LocalDate.of(2014, 9, 1), ItemType.BOOK),
				new CheckoutRecordEntry(cds[0], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD), //10
				new CheckoutRecordEntry(cds[3], LocalDate.of(2015, 6, 1),LocalDate.of(2015, 8, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[4], LocalDate.of(2015,5, 10),LocalDate.of(2015, 7, 10), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 9, 1),LocalDate.of(2015, 11, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2016, 1, 1),LocalDate.of(2016, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2016, 2, 15),LocalDate.of(2016, 4, 15), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2016, 9, 10),LocalDate.of(2015, 11, 10), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2016, 10, 1),LocalDate.of(2016, 12, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2017, 3, 15),LocalDate.of(2017, 5, 11), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[3], LocalDate.of(2017, 1, 8),LocalDate.of(2017, 3, 9), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[4], LocalDate.of(2017, 1, 12),LocalDate.of(2017, 3, 12), ItemType.CD)//25
		};
		CheckoutRecord[] records = {new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord(),
				new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord(),
				new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord()
		};
		records[0].addCheckoutEntry(entries[0]);
		records[0].addCheckoutEntry(entries[1]);
		records[0].addCheckoutEntry(entries[10]);
		records[0].addCheckoutEntry(entries[11]);

		records[1].addCheckoutEntry(entries[2]);
		records[1].addCheckoutEntry(entries[3]);
		records[1].addCheckoutEntry(entries[12]);
		records[1].addCheckoutEntry(entries[13]);

	records[2].addCheckoutEntry(entries[4]);
		records[2].addCheckoutEntry(entries[14]);
		records[2].addCheckoutEntry(entries[15]);

		records[3].addCheckoutEntry(entries[16]);
		records[3].addCheckoutEntry(entries[17]);

		records[4].addCheckoutEntry(entries[5]);
		records[4].addCheckoutEntry(entries[6]);
		records[4].addCheckoutEntry(entries[18]);

		records[5].addCheckoutEntry(entries[19]);
		records[5].addCheckoutEntry(entries[20]);

		records[6].addCheckoutEntry(entries[7]);
		records[6].addCheckoutEntry(entries[8]);
		records[6].addCheckoutEntry(entries[21]);
		records[6].addCheckoutEntry(entries[22]);

		records[7].addCheckoutEntry(entries[9]);
		records[7].addCheckoutEntry(entries[23]);
		records[7].addCheckoutEntry(entries[24]);

		records[8].addCheckoutEntry(entries[10]);
		records[8].addCheckoutEntry(entries[25]);


		//String id, String fname, String lname, String phone
		LibraryMember[] members = {
				new LibraryMember("1001", "Hank", "Reynolds", "323-4556"),
				new LibraryMember("1002", "Bob", "Montelbahn", "377-4112"),
				new LibraryMember("1003", "Methusalah", "King", "923-8756"),
				new LibraryMember("1004", "Moses", "Ofisrael", "802-5716"),
				new LibraryMember("1005", "Abraham", "McDonald", "333-7806"),
				new LibraryMember("1006", "Ricardo", "Thomas", "717-1235"),
				new LibraryMember("1007", "Enrico", "Alvarez", "989-1256"),
				new LibraryMember("1008", "Francois", "Cinquante", "347-1111"),
				new LibraryMember("1009", "Joy", "Johnson", "523-4886")
		};
		setCheckoutRecords(members, records);
		System.out.println(Admin.getPhoneNums(members, cds[1]));


    }
	private static void setNumCopies(CD[] cds, Book[] books) {
		int count = 0;
		for(CD c: cds) {
			c.setNumCopiesInLib(1 + (count++) % 3);
		}
		for(Book b: books) {
			b.setNumCopiesInLib(1 + (count++) % 3);
		}
	}
	private static void setCheckoutRecords(LibraryMember[] members, CheckoutRecord[] records) {
		if(members.length != records.length) throw new IllegalArgumentException("members array has different size from records array");
		for(int i = 0; i < members.length; ++i) {
			members[i].setCheckoutRecord(records[i]);
		}
	}

}