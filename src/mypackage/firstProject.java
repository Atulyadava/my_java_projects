package mypackage;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class firstProject {
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int option;
		int suboption;
		File folder = new File("E:\\notes\\today");
		System.out.println(" welcome to");
		System.out.println("File Management Application");
		System.out.println("Application Developer : Atul");

		do
		{
			System.out.println("Choose your option");
			System.out.println("1 - Display the Current File Name");
			System.out.println("2 - Display the user interface");
			System.out.println("3 - Exit");
			option=sc.nextInt();
			switch(option)
			{
			case 1:System.out.println("You are in Case 1");
			//store a folder address
			File[] listOfFiles = folder.listFiles();

			//to print all the files in specified directory
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("File " + listOfFiles[i].getName());
				} 
			}
			//for showing default Directories
			Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
			for (Path name: dirs) {
				System.err.println(name);

			}
			break;
			case 2: 
				System.out.println("You are in Case 2");
				System.out.println("Please Choose the operation to do...");
				System.out.println("11 - For Add a file to the existing directory list");
				System.out.println("12 - For Delete a user specified file from the existing directory list");
				System.out.println("13 - For Search a user specified file from the main directory");
				System.out.println("14 - For Option to navigate back to the main context");
				suboption=sc.nextInt();
				System.out.println("you choose: "+suboption);			    
				switch(suboption)
				{
				case 11:
					//	you need to write a logic to add  a file
					File file = new File(folder,"two.txt");
					if (file.createNewFile()) {
						System.out.println("Your File is Added");
					}
					else {
						System.out.println("File is alrady exist");
					}
					//if you want to write content on file then you can
					FileWriter writer= new FileWriter(file);
					writer.write("Hey Brother It's me atul ,This is our first file create by using IO");
					writer.close();

					break;
				case 12:
					// you need to write a logic to delete a file
					try {
						Files.delete(Paths.get("E:\\notes\\today\\two.txt"));
						System.out.println("deletion is successful");
					}
					catch(NoSuchFileException e) {
						System.out.println("No Such File/Directory exists");
					}
					catch(DirectoryNotEmptyException e) {
						System.out.println("Directory is not Empty");
					}
					catch(IOException e) {
						System.out.println("Invelid permission");

					}
					break;
				case 13: 			
					String name="two.txt";
					File[] listOfFiles1 = folder.listFiles();
					if(folder!=null)
						for(int i=0;i<listOfFiles1.length;i++)
						{
							if(name.equals(listOfFiles1[i].getName())) {
								System.out.println(" your file "+listOfFiles1[i]+" is found at index: "+i+" in "+folder+" folder");
							}

							else {
								System.out.println("your file  is not at index: "+i);
							}
						}


					break;
				case 14:
				}
				break;			
			case 3: 
				System.out.println("You are in Case 3");
				return;

			}

		}while(true);
	}

}
