import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Admin {
    //Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
    public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
        List<String> phoneNums = new ArrayList<>();
        for (LibraryMember libraryMember : members){

            for (CheckoutRecordEntry checkoutRecordEntry: libraryMember.getCheckoutRecord().getCheckoutRecordList()){

                if (checkoutRecordEntry.getLendingItem().equals(item)){
                    phoneNums.add(libraryMember.getPhone());
                    break;
                }

            }

        }

        Collections.sort(phoneNums);



        return phoneNums;
    }


}