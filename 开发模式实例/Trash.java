public class Trash {
	private int file_num;
	
	public static Trash trash;
	
	private Trash(int num) {
		this.file_num=num;
	}

	public int getFile_num() {
		return file_num;
	}

	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	
	public void addFile() {
		System.out.println("The trash add a file!");
	}
	
	public void DeleteFile() {
		System.out.println("The trash delete a file!");
	}
	
	public static Trash getInstance() {
		if(trash==null) 
			trash=new Trash(10);
		return trash;
	}
	
	public static void main(String[] args) {
		Trash t1=Trash.getInstance();
		System.out.println(t1.getFile_num());
		t1.addFile();
		t1.DeleteFile();
		Trash t2=Trash.getInstance();
		t2.setFile_num(200);
		System.out.println(t2.getFile_num());
		System.out.println(t1.getFile_num());
	}
}
