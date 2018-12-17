import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class StoryReconstructor {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner filename;
		try {
			filename = new Scanner(new File("story-input.txt"));
			List<String> listStory = new ArrayList<String>();
			
			while (filename.hasNext()) {
				listStory.add(filename.next());	
			}
			FileWriter storyWriter = new FileWriter("story-output.text");
		    storyWriter.write(constructStory(listStory));
			storyWriter.close();
			filename.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static String constructStory(List<String> lines){
		Map<Integer, String> words = new TreeMap<>();
		
		lines.forEach( line -> {
			String[] splitted = line.split("=",2);
			if(splitted.length == 2){
				words.put(Integer.parseInt(splitted[0]), splitted[1]);
			}
		});
		return makeText(words.values());
	}
	
	private static String makeText(Collection<String> words){
		StringBuilder textBuilder = new StringBuilder();
		for(String word : words){
			textBuilder.append(word + " ");
		}
		return textBuilder.toString();
	}

}
