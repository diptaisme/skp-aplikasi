/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sony
 */
import java.io.*;
import java.net.*;

public class urlDownload {
final static int size=1024;
public static void
fileUrl(String fAddress, String
localFileName, String destinationDir) {
OutputStream outStream = null;
URLConnection  uCon = null;

InputStream is = null;
try {
URL Url;
byte[] buf;
int ByteRead,ByteWritten=0;
Url= new URL(fAddress);
outStream = new BufferedOutputStream(new
FileOutputStream(destinationDir+"\\"+localFileName));

uCon = Url.openConnection();
is = uCon.getInputStream();
buf = new byte[size];
while ((ByteRead = is.read(buf)) != -1) {
outStream.write(buf, 0, ByteRead);
ByteWritten += ByteRead;
}
System.out.println("Downloaded Successfully.");
System.out.println
("File name:\""+localFileName+ "\"\nNo ofbytes :" + ByteWritten);
}
catch (Exception e) {
e.printStackTrace();
}
finally {
try {
is.close();
outStream.close();
}
catch (IOException e) {
e.printStackTrace();
}}}
public static void 
fileDownload(String fAddress, String destinationDir)
{
 
  int slashIndex =fAddress.lastIndexOf('/');
int periodIndex =fAddress.lastIndexOf('.');

String fileName=fAddress.substring(slashIndex + 1);

if (periodIndex >=1 &&  slashIndex >= 0 
&& slashIndex < fAddress.length()-1)
{
fileUrl(fAddress,fileName,destinationDir);
}
else
{
System.err.println("path or file name.");
}}
public static void main(String[] args)
{
    String[] args1 =new String[2];
    
args1[0]="C:/Sapk";
args1[1]="C:/bkn/Doc3.doc";
if(args1.length==2)
{
for (int i = 1; i < args1.length; i++) {
fileDownload(args1[i],args1[0]);
}
}
else{
  
}
}
}