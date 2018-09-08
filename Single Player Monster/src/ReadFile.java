

import java.io.*;
import java.util.ArrayList;import java.util.Comparator;
import java.util.List;

public class ReadFile {

	
	public static void main(String[] args) throws Exception
	{
		FileReader file = new FileReader("C:/Users/Thilina Thebuwana/Desktop/Workspace/Single Player Monster/score.txt");
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/Users/Thilina Thebuwana/Desktop/Workspace/Single Player Monster/score.txt"));
			List<Score> scores = (ArrayList<Score>) inputStream.readObject();
			scores.sort(new RankScores());
			for(Score s: scores) {
				System.out.println(s.getNaam() + "\t" + s.getScore());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
