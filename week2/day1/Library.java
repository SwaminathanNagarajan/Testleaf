package week2.day1;

public class Library {
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;

	}
	public void issueBook() {
		System.out.println("Book issued successfully");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library Obj1 = new Library();
		Obj1.addBook(null);
		Obj1.issueBook();

	}

}
