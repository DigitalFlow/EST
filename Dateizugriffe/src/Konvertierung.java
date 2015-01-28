import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Konvertierung {

	public static void main(String[] args) {
		File file = OpenFile("USREXP.TXT");
		
		if(file == null)
		{
			return;
		}
		
		try
		{
			FileReader reader = new FileReader(file);
			
			Files.R
			BufferedReader buffer = new BufferedReader(reader);
			
			File output = CreateOutputFile("USRDAT.TXT");
			
			FileWriter writer = new FileWriter(output);
			
			String line = null;
			
			do
			{
				line = buffer.readLine();
				
				line = line.replaceAll("ä", "ae");
				line = line.replaceAll("Ä", "Ae");
				line = line.replaceAll("ö", "oe");
				line = line.replaceAll("Ö", "Oe");
				line = line.replaceAll("ü", "ue");
				line = line.replaceAll("Ü", "Ue");
				line = line.replaceAll("ß", "ss");
				
				writer.write(line);
			}while(line != null);

			writer.close();
			buffer.close();
			reader.close();
		}
		catch(FileAlreadyExistsException fex)
		{
			System.out.println("Ausgabedatei bereits vorhanden! Umbenennen oder neuen Ausgabepfad angeben!");
		}
		catch(Exception ex)
		{ 
			ex.printStackTrace();
		}
	}

	private static List<String> ReadFile(String filePath) {
		return Files.readAllLines(new Path(filePath));
	}
	
	private static File CreateOutputFile(String path) throws IOException
	{
		File file = new File(path);
		
		if(file.createNewFile())
		{
			return file;
		};

		throw new FileAlreadyExistsException("Die Datei gibt es schon!");
	}
	
}
