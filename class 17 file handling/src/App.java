import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class App {

	public static void main(String[] args)  {
		File file=new File("STUDYEASY");//folder name 
		file.mkdir();
		 file=new File("STUDYEASY\\ time.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	System.out.println("file created");	
	
	try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){//we use true as aparameter to apend item and files so when we run it.it will atomatically apend it content 
		bw.write("chand");
		bw.newLine();
		bw.write("hari");
		bw.newLine();
		bw.write("om");
		bw.newLine();
		bw.write("namah");
		bw.newLine();
		bw.write("shivay");
		bw.newLine();
		System.out.println("new file creation created ");
		bw.close();
	}catch (IOException e){
		System.out.println("error occured ");
	}
	try {
		BufferedReader br=new BufferedReader(new FileReader("STUDYEASY\\ time.txt"));
		try {
			String line;
			while((line= br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
