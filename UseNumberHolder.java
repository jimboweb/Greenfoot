class UseNumberHolder {
	public static void main (String[] args){
		NumberHolder hold = new NumberHolder();
		hold.anInt = 5;
		hold.aFloat = 3.2f;
		System.out.println("The integer is " + hold.anInt);
		System.out.println("The float is " + hold.aFloat);
	}
}