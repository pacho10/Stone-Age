package stoneAge.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Test {
	
	private String asd ="asdasdasd";
	private String aasdd ="asdasdasdasd";
	private String asasdad ="asdsdasddasd";
	private String asasdasdd ="asdaasdasdassdasd";
	
	
public static void main(String[] args) {
	Test t = new Test();
	t.makeHistoryJson();
}
public void makeHistoryJson() {
	XStream xstream = new XStream(new DomDriver());
	xstream.toXML(this);
	String asd = LocalTime.now().toString();
	String date = LocalDate.now().toString();
	String time = LocalTime.now().toString();
	File file = new File("History");
	file.mkdir();
	file = new File("History" + File.separator + date+" at: "+time.replace(".",",")+".xml");
	PrintWriter pr = null;
	try {
		file.createNewFile();
		 pr= new PrintWriter(file);
		 pr.write(xstream.toXML(this).toString());
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		pr.close();
	}
}
}
