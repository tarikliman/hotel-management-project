package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
	
    public static void  fileCreate(){
        
    	File fileln = new File ("customerList.txt");
    	
    	try {
			if (fileln.createNewFile()) {
			}
			else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static void writeFile(String line) {
		
		try {
			BufferedWriter bufwriter = new BufferedWriter(new FileWriter ("customerList.txt",true));
			bufwriter.newLine();
			bufwriter.write(line);
			bufwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void writetemp(String name, String surname,String iD) {
		
		try {
			BufferedWriter bufwriter = new BufferedWriter(new FileWriter ("temp.txt",true));
			bufwriter.newLine();
			bufwriter.write(name+" "+surname+" "+iD);
			bufwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public static void readandwriteFile() {
		File fileln = new File ("temp.txt"); 
		try {
			Scanner ln = new Scanner(fileln);
			while(ln.hasNextLine()) {
				
				String line = ln.nextLine();
				FileOperations.writeFile(line);
			}
			ln.close(); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
    
    public static void getFileInfo() {
		File fileln = new File ("customerList.txt");
		if (fileln.exists()) {
			System.out.println("file name: "+ fileln.getName());
			
			System.out.println("file path: "+fileln.getAbsolutePath());
			
			System.out.println("canwrite: "+fileln.canWrite());
			
			System.out.println("can read: "+fileln.canRead());
			
			System.out.println("file length: "+fileln.length());
			
		}
		}
    public static String[] readArrayTest() {
        File fileln = new File ("customerList.txt");
        int ctr = 0;
        try {
            Scanner s1 = new Scanner(fileln);
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.next();
            }
            s1.close();
            String [] words = new String [ctr];

            Scanner s2 = new Scanner (fileln);
            for (int j=0 ; j<ctr ; j++) {
                words[j]= s2.next();
            }
            s2.close();
            return words;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
 public static void writeRoom(String SelectedRoom) {
		
		
		try {
			BufferedWriter bufwriter = new BufferedWriter(new FileWriter ("temp.txt",true));
			bufwriter.write( " " + SelectedRoom);
			bufwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
 public static int NumberOfCustomer() {
     File fileln = new File ("customerList.txt");
     int ctr = 0;
     try {
         Scanner s1 = new Scanner(fileln);
         while (s1.hasNextLine()) {
             ctr = ctr + 1;
             s1.next();
         }
         s1.close();
       
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
	return ctr/4;

 }

 public static void deleteCus(String iDdelete) {
     File oldFile = new File ("customerList.txt");
     File deleteFile = new File ("delete.txt");
     String[] words = FileOperations.readArrayTest();


     try {
        FileWriter fw = new FileWriter("delete.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        int ctr = FileOperations.NumberOfCustomer();
         for(int i=2; i<(ctr*4); i=i+4) {
             if(!words[i].equals(iDdelete)) {
                 pw.println(words[i-2]+" "+words[i-1]+" "+words[i]+" "+words[i+1]);
                }
         }
             pw.flush();
             Files.deleteIfExists(Paths.get("customerList.txt"));
             File newFile = new File ("customerList.txt");
             FileOperations.fileCreate();
             FileOperations.DelreadandwriteFile();
    } catch (IOException e) {

        e.printStackTrace();
    }}
 
 public static void DelreadandwriteFile() {
		File fileln = new File ("delete.txt"); 
		try {
			Scanner ln = new Scanner(fileln);
			while(ln.hasNextLine()) {
				
				String line = ln.nextLine();
				FileOperations.writeFile(line);
			}
			ln.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
 
 public static void deleteTemp() {
	 try

     { 
         Files.deleteIfExists(Paths.get("temp.txt")); 
     } 
     catch(NoSuchFileException e) 
     { 
     } 
     catch(DirectoryNotEmptyException e) 
     { 
     } 
     catch(IOException e) 

     { 

     } 

 }
    }