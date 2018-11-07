
public class HouseDog extends Dog{
	public void sleep() {
		System.out.println(this.name + " zzz in house");
	}
	public void sleep(int hour) {
		System.out.println(this.name + " zzz in house for " + hour + " hours");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseDog hDog = new HouseDog();
//		hDog.setName("happy");
//		hDog.sleep();
//		hDog.sleep(3);
		System.out.println(hDog.name);

	}

}
