import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class RedditReader {


		RedditReader () {
		//Default construct	
		}
		
		public void checkThreeKeywords(String fileToRead, String authorFile, String dateFile, String NumCommentsFile, String ScoreFile, String checkFor, String checkFor1, String checkFor2, String ANDOR) {
			try {
				
			//testing(fileToRead, authorFile, dateFile, NumCommentsFile, ScoreFile);
			int[] arrayLine=new int[7000]; //how can I make it infinitely large //DATE COMMENT SCORE
			String[] arrayAuthor= new String[6466]; //this number needs to be changed to # hits
			Date[] arrayDate= new Date[7000];
			String[] arrayEpoch= new String[7000];
			String[] arrayNumComments= new String[7000];
			String[] arrayScore= new String[7000];
			
			System.out.println("Importing: " + fileToRead);
			
			FileReader myFileReader = new FileReader(fileToRead);
			FileReader myFileReader1= new FileReader(authorFile);
			FileReader myFileReader2= new FileReader(dateFile);
			FileReader myFileReader3= new FileReader(NumCommentsFile);
			FileReader myFileReader4= new FileReader(ScoreFile);
			
			System.out.println("Success!");
			
			BufferedReader myBufferedReader = new BufferedReader(myFileReader);
			BufferedReader myBufferedReader1 = new BufferedReader(myFileReader1);
			BufferedReader myBufferedReader2 = new BufferedReader(myFileReader2);
			BufferedReader myBufferedReader3 = new BufferedReader(myFileReader3);
			BufferedReader myBufferedReader4 = new BufferedReader(myFileReader4);
			
			System.out.println("Ready to Buffer: " + fileToRead);
			
			String line=myBufferedReader.readLine();
			String author=myBufferedReader1.readLine();
			String date=myBufferedReader2.readLine();
			String numComments=myBufferedReader3.readLine();
			String score=myBufferedReader4.readLine();
			
			int counter= 0;
			int countTotal= 0;
			int instanceNum=1;
			
			while (line != null) {
				
				if (detectThreeWords(line, checkFor, checkFor1, checkFor2, ANDOR) == true) {
					
					//counter++;
					
					System.out.println("\nDetected " + checkFor +  " " + ANDOR + " "  + checkFor1 + " " + checkFor2);
					System.out.println("Line" + counter + ": " + line);
				
					detectThreeWords(line, checkFor, checkFor1, checkFor2, ANDOR);
					
					System.out.println("Line: " + counter + " Instance Number: " + instanceNum);
					arrayLine [countTotal]= counter; //trying to add to the next element the line number
					
					System.out.println("Author: " + author);
					arrayAuthor [countTotal]= author;
					
					long epoch = Long.parseLong( date );
					Date convertedDate = new Date( epoch * 1000 );
					
					System.out.println("Date: " + convertedDate + " | " +  date);
					arrayDate [countTotal]= convertedDate;
					arrayEpoch [countTotal]= date;
					System.out.println("Number of Comments: " + numComments);
					arrayNumComments [countTotal]= numComments;
					System.out.println("Score: " + score);
					arrayScore [countTotal]= score;
					
					counter++;
					countTotal++;
					instanceNum++;
					
					line= myBufferedReader.readLine();
					author= myBufferedReader1.readLine();
					date= myBufferedReader2.readLine();
					numComments= myBufferedReader3.readLine();
					score= myBufferedReader4.readLine();
					
				}else
					counter++;
					
					line= myBufferedReader.readLine();
					author= myBufferedReader1.readLine();
					date= myBufferedReader2.readLine();
					numComments= myBufferedReader3.readLine();
					score= myBufferedReader4.readLine();
			
			}
			
			/*String[] arrayAuthorSorted= new String[countTotal];
			Date[] arrayDateSorted= new Date[countTotal];
			String[] arrayEpochSorted= new String[countTotal];
			String[] arrayNumCommentsSorted= new String[countTotal];
			String[] arrayScoreSorted= new String[countTotal];
			for (int n=0; n<countTotal; n++) {
				arrayAuthorSorted[n] = arrayAuthor[n];
				arrayDateSorted[n] = arrayDate[n];
				arrayEpochSorted[n] = arrayEpoch[n];
				arrayNumCommentsSorted[n] = arrayNumComments[n];
				arrayScoreSorted[n]= arrayScore[n];
				
			}
			Arrays.sort(arrayLine);
			Arrays.sort(arrayAuthorSorted);
			Arrays.sort(arrayDateSorted);
			Arrays.sort(arrayEpochSorted);
			Arrays.sort(arrayNumCommentsSorted);
			Arrays.sort(arrayScoreSorted);*/
			
			System.out.println("\n" + fileToRead + " Buffered Successfully!");
			
			System.out.println("Number of lines containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + ": " + countTotal);
			
			System.out.println("Line numbers containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
				if (arrayLine[n] != 0) {
			System.out.println(arrayLine[n]);
				}
			}
			
			System.out.println("List of Authors who's post contain " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayAuthor[n]);
			}
			
			System.out.println("List of Dates (YYYY-MM-DD | Epoch)for posts containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayDate[n] + " | " + arrayEpoch[n]);
			}
			
			System.out.println("List of number of comments for lines containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayNumComments[n]);
			}
		
			System.out.println("List of Score for lines containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + " "  + checkFor2 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayScore[n]);
			}

			} // end try
			
			
			catch (Exception ex)
			{
				System.out.println("Error: File Not Found");
			}
			}
		
		public void checkTwoKeywords(String fileToRead, String authorFile, String dateFile, String NumCommentsFile, String ScoreFile, String checkFor, String checkFor1, String ANDOR) {	
			try {
				
			int[] arrayLine=new int[7000]; //how can I make it infinitely large //DATE COMMENT SCORE
			String[] arrayAuthor= new String[7000];
			Date[] arrayDate= new Date[7000];
			String[] arrayEpoch= new String[7000];
			String[] arrayNumComments= new String[7000];
			String[] arrayScore= new String[7000];
			
			System.out.println("Importing: " + fileToRead);
			
			FileReader myFileReader = new FileReader(fileToRead);
			FileReader myFileReader1= new FileReader(authorFile);
			FileReader myFileReader2= new FileReader(dateFile);
			FileReader myFileReader3= new FileReader(NumCommentsFile);
			FileReader myFileReader4= new FileReader(ScoreFile);
			
			System.out.println("Success!");
			
			BufferedReader myBufferedReader = new BufferedReader(myFileReader);
			BufferedReader myBufferedReader1 = new BufferedReader(myFileReader1);
			BufferedReader myBufferedReader2 = new BufferedReader(myFileReader2);
			BufferedReader myBufferedReader3 = new BufferedReader(myFileReader3);
			BufferedReader myBufferedReader4 = new BufferedReader(myFileReader4);
			
			System.out.println("Ready to Buffer: " + fileToRead);
			
			String line=myBufferedReader.readLine();
			String author=myBufferedReader1.readLine();
			String date=myBufferedReader2.readLine();
			String numComments=myBufferedReader3.readLine();
			String score=myBufferedReader4.readLine();
			
			int counter= 0;
			int countTotal= 0;
			int instanceNum=1;
			
			while (line != null) {
				
				if (detectTwoWords(line, checkFor, checkFor1, ANDOR) == true) {
					
					//counter++;
					
					System.out.println("\nDetected " + checkFor +  " " + ANDOR + " "  + checkFor1);
					System.out.println("Line" + counter + ": " + line);
				
					detectTwoWords(line, checkFor, checkFor1, ANDOR);
					
					System.out.println("Line: " + counter + " Instance Number: " + instanceNum);
					arrayLine [countTotal]= counter; //trying to add to the next element the line number
					
					System.out.println("Author: " + author);
					arrayAuthor [countTotal]= author;
					
					long epoch = Long.parseLong( date );
					Date convertedDate = new Date( epoch * 1000 );
					
					System.out.println("Date: " + convertedDate + " | " +  date);
					arrayDate [countTotal]= convertedDate;
					arrayEpoch [countTotal]= date;
					System.out.println("Number of Comments: " + numComments);
					arrayNumComments [countTotal]= numComments;
					System.out.println("Score: " + score);
					arrayScore [countTotal]= score;
					
					counter++;
					countTotal++;
					instanceNum++;
					
					line= myBufferedReader.readLine();
					author= myBufferedReader1.readLine();
					date= myBufferedReader2.readLine();
					numComments= myBufferedReader3.readLine();
					score= myBufferedReader4.readLine();
					
				}else
					
					counter++;
					
					line= myBufferedReader.readLine();
					author= myBufferedReader1.readLine();
					date= myBufferedReader2.readLine();
					numComments= myBufferedReader3.readLine();
					score= myBufferedReader4.readLine();
			
			}
			
			System.out.println("\n" + fileToRead + " Buffered Successfully!");
			
			System.out.println("Number of lines containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + ": " + countTotal);
			
			System.out.println("Line numbers containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
			System.out.println(arrayLine[n]);
			}
			
			System.out.println("List of Authors who's post contain " + checkFor +  " " + ANDOR + " "  + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayAuthor[n]);
			}
			
			System.out.println("List of Dates (YYYY-MM-DD | Epoch)for posts containing " + checkFor +  " " + ANDOR + " "  + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayDate[n] + " | " + arrayEpoch[n]);
			}
			
			System.out.println("List of number of comments for lines containing " + checkFor +  " " + ANDOR + " " + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayNumComments[n]);
			}
		
			System.out.println("List of Score for lines containing " + checkFor +  " " + ANDOR + " " + checkFor1 + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayScore[n]);
			}

			} // end try
			
			
			catch (Exception ex)
			{
				System.out.println("Error: File Not Found");
			}
			}
		
		public void checkOneKeyword(String fileToRead, String authorFile, String dateFile, String NumCommentsFile, String ScoreFile, String checkFor) {
			try {
			int[] arrayLine=new int[7000]; //how can I make it infinitely large //DATE COMMENT SCORE
			String[] arrayAuthor= new String[7000];
			Date[] arrayDate= new Date[7000];
			String[] arrayEpoch= new String[7000];
			String[] arrayNumComments= new String[7000];
			String[] arrayScore= new String[7000];
			
			System.out.println("Importing: " + fileToRead);
			
			FileReader myFileReader = new FileReader(fileToRead);
			FileReader myFileReader1= new FileReader(authorFile);
			FileReader myFileReader2= new FileReader(dateFile);
			FileReader myFileReader3= new FileReader(NumCommentsFile);
			FileReader myFileReader4= new FileReader(ScoreFile);
			
			System.out.println("Success!");
			
			BufferedReader myBufferedReader = new BufferedReader(myFileReader);
			BufferedReader myBufferedReader1 = new BufferedReader(myFileReader1);
			BufferedReader myBufferedReader2 = new BufferedReader(myFileReader2);
			BufferedReader myBufferedReader3 = new BufferedReader(myFileReader3);
			BufferedReader myBufferedReader4 = new BufferedReader(myFileReader4);
			
			System.out.println("Ready to Buffer: " + fileToRead);
			
			String line=myBufferedReader.readLine();
			String author=myBufferedReader1.readLine();
			String date=myBufferedReader2.readLine();
			String numComments=myBufferedReader3.readLine();
			String score=myBufferedReader4.readLine();
			
			int counter= 1;
			int countTotal= 0;
			int instanceNum=1;
			
			while (line != null) {
				
				if (detectWord(line, checkFor) == true) {
				
					System.out.print("Detected: " + checkFor);
					System.out.println("\nLine" + counter + ": " + line); //print line # followed by line
					
					detectWord(line, checkFor);
			
					System.out.println("Line: " + counter + " Instance Number: " + instanceNum);
					arrayLine [countTotal]= counter; //trying to add to the next element the line number
					
					System.out.println("Author: " + author);
					arrayAuthor [countTotal]= author;
					
					long epoch = Long.parseLong(date);
					Date convertedDate = new Date( epoch * 1000 );
					
					System.out.println("Date: " + convertedDate + " | " +  date);
					arrayDate [countTotal]= convertedDate;
					arrayEpoch [countTotal]= date;
					System.out.println("Number of Comments: " + numComments);
					arrayNumComments [countTotal]= numComments;
					System.out.println("Score: " + score + "\n");
					arrayScore [countTotal]= score;
					//System.out.print("\nLine # " + counter + " Post: " + line ); for testing
					
					counter++;
					countTotal++;
					instanceNum++;
					
					//line= myBufferedReader.readLine();
					//author= myBufferedReader1.readLine();
					//date= myBufferedReader2.readLine();          //////why no need????????
					//numComments= myBufferedReader3.readLine();
					//score= myBufferedReader4.readLine();
					
				}else
					//System.out.print("\nLine # " + counter + " Post: " + line );
					counter++;
					line= myBufferedReader.readLine();
					author= myBufferedReader1.readLine();
					date= myBufferedReader2.readLine();
					numComments= myBufferedReader3.readLine();
					score= myBufferedReader4.readLine();
					
			}
			
			System.out.println("\n" + fileToRead + " Buffered Successfully!");
			
			System.out.println("Number of lines containing " + checkFor + ": " + countTotal);
			
			System.out.println("Line numbers containing " + checkFor + ":");
			for (int n=0; n<countTotal; n++) {
			System.out.println(arrayLine[n]);
			}
			
			System.out.println("List of Authors who's post contain " + checkFor + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayAuthor[n]);
			}
			
			System.out.println("List of Dates (YYYY-MM-DD | Epoch)for posts containing " + checkFor + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayDate[n] + " | " + arrayEpoch[n]);
			}
			
			System.out.println("List of number of comments for lines containing " + checkFor + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayNumComments[n]);
			}
		
			System.out.println("List of Score for lines containing " + checkFor + ":");
			for (int n=0; n<countTotal; n++) {
				System.out.println(arrayScore[n]);
			}
			
			
			} // end try
			
			
			catch (Exception ex)
			{
				System.out.println("Error: File Not Found");
			}
			}

		public void menu() {
			System.out.println("Main Menu: ");
			System.out.println("1) Single Keyword Search");
			System.out.println("2) Two Keyword Search");
			System.out.println("3) Three Keyword Search");
			System.out.println("0) Exit Program");
			System.out.println("Enter the number correcposnding to the desired option: ");
		}
		
		public String testing(String fileToRead, String authorFile, String dateFile, String NumCommentsFile, String ScoreFile) throws IOException {
			
			int[] arrayLine=new int[7000];
			String[] arrayAuthor= new String[7000];
			Date[] arrayDate= new Date[7000];
			String[] arrayEpoch= new String[7000];
			String[] arrayNumComments= new String[7000];
			String[] arrayScore= new String[7000];
			
			System.out.println("Importing: " + fileToRead);
			
			FileReader myFileReader;
		
				myFileReader = new FileReader(fileToRead);
				FileReader myFileReader1= new FileReader(authorFile);
				FileReader myFileReader2= new FileReader(dateFile);
				FileReader myFileReader3= new FileReader(NumCommentsFile);
				FileReader myFileReader4= new FileReader(ScoreFile);
				
				System.out.println("Success!");
				
				BufferedReader myBufferedReader = new BufferedReader(myFileReader);
				BufferedReader myBufferedReader1 = new BufferedReader(myFileReader1);
				BufferedReader myBufferedReader2 = new BufferedReader(myFileReader2);
				BufferedReader myBufferedReader3 = new BufferedReader(myFileReader3);
				BufferedReader myBufferedReader4 = new BufferedReader(myFileReader4);
				
				System.out.println("Ready to Buffer: " + fileToRead);
				
				String line=myBufferedReader.readLine();
				String author=myBufferedReader1.readLine();
				String date=myBufferedReader2.readLine();
				String numComments=myBufferedReader3.readLine();
				String score=myBufferedReader4.readLine();
				return line + author + date + numComments + score;
				/*return author;
				return date;
				return numComments;
				return score;*/
		}

		boolean detectThreeWords(String lineToCheck, String checkFor, String checkFor1, String checkFor2, String ANDOR) {
					
					String lineToCheckLowercase= lineToCheck.toLowerCase();
				
					if (ANDOR.equals("AND")) {
						if (lineToCheckLowercase.contains(checkFor) && lineToCheckLowercase.contains(checkFor1) && lineToCheckLowercase.contains(checkFor2) ) {
							//System.out.println("\nDetected " + checkFor +  " " + ANDOR + " " + checkFor1);
							return true;
						
						} else {
							//System.out.println("Desired string not detected");
							return false;
						}
					} else if (ANDOR.equals("OR")) {
						if (lineToCheckLowercase.contains(checkFor) || lineToCheckLowercase.contains(checkFor1) || lineToCheckLowercase.contains(checkFor2)) {
							//System.out.println("\nDetected " + checkFor + " " + ANDOR + " " + checkFor1);
							return true;
						
							} else {
								//System.out.println("Desired string not detected");
								return false;
							}
					} else {
						System.out.println("Invalid Input for ANDOR");
						return false;
							
						}
					}

		boolean detectTwoWords(String lineToCheck, String checkFor, String checkFor1, String ANDOR) {
			
			String lineToCheckLowercase= lineToCheck.toLowerCase();
		
			if (ANDOR.equals("AND")) {
				if (lineToCheckLowercase.contains(checkFor) && lineToCheckLowercase.contains(checkFor1)) {
				//System.out.println("\nDetected " + checkFor +  " " + ANDOR + " " + checkFor1);
				return true;
			
				} else {
					//System.out.println("Desired string not detected");
					return false;
				}
			} else if (ANDOR.equals("OR")) {
				if (lineToCheckLowercase.contains(checkFor) || lineToCheckLowercase.contains(checkFor1)) {
					System.out.println("\nDetected " + checkFor + " " + ANDOR + " " + checkFor1);
					return true;
				
					} else {
						//System.out.println("Desired string not detected");
						return false;
					}
			} else {
				System.out.println("Invalid Input for ANDOR");
				return false;
					
				}
			}
			
			boolean detectWord(String lineToCheck, String checkFor) {
					
					String lineToCheckLowercase= lineToCheck.toLowerCase();
				
					
						if (lineToCheckLowercase.contains(checkFor)) { 
						//System.out.println("\nDetected " + checkFor);
						return true;
					
						} else {
							//System.out.println("Desired string not detected");
							return false;
	
				}
			}
			}	
	
//to-do SINGLE WORD IS DONE!!!!!!!!!!! now copy format to two word, find out why it wasnt working (repeated "detected" and skipping lines
//look up array list
//make method to buffer in only
//make method to use keyword that calls method that buffers in only.
