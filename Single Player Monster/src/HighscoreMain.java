public class HighscoreMain {
	 public static void main(String[] args) {
    {
        HighscoreManager hm = new HighscoreManager();
        hm.addScore("Pat",740);
        
        System.out.print(hm.getHighscoreString());
    }
}	}