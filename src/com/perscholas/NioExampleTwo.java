package com.perscholas;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		//Input files
		String[] inputFiles = { "/Users/hazem/Desktop/Assignments/Lab303.10.2-NIO/file2.txt" };

		//Files contents will be written in these files
		String outputFile = "/Users/hazem/Desktop/Assignments/Lab303.10.2-NIO/OutputExampleTwo.txt";

		//Get channel for output file
		FileOutputStream fos = new FileOutputStream(outputFile);
		WritableByteChannel targetChannel = fos.getChannel();
		for (int i = 0; i < inputFiles.length; i++) {

			//Get channel for input files
			FileInputStream fis = new FileInputStream(inputFiles[i]);
			FileChannel inputChannel = fis.getChannel();

			//Transfer data from input channel to output channel
			inputChannel.transferTo(0, inputChannel.size(), targetChannel);

			//close the input channel
			inputChannel.close();
			fis.close();
		}

		//finally close the target channel
		targetChannel.close();
		fos.close();
	}
}