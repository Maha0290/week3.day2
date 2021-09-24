package week3.day2.assignment;

public class Desktop implements Hardware, Software {

	public void desktopModel() {
		
		System.out.println("This is desktop model method of implementing class");
	}

	public void softwareResources() {
		// TODO Auto-generated method stub
		System.out.println("This is software resources method");
	}

	public void hardwareResources() {
		// TODO Auto-generated method stub
		System.out.println("This is hardware resources method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Desktop deskObj = new Desktop();
		deskObj.desktopModel();
		deskObj.softwareResources();
		deskObj.hardwareResources();
	}

}