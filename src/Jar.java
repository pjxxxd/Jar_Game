public class Jar{
	private String mItemName;
	private int mNumInJar;

	public Jar(String itemName, int numInJar){
		mItemName = itemName;
		mNumInJar = numInJar;
	}

	public String getItemName(){
		return mItemName; 
	}

	public int getNumInJar(){
		return mNumInJar;
	}
}