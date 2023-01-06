	
	package entities;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	
	public class FileManipulation {
	static String modifyFile(String filePath, String oldString, String
	newString)
	{
	File fileToBeModified = new File(filePath);
	String oldContent = "";
	BufferedReader reader = null;
	FileWriter writer = null;
	String resultMessage = "";
	try
	{
	reader = new BufferedReader(new FileReader(fileToBeModified));
	//Reading all the lines of input text file into oldContent
	String line = reader.readLine();
	while (line != null)
	{
	oldContent = oldContent + line + System.lineSeparator();
	line = reader.readLine();
	}
	//Replacing oldString with newString in the oldContent
	String newContent = oldContent.replace(oldString, newString);
	//Rewriting the input text file with newContent
	writer = new FileWriter(fileToBeModified);
	writer.write(newContent);
	resultMessage = "Success";
	}
	catch (IOException e)
	{
	resultMessage = "Could not update the user";
	}
	finally
	{
	try
	{
	//Closing the resources
	reader.close();
	writer.close();
	}
	catch (IOException e)
	{
	resultMessage = "Could not update the user";
	}
	}
	return resultMessage;
	}
	

}
