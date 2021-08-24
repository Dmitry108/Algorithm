package homework1;

public enum Maker {
	XIAMIOU("Xiamiou"),
	ESER("Eser"),
	MACNOTE("MacNote"),
	ASOS("Asos"),
	LENUVO("Lenuvo");

	private String name;

	Maker (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Maker getMaker(int rang){
		return Maker.values()[rang];
	}
}